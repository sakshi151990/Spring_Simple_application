package spitter.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleRepositoryIML implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
	
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle"+i,new Date()));
			}
			
		
		return spittles;
	}

	@Override
	public Spittle findOne(long spittleid) {
System.out.println("indside findone");
if(spittleid == 1 )
{	 Spittle spittle = new Spittle(1L, "message", new Date(), 3.0, 4.0);
return spittle;}
else
	return null;
	}

	@Override
	public Spittle save(Spittle spittle) {

		return spittle;
	}

	

}
