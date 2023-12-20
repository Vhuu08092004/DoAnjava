import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hocphantunhien extends HocPhan {

    String diaDiemThucHanh;

    public hocphantunhien() {
    }

    public hocphantunhien(String MaHocPhan, String TenHocPhan, int TinChi, String loai, String diaDiemThucHanh) {
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
        this.loai = loai;
        this.diaDiemThucHanh = diaDiemThucHanh;
    }

    public String getDiaDiemThucHanh() {
        return diaDiemThucHanh;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập mã học phần:");
        this.MaHocPhan = scanner.nextLine();
        System.out.println("Vui lòng nhập tên học phần:");
        this.TenHocPhan = scanner.nextLine();
        System.out.println("Vui lòng nhập số tín chỉ của học phần:");
        this.TinChi = Integer.valueOf(scanner.nextLine());
        System.out.println("Vui lòng nhập địa điểm thực hành của học phần:");
        this.diaDiemThucHanh = scanner.nextLine();
        this.loai = "tu nhien";
    }

    public hocphantunhien(String diaDiemThucHanh) {
        super();
        this.diaDiemThucHanh = diaDiemThucHanh;
    }

    public void xuat() {
        System.out.println("Mã học phần là:" + this.MaHocPhan);
        System.out.println("Tên học phần là:" + this.TenHocPhan);
        System.out.println("Số tín chỉ của học phần là:" + this.TinChi);
        System.out.println("Địa điểm đi thực hành của học phần là:" + this.diaDiemThucHanh);
        System.out.println("Loại học phần là:" + this.loai);
    }

    public void setDiaDiemThucHanh(String diaDiemThucHanh) {
        this.diaDiemThucHanh = diaDiemThucHanh;
    }

    @Override
    public void XuatThongTinHocPhan() {

    }

    public void GhiFile(String filename) {
    	try {
    		BufferedWriter buffer = new BufferedWriter(new FileWriter(filename, true));
			String code = "1";
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
				buffer.write(diaDiemThucHanh);
				buffer.newLine();
			buffer.close();
	
			;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
    }

    public static void main(String[] args) {
        HocPhan hp = new hocphantunhien();
        try {
        	hp.nhap();
            hp.GhiFile("danhsachhocphan");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
