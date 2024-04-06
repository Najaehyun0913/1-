package Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Dao.Common.CommonDao;
import Domain.Dto.MemberDto;


public class MemberDaoImpl extends CommonDao implements MemberDao{
	
	private static MemberDao instance ;
	public static MemberDao getInstance() throws Exception {
		if(instance==null)
			instance=new MemberDaoImpl();
		return instance;
	}
	
	private MemberDaoImpl() throws Exception{
		System.out.println("[DAO] MemberDaoImpl's INIT..."+conn);

	}
	
	//INSERT
	@Override
	public boolean Insert(MemberDto dto) throws Exception{
		pstmt =  conn.prepareStatement("insert into user values(?,?,?,?)");
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		System.out.println("insert 성공");
		return result>0;
	}
	
	
	//UPDATE
	@Override
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
	
//	Delete
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
		
		
	
	
	
	//SELECTALL
	@Override
	public List<MemberDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from Member");
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
	
	
	//SELECTONE
	@Override
	public MemberDto Select(String name) throws Exception{
		pstmt = conn.prepareStatement("select * from member where MemberCode=?");
		pstmt.setString(1, membercode);
		rs = pstmt.executeQuery();
		MemberDto dto = null;
		
		if(rs!=null) {
			if(rs.next()) {
				rs.next();
				dto= new MemberDto();
				dto.setMemberCode(rs.getInt("MemberCode"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("Name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setTellphone(rs.getString("tellPhone"));
			}
			
		}
		freeConnection(pstmt,rs);
		return dto;	
	}
	
	
	
	
	
	
	
}
