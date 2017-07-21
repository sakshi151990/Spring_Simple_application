package spitter.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

public class spittermapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int num) throws SQLException {
		
		
		
		return new Spitter(rs.getString("username"),rs.getString("FirstName"),rs.getString("password"),rs.getString("lastName"));	}

}
