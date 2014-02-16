package gen.wzp.main.domain;

public class UserPosition {

	private int uid;
	private double longitude;
	private double latitude;
	private String time;

	public UserPosition() {

	}

	public UserPosition(int uid, double longitude, double latitude, String time) {
		super();
		this.uid = uid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.time = time;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
