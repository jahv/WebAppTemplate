package jahv.selfstudy.repository.rowmapper;

import jahv.selfstudy.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {

	@Override
	public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDTO e = new EmployeeDTO();
		e.setId(rs.getLong(1));
		e.setFirstName(rs.getString(2));
		e.setLastName(rs.getString(3));
		e.setDepartment(rs.getString(4));
		e.setNotes(rs.getString(5));
		return e;
	}
}
