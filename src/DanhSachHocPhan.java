
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;







public class DanhSachHocPhan implements DuyetDS, File{

	public HocPhan[] dshp;
	private int n;
	Scanner scanner = new Scanner(System.in);
	
	
	
	public HocPhan[] getDshp() {
		return dshp;
	}
	public void setDshp(HocPhan[] dshp) {
		this.dshp = dshp;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public DanhSachHocPhan() {}
	public DanhSachHocPhan(HocPhan[] dshp, int n, Scanner scanner) {
		this.dshp = dshp;
		this.n = n;
	}
	@Override
	public void timKiem() {
		// TODO Auto-generated method stub
	}
	public int timKiemid(String Maso) {
		for (int i = 0; i < n; i++) {
			if (dshp[i].getMaHocPhan().equals(Maso))
				return i;
		}
		return -1;
	}
	@Override
	public void nhapDS() {
		// TODO Auto-generated method stub
		System.out.println("Nhập số lượng học phần:");
		n = scanner.nextInt();
		dshp = new HocPhan[n];
		int option ;
		for(int i = 0; i < n; i++) {
			System.out.println("1.Học phần tự nhiên");
			System.out.println("2.HỌc phần xã hội");
			do {
				System.out.print("Lựa chọn của bạn là gì: ");
				option = scanner.nextInt();
				if(option < 1 || option > 2) {
					System.err.println("Bạn đã nhập sai lựa chọn của mình, mù hay sao mà nhập sai vậy!!!");
				}
			}while(option < 1 || option > 2);
			if(option == 1) {
				dshp[i] = new hocphantunhien();
				System.out.print("\nHỌC PHẦN THỨ " + (i + 1) + " (HỌC PHẦN TỰ NHIÊN)\n");
				dshp[i].nhap();
				scanner.nextLine();
				
			}
			else if(option == 2) {
				System.out.print("\nHỌC PHẦN THỨ " + (i + 1) + "(HỌC PHẦN XÃ HỘI)\n");
				dshp[i] = new hocphanxahoi();
				dshp[i].nhap();
				scanner.nextLine();
				
			}
		}
	}
	
	@Override
	public void xuatDS() {
		System.out.println("DANH SÁCH HỌC PHẦN");
		for(int i= 0 ; i < n ; i++) {
			System.out.println("Học phần" + (i + 1));
			dshp[i].xuat();
		}
		
	}

	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void themPT() {
		// TODO Auto-generated method stub
		n++;
		dshp = Arrays.copyOf(dshp, n);
		dshp[n - 1] = new HocPhan();
		dshp[n - 1].nhap();
	}

	@Override
	public boolean xoaPT(int x) {
		if(x < n) {
			return false;
		}
		if (x > n)
			return false;
		n--;
		for (int i = x; i < n; i++) {
			dshp[i] = dshp[i + 1];
		}
		dshp[n] = null;
		dshp = Arrays.copyOf(dshp, n);
		return true;
	}

	
	@Override
	public void docFile() {
		// TODO Auto-generated method stub
	}
	public void docFile(String filename) {
		int i = 0;
		try {
			BufferedReader dis = new BufferedReader(new FileReader(filename));
			n = Integer.parseInt(dis.readLine());
			dshp = new HocPhan[n];
			try {
				while(true) {
					
					String code = dis.readLine();
					if(dis.readLine() == null) {
						break;
					}
					String mahocphan = dis.readLine();
					String tenhocphan = dis.readLine();
					int tinchi = Integer.parseInt(dis.readLine()) ;
					String loai = dis.readLine();
					if(code.equals("0")) {
						String diadiemthucte = dis.readLine();
						dshp[i] = new hocphanxahoi(mahocphan,tenhocphan,tinchi,loai,diadiemthucte);
					}
					else if(code.equals("1")) {
						String diadiemthuchanh = dis.readLine();
						dshp[i] = new hocphanxahoi(mahocphan,tenhocphan,tinchi,loai,diadiemthuchanh);
					}
					i++;
				}
			}catch(EOFException e) {
			}
			finally {
				dis.close();
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void ghiFile() {
		// TODO Auto-generated method stub
		
	}
	public void ghiFile(String nameFile) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(nameFile));
			for(int i = 0; i < n; i++) {
				if(dshp[i] instanceof hocphantunhien) {
					dshp[i] = (hocphantunhien) dshp[i];
					dshp[i].GhiFile(nameFile);
				}
				if(dshp[i] instanceof hocphanxahoi) {
					dshp[i] = (hocphanxahoi) dshp[i];
					dshp[i].GhiFile(nameFile);
				}
			}
			dos.close();}
		catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
	}
	public static void main(String[] args) {
		DanhSachHocPhan ds = new DanhSachHocPhan();
//		ds.nhapDS();
//		ds.ghiFile("danhsachhocphan");
		ds.docFile("danhsachhocphan");
//		ds.xuatDS();
	}
}


