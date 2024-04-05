package Ch36A.Dto;

public class SessionDto {
	private int SessionId;
	private String Name;
	private String TellPhone;
	private String Role;
	
	public SessionDto() {}
//	생성자

	@Override
	public String toString() {
		return "SessionDto [SessionId=" + SessionId + ", Name=" + Name + ", TellPhone=" + TellPhone + ", Role=" + Role
				+ "]";
	}
public SessionDto(int sessionId, String name, String tellPhone, String role) {
	super();
	SessionId = sessionId;
	Name = name;
	TellPhone = tellPhone;
	Role = role;
}

public int getSessionId() {
	return SessionId;
}

public void setSessionId(int sessionId) {
	SessionId = sessionId;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getTellPhone() {
	return TellPhone;
}

public void setTellPhone(String tellPhone) {
	TellPhone = tellPhone;
}

public String getRole() {
	return Role;
}

public void setRole(String role) {
	Role = role;
}




	
	
}
