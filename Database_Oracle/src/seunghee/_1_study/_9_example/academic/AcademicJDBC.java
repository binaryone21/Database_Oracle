package seunghee._1_study._9_example.academic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AcademicJDBC {
	
	// 성적 추가 SQL
	public String insertSQL = "insert into ACADENIC (ano, name, kor, eng, mat, tot, mean, grd) values (ac_seq.nextval,?,?,?,?,?,?,?)";
	// 성적 전체 조회 SQL
	public String listVOSQL = "select sno, name, kor, eng, mat, regdate from ACADENIC order by ano";
	// 성적 상세 조회 SQL
	public String selectSQL = "select * from ACADENIC where ano = ?";
	// 성적 수정 SQL
	public String updateSQL = "update ACADENIC set kor=?, eng=? ,mat=?, tot=?, mean=?, grd=?, regdate=sysdate where ano=?";
	// 성적 삭제 SQL
	public String deleteSQL = "delete from ACADENIC where ano = ?";
	
	// JDBC 연결
	public Connection makeConn() {
		Connection conn = null;
		String drv = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String usr = "academic";
		String pwd = "test1234";
		
		try {
			Class.forName(drv);
			conn = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// JDBC 해제
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// JDBC 해제	
	public void closeConn(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
