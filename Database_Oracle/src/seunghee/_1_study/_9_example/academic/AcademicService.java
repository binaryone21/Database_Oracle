package seunghee._1_study._9_example.academic;

public interface AcademicService {
	
	// 화면 출력
	void display();
	
	// 성적 계산
	void computeAcademic(AcademicVO person);
	
	// 성적 추가
	void insertAcademic();
	
	// 성적 전체 조회
	void listVOAcademic();
	
	// 성적 상세 조회
	void selectAcademic();
	
	// 성적 수정
	void updateAcademic();
	
	// 성적 삭제
	void deleteAcademic();
}
