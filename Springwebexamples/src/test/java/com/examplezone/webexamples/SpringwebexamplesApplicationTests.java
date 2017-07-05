package com.examplezone.webexamples;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;




public class SpringwebexamplesApplicationTests {

	@Test
	public void testhomecontorller() throws Exception {
		
		SpringwebexamplesApplicationController controller = new SpringwebexamplesApplicationController();
		MockMvc mockmvc =new MockMvcBuilders().standaloneSetup(controller).build();
		mockmvc.perform(get("/")).andExpect(view().name("Home"));

}
}