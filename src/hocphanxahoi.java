import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hocphanxahoi extends HocPhan {
	String diaDiemThucTe ;

	public String getDiaDiemThucTe() {
		return diaDiemThucTe;
	}
	public hocphanxahoi() {
		
	}
	
	 public hocphanxahoi(String MaHocPhan, String TenHocPhan, int TinChi , String loai, String diaDiemThucTe){
	        this.MaHocPhan = MaHocPhan;
	        this.TenHocPhan = TenHocPhan;
	        this.TinChi = TinChi;
	        this.loai = loai;
	        this.diaDiemThucTe = diaDiemThucTe;
	    }


	public void setDiaDiemThucTe(String diaDiemThucTe) {
		this.diaDiemThucTe = diaDiemThucTe;
	}

	public void nhap() {
    	Scanner scanner = new Scanner(System.in); 
    	System.out.println("Vui lòng nhập mã học phần:");
    	this.MaHocPhan = scanner.nextLine(); 
    	System.out.println("Vui lòng nhập tên học phần:");
    	this.TenHocPhan = scanner.nextLine();
    	System.out.println("Vui lòng nhập số tín chỉ của học phần:");
    	this.TinChi = Integer.valueOf(scanner.nextLine()); 
    	System.out.println("Vui lòng nhập địa điểm đi thực tế của học phần:");
    	this.diaDiemThucTe = scanner.nextLine();
    	this.loai = "xa hoi";
    }
	 public void xuat() {
	    	System.out.println("Mã học phần là:" + this.MaHocPhan);
	    	System.out.println("Tên học phần là:" + this.TenHocPhan);
	    	System.out.println("Số tín chỉ của học phần là:"+ this.TinChi);
	    	System.out.println("Địa điểm đi thực tế của học phần là:" + this.diaDiemThucTe);
	    	System.out.println("Loại học phần là:" + this.loai);
	    }
	@Override
    public void XuatThongTinHocPhan() {
        super.XuatThongTinHocPhan(); 
        System.out.println("Địa điểm thực tế:bảo tàng" );
    }
	
	public void GhiFile(String filename) throws IOException {
		try {
//			FileWriter file = new FileWriter(filename);
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filename, true));
			String code = "0";
			String tinchi =  String.valueOf(TinChi);
				buffer.write(code);
				buffer.newLine();
				buffer.write(MaHocPhan);
				buffer.newLine();
				buffer.write(TenHocPhan);
				buffer.newLine();
				buffer.write(tinchi);
				buffer.newLine();
				buffer.write(loai);
				buffer.newLine();
				buffer.write(diaDiemThucTe);
				buffer.newLine();
			buffer.close();
			;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
	}
	
	public static void main(String[] args) {
        HocPhan hp = new hocphanxahoi();
        try {
        	hp.nhap();
            hp.GhiFile("danhsachhocphan");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

	

