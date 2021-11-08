package seunghee._1_study._9_example.academic;

import java.util.ArrayList;

public interface AcademicDao {
	
	// 성적 추가 
	String insertAcademic(AcademicVO person);
	
	// 성적 전체 조회
	ArrayList<AcademicVO> listVOAcademic();
	
	// 성적 상세 조회
	AcademicVO selectAcademic(String target);
	
	// 성적 수정
	String updateAcademic(AcademicVO person);
	
	// 성적 삭제
	String deleteAcademic(String target);
}
