package seunghee._1_study._9_example.academic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcademicDaoImpl implements AcademicDao {

	AcademicJDBC jdbc = new AcademicJDBC();
	
	// 성적 추가
	@Override
	public String insertAcademic(AcademicVO person) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String result = "데이터 업로드 실패";
		
		try {
			conn = jdbc.makeConn();
			pstmt = conn.prepareStatement(jdbc.insertSQL);
			pstmt.setString(1, person.getName());
			pstmt.setInt(2, person.getKor());
			pstmt.setInt(3, person.getEng());
			pstmt.setInt(4, person.getMat());
			pstmt.setInt(5, person.getTot());
			pstmt.setDouble(6, person.getMean());
			pstmt.setString(7, String.valueOf(person.getGrd()));
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				result = "데이터 업로드 성공";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.closeConn(pstmt, conn);
		}
		
		return result;
	}

	// 성적 전체 조회
	@Override
	public ArrayList<AcademicVO> listVOAcademic() {
		ArrayList<AcademicVO> persons = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jdbc.makeConn();
			pstmt = conn.prepareStatement(jdbc.listVOSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AcademicVO person = new AcademicVO();
				person.setAno(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setKor(rs.getInt(3));
				person.setEng(rs.getInt(4));
				person.setMat(rs.getInt(5));
				person.setRegdate(rs.getString(6));
				persons.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.closeConn(rs, pstmt, conn);
		}
		
		return persons;
	}

	// 성적 상세 조회
	@Override
	public AcademicVO selectAcademic(String target) {
		AcademicVO person = new AcademicVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jdbc.makeConn();
			pstmt = conn.prepareStatement(jdbc.selectSQL);
			pstmt.setString(1, target);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				person.setAno(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setKor(rs.getInt(3));
				person.setEng(rs.getInt(4));
				person.setMat(rs.getInt(5));
				person.setTot(rs.getInt(6));
				person.setMean(rs.getDouble(7));
				person.setGrd(rs.getString(8).charAt(0));
				person.setRegdate(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.closeConn(rs, pstmt, conn);
		}
		
		return person;
	}

	// 성적 수정
	@Override
	public String updateAcademic(AcademicVO person) {
		String result = "업데이트 실패";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = jdbc.makeConn();
			pstmt = conn.prepareStatement(jdbc.updateSQL);
			pstmt.setInt(1, person.getKor());
			pstmt.setInt(2, person.getEng());
			pstmt.setInt(3, person.getMat());
			pstmt.setInt(4, person.getTot());
			pstmt.setDouble(5, person.getMean());
			pstmt.setString(6, String.valueOf(person.getGrd()));
			pstmt.setInt(7, person.getAno());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				result = "업데이트 성공";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.closeConn(pstmt, conn);
		}
		
		return result;
	}

	// 성적 삭제
	@Override
	public String deleteAcademic(String target) {
		String result = "삭제 실패";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = jdbc.makeConn();
			pstmt = conn.prepareStatement(jdbc.deleteSQL);
			pstmt.setString(1, target);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				result = "삭제 성공";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.closeConn(pstmt, conn);
		}
		
		return result;
	}

}
