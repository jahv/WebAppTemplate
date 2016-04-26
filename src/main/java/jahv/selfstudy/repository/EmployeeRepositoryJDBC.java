package jahv.selfstudy.repository;

import jahv.selfstudy.model.EmployeeDTO;
import jahv.selfstudy.repository.rowmapper.EmployeeRowMapper;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryJDBC {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Get all employees
	 * @return
	 */
	public List<EmployeeDTO> getEmployees() {
		final String sql = "SELECT * FROM EMPLOYEES";
		List<EmployeeDTO> employees = jdbcTemplate.query(sql, new EmployeeRowMapper());

		return employees;
	}

	/**
	 * Get employee based on id
	 * @param id
	 * @return
	 */
	public EmployeeDTO getEmployee(final Long id) {
		final String sql = "SELECT * FROM EMPLOYEES WHERE ID = ?";
		final Object[] args = new Object[] { id };

		return jdbcTemplate.queryForObject(sql, args, new EmployeeRowMapper());
	}

	public void updateEmployee(final Long id) {
		final String sql = "UPDATE EMPLOYEES SET NOTES = ? WHERE ID = ?";
		final Object[] args = new Object[] { new Date().toString(), id };

		jdbcTemplate.update(sql, args);
	}

	public void saveEmployee(final EmployeeDTO employee) {
		final String sql = "INSERT INTO EMPLOYEES(first_name, last_name, department) VALUES (?,?,?)";
		final Object[] args =
				new Object[] { employee.getFirstName(), employee.getLastName(), employee.getDepartment() };

		jdbcTemplate.update(sql, args);
	}

	public void deleteEmployee(final Long id) {
		final String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
		final Object[] args = new Object[] { id };

		jdbcTemplate.update(sql, args);
	}
}
