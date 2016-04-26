package jahv.selfstudy.repository;

import jahv.selfstudy.model.EmployeeEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepositoryJPA {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EmployeeEntity> getEmployees() {
		List<EmployeeEntity> employees = entityManager.createQuery(
				"SELECT e FROM EmployeeEntity e", EmployeeEntity.class).getResultList();
		return employees;
	}

	public EmployeeEntity getEmployee(final Long id) {
		return entityManager.find(EmployeeEntity.class, id);
	}
}
