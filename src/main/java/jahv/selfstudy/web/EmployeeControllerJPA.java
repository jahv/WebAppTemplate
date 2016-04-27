package jahv.selfstudy.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.service.EmployeeServiceJPA;

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

	@RequestMapping(value = "/{id}", params = "action=update", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeEntity updateEmployee(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Updating employee with id: " + id);
		return employeeServiceJPA.updteEmployee(id);
	}

	@RequestMapping(params = "action=save", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeEntity saveEmployee() {
		LOGGER.info("[UI] - Saving employee");
		return employeeServiceJPA.saveEmployee();
	}

	@RequestMapping(value = "/{id}", params = "action=delete", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Deleting employee with id: " + id);
		employeeServiceJPA.deleteEmployee(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
