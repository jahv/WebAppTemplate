package jahv.selfstudy.web;

import jahv.selfstudy.model.EmployeeDTO;
import jahv.selfstudy.service.EmployeeServiceJDBC;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employeeJDBC")
public class EmployeeControllerJDBC {

	private static final Logger LOGGER = Logger.getLogger(EmployeeControllerJDBC.class);

	@Autowired
	private EmployeeServiceJDBC employeeServiceJDBC;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<EmployeeDTO> getEmployees() {
		LOGGER.info("[UI] - Getting all employees");
		return employeeServiceJDBC.getEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeDTO getEmployee(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Getting employee with id: " + id);
		return employeeServiceJDBC.getEmployee(id);
	}

	@RequestMapping(value = "/{id}", params = "action=update", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateEmployee(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Updating employee with id: " + id);
		employeeServiceJDBC.updateEmployee(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping(params = "action=save", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> saveeEmployee(@RequestParam(defaultValue = "Norma") final String firstName,
			@RequestParam(defaultValue = "Flores") final String lastName,
			@RequestParam(defaultValue = "RH") final String department) {
		LOGGER.info("[UI] - Saving employee");
		employeeServiceJDBC.saveEmployee(firstName, lastName, department);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", params = "action=delete", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") final Long id) {
		LOGGER.info("[UI] - Deleting employee with id: " + id);
		employeeServiceJDBC.deleteEmployee(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
