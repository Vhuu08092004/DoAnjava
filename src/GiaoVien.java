import java.util.Scanner;

public class GiaoVien extends Human{
	private String id;
	private String khoa;
	
	public GiaoVien() {
	}
	
	
	public GiaoVien(GiaoVien other) {
        super(other);
        this.id = other.id;
        this.khoa = other.khoa;
    }

	public GiaoVien(String id,String khoa, String firstName, String lastName, String gender,
            String dateOfBirth) {
		super(firstName, lastName, gender, dateOfBirth);
		this.id = id;
		this.khoa = khoa;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getFaculty() {
		return khoa;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Nhập vào id của giáo viên:");
		this.id = sc.next();
		System.out.println("Nhập vào khoa của giáo viên:");
		this.khoa = sc.next();
	}
	public void xuat() {
		super.output();
		System.out.println("id của giáo viên:" + this.id );
		System.out.println("Khoa của giáo viên:" + this.khoa);
	}
	
	
}
