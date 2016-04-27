package jahv.selfstudy.utils.security;

import jahv.selfstudy.model.UserEntity;
import jahv.selfstudy.model.UserRolesEntity;
import jahv.selfstudy.repository.UserRepository;
import jahv.selfstudy.repository.UserRolesRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
		final String password = authentication.getCredentials().toString();

		final UserEntity user = userRepository.findByUserNameAndPassword(username, password);

		if (user != null) {
			final List<UserRolesEntity> roles = userRolesRepository.findByUserName(user.getUserName());
			final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

			for (UserRolesEntity role : roles) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
			}

			Authentication auth = new UsernamePasswordAuthenticationToken(user.getUserName(),
					user.getPassword(), grantedAuthorities);
			return auth;
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
