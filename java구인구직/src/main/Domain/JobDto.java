package main.Domain;

public class JobDto {
	private int applyCode;
	private boolean applyClassify;

	@Override
	public String toString() {
		return "JobDto [applyCode=" + applyCode + ", applyClassify=" + applyClassify + "]";
	}

	public int getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(int applyCode) {
		this.applyCode = applyCode;
	}

	public boolean isApplyClassify() {
		return applyClassify;
	}

	public void setApplyClassify(boolean applyClassify) {
		this.applyClassify = applyClassify;
	}

	public JobDto(int applyCode, boolean applyClassify) {
		super();
		this.applyCode = applyCode;
		this.applyClassify = applyClassify;
	}

	public JobDto(int i) {

	}

}
