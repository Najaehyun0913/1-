package Domain.Dto;

public class SessionDto {
	private int sessionId;
	private String name;
	private String role;
	
	
	
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public static String getname() {
		return name;
	}
	public void setMembername(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", username=" + username + ", role=" + role + "]";
	}
	public SessionDto(int sessionId, String username, String role) {
		super();
		this.sessionId = sessionId;
		this.username = username;
		this.role = role;
	}
	public SessionDto() {
		// TODO Auto-generated constructor stub
	}
	
}
