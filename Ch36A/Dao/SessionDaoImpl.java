package Ch36A.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ch36A.Dto.SessionDto;

public class SessionDaoImpl extends CommonDao implements session {
	
//	싱클톤 패턴
	private static session instance;
	public static session getinstance() throws Exception {
		if(instance==null)
			instance=new SessionDaoImpl();
		return instance;
	}
	

//	생성자 생성
	private SessionDaoImpl() throws Exception{
		System.out.println("[DAO] SessionDaoImpl's INIT DB Connected...");
		
		
	}
//	session 용 insert
	@Override
	public boolean insert(SessionDto dto) throws Exception{
		//쿼리문 작성
		pstmt=conn.prepareStatement("insert into session values(null,?,?)");
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTellphone());
		int result =pstmt.executeUpdate();	
		return result>0;
	}
	
//	session 용 select id로 찾기
	@Override
	public SessionDto select(int sessionid) throws Exception {
		pstmt=conn.prepareStatement("select *from session where id=?");
		pstmt.setInt(1, sessionid);
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setName(rs.getString("name"));
			dto.setSessionId(rs.getInt("id"));
			dto.setTellphone(rs.getString("tellphone"));
		}
		return dto;
	}
	
//	sessioname으로 조회하기
	public SessionDto select1(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username=? order by id desc");
		pstmt.setString(1,username);
		
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setName(rs.getString("name"));
			dto.setTellphone(rs.getString("tellphone"));
			dto.setSessionId(rs.getInt("id"));
		}
		freeConnection(pstmt,rs);
		return dto;
	}
	
//	selcet All 
	@Override
	public List<SessionDto> selectAll() throws Exception{
		pstmt=conn.prepareStatement("select *from session");
		rs=pstmt.executeQuery();
		List<SessionDto> list=new ArrayList();
		SessionDto dto=null;
		if(rs!=null) {
			while(rs.next()) {
				dto=new SessionDto();
				dto.setName(rs.getString("name"));
				dto.setSessionId(rs.getInt("sessionId"));
				dto.setTellphone(rs.getString("tellphone"));
				list.add(dto);
			}
		}
		freeConnection(pstmt,rs);
		return list;
	}
//	session 로그아웃시 delete 삭제용 
	public boolean Delete(int sessionId) throws SQLException {
		pstmt=conn.prepareStatement("delete from session where sessionId=?");
		pstmt.setInt(1, sessionId);
		int result=pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
				
	}


	@Override
	public SessionDto select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where name=? order by sessionid desc");
		pstmt.setString(1,username);		
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setName(rs.getString("name"));
			dto.setTellphone(rs.getString("tellphone"));
			dto.setSessionId(rs.getInt("sessionId"));
		}
		freeConnection(pstmt,rs);
		return dto;
	}

	
}
