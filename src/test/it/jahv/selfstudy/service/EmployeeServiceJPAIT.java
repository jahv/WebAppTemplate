package jahv.selfstudy.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import jahv.selfstudy.model.EmployeeEntity;

@ContextConfiguration(locations = { "/test-applicationContext.xml",
		"classpath*:META-INF/spring/jdbc-applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class EmployeeServiceJPAIT extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EmployeeServiceJPA employeeServiceJPA;

	@Test
	public void testFindAll() {
		final List<EmployeeEntity> employees = employeeServiceJPA.getEmployees();
		Assert.assertFalse(employees.isEmpty());
	}

	@Test
	public void testSave() {
		final EmployeeEntity saved = employeeServiceJPA.saveEmployee();
		Assert.assertNotNull(saved);
	}
}
