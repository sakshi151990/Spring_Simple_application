package io.exampleszone.com.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class topicService {


	private List<Topic> list = new ArrayList<Topic>(Arrays.asList(new Topic("Java" ,1,"JAVA course"), new Topic("Spring", 2, "spring course")));
	
	public List<Topic> getalltopics()
	{ return list;}
	
	
	public Topic gettopicbyid(int id)
	{ 
		int index =0;
		
		for (Topic topic : list) {
			if(topic.getId() == id)
			{
				index =list.indexOf(topic);
		break;}	
		}
		return list.get(index);
 }


	public void addtopic(Topic topic) {
		list.add(topic);
		
	}


	public void updatetopic(int id, Topic topic) {
	
		for (int i = 0; i < list.size(); i++) {
			Topic  topic1= list.get(i);
			if (topic1.getId()== id) {
				list.set(i, topic);
			}
		}
		
	}


	public Topic deletetopicbyid(int id) {
		// TODO Auto-generated method stub
int index =0;
		
		for (Topic topic : list) {
			if(topic.getId() == id)
			{
				index =list.indexOf(topic);
		break;}	
		}
		return list.remove(index);
	}

	
	
}
