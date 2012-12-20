package ie.cit.cloud.mvc.model;

public class LogEntry {
	
	String lo_message_start_time;
	String lo_message_test_id; 
	String lo_message_channel;
	String lo_message_service;
	String lo_message_timestamp;
	
	
	public String getLo_message_start_time() {
		return lo_message_start_time;
	}
	public void setLo_message_start_time(String lo_message_start_time) {
		this.lo_message_start_time = lo_message_start_time;
	}
	public String getLo_message_end_time() {
		return lo_message_test_id;
	}
	public void setLo_message_test_id(String lo_message_test_id) {
		this.lo_message_test_id = lo_message_test_id;
	}
	public String getLo_message_channel() {
		return lo_message_channel;
	}
	public void setLo_message_channel(String lo_message_channel) {
		this.lo_message_channel = lo_message_channel;
	}
	public String getLo_message_service() {
		return lo_message_service;
	}
	public void setLo_message_service(String lo_message_service) {
		this.lo_message_service = lo_message_service;
	}
	public String getLo_message_timestamp() {
		return lo_message_timestamp;
	}
	public void setLo_message_timestamp(String lo_message_timestamp) {
		this.lo_message_timestamp = lo_message_timestamp;
	}
		
}

