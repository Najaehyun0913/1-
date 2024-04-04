package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.ApplyDto;


public class ApplyDaoImpl {
	private String url = "jdbc:mysql://localhost:3306/jobdb";
	private String id = "root";
	private String pw = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ApplyDaoImpl() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("[DAO] BookDaoImpl's INIT DB Connected...");
	}

	// INSERT
	public boolean Insert(ApplyDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into apply values(?,?)");
		pstmt.setInt(1, dto.getApplyCode());
		pstmt.setBoolean(2, dto.isApplyClassify());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;

	}

	// UPDATE
	public boolean Update(ApplyDto dto) throws Exception {
		pstmt = conn.prepareStatement("update apply set applyClassify = ? where applyCode = ?");
		pstmt.setBoolean(1, dto.isApplyClassify());
		pstmt.setInt(2, dto.getApplyCode());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;
	}

	// DELETE
	public boolean Delete(ApplyDto dto) throws Exception {
		pstmt = conn.prepareStatement("delete from apply where applyCode = ?");
		pstmt.setInt(1, dto.getApplyCode());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;
	}

	// SELECTALL
	public List<ApplyDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from book");
		rs = pstmt.executeQuery();
		List<ApplyDto> list = new ArrayList();
		ApplyDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new ApplyDto(0);
				dto.setApplyCode(rs.getInt("bookCode"));
				dto.setApplyClassify(false);

				list.add(dto);

			}
		}
		rs.close();
		pstmt.close();
		return list;

	}

	// SELECTONE
	public ApplyDto Select(int applyCode) throws Exception {
		pstmt = conn.prepareStatement("select * from book where bookCode=?");
		pstmt.setInt(1, applyCode);
		rs = pstmt.executeQuery();

		ApplyDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new ApplyDto(applyCode);
				dto.setApplyCode(rs.getInt("applyCode"));
				dto.setApplyClassify(rs.getBoolean("applyClassify"));
			}
		}
		rs.close();
		pstmt.close();
		return dto;

	}
}
