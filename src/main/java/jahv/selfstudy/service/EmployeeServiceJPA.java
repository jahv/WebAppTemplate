package jahv.selfstudy.service;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.repository.EmployeeRepositoryJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceJPA {

	@Autowired
	private EmployeeRepositoryJPA employeeRepositoryJPA;

	public List<EmployeeEntity> getEmployees() {
		return employeeRepositoryJPA.getEmployees();
	}

	public EmployeeEntity getEmployee(final Long id) {
		return employeeRepositoryJPA.getEmployee(id);
	}
}
