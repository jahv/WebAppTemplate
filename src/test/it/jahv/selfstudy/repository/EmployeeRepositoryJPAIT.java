package jahv.selfstudy.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import jahv.selfstudy.model.EmployeeEntity;

@ContextConfiguration(locations = "classpath*:META-INF/spring/jdbc-applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
public class EmployeeRepositoryJPAIT extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EmployeeRepositoryJPA employeeRepositoryJPA;

	@Test
	public void testFindAll() {
		final List<EmployeeEntity> employees = employeeRepositoryJPA.findAll();
		Assert.assertFalse(employees.isEmpty());
	}

	@Test
	public void testSave() {
		final EmployeeEntity employee = new EmployeeEntity();
		employee.setFirstName("firstName");
		employee.setLastName("lastName");
		employee.setDepartment("department");

		final EmployeeEntity saved = employeeRepositoryJPA.save(employee);

		Assert.assertNotNull(saved);
		Assert.assertNotNull(saved.getId());
	}
}
