package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.Dto.MemberDto;
import Domain.Dto.SessionDto;

public class CommonDao {

	protected Connection conn= null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	protected ConnectionPool connectionPool;
	
	public CommonDao() throws Exception{
		connectionPool = ConnectionPool.getInstance();
		conn = connectionPool.getConnection();
		
		public void freeConnection(Connection conn) throws SQLException {
			conn.close();
		}
		public void freeConnection(Connection conn,PreparedStatement pstmt) throws SQLException {
			pstmt.close();
			conn.close();
			
		}
		public void freeConnection(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
			rs.close();
			pstmt.close();
			conn.close();
		}
		public void freeConnection(PreparedStatement pstmtp) throws SQLException {
			pstmt.close();
		}
		public void freeConnection(PreparedStatement pstmtp,ResultSet rs) throws SQLException {
			rs.close();
			pstmt.close();
		}
		
		
		
		
	}

	public boolean Insert(SessionDto sessionDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Delete(int sessionId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public SessionDto Select(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionDto Select(int sessionId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
