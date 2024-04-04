package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.BoardDto;
import Domain.Dto.comuDto;

public class comuDaoImpl {
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public comuDaoImpl() throws Exception{ // 실행하는 위치에서 예외처리
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // driver 경로
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO] BookDaoImpl's INIT DB Connected...");
	}
	
	//INSERT
	public boolean Insert(comuDto dto, BoardDto bdto) throws Exception{
		pstmt = conn.prepareStatement("insert into comu values(?,?,?,?)");
		pstmt.setInt(1, dto.getComuCode());
		pstmt.setString(2, bdto.getTitle());
		pstmt.setString(3, bdto.getContent());
		pstmt.setDate(4, bdto.getDate());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result>0;
	}
	//UPDATE
	public boolean Update(comuDto dto,BoardDto bdto) throws Exception{
		pstmt = conn.prepareStatement("update book set Content=? where comuCode=?");
		pstmt.setString(1, bdto.getContent());
		pstmt.setInt(2, dto.getComuCode());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result>0;
	}
	//DELETE
	public boolean Delete(comuDto dto) throws Exception{
		pstmt = conn.prepareStatement("delete from book where comuCode=?");
		pstmt.setInt(1, dto.getComuCode());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result>0;
	}
	//SELECTALL
	public List<comuDto> SelectAll() throws Exception{
		// select 기본 코드
		pstmt = conn.prepareStatement("select * from book");
		rs = pstmt.executeQuery();
		List<comuDto> list = new ArrayList();
		comuDto dto = null;
		BoardDto bdto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new comuDto();
				bdto = new BoardDto();
				dto.setComuCode(rs.getInt("comuCode"));
				bdto.setTitle(rs.getString("Title"));
				bdto.setContent(rs.getString("Content"));
				bdto.setDate(rs.getDate("Date"));
				list.add(dto);
			}
		}
		
		rs.close();
		pstmt.close();
		return list;
	}
	//SELECTONE
	public comuDto Select(int comuCode) throws Exception{
		
		pstmt = conn.prepareStatement("select * from book where bookCode=?");
		pstmt.setInt(1, comuCode);
		
		rs = pstmt.executeQuery();
		comuDto dto = null;
		BoardDto bdto = null;
		if(rs!=null) {
			rs.next();
			dto = new comuDto();
			bdto = new BoardDto();
			dto.setComuCode(rs.getInt("comuCode"));
			bdto.setTitle(rs.getString("Title"));
			bdto.setContent(rs.getString("Content"));
			bdto.setDate(rs.getDate("Date"));
		}
		
		rs.close();
		pstmt.close();
		return dto;
	}

	
}
