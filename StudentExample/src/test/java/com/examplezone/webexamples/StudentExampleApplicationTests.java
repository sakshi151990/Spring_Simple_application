package com.examplezone.webexamples;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import student.web.StudentContoller;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentExampleApplicationTests {

	@Test
	public void testhomecontorller() throws Exception {
		
		StudentContoller controller = new StudentContoller();
		MockMvc mockmvc =new MockMvcBuilders().standaloneSetup(controller).build();
		mockmvc.perform(get("/student")).andExpect(view().name("Home"));

}
}

