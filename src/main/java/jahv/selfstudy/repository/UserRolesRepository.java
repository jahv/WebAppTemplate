package jahv.selfstudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jahv.selfstudy.model.UserRolesEntity;

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {

	List<UserRolesEntity> findByUserName(final String userName);

	@Query("SELECT ure, ue "
			+ "FROM UserRolesEntity ure, UserEntity ue "
			+ "WHERE ure.userName = ue.userName")
	List<Object[]> getAllEntities();

	@Query("SELECT ure, ue "
			+ "FROM UserRolesEntity ure JOIN UserEntity ue")
	List<Object[]> getAllEntities2();
}
