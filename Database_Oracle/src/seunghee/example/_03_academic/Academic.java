package seunghee._1_study._9_example.academic;

import java.util.Scanner;

public class Academic {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AcademicServiceImpl acdmSvc = new AcademicServiceImpl();
		
		String check = "";
		while ( !check.equals("0")) {
			acdmSvc.display();
			check = sc.nextLine();
			
			switch(check) {
				// 성적 추가
				case "1" : acdmSvc.insertAcademic(); break;
				// 성적 전체 조회
				case "2" : acdmSvc.listVOAcademic(); break;
				// 성적 상세 조회
				case "3" : acdmSvc.selectAcademic(); break;
				// 성적 수정
				case "4" : acdmSvc.updateAcademic(); break;
				// 성적 삭제
				case "5" : acdmSvc.deleteAcademic(); break;
				// 프로그램 종료
				case "0" : System.out.println("프로그램을 종료합니다."); break;
				// 기타
				default : System.out.println("번호를 다시 확인해주세요.");
			}
		}
	}
}
