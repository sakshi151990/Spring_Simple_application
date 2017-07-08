package spitter.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleRepositoryIML implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle"+i,new Date()));
			}
			
		
		return spittles;
	}

	@Override
	public Spittle findOne(long spittleid) {
		// TODO Auto-generated method stub
		
		
		return new Spittle("Hello", new Date());
	}

	

}
