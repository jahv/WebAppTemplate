package jahv.selfstudy.service;

import jahv.selfstudy.model.EmployeeDTO;
import jahv.selfstudy.repository.EmployeeRepositoryJDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceJDBC {

	@Autowired
	private EmployeeRepositoryJDBC employeeRepositoryJDBC;

	public List<EmployeeDTO> getEmployees() {
		return employeeRepositoryJDBC.getEmployees();
	}

	public EmployeeDTO getEmployee(final Long id) {
		return employeeRepositoryJDBC.getEmployee(id);
	}

	public void updateEmployee(final Long id) {
		employeeRepositoryJDBC.updateEmployee(id);
	}

	public void saveEmployee(final String firstName, final String lastName, final String department) {
		final EmployeeDTO employee = new EmployeeDTO();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDepartment(department);

		employeeRepositoryJDBC.saveEmployee(employee);
	}

	public void deleteEmployee(final Long id) {
		employeeRepositoryJDBC.deleteEmployee(id);
	}
}
