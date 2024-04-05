package Ch36A.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import Ch36A.Dto.MemberDto;



public class MemberDao extends CommonDao implements member{

	
	//싱클톤 패턴 적용
	private static member instance;
	public static member getInstance() throws Exception {
		if(instance==null)
			instance=new MemberDao();
		return instance;
	}
	
	public MemberDao() throws Exception{
	
		System.out.println("[DAO]MemberDao's Init DB connected"+conn);
		
	}
//	insert
	@Override
	public boolean insert(MemberDto dto) throws Exception{
		pstmt=conn.prepareStatement("insert into member values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, dto.getMemberCode());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPw());
		pstmt.setString(4, dto.getName());
		pstmt.setString(5, dto.geteMail());
		pstmt.setString(6, dto.getTellphone());
		pstmt.setString(7, dto.getRole());
		
		int result=pstmt.executeUpdate();
		
		freeConnection(pstmt);
		System.out.println("insert 성공~!");
		return result>0;
		
	}
//		update
	@Override
	public boolean update(MemberDto dto) throws Exception{
		
		//이름만 변경이가능하다. membercode를 입력받으면
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
	@Override
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
		@Override
		public List<MemberDto> SelectAll() throws Exception{
			pstmt = conn.prepareStatement("select * from member");
			rs =  pstmt.executeQuery();
			List<MemberDto> list = new ArrayList();
			MemberDto dto = null;
			if(rs!=null	){
				while(rs.next()) {
					dto = new MemberDto();
					dto.setMemberCode(rs.getInt("MemberCode"));
					dto.setId(rs.getString("id"));
					dto.setPw(rs.getString("PW"));
					dto.setName(rs.getString("Name"));
					dto.seteMail(rs.getString("eMail"));
					dto.setTellphone(rs.getString("TellPhone"));
					dto.setRole(rs.getString("Role"));
					list.add(dto);
				}
			}	
			freeConnection(pstmt,rs);
			return list;
	}
		
//		
		public MemberDto seleect(String username) throws Exception {
		    pstmt = conn.prepareStatement("select * from member where name=?");
		    pstmt.setString(1, username);
		    rs = pstmt.executeQuery();
		    MemberDto dto = null;

		    // rs.next()가 true를 반환하면, 즉 결과 집합에서 데이터를 읽을 수 있으면 실행
		    if(rs.next()) {
		        dto= new MemberDto();
		        dto.setMemberCode(rs.getInt("MemberCode"));
		        dto.setId(rs.getString("id"));
		        dto.setPw(rs.getString("pw"));
		        dto.setName(rs.getString("Name"));
		        dto.seteMail(rs.getString("eMail"));
		        dto.setTellphone(rs.getString("tellPhone"));
		        dto.setRole(rs.getString("Role"));
		   
		    }
		    
		    return dto;
		}

		
//		selectOne
		@Override
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
				dto.setPw(rs.getString("PW"));
				dto.setName(rs.getString("Name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setTellphone(rs.getString("TellPhone"));
				dto.setRole(rs.getString("Role"));
			}
			freeConnection(pstmt,rs);
			return dto;
		}

		
}
