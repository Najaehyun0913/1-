package Domain.Dto;

public class PRDto {
	private int PRNum;		// PR번호(구분자)
	private String info; 	// 기본정보
	private String edu; 	// 학력
	private String career; 	// 경력
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "PRDto [info=" + info + ", edu=" + edu + ", career=" + career + "]";
	}
	public PRDto(String info, String edu, String career) {
		super();
		this.info = info;
		this.edu = edu;
		this.career = career;
	}
	
	public PRDto() {}
	public int getPRNum() {
		return PRNum;
	}
	public void setPRNum(int pRNum) {
		PRNum = pRNum;
	}

}
