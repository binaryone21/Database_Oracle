package seunghee._1_study._9_example.academic;

public class AcademicVO {
	
	private int ano;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double mean;
	private char grd;
	private String regdate;
 
	public AcademicVO() { }
	
	public AcademicVO(String name, int kor, int eng, int mat) {
		this.name = name;
	    this.kor = kor;
	    this.eng = eng;
	    this.mat = mat;
	}  
	
	public AcademicVO(int ano, String name, int kor, int eng, int mat, String regdate) {
		this.ano = ano;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.regdate = regdate;
	}
	
	public AcademicVO(int ano, String name, int kor, int eng, int mat, int tot, double mean, char grd, String regdate) {
		super();
		this.ano = ano;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.mean = mean;
		this.grd = grd;
		this.regdate = regdate;
	}

	
	public int getAno() {
		return ano;
	}
	public void setAno(int sno) {
		this.ano = sno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getName() {
		return name;
	}
    public void setName(String name) {
    	this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}	
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public char getGrd() {
		return grd;
	}
	public void setGrd(char grd) {
		this.grd = grd;
	}
}