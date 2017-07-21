package spitter.data;

import javax.inject.Inject;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class JdbcSpitterRepository implements spitterRepository {

	
	private JdbcOperations jdbcOperations;
	
	@Inject
	public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
	this.jdbcOperations = jdbcOperations;
	}
	
	@Override
	public void save(Spitter unsaved) {
		jdbcOperations.update("insert into spitter(username,FirstName,LastName,password) values (?,?,?,?)", unsaved.getUsername(),unsaved.getFirstName(),unsaved.getLastName(),unsaved.getPassword());
		
	}

	@Override
	public Spitter findByUsername(String username) {
		
		return  (Spitter) jdbcOperations.queryForObject("select * from spitter where username =  ?", new spittermapper(),username);
	}
	
	

}
