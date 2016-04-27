package jahv.selfstudy.repository;

import jahv.selfstudy.model.UserRolesEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {

	List<UserRolesEntity> findByUserName(final String userName);
}
