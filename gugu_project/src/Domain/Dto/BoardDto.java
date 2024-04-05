package Domain.Dto;

import java.sql.Date;

public class BoardDto {
	// comuCode, Member_id 받아와야함
	private String Title;
	private String Content;
	private Date Date; // sql date 받아오기
	private String Comment;
	
	//디폴트생성자/ 모든인자 생성자 추가하기
	public BoardDto() {}
	
	
	
	public BoardDto(String title, String content, java.sql.Date date, String comment) {
		super();
		Title = title;
		Content = content;
		Date = date;
		Comment = comment;
	}


	//getter and setter
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoardDto [Title=" + Title + ", Content=" + Content + ", Date=" + Date + ", Comment=" + Comment + "]";
	}
	
	
	
}
