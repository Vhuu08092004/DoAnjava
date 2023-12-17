import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachCauHoi implements DuyetDS , File{
	private CauHoi[] ch;
	private int n;
	
	public DanhSachCauHoi () {
		
	}
	
	public DanhSachCauHoi(CauHoi[] ch, int n) {
		this.ch = ch;
		this.n = n;
	}
	
	
	public CauHoi[] getCh() {
		return ch;
	}


	public void setCh(CauHoi[] ch) {
		this.ch = ch;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	@Override
	public void docFile() {
		
	}
	public void docFile(String nameFile) {
		try (FileReader file = new FileReader(nameFile);
				BufferedReader buffer = new BufferedReader(file)) {
	
			n = 0; // Assuming n is a variable to keep track of the number of questions
			ch = new CauHoi[1]; // Assuming ch is an array to store CauHoi objects
	
			String[] data = new String[7]; // Array to store data for each question
	
			String line = buffer.readLine(); // Read the first line (assuming it's not used)
	
			while (true) {
				data[0] = buffer.readLine(); // Read the question text
				//System.out.println(data[0]); // Print the question text
	
				if (data[0] == null)
					break; // Exit the loop if there is no more data
	
				n++; // Increment the number of questions
				ch = Arrays.copyOf(ch, n); // Resize the array to accommodate the new question
	
				// Read data for the question (assuming there are 6 more lines of data)
				data[1] = buffer.readLine();
				data[2] = buffer.readLine();
				data[3] = buffer.readLine();
				data[4] = buffer.readLine();
				data[5] = buffer.readLine();
				data[6] = buffer.readLine();
	
				// Create a new CauHoi object and store it in the array
				ch[n - 1] = new CauHoi(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
			}
	
			buffer.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
	}
	
	@Override
	public void ghiFile() {
	}
	public void ghiFile(String nameFile) {
		try {
			FileWriter file = new FileWriter(nameFile);
			BufferedWriter buffer = new BufferedWriter(file);
			buffer.write("Số lượng câu hỏi:" + n);
			buffer.newLine();
			for(CauHoi s : ch) {
				buffer.write(s.getIdCau());
				buffer.newLine();
				buffer.write(s.getNoiDungCau());
				buffer.newLine();
				buffer.write(s.getPhuongAnA());
				buffer.newLine();
				buffer.write(s.getPhuongAnB());
				buffer.newLine();
				buffer.write(s.getPhuongAnC());
				buffer.newLine();
				buffer.write(s.getPhuongAnD());
				buffer.newLine();
				buffer.write(s.getDapAn());
				buffer.newLine();
			}
			buffer.close();
			file.close();;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
		
	}
	@Override
	public void timKiem() {}
//	public void timKiem(int id) {
//		for(int i = 1 ; i <= n ; i++) {
//			if(ch[i].g)
//		}
//	}
	public int timKiem(String NoiDungCauHoi) {
		for(int i = 0 ; i < n ; i++) {
			if(ch[i].getNoiDungCau().equalsIgnoreCase(NoiDungCauHoi)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void themPT() {
		n++;
		ch = Arrays.copyOf(ch, n);
		ch[n - 1] = new CauHoi();
		ch[n - 1].nhap();
		
	}
	@Override
	public boolean xoaPT(int x) {
        if (x > n)  return false;
        n--;
        if (x > n)  return true;
        for (int i = x; i < n; i++){
            ch[i] = ch[i+1];
        }
        ch[n] = null;
        ch = Arrays.copyOf(ch, n);
        return true;
    }
	@Override
	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Nhập vào số câu hỏi bạn muốn:");	
			n = sc.nextInt();
		} while (n < 0);
		ch = new CauHoi[n];
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("Câu "+ i + ":");
			ch[i] = new CauHoi();
			ch[i].nhap();
		}	
		
	}
	@Override
	public void xuatDS() {
		for(int i = 0 ; i < n ; i++) {
			System.out.print("Câu hỏi:" +(i+1));
			ch[i].xuat();
		}
		
	}
    public int TimKiemTheoID(String ID){
		for(int i = 0 ; i < this.getN(); i++) {
			if(ch[i].getIdCau().equals(ID)) {
              return 1;
			}
		}
		return -1;
	}
	public void XuatCauHoiTheoViTri(int index){
			this.ch[index].xuat(); 
	}
	public void XoaPhanTuTheoViTri(int index){
		for(int i = index; i < n - 1; i++){
            ch[i] = ch[i + 1] ;
		}
		n--;
		ch = Arrays.copyOf(ch, n);
	}
	public void ThemPhanTuTheoViTri(int index){
		if(index < 0){
			index = 0;
		}
		if(index >= n) {
		   index = n;
		}
		n++;
		ch = Arrays.copyOf(ch, n);
		ch[n - 1] = new CauHoi();
		for(int i = n - 1 ; i > index; i--){
			this.ch[i] = this.ch[i-1];
		}
		ch[index] = new CauHoi();
		this.ch[index].nhap();
	}
    public void SuaPhanTuTheoViTri(int index){
		ch[index] = new CauHoi();
        this.ch[index].nhap();
	}
	
	public void XoaPhanTuTheoID(String ID){
		for(int i = 0; i < n; i++){
			if(TimKiemTheoID(ID) == 1) {
				for(int j = i; j < n - 1; j++){
                ch[j] = ch[j + 1] ;
		        }
		        n--;
				System.out.println("Xóa Câu Hỏi Thành Công!");
				return;
			} 
		}
		System.out.println("Câu Hỏi Không Có Trong Danh Sách");
		return;
	}
	public void SuaPhanTuTheoID(String ID){
		for(int i = 0; i < n; i++){
			if(TimKiemTheoID(ID) == 1) {
				ch[i] = new CauHoi();
                this.ch[i].nhap();
				System.out.println("Chỉnh Sửa Câu Hỏi Thành Công!");
				return;
			} 
		}
		System.out.println("Câu Hỏi Không Có Trong Danh Sách");
		return;
	}
	
	public static void main(String[] args) {
		DanhSachCauHoi dsch = new DanhSachCauHoi();
		dsch.ghiFile("monhoc.txt");
	}
	
	
	
	
	
}