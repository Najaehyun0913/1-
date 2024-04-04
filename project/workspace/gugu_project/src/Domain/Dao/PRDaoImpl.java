package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.ApplyDto;
import Domain.Dto.PRDto;

public class PRDaoImpl extends CommonDao implements PRDao{
	
	private static PRDao instance;  // PRDao 인터페이스 생성및 싱글톤 패턴 적용 
	public static PRDao getInstance() throws Exception{
		if(instance==null)
			instance=new PRDaoImpl();
		return instance;
	}
	
	public PRDaoImpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("[DAO] PRDaoImpl's INIT DB CONNECTED..");
		
	}
	
	//INSERT
	@Override
	public boolean Insert(PRDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into PR values(?,?,?");  
		pstmt.setString(1, dto.getInfo());
		pstmt.setString(2, dto.getEdu());
		pstmt.setString(3, dto.getCareer());
		
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
	}
	//DELETE
	@Override
	public boolean delete(int PRInfo) throws Exception{
		pstmt = conn.prepareStatement("delete from PR where info=?");
		pstmt.setInt(1, PRInfo);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return result>0;
	}
	//SELECTALL
	@Override
	public List<PRDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from PR");
		rs = pstmt.executeQuery();
		List<PRDto> list = new ArrayList();
		PRDto dto = null;
		
		if(rs !=null )
		{
			while(rs.next()) {
				dto = new PRDto();
				dto.setInfo(rs.getString("PRinfo"));
				dto.setEdu(rs.getString("PRedu"));
				dto.setCareer(rs.getString("PRcarrer"));
				list.add(dto);
			}
		}
		freeConnection(pstmt,rs);
		return list;
	}
	
	// SELECTONE
	@Override
	public PRDto Select(int PRNum) throws Exception {
		pstmt = conn.prepareStatement("select * from PR where PRNum=?");
		pstmt.setInt(1, PRNum);
		rs = pstmt.executeQuery();

		PRDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new PRDto();
				dto.setInfo(rs.getString("PRinfo"));
				dto.setEdu(rs.getString("PRedu"));
				dto.setCareer(rs.getString("PRcarrer"));
			}
		}
		freeConnection(pstmt,rs);
		return dto;

	}
	
}
