package Ch36A.Dto;

public class SessionDto {
	private int sessionId;
	private String name;
	private String tellphone;
	
	public SessionDto() {}
//	생성자

	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", name=" + name + ", tellphone=" + tellphone + "]";
	}

	public SessionDto(int sessionId, String name, String tellphone) {
		super();
		this.sessionId = sessionId;
		this.name = name;
		this.tellphone = tellphone;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTellphone() {
		return tellphone;
	}

	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}


	
	
}
