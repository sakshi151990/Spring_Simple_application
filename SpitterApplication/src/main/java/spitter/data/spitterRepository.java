package spitter.data;

public interface spitterRepository {
	Spitter save(Spitter unsaved);

	static Spitter findByUsername(String username) {
		
		return new Spitter(username,  "24hours", "Jack", "Bauer");
	}
}
