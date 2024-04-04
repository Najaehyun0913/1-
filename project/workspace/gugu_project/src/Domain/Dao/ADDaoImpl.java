package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Domain.Dto.ADDto;

public class ADDaoImpl {
    // 데이터베이스 연결 정보
    private String url = "jdbc:mysql://localhost:3306/ad";
    private String id = "root";
    private String pw = "1234";

    // 데이터베이스 연결 및 쿼리 실행을 위한 객체
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // ADDaoImpl 생성자
    public ADDaoImpl() throws Exception {
        // JDBC 드라이버 로드 및 데이터베이스 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, id, pw);
        System.out.println("[DAO] ADDaoImpl's INIT DB Connected...");
    }

    // INSERT 메서드: 광고 정보를 추가하는 메서드
    public boolean Insert(ADDto adDto) throws Exception {
    	pstmt = conn.prepareStatement("INSERT INTO ad (cominfo, salary, walfare, work) VALUES (?, ?, ?, ?)");
        pstmt.setString(1, adDto.getCominfo());
        pstmt.setString(2, adDto.getSalary());
        pstmt.setString(3, adDto.getWalfare());
        pstmt.setString(4, adDto.getWork());
        int result = pstmt.executeUpdate();

        // 결과 반환
        pstmt.close();
        return result > 0;
    }

    // SELECTALL 메서드: 모든 광고 정보를 조회하는 메서드
    public List<ADDto> SelectAll() throws Exception {
        pstmt = conn.prepareStatement("select * from ad");
        rs = pstmt.executeQuery();
        List<ADDto> list = new ArrayList<>();
        ADDto dto = null;
        if (rs != null) {
            while (rs.next()) {
                dto = new ADDto();
                dto.setCominfo(rs.getString("cominfo"));
                dto.setSalary(rs.getString("salary"));
                dto.setWalfare(rs.getString("walfare"));
                dto.setWork(rs.getString("work"));
                list.add(dto);
            }
        }
        rs.close();
        pstmt.close();
        return list;
    }

    // SELECTONE 메서드: 특정 광고 정보를 조회하는 메서드
    public ADDto Select(String cominfo) throws Exception {
        pstmt = conn.prepareStatement("select * from ad where cominfo=?");
        pstmt.setString(1, cominfo);
        rs = pstmt.executeQuery();

        ADDto dto = null;
        if (rs != null) {
            rs.next();
            dto = new ADDto();
            dto.setCominfo(rs.getString("cominfo"));
            dto.setSalary(rs.getString("salary"));
            dto.setWalfare(rs.getString("walfare"));
            dto.setWork(rs.getString("work"));
        }
        rs.close();
        pstmt.close();
        return dto;
    }
}
