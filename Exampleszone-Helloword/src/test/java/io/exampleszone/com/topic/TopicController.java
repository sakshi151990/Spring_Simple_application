package io.exampleszone.com.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private topicService topicservice;
	
	@RequestMapping("/topic")
	public List<Topic> gettopiclist()
	{
		return  topicservice.getalltopics();
				
	}
	
	@RequestMapping("/topic/{id}")
	public Topic gettopicbyid(@PathVariable int id)
	{  
		return topicservice.gettopicbyid(id); }
	
	@RequestMapping(method =RequestMethod.POST,value ="/topic")
	public void addtopic(@RequestBody Topic topic){
		
		topicservice.addtopic(topic);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topic/{id}")
	public void updatetopic(@PathVariable  int id,@RequestBody Topic topic)
	{
  topicservice.updatetopic(id,topic);
  
	}
	
	@RequestMapping(method=RequestMethod.DELETE,  value="/topic/{id}")
	public Topic deletetopicbyid(@PathVariable int id)
	{  
		return topicservice.deletetopicbyid(id); }
	
	

}
