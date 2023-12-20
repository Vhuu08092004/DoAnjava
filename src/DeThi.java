
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DeThi extends HocPhan{
    private DanhSachCauHoi danhSachCauHoi = new DanhSachCauHoi();
    private String maDeThi;
    private String tenMonThi;
    private int thoiGian;
    private int soCau;
    private int index[];
    
    public DeThi() {
        super();
    };

    public DeThi(String maDeThi, String tenMonThi, int thoiGian, int soCau, int maHocPhan, String tenHocPhan, int tinChi , int Index[]) {
        super();
        this.maDeThi = maDeThi;
        this.tenMonThi = tenMonThi;
        this.thoiGian = thoiGian;
        this.soCau = soCau;
        this.index = Index;
    }
    public DanhSachCauHoi getDanhSachCauHoi() {
        return danhSachCauHoi;
    }
    public String getMaDeThi() {
        return this.maDeThi;
    }
    public String getTenMonThi() {
        return this.tenMonThi;
    }
    public int getThoiGian() {
        return this.thoiGian;
    }
    public int getSoCau() {
        return this.soCau;
    }
    public int[] getIndex() {
        return index;
    }
    public void setMaDeThi(String maDeThi) {
        this.maDeThi = maDeThi;
    }
    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }
    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }
    public void setIndex( int index[]) {
        this.index = index;
    }
    public void NhapMaDeThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma de thi :");
        this.maDeThi = scanner.nextLine();
        if(!KiemTraThongTin(this.maDeThi)){
            System.out.println("Ma de thi khong hop le!");
            NhapMaDeThi();
        }
    }
    public void NhapTenMonThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten mon thi:");
        this.tenMonThi = scanner.nextLine();
        if(!KiemTraThongTin(this.tenMonThi)){
            System.out.println("Ten mon thi khong hop le!");
            NhapTenMonThi();
        }     
    }
    public void NhapThoiGian(){
        int tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap thoi gian thi :");
        tmp = scanner.nextInt();
        if(tmp > 0){
        this.thoiGian = tmp;
        }
        else {
            System.out.println("Thoi gian khong hop le!");
            NhapThoiGian();
        }

    }
    public void NhapSoCau() {
        int tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap so cau cho mon thi :");
        tmp = scanner.nextInt();
        if (tmp > 0) {
            this.soCau = tmp;
        } else {
            System.out.println("So cau khong hop le! Nhap lai.");
            NhapSoCau(); 
        }
    }
    
    public boolean KiemTraThongTin(String thongTin) {
        return thongTin != null && !thongTin.trim().isEmpty();
    }
    public void NhapThongTinDeThi(){
        //super.capNhat();
//    	NhapTenKiThi();
        NhapMaDeThi();
        NhapTenMonThi();
        NhapSoCau();
        NhapThoiGian();
    }
    public void XuatThongTinDeThi() {
       // this.XuatThongTinHocPhan();
        System.out.println("Ma de thi: " + this.maDeThi);
        System.out.println("Ten mon thi: " +this.tenMonThi);
        System.out.println("Thoi gian:" + this.thoiGian + " phut");
        System.out.println("So cau: "+ this.soCau);
    }
    public void HienThiDeThi(){    
        XuatThongTinDeThi(); 
        MonThi(this.tenMonThi.concat(".txt"));
        NoiDungDeThi();
    }
   public void NoiDungDeThi(){ 
      for(int i = 0; i < this.soCau; i++) {
        int Index = i + 1;
        System.out.print("Cau hoi " + Index + " ");
        this.danhSachCauHoi.XuatCauHoiTheoViTri(index[i]);
      }   
   }
   public void MonThi(String documentsIn){
       this.danhSachCauHoi.docFile(documentsIn);
       index = new int[this.danhSachCauHoi.getN()];
       LayNgauNhienCauHoi();
   }

   public void LayNgauNhienCauHoi(){
        Random random = new Random();
        for(int i = 0; i < this.soCau; i++){
            index[i] = random.nextInt(this.danhSachCauHoi.getN());
            for(int j = 0; j < i; j++){
                  if(index[j] == index[i]){ 
                    i = i - 1;    
            }
        }
   }
}
 public static void main(String[] args){
    DeThi deThi = new DeThi();
    deThi.NhapThongTinDeThi();
    deThi.HienThiDeThi();
 }
}