package Domain.Dto;

public class ADDto {
	private int ADNum; 		// 광고 번호(구분자)
    private String cominfo; // 회사 정보
    private String walfare; // 복지
    private String salary;  // 급여
    private String work;    // 업무

    // 모든 인자를 받는 생성자
    public ADDto(String cominfo, String salary, String walfare, String work) {
        super();
        this.cominfo = cominfo;
        this.walfare = walfare;
        this.salary = salary;
        this.work = work;
    }

    // 디폴트 생성자
    public ADDto() {}

    // toString 메서드
    @Override
    public String toString() {
        return "ADServiceDtoImpl [cominfo=" + cominfo +  ", salary=" + salary + ", walfare=" + walfare + ", work=" + work + "]";
    }

    // getter 및 setter 메서드
    public String getCominfo() {
        return cominfo;
    }

    public void setCominfo(String cominfo) {
        this.cominfo = cominfo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public String getWalfare() {
        return walfare;
    }

    public void setWalfare(String walfare) {
        this.walfare = walfare;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}

