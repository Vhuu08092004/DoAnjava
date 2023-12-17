import java.util.Scanner;

public class App {
	private static Scanner scan = new Scanner(System.in);
    public static DanhSachCauHoi DSCH = new DanhSachCauHoi();
    public static DanhSachGiaoVien DSGV = new DanhSachGiaoVien();
    public static StudentList DSSV = new StudentList();
    public static DanhSachKetQua DSKQ = new DanhSachKetQua();
    public static int MatKhau = 12345678;
    public static int id;
    
    public static void clearScreen(){
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void DangNhap(){
        int m;
        do{
        	
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("ID cua ban:");
            id = Integer.parseInt(scan.nextLine());
            System.out.println("Mat khau:");
            m = Integer.parseInt(scan.nextLine());
            
            if(id <= DSSV.getN() && m == 12345678) {
            	MenuSinhVien();
            } else {
            	System.out.println("Sai thông tin đăng nhập mời bạn nhập lại");
            }
        }while(true);
        
    }
    public static void DangNhapAdmin() {
    	int m;
do{
        	
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("ID cua giang vien:");
            id = Integer.parseInt(scan.nextLine());
            System.out.println("Mat khau:");
            m = Integer.parseInt(scan.nextLine());
            
            if(id <= DSGV.getN() && m == 123456) {
            	menuAdmin();
            } else {
            	System.out.println("Sai thông tin đăng nhập mời bạn nhập lại");
            }
        }while(true);
    }
    public static void Thi() {
    	Thi thi = new Thi();
    	thi.getDetThi().NhapThongTinDeThi();
    	thi.LamDeThi();
    	DSKQ.WriteFile(thi.getDiemSo(), id, DSSV.getStudentArray()[id].getLastName(), DSSV.getStudentArray()[id].getFaculty(), thi.getTenKiThi());
    	System.out.println("Chuc Mung ban da hoan thanh Bai Thi");
    	Scanner scanner = new Scanner(System.in);
        int option;
    	while(true) {
    		System.out.println("1.Dang Xuat");
    		System.out.println("2.Quay ve Menu");
    		option = scanner.nextInt();
    		if(option == 1) {
    			ThongThiTracNghiem();
    		} 
    		if(option == 2) {
    			MenuSinhVien();
    		}
    	}
    }
    
    public static void ThongTinSinhVien() {
    	DSSV.searchId(id - 1);
    	clearScreen();
    	MenuSinhVien();
    }
    
    
    public static void CapNhatThongTinSinhVien() {
    	DSSV.updateInfo(id);
    	clearScreen();
    	MenuSinhVien();
    }
    
    public static void MenuSinhVien(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
           System.out.println("1.Vao Thi");
           System.out.println("2.Xem Thong Tin");
           System.out.println("3.Cap Nhat Thong Tin");
           System.out.println("4.Dang Xuat");
            option = scanner.nextInt();
           if(option == 1){
        	   System.out.println("Vao Thi thanh cong");
        	   clearScreen();
        	   Thi();
            return;
           } else if(option == 2){
            System.out.println("Thong tin sinh vien");
            ThongTinSinhVien();
 
           } else if(option == 3){
             System.out.println("Moi Cap nhat thong tin");
             CapNhatThongTinSinhVien();
        }  else if(option == 4){
            return;
        }
         System.out.println("Khong Hop Le Moi Nhap Lai");
        }
    }
    public static void DanhSachMonHoc() {
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
        System.out.println("=======================================================");
        System.out.println("Danh Sách Môn Học Bạn Muốn Xuất Ra Là:");
        System.out.println("1.Danh Sách Môn Cấu Trúc Rời Rạc");
        System.out.println("2.Danh Sách Môn Triết Học");
        System.out.println("3.Danh Sách Môn Xác Xuất Thống Kê");
        System.out.println("4.Quay Lại");
        System.out.println("5.Trở Về Trang chủ");
        option = scanner.nextInt();
        if(option == 1){
            DSCH.docFile("CauTrucRoiRac.txt");
            DSCH.xuatDS();
        } 
        else if(option == 2){
            DSCH.docFile("TrietHoc.txt");
            DSCH.xuatDS();
        } 
        else if(option == 3){
           DSCH.docFile("XacXuatThongKe.txt");
           DSCH.xuatDS();
        } 
        else if(option == 4){
            menuAdmin();
        } 
        else if(option == 5){
            menuAdmin();
        }
        else {
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
    }
    }
    public static void ThayDoiNoiDungDanhSach(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
        System.out.println("=======================================================");
        System.out.println("Danh Sách Môn Học Bạn Muốn Thay Đổi Là:");
        System.out.println("1.Danh Sách Môn Cấu Trúc Rời Rạc");
        System.out.println("2.Danh Sách Môn Triết Học");
        System.out.println("3.Danh Sách Môn Xác Xuất Thống Kê");
        System.out.println("4.Quay Lại");
        System.out.println("5.Trở Về Trang chủ");
        option = scanner.nextInt();
        if(option == 1){
            DSCH.docFile("CauTrucRoiRac.txt");
            PhuongThucCapNhat("CauTrucRoiRac.txt");
            ThayDoiNoiDungDanhSach();
        } 
        else if(option == 2){
            DSCH.docFile("TrietHoc.txt");
            PhuongThucCapNhat("TrietHoc.txt");
            ThayDoiNoiDungDanhSach();
        } 
        else if(option == 3){
           DSCH.docFile("XacXuatThongKe.txt");
           PhuongThucCapNhat("XacXuatThongKe.txt");
           ThayDoiNoiDungDanhSach();
        } 
        else if(option == 4){
            menuAdmin();
        } 
        else if(option == 5){
            menuAdmin();
        }
        else {
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
    }
    }
    public static void CapNhatDanhSachTheoViTri(String document) {
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("======================================================");
            System.out.println("Nhập Lựa Chọn Thay Đổi Danh Sách Của Bạn");
            System.out.println("1.Tôi Muốn Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("2.Tôi Muốn Xóa Câu Hỏi Khỏi Danh Sách");
            System.out.println("3.Tôi Muốn Thay Đổi Câu Hỏi Trong Sách");
            System.out.println("4.Quay Lại");
            System.out.println("5.Trở Về Trang chủ");
            option = scanner.nextInt();
        if(option == 1){
             ThemCauHoi();
             DSCH.ghiFile(document);
             CapNhatDanhSachTheoViTri(document);
        } 
        else if(option == 2){
            XoaCauHoi();
            DSCH.ghiFile(document);
            CapNhatDanhSachTheoViTri(document);
        } 
        else if(option == 3){
            SuaCauHoi();
            DSCH.ghiFile(document);
            CapNhatDanhSachTheoViTri(document);
        } 
        else if(option == 4){
            PhuongThucCapNhat(document);
        } 
        else if(option == 5){
             menuAdmin();
        }else{
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
        }
    }
    public static void CapNhatDanhSachTheoID(String document){
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("======================================================");
            System.out.println("Nhập Lựa Chọn Thay Đổi Danh Sách Của Bạn");
            System.out.println("1.Tôi Muốn Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("2.Tôi Muốn Xóa Câu Hỏi Khỏi Danh Sách");
            System.out.println("3.Tôi Muốn Thay Đổi Câu Hỏi Trong Sách");
            System.out.println("4.Quay Lại");
            System.out.println("5.Trở Về Trang chủ");
            option = scanner.nextInt();
            scanner.nextLine();
        if(option == 1){
            ThemCauHoi();
            DSCH.ghiFile(document);
            CapNhatDanhSachTheoID(document);
        } 
        else if(option == 2){
            System.out.println("Mời Nhập ID Câu Hỏi Cần Xóa");
            String ID = scanner.nextLine();
            DSCH.XoaPhanTuTheoID(ID);
            DSCH.ghiFile(document);
            CapNhatDanhSachTheoID(document);
    
        } 
        else if(option == 3){
            System.out.println("Mời Nhập ID Câu Hỏi Cần Chỉnh Sửa");
            String ID = scanner.nextLine();
            DSCH.SuaPhanTuTheoID(ID);
            DSCH.ghiFile(document);
            CapNhatDanhSachTheoID(document);
        } 
        else if(option == 4){
            PhuongThucCapNhat(document);
        } 
        else if(option == 5){
             menuAdmin();
        }else{
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
        }
    }
    public static void PhuongThucCapNhat(String document){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
             System.out.println("====================================================================");
             System.out.println("1.Phương Thức Cập Nhật Theo ID Câu Hỏi");
             System.out.println("2.Phương Thức Cập Nhật Theo Vị Trí Câu Hỏi");
             System.out.println("3.Quay Lại");
             System.out.println("4.Trở Về Trang Chủ");
             option = scanner.nextInt();
             if (option == 1) {
                CapNhatDanhSachTheoID(document);
                PhuongThucCapNhat(document);
             } else if(option == 2) {
                CapNhatDanhSachTheoViTri(document);
                PhuongThucCapNhat(document);
             } else if (option == 3) {
                ThayDoiNoiDungDanhSach();
             } else if(option == 4) {
                menuAdmin();
             } else {
                System.out.println("Lựa Chọn Không Hợp Lệ !!!");
             }
        }
    }
    public static void ThemCauHoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Thêm:");
        int number = scanner.nextInt();
        for(int i = 0; i < number; i++) {   
            System.out.println("Xin Mời Nhập Vị Trí Cần Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ : " );
            int index = scanner.nextInt();
            DSCH.ThemPhanTuTheoViTri(index - 1);
        }
        System.out.println("Thêm Câu Hỏi Thành Công !");
    }
    public static void XoaCauHoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Xóa:");
        int number = scanner.nextInt();
        int starIndex[] = new int[number];
        for(int i = 0; i < number; i++) {
            System.out.println("Xin Mời Nhập Vị Trí Cần Xóa Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ :");
            starIndex[i] = RangBuocViTri();
            if(i > 0 && starIndex[i] == (starIndex[i-1] + 1)){
                starIndex[i] = starIndex[i-1];
            }
        }
        for(int i = 0; i < number;i++) {
             DSCH.XoaPhanTuTheoViTri(starIndex[i] - 1);
        }
            System.out.println("Xóa Câu Hỏi Thành Công !");
    }
    public static void SuaCauHoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Thay Đổi:");
        int number = scanner.nextInt();
        for(int i = 0; i < number; i++) {
            System.out.println("Xin Mời Nhập Vị Trí Cần Sửa Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ :");
            int index = RangBuocViTri();
            DSCH.SuaPhanTuTheoViTri(index - 1);
        }
        System.out.println("Sửa Câu Hỏi Thành Công !!!!");
    }
    public static int RangBuocViTri(){
        Scanner scanner = new Scanner(System.in);
        int index;
        index = scanner.nextInt();
        if(index <= 0 || index > DSCH.getN()) {
            System.out.println("Vị Trí Câu Hỏi Không Hợp Lệ Xin Nhập Lại !!!");
            return RangBuocViTri();
        }
        return index;
    }
    
    public static void updateCauhoi() {
    	Scanner scanner = new Scanner(System.in);
    	int option;
    	while(true) {
    		System.out.println("Nhập câu bạn muốn sửa");
    		
    	}
    }
    
    public static void upDateGiangVien() {
    	 Scanner scanner = new Scanner(System.in);
         int option;
         while (true) {
        	 clearScreen();
        	 System.out.println("1. Thêm giảng viên vào danh sách");
        	 System.out.println("2. Xóa giảng viên ra khỏi danh sách bằng id");
        	 System.out.println("3. Xóa giảng viên khỏi danh sách bằng tên");
        	 System.out.println("4. Tìm kiếm giảng viên theo tên");
        	 System.out.println("5. Tìm kiếm giảng viên theo id");
        	 option = scanner.nextInt();
        	 if(option == 1){
        		DSGV.themPT();
        		DSGV.xuatDS();
        		DSGV.ghiFile("danhsachgiaovien");
        		upDateGiangVien();
             } else if(option == 2){
            	 System.out.println("Nhập vào id giảng viên bạn muốn xóa");
            	 int x = scanner.nextInt();
            	 DSGV.xoaPT(x-1);
            	 System.out.println("Danh sách giảng viên sao khi xóa là:");
            	 DSGV.xuatDS();
            	 DSGV.ghiFile();
            	 upDateGiangVien();
             } else if(option == 3){
            	 System.out.println("Nhập vào tên giảng viên mà bạn muốn xóa");
            	 String x = scanner.next();
            	 DSGV.xoaPT(x);
            	 System.out.println("Danh sách giảng viên sao khi xóa là:");
            	 DSGV.xuatDS();
            	 DSGV.ghiFile();
            	 upDateGiangVien();
               
          }  else if(option == 4){
              System.out.println("Nhập vào tên giảng viên bạn muốn tìm kiếm");
              String x = scanner.next();
              int temp;
              if (DSGV.timKiem(x) != -1) {
            	  temp = DSGV.timKiem(x);
            	  System.out.println("Tìm được giảng viên có tên là "+ x +  " trong danh sách giảng viên");
              } else {
            	  System.out.println("Không tồn tại giảng viên có tên là:" + x);
              }
              
              
              upDateGiangVien();
          } else if(option == 5) {
        	  System.out.println("Nhập vào id giãng viên bạn muốn tìm kiếm");
        	  String x = scanner.next();
        	  int temp;
        	  if (DSGV.timKiemid(x) != -1) {
            	  temp = DSGV.timKiem(x);
            	  System.out.println("Tìm được giảng viên có id là "+ x +  " trong danh sách giảng viên");
              } else {
            	  System.out.println("không tồn tại giảng viên có id là:"+ x);
              }
        	  upDateGiangVien();
          }
           System.out.println("Khong Hop Le Moi Nhap Lai");
         }
         
    }
    
    public static void menuAdmin() {
    	Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
        	clearScreen();
           System.out.println("1.Danh sách học sinh");
           System.out.println("2.Danh sách giảng viên");
           System.out.println("3.Danh sách câu hỏi");
           System.out.println("4.Cập nhật danh sách câu hỏi");
           System.out.println("5.Cập nhật danh sách học sinh");
           System.out.println("6.Cập nhật danh sách giảng viên");
           System.out.println("7.Thống kê theo khoa");
           System.out.println("8.Thống kê theo kì thi");
           System.out.println("9.Thống kê theo khoản điểm");
           System.out.println("10.Thống kê giáo viên");
           System.out.println("11.Đăng xuất");
            option = scanner.nextInt();
           if(option == 1){
        	   System.out.println("Danh sách học sinh");
        	   clearScreen();
        	   DSSV.printList();
        	   menuAdmin();
           } else if(option == 2){
            System.out.println("Danh sách giảng viên");
            	DSGV.xuatDS();
            	menuAdmin();
           } else if(option == 3){
             DanhSachMonHoc();
             menuAdmin();
            menuAdmin();
           }  else if(option == 4) {
        	System.out.println("Cập nhật danh sách câu hỏi");
        		ThayDoiNoiDungDanhSach();
        	}
       			else if(option == 5) {
        	System.out.println("Cập nhật danh sách học sinh");
       		}
       			else if(option == 6) {
        	System.out.println("Cập nhật danh sách giảng viên");
        		upDateGiangVien();
        	}
           
       		else if(option == 7){
       			System.out.println("Nhập vào khoa mà bạn muốn thống kê điểm số");
       			String khoa = scanner.next();
       			DSKQ.khoaStatistic(khoa);
       			menuAdmin();
       		} else if(option == 8) {
       			System.out.println("Nhập vào kì thi mà bạn muốn thống kê điểm số");
       			String kithi = scanner.next();
       			DSKQ.hkStatistic(kithi);
       			menuAdmin();
       		} else if(option == 9) {
       			clearScreen();
       			DSKQ.ReadFile();
       			DSKQ.DisplayStatistic();
       			menuAdmin();
       		} else if (option == 10) {
       			DSGV.statistics();
       			menuAdmin();
       		}
         System.out.println("Khong Hop Le Moi Nhap Lai");
        }
    }
    public static void ThongThiTracNghiem(){
        Scanner scanner = new Scanner(System.in);
        int option;
        clearScreen();
        do{
     System.out.println("===============================================");
        System.out.println("Ban muon dang nhap voi tu cach gi: ");
        System.out.println("1.Tu cach sinh vien");
        System.out.println("2.Tu cach giao vien ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                  DangNhap();
                    return;
                case 2:
                    DangNhapAdmin();
                    return;
            }
            System.out.println("Khong hop le moi nhap lai");
        }while(true);
    }
    public static void main(String[] args) {
    	DSGV.docFile("danhsachgiaovien");
    	DSSV.readFile("student-data.txt");
        App app = new App();
        app.ThongThiTracNghiem();    
    }

}