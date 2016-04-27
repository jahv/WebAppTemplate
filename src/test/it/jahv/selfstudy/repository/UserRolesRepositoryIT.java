package jahv.selfstudy.repository;

import jahv.selfstudy.model.UserRolesEntity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath*:META-INF/spring/jdbc-applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class UserRolesRepositoryIT extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Test
	public void testFindAll() {
		final List<UserRolesEntity> roles = userRolesRepository.findAll();
		Assert.assertFalse(roles.isEmpty());
	}

	@Test
	public void testFindByUserName() {
		final List<UserRolesEntity> roles = userRolesRepository.findByUserName("jahv");
		Assert.assertFalse(roles.isEmpty());
	}
}
