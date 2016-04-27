package jahv.selfstudy.web;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

import jahv.selfstudy.model.EmployeeEntity;

@ContextConfiguration(locations = { "/test-applicationContext.xml",
		"classpath*:META-INF/spring/jdbc-applicationContext.xml" })
public class EmployeeControllerJPAIT extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String HOST = "http://localhost:8080/WebAppTemplate";
	private static final String BASE_URL = "/employeeJPA";

	@Autowired
	@Qualifier("testRestTemplate")
	private RestTemplate restTemplate;

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testFindAll() {
		final ResponseEntity<List> responseEntity = restTemplate.getForEntity(HOST + BASE_URL, List.class);
		Assert.assertNotNull(responseEntity.getBody());
		final List<EmployeeEntity> employees = responseEntity.getBody();
		Assert.assertFalse(employees.isEmpty());
	}

	@Test
	public void testSave() {
		final String url = HOST + BASE_URL + "?action=save";
		final ResponseEntity<EmployeeEntity> responseEntity = restTemplate.getForEntity(url, EmployeeEntity.class);
		Assert.assertNotNull(responseEntity.getBody());
		final EmployeeEntity employee = responseEntity.getBody();
		Assert.assertNotNull(employee.getId());
	}
}
