

import java.util.Scanner;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Thi {
    private DeThi deThi = new DeThi();
    private String MaKiThi;
    private String TenKiThi;
    private String NgayBatDau;
    private String NgayKetThuc;
    private float diemSo;
    public DeThi getDeThi() {
		return deThi;
	}
	public void setDeThi(DeThi deThi) {
		this.deThi = deThi;
	}
	public float getDiemSo() {
		return diemSo;
	}
	public void setDiemSo(float diemSo) {
		this.diemSo = diemSo;
	}
	public Thi(){};
    public Thi(String MaKiThi, String TenKiThi, String NgayBatDau, String NgayKetThuc){
        this.MaKiThi = MaKiThi;
        this.TenKiThi = TenKiThi;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }
    public DeThi getDetThi() {
    	return deThi;
    }
    public String getMaKiThi() {
        return MaKiThi;
    }
    public String getTenKiThi() {
        return TenKiThi;
    }
    public String getNgayBatDau() {
        return NgayBatDau;
    }
    public String getNgayKetThuc() {
        return NgayKetThuc;
    }
    public void setMaKiThi(String MaKiThi) {
            this.MaKiThi = MaKiThi;
    }
    public void setTenKiThi(String TenKiThi) {
        this.TenKiThi = TenKiThi;
    }
    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }
    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }
    public void NhapMaKiThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ma Ki Thi: ");
        this.MaKiThi = scanner.nextLine();
        if (!KiemTraThongTin(this.MaKiThi)) {
            System.out.println("Ma ki thi khong hop le!");
            NhapMaKiThi();  
        }  
    }
    public void NhapTenKiThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ten Ki Thi: ");
        this.TenKiThi = scanner.nextLine();
        if (!KiemTraThongTin(this.TenKiThi)) {
            System.out.println("Ten ki thi khong hop le!");
            NhapTenKiThi();  
        }  
    }
    public void NhapNgayBatDau(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ngay Bat Dau: ");
        this.NgayBatDau = scanner.nextLine();
        if(!KiemTraThongTin(this.NgayBatDau)||!KiemTraDinhDangNgay(this.NgayBatDau)){
            System.out.println("Dinh dang ngay khong hop le!");
            NhapNgayBatDau();
        }
}
    public void NhapNgayKetThuc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ngay Ket Thuc: ");
        this.NgayKetThuc = scanner.nextLine();
        if(!KiemTraThongTin(this.NgayKetThuc)||!KiemTraDinhDangNgay(this.NgayKetThuc)){
            System.out.println("Dinh dang ngay khong hop le!");
            NhapNgayKetThuc();
        }
}
    public boolean KiemTraThongTin(String ThongTin){
        return ThongTin!= null && !ThongTin.trim().isEmpty();
    }
    public boolean KiemTraDinhDangNgay(String chuoiNgay){
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            Date date = df.parse(chuoiNgay);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void LamDeThi(){
        int True = 0;
        this.NhapTenKiThi();
        this.deThi.XuatThongTinDeThi();
        this.deThi.MonThi(this.deThi.getTenMonThi().concat(".txt"));
        this.deThi.NoiDungDeThi();
        int number = this.deThi.getSoCau();
        
        for(int i = 0; i < number; i++) {
            int index = deThi.getIndex()[i];
            System.out.println("Chon dap an cau " + (i+1));
            String chonDapAn = NhapDapAn();
            if(chonDapAn.equals("A")){
                String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
                String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnA();
              if(dapAn.equals(chon)){
                True++;
              }
            }
            else if(chonDapAn.equals("B")){
               String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
                String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnB();
              if(dapAn.equals(chon)){
                True++;
              }
            }
             else if(chonDapAn.equals("C")){
                String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
                String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnC();
              if(dapAn.equals(chon)){
                True++;
              }
            }
             else if(chonDapAn.equals("D")){
               String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
               String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnD();
              if(dapAn.equals(chon)){
                True++;
              }
            };
        }
         diemSo = ((float)True/number)*10;
        System.out.println("Diem so bai thi cua ban la:" + diemSo);
        if(diemSo >= 5){
            System.out.println("So cau dung: "+ True);
            System.out.println("So cau sai: "+ (number - True));
          System.out.println("Xin chuc mung ban thong qua bai thi!");
        }
        else {
            System.out.println("So cau dung: "+ True);
            System.out.println("So cau sai: "+ (number - True));
            System.out.println("Ban chua dat yeu cau");
        }
    }
    public String NhapDapAn(){
        Scanner scanner = new Scanner(System.in);
        String dapAn = scanner.nextLine();
        if (!dapAn.equals("A") && !dapAn.equals("B") && !dapAn.equals("C") && !dapAn.equals("D")){
            System.out.println("Dap an khong hop le!");
           return NhapDapAn();
        }
        return dapAn;
    }
    public void NhapThongTinKiThi() {
        NhapMaKiThi();
        NhapTenKiThi();
        NhapNgayBatDau();
        NhapNgayKetThuc();
    }
    public void XuatThongTinKiThi() {
        System.out.println("=================================");
        System.out.println("========Thong tin ki thi========= ");
        System.out.println("Ma ki thi: " + this.MaKiThi);
        System.out.println("Ten ki thi: " + this.TenKiThi);
        System.out.println("Ngay bat dau: " + this.NgayBatDau);
        System.out.println("Ngay ket thuc: " + this.NgayKetThuc);
        System.out.println("=================================");
    }
    public static void main(String[] args){
         Thi thi = new Thi();
        // thi.NhapThongTinKiThi();
        // thi.XuatThongTinKiThi();
         thi.deThi.NhapThongTinDeThi();
         thi.LamDeThi();
    }

}
