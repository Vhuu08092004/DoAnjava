import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachGiaoVien implements File, DuyetDS {
	GiaoVien[] gv;
	int n;

	public DanhSachGiaoVien() {
		this.gv = new GiaoVien[100];
		this.n = 0;

	}


	public DanhSachGiaoVien(GiaoVien[] giaoVien, int n) {
		gv = giaoVien;
		this.n = n;
	}

	public GiaoVien[] getGiaoVien() {
		return gv;
	}

	public void setGiaoVien(GiaoVien[] giaoVien) {
		gv = giaoVien;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public void timKiem() {
		// TODO Auto-generated method stub
	}

	public int timKiemid(String Maso) {
		for (int i = 0; i < n; i++) {
			if (gv[i].getId().equals(Maso))
				return i;
		}
		return -1;
	}

	public int timKiem(String Ten) {
		for (int i = 0; i < n; i++) {
			if ((gv[i].getLastName()).equalsIgnoreCase(Ten))
				return i;
		}
		return -1;
	}

	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
	}

	@Override
	public void themPT() {
		// TODO Auto-generated method stub
		n++;
		gv = Arrays.copyOf(gv, n);
		gv[n - 1] = new GiaoVien();
		gv[n - 1].nhap();
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
			gv[i] = gv[i + 1];
		}
		gv[n] = null;
		gv = Arrays.copyOf(gv, n);
		return true;
	}
	// public int timKiem(String Ten){
	// for (int i = 0; i < n; i++){
	// if ((gv[i].getLastName()).equalsIgnoreCase(Ten))
	// return i;
	// }
	// return -1;
	// }

	public int xoaPT(String x) {
		for (int i = 1; i <= n; i++) {
			if ((gv[i].getLastName()).equalsIgnoreCase(x)) {
				n--;
				for (int y = i; i < n; i++) {
					gv[i] = gv[i + 1];
				}
			}
		}
		gv[n] = null;
		gv = Arrays.copyOf(gv, n);
		return 1;
	}

	@Override
	public void nhapDS() {
		String ho;
		String ten;
		String MaSo;
		String khoa;
		String NgaySinh;
		String GioiTinh;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Nhap So Luong Giao Vien: ");
			n = Integer.parseInt(scan.nextLine());
		} while (n < 0);
		gv = new GiaoVien[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Giao Vien " + i);
			System.out.println("Nhập vào id của giáo viên:");
			MaSo = scan.nextLine();
			System.out.print("Nhap Ho: ");
			ho = scan.nextLine();
			System.out.print("Nhap Ten: ");
			ten = scan.nextLine();
			System.out.println("Nhap Ngay sinh: ");
			NgaySinh = scan.nextLine();
			System.out.println("Nhap vao khoa cua giao vien: ");
			khoa = scan.nextLine();
			System.out.println("Nhap Gioi Tinh: ");
			GioiTinh = scan.nextLine();
			gv[i] = new GiaoVien(MaSo, khoa, ho, ten, GioiTinh, NgaySinh);
		}
	}

	@Override
	public void docFile() {
		// TODO Auto-generated method stub

	}

	public void docFile(String nameFile) {
		try (FileReader file = new FileReader(nameFile);
				BufferedReader buffer = new BufferedReader(file)) {
			n = 0;
			gv = new GiaoVien[1];
			String[] data = new String[6];
			String line = buffer.readLine();
			System.out.println(line);
			while (true) {
				data[0] = buffer.readLine();
				if (data[0] == null)
					break;
				n++;
				gv = Arrays.copyOf(gv, n);
				data[1] = buffer.readLine();
				data[2] = buffer.readLine();
				data[3] = buffer.readLine();
				data[4] = buffer.readLine();
				data[5] = buffer.readLine();
				gv[n - 1] = new GiaoVien(data[0], data[1], data[2], data[3], data[4], data[5]);
			}
			buffer.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
	}

	@Override
	public void ghiFile() {
		// TODO Auto-generated method stub
	}

	public void ghiFile(String nameFile) {
		try {
			FileWriter file = new FileWriter(nameFile);
			BufferedWriter buffer = new BufferedWriter(file);
			buffer.write("Số lượng giáo viên:" + n);
			buffer.newLine();
			for (GiaoVien s : gv) {
				buffer.write(s.getId());
				buffer.newLine();
				buffer.write(s.getKhoa());
				buffer.newLine();
				buffer.write(s.getFirstName());
				buffer.newLine();
				buffer.write(s.getLastName());
				buffer.newLine();
				buffer.write(s.getdateOfBirth());
				buffer.newLine();
				buffer.write(s.getGender());
				buffer.newLine();
			}
			buffer.close();
			file.close();
			;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
	}

	// -----------------------------------------------------------------------
	public void xuatDS() {
		System.out.println(
				"--------------------------------------------------------------------------------------");
		System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-8s | %-15s |\n",
				"ID", "Faculty", "First Name", "Last Name", "Gender", "Date of Birth");
		System.out.println(
				"--------------------------------------------------------------------------------------");

		for (int i = 0; i < this.n; i++) {
			GiaoVien st = this.gv[i];
			System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-8s | %-15s |\n",
					st.getId(), st.getFaculty(), st.getFirstName(), st.getLastName(), st.getGender(),
					st.getdateOfBirth());
		}

		System.out.println(
				"--------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\tTotal teachers: " + this.n + "\t\t\t     |");
		System.out.println(
				"--------------------------------------------------------------------------------------");
	}

	public void addGiaoVien(GiaoVien other) {
		GiaoVien st = new GiaoVien(other);
		gv[n] = st;
		n++;
	}

	public DanhSachGiaoVien statistics() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select statistics criteria:");
		System.out.println("1. Faculty");
		System.out.println("2. Gender");
		System.out.print("Select statistics option: ");
		int option = Integer.parseInt(scanner.nextLine());
		DanhSachGiaoVien result = new DanhSachGiaoVien();
		switch (option) {
			case 1:
				System.out.println("Do you want to print individual teachers in a faculty?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.print("Select option: ");
				int option2 = Integer.parseInt(scanner.nextLine());
				switch (option2) {
					case 1:
						statisticsByFacultyIndividually();
						break;
					case 2:
						statisticsByFaculty();
						break;
					default:
						System.out.println("Invalid option.");
						break;
				}
				break;
			case 2:
				System.out.println("Do you want to print individual teachers by gender?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.print("Select option: ");
				int option3 = Integer.parseInt(scanner.nextLine());
				switch (option3) {
					case 1:
						statisticsByGenderIndividually();
						break;
					case 2:
						statisticsByGender();
						break;
					default:
						System.out.println("Invalid option.");
						break;
				}
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
		return result;
	}

	public void statisticsByFaculty() {
		String[] facultyArray = new String[gv.length];
		int m = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false; 
			for (int j = 0; j < m; j++) {
				if (gv[i].getFaculty().equals(facultyArray[j])) {
					found = true;
					break;
				}
			}

			if (!found) {
				facultyArray[m] = gv[i].getFaculty();
				m++;
			}
		}
		System.out.println("-------------------------\nStatistic by faculty:");
		System.out.printf("| %-10s | %-8s |\n", "Faculty", "Teachers");
		System.out.println("-------------------------");
		for (int i = 0; i < m; i++) {
			DanhSachGiaoVien result = new DanhSachGiaoVien();
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (gv[j].getFaculty().equals(facultyArray[i])) {
					result.addGiaoVien(gv[j]);
					count++;
				}
			}
			System.out.printf("| %-10s | %-8s |\n", facultyArray[i], count);
		}
		System.out.println("-------------------------");
	}

	public void statisticsByFacultyIndividually() {
		String[] facultyArray = new String[gv.length];
		int m = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = 0; j < m; j++) {
				if (gv[i].getFaculty().equals(facultyArray[j])) {
					found = true;
					break;  
				}
			}
			if (!found) {  
				facultyArray[m] = gv[i].getFaculty();
				m++;
			}
		}
		System.out.println("----------------------\nStatistic by faculty individually:");
		System.out.printf("| %-10s | %-8s |\n", "Faculty", "Teachers");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			DanhSachGiaoVien result = new DanhSachGiaoVien();
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (gv[j].getFaculty().equals(facultyArray[i])) {
					result.addGiaoVien(gv[j]);
					count++;
				}
			}
			System.out.printf("| %-10s | %-56s |\n", facultyArray[i], count);
			if (count > 0) {
				System.out.println("-------------------------------------------------------------------------");
				System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
						"ID", "First Name", "Last Name", "Gender", "Date of Birth");
				System.out.println("-------------------------------------------------------------------------");
			}
			for (int k = 0; k < count; k++) {
				GiaoVien giaovien = result.gv[k];
				System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
						giaovien.getId(), giaovien.getFirstName(), giaovien.getLastName(),
						giaovien.getGender(), giaovien.getdateOfBirth());

			}
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf("| %-69s |\n",
					"Total: " + count);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("-------------------------------------------------------------------------");
		}
	}

	public void statisticsByGender() {
		String[] genderArray = new String[gv.length];
		int m = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = 0; j < m; j++) {
				if (gv[i].getGender().equals(genderArray[j])) {
					found = true;
					break;
				}
			}

			if (!found) {
				genderArray[m] = gv[i].getGender();
				m++;
			}
		}
		System.out.println("-------------------------\nStatistic by Gender:");
		System.out.printf("| %-10s | %-8s |\n", "Gender", "Teachers");
		System.out.println("-------------------------");
		for (int i = 0; i < m; i++) {
			DanhSachGiaoVien result = new DanhSachGiaoVien();
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (gv[j].getGender().equals(genderArray[i])) {
					result.addGiaoVien(gv[j]);
					count++;
				}
			}
			System.out.printf("| %-10s | %-8s |\n", genderArray[i], count);
		}
		System.out.println("-------------------------");
	}


	public void statisticsByGenderIndividually() {
		String[] genderArray = new String[gv.length];
		int m = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = 0; j < m; j++) {
				if (gv[i].getGender().equals(genderArray[j])) {
					found = true;
					break;
				}
			}
			if (!found) {
				genderArray[m] = gv[i].getGender();
				m++;
			}
		}
		System.out.println("----------------------\nStatistic by gender individually:");
		System.out.printf("| %-10s | %-8s |\n", "Gender", "Teachers");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			DanhSachGiaoVien result = new DanhSachGiaoVien();
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (gv[j].getGender().equals(genderArray[i])) {
					result.addGiaoVien(gv[j]);
					count++;
				}
			}
			System.out.printf("| %-10s | %-56s |\n", genderArray[i], count);
			if (count > 0) {
				System.out.println("-------------------------------------------------------------------------");
				System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
						"ID", "First Name", "Last Name", "Gender", "Date of Birth");
				System.out.println("-------------------------------------------------------------------------");
			}
			for (int k = 0; k < count; k++) {
				GiaoVien giaovien = result.gv[k];
				System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
						giaovien.getId(), giaovien.getFirstName(), giaovien.getLastName(),
						giaovien.getGender(), giaovien.getdateOfBirth());

			}
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf("| %-69s |\n",
					"Total: " + count);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("-------------------------------------------------------------------------");
		}
	}  
}
