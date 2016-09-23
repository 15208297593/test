package com.dengqi.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JdbcSequence {
	public static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	public static final String driverName = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "123456";

	private static Logger logger = Logger.getLogger(JdbcSequence.class);
	public static void main(String[] args) {
		InsertBySequencePrepare();
	}

	public static void InsertBySequencePrepare() {
		Connection conn = null;
		// PreparedStatement pstmt = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
	}

}