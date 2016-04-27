package jahv.selfstudy.repository;

import jahv.selfstudy.model.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByUserNameAndPassword(final String username, final String password);
}
