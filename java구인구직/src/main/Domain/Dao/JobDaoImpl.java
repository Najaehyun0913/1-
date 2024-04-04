package main.Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import main.Domain.JobDto;

public class JobDaoImpl extends CommonDao {
	// 싱글톤 인스턴스 생성
	private static JobDaoImpl instance;

	// 싱글톤 인스턴스 반환 메서드
	public static JobDaoImpl getInstance() throws Exception {
		if (instance == null) {
			synchronized (JobDaoImpl.class) {
				if (instance == null) {
					instance = new JobDaoImpl();
				}
			}
		}
		return instance;
	}

	// private 생성자
	private JobDaoImpl() throws Exception {
		System.out.println("[DAO] JobDaoImpl's INIT...");
	}

	// INSERT
	public boolean Insert(JobDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into apply values(?,?)");
		pstmt.setInt(1, dto.getApplyCode());
		pstmt.setBoolean(2, dto.isApplyClassify());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;
	}

	// UPDATE
	public boolean Update(JobDto dto) throws Exception {
		pstmt = conn.prepareStatement("update apply set applyClassify = ? where applyCode = ?");
		pstmt.setBoolean(1, dto.isApplyClassify());
		pstmt.setInt(2, dto.getApplyCode());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;
	}

	// DELETE
	public boolean Delete(JobDto dto) throws Exception {
		pstmt = conn.prepareStatement("delete from apply where applyCode = ?");
		pstmt.setInt(1, dto.getApplyCode());
		int result = pstmt.executeUpdate();

		pstmt.close();
		return result > 0;
	}

	// SELECTALL
	public List<JobDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from book");
		rs = pstmt.executeQuery();
		List<JobDto> list = new ArrayList<>();
		JobDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new JobDto(0);
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
	public JobDto Select(int applyCode) throws Exception {
		pstmt = conn.prepareStatement("select * from book where bookCode=?");
		pstmt.setInt(1, applyCode);
		rs = pstmt.executeQuery();

		JobDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new JobDto(applyCode);
				dto.setApplyCode(rs.getInt("applyCode"));
				dto.setApplyClassify(rs.getBoolean("applyClassify"));
			}
		}
		rs.close();
		pstmt.close();
		return dto;
	}
}