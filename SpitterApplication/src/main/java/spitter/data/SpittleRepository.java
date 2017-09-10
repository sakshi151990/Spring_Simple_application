package spitter.data;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleid);

	Spittle save(Spittle spittle);

	
	
	
}
