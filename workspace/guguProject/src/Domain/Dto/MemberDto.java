package Domain.Dto;

public class MemberDto {

	private int MemberCode;
	private String id;
	private String name;
	private String password;
	private String eMail;
	private String tellPhone;
	private String role; // get role 추가
	public int getMemberCode() {
		return MemberCode;
	}
	public void setMemberCode(int memberCode) {
		MemberCode = memberCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTellPhone() {
		return tellPhone;
	}
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberDto [MemberCode=" + MemberCode + ", id=" + id + ", name=" + name + ", password=" + password
				+ ", eMail=" + eMail + ", tellPhone=" + tellPhone + ", role=" + role + "]";
	}
	public MemberDto(int memberCode, String id, String name, String password, String eMail, String tellPhone,
			String role) {
		super();
		MemberCode = memberCode;
		this.id = id;
		this.name = name;
		this.password = password;
		this.eMail = eMail;
		this.tellPhone = tellPhone;
		this.role = role;
	}
	
	public MemberDto() {}




	
	
	
}
