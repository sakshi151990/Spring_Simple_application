package spitter.data;

import java.util.Date;

public class Spittle {

	public Spittle() {
		super();
	}
	private Long id;
	private  String message;
	private  Date time;
	private Double latitude;
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
	private Double longitude;
	
	public Spittle(String message, Date time) {
		this(message, time, null, null);

	}
	public Spittle(
			String message, Date time, Double longitude, Double latitude) {
			this.id = null;
			this.message = message;
			this.time = time;
			this.longitude = longitude;
			this.latitude = latitude;
			}
	public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
}
