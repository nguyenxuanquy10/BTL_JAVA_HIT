package BTL_JAVA;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class QuanLySinhVien {
    static Scanner sc = new Scanner(System.in);

    private List<SinhVien> DanhSachSV;

    private FILE_thaotac DuLieuFile;

    private JDBC_thaotac jdbc_thaotac = new JDBC_thaotac();

    public QuanLySinhVien() {
        DanhSachSV = new ArrayList<>();
        DuLieuFile = new FILE_thaotac();
    }

    // thao tác với file
    public void DocFile1() throws Exception {
        DuLieuFile.DocFile(DanhSachSV);
    }

    public void VietFile1() throws Exception {
        DuLieuFile.GhiFile(DanhSachSV);
    }

    // xuất dữ liệu
    public void XuatDuLieu() {
        DanhSachSV.forEach(System.out::println);
    }

    // tìm kiếm sinh viên bằng id
    public void TimKiemBangId(String ID) throws IOException {
        String newid = ID.trim();
        SinhVien result = DanhSachSV.stream().filter(o -> o.getId().equals(newid)).findFirst().orElse(null);
        if (result != null) {
            System.out.println("Tìm kiếm thành công");
            System.out.println(result);
            System.in.read();
        } else {
            System.out.println("Sai id");
        }
    }

    // xóa sinh viên bằng id
    public void XoaBangId(String ID) throws IOException {
        SinhVien result = DanhSachSV.stream().filter(o -> o.getId().equals(ID)).findFirst().orElse(null);
        if (result != null) {
            System.out.println("Xóa thành công");
            DanhSachSV.remove(result);
            System.in.read();

        } else {
            System.out.println("Sai id");
        }
    }

    // truyền thông tin sinh viên vào List
    public List<SinhVien> LayTatCaSinhVien(List<SinhVien> result) {
        for (SinhVien o : DanhSachSV) {
            result.add(o);
        }
        return result;
    }

    //kiểm tra id đã tồn tại chưa
    public boolean kiemtra_id(List<SinhVien> result, String id_) {
        for (SinhVien o : result) {
            if (id_.equals(o.getId())) return true;
        }
        return false;
    }

    // kiểm tra số chứng minh thư đã tồn tại chưa
    public boolean kiemtra_cmt(List<SinhVien> result, String cmt_) {
        for (SinhVien o : result) {
            if (cmt_.equals(o.getSoCMT())) return true;
        }
        return false;
    }

    // thêm 1 sinh viên
    public void ThemSV() {
        SinhVien sinhvien = new SinhVien();
        // nhap id
        String newid;
        // sc.nextLine();
        do {

            System.out.println("Nhâp id ( mã sinh viên - VD:2020606494 ): ");
            newid = sc.nextLine();
            if (kiemtra_id(DanhSachSV, newid)) {
                System.out.println("Đã tồn tại,nhập lại!");
                newid = "";
            }
        } while (!sinhvien.regex_id(newid) && !kiemtra_id(DanhSachSV, newid));
        System.out.println("Hợp lệ");
        // nhap mat khau
        String newmatkhau;
        do {
            System.out.println("Nhập mật khẩu( ít nhất 8 ký tự ,chứa 1 chữ hoa,1 chữ thường,1 ký tự đặc biệt - VD: Abcd111@");
            newmatkhau = sc.nextLine();
        } while (!sinhvien.regex_matkhau(newmatkhau));
        System.out.println("Hợp lệ");
        // nhap ho ten
        String hoten;
        do {
            System.out.println("Nhập họ tên ( VD: NGUYEN VAN A ) ");
            hoten = sc.nextLine();
        } while (!sinhvien.regex_hoten(hoten));
        System.out.println("Hợp lệ");
        // nhap tuoi
        String newtuoi;
        do {
            System.out.println("Nhập tuổi( VD: 18 )");
            newtuoi = sc.nextLine();
        } while (!sinhvien.regex_tuoi(newtuoi));
        System.out.println("Hợp lê");
        // nhap dia chi
        String newdiachi;
        do {
            System.out.println("Nhập địa chỉ (VD: HA NOI)");
            newdiachi = sc.nextLine();
        } while (!sinhvien.regex_diachi(newdiachi));
        System.out.println("Hợp lệ");
        // nhap gioi tinh
        String newgioitinh;
        do {
            System.out.println("Nhập giới tính( NAM|NU|THUBA )");
            newgioitinh = sc.nextLine();
        } while (!sinhvien.regex_gioitinh(newgioitinh));
        System.out.println("Hợp lệ");
        // nhap sdt
        String newsdt;
        do {
            System.out.println("Nhập SDT ( so 0 DUNG DAU,10 CHU SO )");
            newsdt = sc.nextLine();
        } while (!sinhvien.regex_sdt(newsdt));
        System.out.println("Hợp lệ");
        // nhap cmt
        String newcmt;
        do {
            System.out.println("Nhập CMT ( 12 SO )");
            newcmt = sc.nextLine();
            if (kiemtra_cmt(DanhSachSV, newcmt)) {
                System.out.println("Đã tồn tại,nhập lại !");
                newcmt = "";
            }
        } while (!sinhvien.regex_cmt(newcmt) && !kiemtra_cmt(DanhSachSV, newcmt));
        System.out.println("Hợp lệ");

        // nhap tinh trang tai chinh
        String newtaichinh;
        do {
            System.out.println("Nhập tình trạng tài chính( VD: THIEU: 1000 )");
            newtaichinh = sc.nextLine();
        } while (!sinhvien.regex_taichinh(newtaichinh));
        System.out.println("Hợp lệ");
        // nhap lich hoc
        String newlichhoc;
        do {
            System.out.println("Nhập lịch học ( VD: T2:TOAN/T3: LY)");
            newlichhoc = sc.nextLine();
        } while (!sinhvien.regex_lichhoc(newlichhoc));
        System.out.println("Hợp lệ");
        // nhap lich thi
        String newlichthi;
        do {
            System.out.println("Nhập lịch thi(VD: T2: THITOAN/T3: THILY) ");
            newlichthi = sc.nextLine();
        } while (!sinhvien.regex_lichthi(newlichthi));
        System.out.println("Hợp lệ");

        // nhap gpa
        double newgpa;
        do {
            System.out.println("Nhập GPA (VD: 9.0)");
            String newgpa1=sc.nextLine();
            newgpa = Double.parseDouble(newgpa1);
        } while (!sinhvien.regex_GPA(newgpa));
        System.out.println("Hợp lệ");
        // nhap Nhập tình trạng sức khẻo
        String newsk;
        do {
            System.out.println("Nhập tình trạng sức khẻo (XAU|TOT|NHIEMCOVID");
            newsk = sc.nextLine();
        } while (!sinhvien.regex_tinhtrangsuckhoe(newsk));
        System.out.println("Hợp lệ");
        // nhap so mui vaccin
        String newsomui;
        do {
            System.out.println("Nhập số mũi vaccin đã tiêm(VD: 2) ");
            newsomui = sc.nextLine();
        } while (!sinhvien.regex_somuivaccin(newsomui));
        System.out.println("Hợp lệ");
        // nhap tinh trang f
        String newf;
        do {
            System.out.println("Bạn là F mấy ( VD: F0|F1|F2|F3|F4|NONE) ");
            newf = sc.nextLine();
        } while (!sinhvien.regex_F(newf));
        System.out.println("Hợp lệ");

        DanhSachSV.add(new SinhVien(newid, newcmt, newmatkhau, hoten, newgioitinh, newdiachi, newtuoi, newsdt,
                newgpa, newtaichinh, newlichhoc, newlichthi, newsk, newsomui, newf));
    }

    // thêm danh sách sinh viên
    public void ThemDanhSachSV() {
        System.out.println("----------Nhập số lượng sinh viên muốn thêm----------");
        String soluong1=sc.nextLine();
        int soluong = Integer.parseInt(soluong1);
        List<SinhVien> result = new ArrayList<>();
        for (int i = 1; i <= soluong; i++) {
            ThemSV();
        }
        sc.nextLine();
    }

    // tìm kiếm sinh viên bằng số cmt
    public void TimKiemBangSoCMT(String SoCMT) throws IOException {
        SinhVien result = DanhSachSV.stream().filter(o -> o.getSoCMT().equals(SoCMT)).findFirst().orElse(null);
        if (result != null) {
            System.out.println("Tìm kiếm thành công");
            System.out.println(result);
            System.in.read();
        } else {
            System.out.println("Khong Hợp lệ,Nhap Lai");
        }
    }

    // xóa sinh viên bằng số cmt
    public void XoaBangSoCMT(String SoCMT) throws IOException {
        SinhVien result = DanhSachSV.stream().filter(o -> o.getSoCMT().equals(SoCMT)).findFirst().orElse(null);
        if (result != null) {
            DanhSachSV.remove(result);
            System.out.println("XOA THANH CONG");
            System.in.read();
        } else {
            System.out.println("Khong Hợp lệ,Nhap Lai");
        }

    }

    // kiểm tra thông tin sinh viên có tình trạng sức khẻo F
    public void TimKiemSVF(String F) {
        List<SinhVien> result = new ArrayList<>();
        result = DanhSachSV.stream().filter(o -> o.getF().equals(F)).collect(Collectors.toList());
        if (result.size() == 0) {
            System.out.println("Khong Hợp lệ,Nhap Lai");
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            result.forEach(System.out::println);
        }
    }

    // kiểm tra thông tin sinh viên đủ điều kiện đến trường
    public void DuDieuKien() throws IOException {
        // so mui vaccin la 2;
        // khong la F0,F1
        // Nhập tình trạng sức khẻo
        List<SinhVien> result = new ArrayList<>();
        for (SinhVien o : DanhSachSV) {
            if ((!o.getF().equals("F0") && !o.getF().equals("F1")) && Integer.parseInt(o.getSoMuiVaccin()) >= 2) {
                result.add(o);
            }
        }
        if (result.size() == 0) {
            System.out.println("Không có sinh viên đủ điều kiện đến trường");
            return;
        }
        System.out.println("Thông tin sinh viên đủ điều kiện đến trường");
        System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
        System.out.println();
        result.forEach(System.out::println);
        System.in.read();
    }

    // kiểm tra số lượng sinh viên chưa đóng học
    // xử lý đầu vào, tách lấy số nguyên trong đầu vào(string)
    public float xulychuoi(String sotien) {
        sotien = sotien.replaceAll("[^0-9-]", "");
        return Float.parseFloat(sotien);
    }

    // kiểm tra thông tin sinh viên thiếu học phí
    public void ThieuHocPhi() throws IOException {
        List<SinhVien> result = new ArrayList<>();
        for (SinhVien o : DanhSachSV) {
            if (xulychuoi(o.getTinhTrangTaiChinh()) > 0) {
                result.add(o);
            }
        }
        if (result.size() <= 0) {
            System.out.println("Không có sinh viên thiếu tiền");
            System.in.read();
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            System.out.println("Danh sách sinh viên thiếu tiền");
            result.forEach(System.out::println);
            System.in.read();
        }
    }

    // kiểm tra thông tin sinh viên đóng đủ học phí
    public void DuHocPhi() throws IOException {
        List<SinhVien> result = new ArrayList<>();
        for (SinhVien o : DanhSachSV) {
            if (xulychuoi(o.getTinhTrangTaiChinh()) == 0) {
                result.add(o);
            }
        }
        if (result.size() <= 0) {
            System.out.println("KHONG CO SINH VIEN DONG DU TIEN");
            System.in.read();
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            System.out.println("DANH SACH SINH VIEN DONG DU TIEN");
            result.forEach(System.out::println);
            System.in.read();
        }
    }

    // kiểm tra thông tin sinh viên theo tình trạng sức khẻo
    public void SearchTinhTrangSucKheo(String TinhTrangSucKheo) throws IOException {
        List<SinhVien> result = new ArrayList<>();
        result = DanhSachSV.stream().filter(o -> o.getF().equals(TinhTrangSucKheo)).collect(Collectors.toList());
        if (result.size() == 0) {
            System.out.println("Không tồn tài: " + TinhTrangSucKheo);
            System.in.read();
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            result.forEach(System.out::println);
            System.in.read();
        }
    }

    // kiểm tra số lượng sinh viên đạt học bổng
    public void DatHocBong() throws IOException {
        List<SinhVien> result = new ArrayList<>();
        result = DanhSachSV.stream().filter(o -> o.getGPA() > 8.0).collect(Collectors.toList());
        if (result.size() < 0) {
            System.out.println("Không có sinh viên nào được học bổng");
            System.in.read();
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            System.out.println("----------Danh sách sinh viên đạt học bổng--------- ");
            result.forEach(System.out::println);
            System.in.read();
        }
    }

    // kiểm tra số lượng sinh viên học lại
    public void HocLai() throws IOException {
        List<SinhVien> result = new ArrayList<>();
        result = DanhSachSV.stream().filter(o -> o.getGPA() < 4.0).collect(Collectors.toList());
        if (result.size() < 0) {
            System.out.println("Không có sinh viên nào học lại");
            System.in.read();
        } else {
            System.out.printf("Số lượng: %d/%d", result.size(), DanhSachSV.size());
            System.out.println();
            System.out.println("----------Danh sách sinh viên học lại--------- ");
            result.forEach(System.out::println);
            System.in.read();
        }
    }

    // xóa sinh viên bằng id
    public void XoaBangId1(String ID) throws IOException {
        SinhVien result = DanhSachSV.stream().filter(o -> o.getId().equals(ID)).findFirst().orElse(null);
        if (result != null) {
            DanhSachSV.remove(result);
            System.in.read();
        }
    }

    // thêm 1 sinh viên
    public void ThemSV1(SinhVien result) {
        DanhSachSV.add(result);
    }

    // sắp xếp theo GPA
    public void SapXepGPA() throws IOException {
        Collections.sort(DanhSachSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.getGPA() > o2.getGPA()) return 1;
                return -1;
            }
        });
        System.out.println("Sắp xếp thành công");
        System.in.read();
    }

    // sắp xếp theo tên
    public void SapXepTheoTen() throws IOException {
        Collections.sort(DanhSachSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien a, SinhVien b) {
                String[] result1 = a.getHoTen().split(" ");
                String[] result2 = b.getHoTen().split(" ");
                return result1[result1.length - 1].compareTo(result2[result2.length - 1]);
            }
        });
        System.out.println("Sắp xếp thành công");
        System.in.read();
    }

    // sắp xếp theo id
    public void SapXepTheoId() throws IOException {
        Collections.sort(DanhSachSV, (sinhvien1, sinhvien2) -> sinhvien1.getId().compareTo(sinhvien2.getId()));
        System.out.println("Sắp xếp thành công");
        System.in.read();
    }

    // hiển thị tất cả thông tin sinh viên
    public void ThongTinhAll() {
        System.out.println("----------Tất cả thông tin sinh viên----------");
        DanhSachSV.stream().forEach(System.out::println);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // thao tác với JDBC

  // truyen du lieu vao từ jdbc
    public void LayTatCaSinhVien1(List<SinhVien> results){
        results.forEach(result->DanhSachSV.add(result));
    }
    // cập nhập dữ liệu vào jdbc
    public void UpdateJbdc() throws Exception {
        jdbc_thaotac.UpdateDl(DanhSachSV);
    }
}
