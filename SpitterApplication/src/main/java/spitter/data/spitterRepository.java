package spitter.data;

public interface spitterRepository {
	void save(Spitter unsaved);

 Spitter findByUsername(String username) ;
		
	
}
