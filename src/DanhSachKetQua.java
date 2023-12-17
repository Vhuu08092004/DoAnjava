import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKetQua {
    private float diem;
    private int id;
    private String tenSV;
    private String khoa;
    private String kiThi;
    private static int recordCount = 0;
    private static int[] diemRanges = {0, 5, 7, 8, 10}; 
    private static int[] diemCount = new int[diemRanges.length - 1]; 
    
    public float getDiem() {
        return diem;
    }
    public int getId() {
        return id;
    }
    public String getKhoa() {
        return khoa;
    }
    public String getKiThi() {
        return kiThi;
    }
    public String getTenSV() {
        return tenSV;
    }
    public void setDiem(float diem) {
        this.diem = diem;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    public void setKiThi(String kiThi) {
        this.kiThi = kiThi;
    }
    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }
    public DanhSachKetQua(){};
    public DanhSachKetQua(float diem, int id, String khoa, String kiThi){
        this.diem = diem;
        this.id = id;
        this.khoa = khoa;
        this.kiThi = kiThi;
    }
    
    public static void WriteFile(float Diem, int id, String tenSV, String khoa, String kithi) {
        try {
            FileWriter file = new FileWriter("danhsachketqua", true);
            BufferedWriter buffer = new BufferedWriter(file);
            String diemString = Float.toString(Diem);
            String idString = Integer.toString(id);
            buffer.write(diemString);
            buffer.newLine();
            buffer.write(idString);
            buffer.newLine();
            buffer.write(tenSV);
            buffer.newLine();
            buffer.write(khoa);
            buffer.newLine();
            buffer.write(kithi);
            buffer.newLine();
            recordCount++;
            UpdateDiemStatistic(Diem);
            buffer.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Loi khi mo File!");
        }
    }

    public static void ReadFile() {
        try {
            FileReader fileReader = new FileReader("danhsachketqua");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String diem, id, tenSV, khoa, kithi;

            while ((diem = bufferedReader.readLine()) != null
                    && (id = bufferedReader.readLine()) != null
                    && (tenSV = bufferedReader.readLine()) != null
                    && (khoa = bufferedReader.readLine()) != null
                    && (kithi = bufferedReader.readLine()) != null) {

                // Tăng biến đếm cho khoảng điểm tương ứng
                float DiemValue = Float.parseFloat(diem);
                UpdateDiemStatistic(DiemValue);

                System.out.println("Diem: " + diem);
                System.out.println("ID: " + id);
                System.out.println("Ten SV: " + tenSV);
                System.out.println("Khoa: " + khoa);
                System.out.println("Ki thi: " + kithi);
                System.out.println("------------------");
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Loi khi doc File!");
        }
    }
    public static void hkStatistic(String hk) {
    	 try {
             FileReader fileReader = new FileReader("danhsachketqua");
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             String diem, id, tenSV, khoa, kithi;

             while ((diem = bufferedReader.readLine()) != null
                     && (id = bufferedReader.readLine()) != null
                     && (tenSV = bufferedReader.readLine()) != null
                     && (khoa = bufferedReader.readLine()) != null
                     && (kithi = bufferedReader.readLine()) != null) {

                if(hk.equals(kithi)) {
                	System.out.println("Diem: " + diem);
                	System.out.println("ID: " + id);
                	System.out.println("Ten SV: " + tenSV);
                	System.out.println("Khoa: " + khoa);
                	System.out.println("Ki thi: " + kithi);
                	System.out.println("------------------");
                	recordCount++;
                }

             }
             System.out.println("Tìm được " +recordCount + " sinh viên thi " + hk);
             bufferedReader.close();
             fileReader.close();
         } catch (IOException e) {
             System.out.println("Loi khi doc File!");
         }
    }
    
    
    public static void khoaStatistic(String khoaStatistic) {
    	 try {
             FileReader fileReader = new FileReader("danhsachketqua");
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             String diem, id, tenSV, khoa, kithi;
             int n = 0;
             while ((diem = bufferedReader.readLine()) != null
                     && (id = bufferedReader.readLine()) != null
                     && (tenSV = bufferedReader.readLine()) != null
                     && (khoa = bufferedReader.readLine()) != null
                     && (kithi = bufferedReader.readLine()) != null) {
            	 if(khoaStatistic.equals(khoa)) {
            		 System.out.println("Diem: " + diem);
                     System.out.println("ID: " + id);
                     System.out.println("Ten SV: " + tenSV);
                     System.out.println("Khoa: " + khoa);
                     System.out.println("Ki thi: " + kithi);
                     System.out.println("------------------");
                     recordCount++;
            	 }
             }
             System.out.println("Tìm được " +recordCount + " sinh viên thuộc khoa " + khoaStatistic);

             bufferedReader.close();
             fileReader.close();
         } catch (IOException e) {
             System.out.println("Loi khi doc File!");
         }
    }
    
   

    public static void UpdateDiemStatistic(float Diem) {
        for (int i = 0; i < diemRanges.length - 1; i++) {
            if (Diem >= diemRanges[i] && Diem < diemRanges[i + 1]) {
                diemCount[i]++;
                break;
            }
        }
    }

    public static void DisplayStatistic() {
        System.out.println("Thong ke theo khoang diem:");
        for (int i = 0; i < diemRanges.length - 1; i++) {
            System.out.println("Tu " + diemRanges[i] + " den " + diemRanges[i + 1] + ": " + diemCount[i] + " sinh vien");
        }
    }


    public static void main(String[] args) {
    	DanhSachKetQua ds = new DanhSachKetQua();
//    	ds.WriteFile(10,1,"Tu", "IT", "hk1");
    	ds.ReadFile();
    	ds.DisplayStatistic();

//    	khoaStatistic("IT");
//    	hkStatistic("hk1");
    	
    }
}