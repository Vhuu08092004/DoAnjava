import java.util.Scanner;

public class CauHoi {
	private String idCau;
	private String NoiDungCau;
	private String PhuongAnA;
	private String PhuongAnB;
	private String PhuongAnC;
	private String PhuongAnD;
	private String DapAn;
	
	public CauHoi() {
		
	}

	public CauHoi(String Idcau,String noiDungCau, String phuongAnA, String phuongAnB, String phuongAnC, String phuongAnD,
			String dapAn) {
		idCau = Idcau;
		NoiDungCau = noiDungCau;
		PhuongAnA = phuongAnA;
		PhuongAnB = phuongAnB;
		PhuongAnC = phuongAnC;
		PhuongAnD = phuongAnD;
		DapAn = dapAn;
	}

	public String getIdCau() {
		return idCau;
	}
	
	public void setIdCau(String idCau) {
		this.idCau = idCau;
	}
	public String getNoiDungCau() {
		return NoiDungCau;
	}

	public void setNoiDungCau(String noiDungCau) {
		NoiDungCau = noiDungCau;
	}

	public String getPhuongAnA() {
		return PhuongAnA;
	}

	public void setPhuongAnA(String phuongAnA) {
		PhuongAnA = phuongAnA;
	}

	public String getPhuongAnB() {
		return PhuongAnB;
	}

	public void setPhuongAnB(String phuongAnB) {
		PhuongAnB = phuongAnB;
	}

	public String getPhuongAnC() {
		return PhuongAnC;
	}

	public void setPhuongAnC(String phuongAnC) {
		PhuongAnC = phuongAnC;
	}

	public String getPhuongAnD() {
		return PhuongAnD;
	}

	public void setPhuongAnD(String phuongAnD) {
		PhuongAnD = phuongAnD;
	}

	public String getDapAn() {
		return DapAn;
	}

	public void setDapAn(String dapAn) {
		DapAn = dapAn;
	}
	
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Id câu hỏi:");
		this.idCau = sc.nextLine();
		System.out.print("Nội dung câu hỏi:");
		this.NoiDungCau = sc.nextLine();
		System.out.print("Nội dung của phương án A:");
		this.PhuongAnA = sc.nextLine();
		System.out.print("Nội dung của phương án B:");
		this.PhuongAnB = sc.nextLine();
		System.out.print("Nội dung của phương án C:");
		this.PhuongAnC = sc.nextLine();
		System.out.print("Nội dung của phương án D:");
		this.PhuongAnD = sc.nextLine();
		System.out.print("Dap án của câu hỏi:");
		this.DapAn = sc.next();
		
	}
	public void xuat() {
		System.out.print(this.idCau);
		System.out.println(".Nội dung câu hỏi:" + this.NoiDungCau);
		System.out.println("A. " + this.PhuongAnA);
		System.out.println("B. " + this.PhuongAnB);
		System.out.println("C. " + this.PhuongAnC);
		System.out.println("D. " + this.PhuongAnD);
		System.out.println("Đáp án câu: " + this.DapAn );
	}
	
}
