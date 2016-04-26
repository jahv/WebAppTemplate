package jahv.selfstudy.web;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.service.EmployeeServiceJPA;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employeeJPA")
public class EmployeeControllerJPA {

	private static final Logger LOGGER = Logger.getLogger(EmployeeControllerJPA.class);

	@Autowired
	private EmployeeServiceJPA employeeServiceJPA;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<EmployeeEntity> getAllEmployees() {
		LOGGER.info("[UI] - Getting employees");
		return employeeServiceJPA.getEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeEntity getAllEmployees(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Getting employee with id: " + id);
		return employeeServiceJPA.getEmployee(id);
	}

}
