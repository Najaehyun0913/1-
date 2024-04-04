package main.Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonDao {
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	protected ConnectionPool connectionPool;

	public CommonDao() throws Exception {
		connectionPool = ConnectionPool.getInstance();
		conn = connectionPool.getConnection();
	}
}