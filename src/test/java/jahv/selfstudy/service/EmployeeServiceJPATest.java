package jahv.selfstudy.service;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.repository.EmployeeRepositoryJPA;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceJPATest {

	@InjectMocks
	private EmployeeServiceJPA employeeServiceJPA;

	@Mock
	private EmployeeRepositoryJPA employeeRepositoryJPA;

	@Test
	public void testGetEmployees() {
		final List<EmployeeEntity> repoResult = new ArrayList<EmployeeEntity>();
		repoResult.add(new EmployeeEntity());

		Mockito.when(employeeRepositoryJPA.findAll()).thenReturn(repoResult);

		final List<EmployeeEntity> actual = employeeServiceJPA.getEmployees();

		Assert.assertEquals(actual, repoResult);
	}

}
