package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.MemberDto;

public class MemberDao {
	private String url="jdbc:mysql://localhost:3306/memberdb";
	private String id="root";
	private String pw="1234";
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public MemberDao() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn =DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO]MemberDao's Init DB connected");
		
	}
//	insert
	public boolean insert(MemberDto dto) throws Exception{
		pstmt=conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
		pstmt.setInt(1, dto.getMemberCode());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPw());
		pstmt.setString(4, dto.getName());
		pstmt.setString(5, dto.geteMail());
		pstmt.setString(6, dto.getTellphone());
		int result=pstmt.executeUpdate();
		
		pstmt.close();
		System.out.println("insert 성공~!");
		return result>0;
		
	}
//		update
	public boolean update(MemberDto dto) throws Exception{
		
		
		pstmt =	conn.prepareStatement("update member set name=? where MemberCode=?");
		pstmt.setString(1, dto.getName());
		pstmt.setInt(2, dto.getMemberCode());

		int result =  pstmt.executeUpdate();
		
		if(result>0)
			System.out.println("UPDATE 성공");
		else
			System.out.println("UPDATE 실패");
		
		return result>0;
	}
		
//		Delete
	public boolean delete(MemberDto dto)throws Exception{
		System.out.println("DB Connected..");
		
		pstmt =	conn.prepareStatement("delete from member where MemberCode=?");
		pstmt.setInt(1, dto.getMemberCode());
		
		
		int result =  pstmt.executeUpdate();
		
		if(result>0)
			System.out.println("DELETE 성공");
		else
			System.out.println("DELETE 실패");
		
		return result>0;
	}
//		SelectAll
		public List<MemberDto> SelectAll() throws Exception{
			pstmt = conn.prepareStatement("select * from member");
			rs =  pstmt.executeQuery();
			List<MemberDto> list = new ArrayList();
			MemberDto dto = null;
			if(rs!=null)
			{
				while(rs.next()) {
					dto = new MemberDto();
					dto.setMemberCode(rs.getInt("MemberCode"));
					dto.setId(rs.getString("Memberid"));
					dto.setPw(rs.getString("Pw"));
					dto.setName(rs.getString("Name"));
					dto.seteMail(rs.getString("eMail"));
					dto.setTellphone(rs.getString("tellPhone"));
					list.add(dto);
				}
			}	
			rs.close();
			pstmt.close();
			return list;
	} 
//		selectOne
		public MemberDto select(int membercode) throws Exception{
			pstmt = conn.prepareStatement("select * from member where Membercode=?");
			pstmt.setInt(1, membercode);
			rs =  pstmt.executeQuery();
			MemberDto dto=null;
			if(rs!=null) {
				rs.next();
				dto= new MemberDto();
				dto.setMemberCode(rs.getInt("MemberCode"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("Name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setTellphone(rs.getString("tellPhone"));
			}
			rs.close();
			pstmt.close();
			return dto;
		}
}
