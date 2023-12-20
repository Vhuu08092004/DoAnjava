import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HocPhan {

    protected String MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    protected String loai;

    HocPhan() {
    }

    public HocPhan(String MaHocPhan, String TenHocPhan, int TinChi, String loai) {
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
        this.loai = loai;
    }

    public String getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(String MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }

    public String getTenHocPhan() {
        return TenHocPhan;
    }

    public void setTenHocPhan(String TenHocPhan) {
        this.TenHocPhan = TenHocPhan;
    }

    public int getTinChi() {
        return TinChi;
    }

    public void setTinChi(int TinChi) {
        this.TinChi = TinChi;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập mã học phần:");
        this.MaHocPhan = scanner.nextLine();
        System.out.println("Vui lòng nhập tên học phần:");
        this.TenHocPhan = scanner.next();
        System.out.println("Vui lòng nhập số tín chỉ của học phần:");
        this.TinChi = scanner.nextInt();
    }

    public void xuat() {
        System.out.println("Mã học phần là:" + this.MaHocPhan);
        System.out.println("Tên học phần là:" + this.TenHocPhan);
        System.out.println("Số tín chỉ của học phần là:" + this.TinChi);
    }

    public void capNhat() {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.println("Vui long chon muc can chinh sua");
            System.out.println("1.MaHocPhan\n2.TenHocPhan\n3.TinChi\n4. Thoat");
            System.out.println("Chon: ");
            n = Integer.parseInt(scan.nextLine());
            switch (n) {
                case 1:
                    System.out.println("Nhap Ma Hoc Phan moi: ");
                    MaHocPhan = scan.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap Ten Hoc Phan moi: ");
                    TenHocPhan = scan.nextLine();
                    break;
                case 3:
                    System.out.println("Nhap so Tin Chi moi: ");
                    TinChi = Integer.parseInt(scan.nextLine());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Khong hop le!!!");

            }
        } while (true);
    }

    public void XuatThongTinHocPhan() {
        System.out.println("Ma hoc phan : " + this.MaHocPhan);
        System.out.println("Ten hoc phan : " + this.TenHocPhan);
        System.out.println("So Tin Chi : " + this.TinChi);
    }

    public void GhiFile(String filename) throws IOException {
    	try {
			FileWriter file = new FileWriter(filename);
			BufferedWriter buffer = new BufferedWriter(file);
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
			buffer.close();
			file.close();
			;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
    }

    public static void main(String[] args) {
        HocPhan hp = new hocphantunhien();
        hp.nhap();
        hp.xuat();
    }

}
