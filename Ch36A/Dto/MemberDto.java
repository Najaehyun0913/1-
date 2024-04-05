package Ch36A.Dto;

public class MemberDto {
	private int MemberCode;
	private String Id;
	private String PW;
	private String Name;
	private String eMail;
	private String TellPhone;
	private String Role;
	public MemberDto() {}
	@Override
	public String toString() {
		return "MemberDto [MemberCode=" + MemberCode + ", Id=" + Id + ", pw=" + PW + ", name=" + Name + ", eMail="
				+ eMail + ", tellphone=" + TellPhone + ", role=" + Role + "]";
	}
	public MemberDto(int memberCode, String id, String pw, String name, String eMail, String tellphone, String role) {
		super();
		MemberCode = memberCode;
		Id = id;
		this.PW = pw;
		this.Name = name;
		this.eMail = eMail;
		this.TellPhone = tellphone;
		this.Role = role;
	}
	public int getMemberCode() {
		return MemberCode;
	}
	public void setMemberCode(int memberCode) {
		MemberCode = memberCode;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return PW;
	}
	public void setPw(String pw) {
		this.PW = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTellphone() {
		return TellPhone;
	}
	public void setTellphone(String tellphone) {
		this.TellPhone = tellphone;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		this.Role = role;
	}


	
}
