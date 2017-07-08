package spitter.data;

import java.util.Date;

public class Spittle {

	private final Long id;
	private final String message;
	private final Date time;
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
	
	
}
