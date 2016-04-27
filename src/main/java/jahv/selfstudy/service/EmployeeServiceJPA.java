package jahv.selfstudy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.repository.EmployeeRepositoryJPA;

@Transactional
@Service
public class EmployeeServiceJPA {

	@Autowired
	private EmployeeRepositoryJPA employeeRepositoryJPA;

	public List<EmployeeEntity> getEmployees() {
		return employeeRepositoryJPA.findAll();
	}

	public EmployeeEntity getEmployee(final Long id) {
		return employeeRepositoryJPA.findOne(id);
	}

	public EmployeeEntity updteEmployee(final Long id) {
		final EmployeeEntity employee = getEmployee(id);
		if (employee != null) {
			employee.setNotes(new Date().toString());
			return employeeRepositoryJPA.save(employee);
		}
		return null;
	}

	public void deleteEmployee(final Long id) {
		final EmployeeEntity employee = getEmployee(id);
		if (employee != null) {
			employeeRepositoryJPA.delete(employee);
		}
	}

	public EmployeeEntity saveEmployee() {
		final EmployeeEntity employee = new EmployeeEntity();
		employee.setFirstName("Jose");
		employee.setLastName("Hernandez");
		employee.setDepartment("DEV");

		return employeeRepositoryJPA.save(employee);
	}
}
