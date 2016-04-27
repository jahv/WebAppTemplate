package jahv.selfstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jahv.selfstudy.model.EmployeeEntity;

@Repository
public interface EmployeeRepositoryJPA extends JpaRepository<EmployeeEntity, Long> {

}
