package Domain.Dto;

public class comuDto {
	private int comuCode;
	
	//디폴트생성자/ 모든인자 생성자 추가하기
	public comuDto() {}
	
	public comuDto(int comuCode) {
		super();
		this.comuCode = comuCode;
	}

	//getter and setter
	public int getComuCode() {
		return comuCode;
	}

	public void setComuCode(int comuCode) {
		this.comuCode = comuCode;
	}
	
	//toString
	@Override
	public String toString() {
		return "comuDto [comuCode=" + comuCode + "]";
	}
	
	
	
}
