package spitter.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import spitter.data.Spitter;
import spitter.data.Spittle;
import spitter.data.SpittleRepository;
import spitter.data.spitterRepository;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {
	HomeController controller = new HomeController();
	new MockMvcBuilders();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(get("/")).andExpect(view().name("Home"));
	}
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
	List<Spittle> expectedSpittles = createSpittleList(20);
	SpittleRepository mockRepository =mock(SpittleRepository.class);
	when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
	SpittleController controller =new SpittleController(mockRepository);

	new MockMvcBuilders();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
	mockMvc.perform(get("/spittles"))
	.andExpect(view().name("spittles"))
	.andExpect(model().attributeExists("spittleList"))
	.andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
	}
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
		spittles.add(new Spittle("Spittle"+i,new Date()));
		}
		return spittles;
		}
	
	
	@Test
	public void shouldShowPagedSpittles() throws Exception {
	List<Spittle> expectedSpittles = createSpittleList(50);
	SpittleRepository mockRepository = mock(SpittleRepository.class);
	when(mockRepository.findSpittles(238900, 50))
	.thenReturn(expectedSpittles);
	SpittleController controller =
	new SpittleController(mockRepository);
	new MockMvcBuilders();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
	.setSingleView(
	new InternalResourceView("/WEB-INF/views/spittles.jsp"))
	.build();
	mockMvc.perform(get("/spittles?max=238900&count=50"))
	.andExpect(view().name("spittles"))
	.andExpect(model().attributeExists("spittleList"))
	.andExpect(model().attribute("spittleList",
	hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testSpittle() throws Exception {
	Spittle expectedSpittle = new Spittle("Hello", new Date());
	SpittleRepository mockRepository = mock(SpittleRepository.class);
	when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
	SpittleController controller = new SpittleController(mockRepository);
	new MockMvcBuilders();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(get("/spittles/12345"))
	.andExpect(view().name("spittle"))
	.andExpect(model().attributeExists("spittle"))
	.andExpect(model().attribute("spittle", expectedSpittle));
	}
	
	@Test
	public void shouldShowRegistration() throws Exception {
		spitterRepository mockRepository = mock(spitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(get("/spitter/register"))
	.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
	spitterRepository mockRepository =mock(spitterRepository.class);
	Spitter unsaved =	new Spitter("jbauer", "24hours", "Jack", "Bauer");
	Spitter saved =
	new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
	when(mockRepository.save(unsaved)).thenReturn(saved);
	SpitterController controller =
	new SpitterController((spitterRepository) mockRepository);
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(post("/spitter/register")
	.param("firstName", "Jack")
	.param("lastName", "Bauer")
	.param("username", "jbauer")
	.param("password", "24hours"))
	.andExpect(redirectedUrl("/spitter/jbauer"));
	verify(mockRepository, atLeastOnce()).save(unsaved);
	}
	
}
