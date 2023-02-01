package seunghee._1_study._9_example.academic;

import java.util.ArrayList;
import java.util.Scanner;

public class AcademicServiceImpl implements AcademicService {

	Scanner sc = new Scanner(System.in);
	AcademicDaoImpl acdmDao = new AcademicDaoImpl();
	
	// 화면 출력
	@Override
	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------\n");
		sb.append(" 1. 학생 성적 입력 \n");
		sb.append(" 2. 학생 성적 조회 \n");
		sb.append(" 3. 학생 성적 상세 조회 \n");
		sb.append(" 4. 학생 성적 수정 \n");
		sb.append(" 5. 학생 성적 삭제 \n");
		sb.append(" 0. 프로그램 종료 \n");
		sb.append("-----------------\n");
		sb.append(" 원하시는 작업은 ? : ");
		System.out.print(sb.toString());
	}

	// 성적 계산
	@Override
	public void computeAcademic(AcademicVO person) {
		person.setTot(person.getKor() + person.getEng() + person.getMat());
		person.setMean(person.getTot()/3.0);
		
		switch((int) person.getMean()/10) {
		case 10 : 
		case 9 : person.setGrd('수'); break;
		case 8 : person.setGrd('우'); break;
		case 7 : person.setGrd('미'); break;
		case 6 : person.setGrd('양'); break;
		default : person.setGrd('가');
		}
	}
	
	// 성적 추가
	@Override
	public void insertAcademic() {
		AcademicVO person = new AcademicVO();
		
		System.out.print("이름을 입력해 주세요 : ");
		person.setName(sc.nextLine());
		System.out.print("국어 점수를 입력해 주세요 : ");
		person.setKor(Integer.parseInt(sc.nextLine()));
		System.out.print("영어 점수를 입력해 주세요 : ");
		person.setEng(Integer.parseInt(sc.nextLine()));
		System.out.print("수학 점수를 입력해 주세요 : ");
		person.setMat(Integer.parseInt(sc.nextLine()));
		
		computeAcademic(person);
		
		String result = acdmDao.insertAcademic(person);
		System.out.println(result);
	}
	
	// 성적 전체 조회
	@Override
	public void listVOAcademic() {
		String fmt = "번호 : %2d, 이름 : %s, 국어 : %d, 영어 : %d, 수학 : %d, 등록일 : %s\n";
		StringBuilder sb = new StringBuilder();
		
		ArrayList<AcademicVO> persons = acdmDao.listVOAcademic();
		for(AcademicVO person : persons) {
			String result = String.format(fmt, person.getAno(), person.getName(), person.getKor(), person.getEng(), person.getMat(), person.getRegdate());
			sb.append(result);
		}
		System.out.println(sb.toString());
	}

	// 성적 상세 조회
	@Override
	public void selectAcademic() {
		System.out.print("상세 조회할 학생의 번호를 입력해 주세요 : ");
		String target = sc.nextLine();
		
		AcademicVO person = acdmDao.selectAcademic(target);
		String fmt = "번호 : %2d, 이름 : %s, 국어 : %d, 영어 : %d, 수학 : %d, "
				+ "총점 : %d, 평균 : %.2f, 학점 : %s, 등록일 : %s\n";
		String result = String.format(fmt, person.getAno(), person.getName(), person.getKor(), person.getEng(), person.getMat(), person.getTot(),
				person.getMean(), person.getGrd(), person.getRegdate());
		System.out.println(result);
	}

	// 성적 수정
	@Override
	public void updateAcademic() {
		AcademicVO person = new AcademicVO();
		
		System.out.print("수정할 학생의 번호를 입력해 주세요 : ");
		person.setAno(Integer.parseInt(sc.nextLine()));
		System.out.print("국어 점수를 입력해 주세요 : ");
		person.setKor(Integer.parseInt(sc.nextLine()));
		System.out.print("영어 점수를 입력해 주세요 : ");
		person.setEng(Integer.parseInt(sc.nextLine()));
		System.out.print("수학 점수를 입력해 주세요 : ");
		person.setMat(Integer.parseInt(sc.nextLine()));
		
		computeAcademic(person);
		
		String result = acdmDao.updateAcademic(person);
		System.out.println(result);
	}

	// 성적 삭제
	@Override
	public void deleteAcademic() {
		System.out.print("삭제할 성적 번호를 입력해 주세요 : ");
		String target = sc.nextLine();
		
		String result = acdmDao.deleteAcademic(target);
		System.out.println(result);
	}
}
