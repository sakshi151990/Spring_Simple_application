package student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import student.data.Student;

@Configuration
@ComponentScan(value={"student.config","student.data"})
public class studentrootconfig {

	@Bean
	public Student getstudent()
	{
		return new Student();
	}
	

}
