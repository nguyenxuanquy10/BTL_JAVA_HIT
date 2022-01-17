package BTL_JAVA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) throws Exception {
        runMain();
    }

    //RunMain
    public static void runMain() {
        Scanner scanner = new Scanner(System.in);
        boolean flat = true;
        while (flat) {
            MenuThaoTac();
            String luachon = scanner.nextLine();
            switch (luachon) {
                case "1": {
                    try {
                        ThaoTacFile(scanner);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "2": {
                    try {
                        ThaoTacJdbc();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "3": {
                    System.out.println("Không hợp lệ,nhập lại!");
                }
            }
        }
    }

    // thao tác với file
    public static void ThaoTacFile(Scanner sc) throws Exception {
        QuanLySinhVien manage = new QuanLySinhVien();
        manage.DocFile1();
        JDBC_thaotac newjdbc = new JDBC_thaotac();
        List<SinhVien> DS = new ArrayList<>();
        manage.LayTatCaSinhVien(DS);
        boolean flat = true;
        while (flat) {
            TieuDeLogin();
            String luachon=sc.nextLine();
            int x = Integer.parseInt(luachon);
            switch (x) {
                // cho quan ly
                case 1: {
                    DangNhapAdmin(sc);

                    boolean choosequanly = true;
                    while (choosequanly) {
                        MenuThaoTacQl();
                        String yourchoose1 = sc.nextLine();
                        int yourchoose=Integer.parseInt(yourchoose1);
                        switch (yourchoose) {
                            case 1: {
                                System.out.println("Nhập id: ");
                                String newId = sc.nextLine();
                                manage.TimKiemBangId(newId);
                                break;
                            }
                            case 2: {
                                System.out.println("Nhập id: ");
                                String newId = sc.nextLine();
                                manage.XoaBangId(newId);
                                manage.VietFile1();
                                break;
                            }
                            case 5: {
                                manage.ThemSV();
                                manage.VietFile1();
                                break;
                            }
                            case 6: {
                                manage.ThemDanhSachSV();
                                manage.VietFile1();
                                break;
                            }
                            case 3: {
                                System.out.println("Nhập số cmt: ");
                                String cmt = sc.nextLine();
                                manage.TimKiemBangSoCMT(cmt);
                                break;
                            }
                            case 4: {
                                System.out.println("Nhập số cmt: ");
                                String cmt = sc.nextLine();
                                manage.XoaBangSoCMT(cmt);
                                manage.VietFile1();
                                break;
                            }
                            case 7: {
                                System.out.println("Nhập tình trạng bệnh(F0|F1|F2|F3|F4|NONE)");
                                String statusf = sc.nextLine();
                                manage.SearchTinhTrangSucKheo(statusf);
                                break;
                            }
                            case 8: {
                                System.out.println("Điều kiện:không là F1,F2 và tiêm 2 mũi trở lên");
                                manage.DuDieuKien();
                                break;
                            }
                            case 9: {
                                manage.ThieuHocPhi();
                                break;
                            }
                            case 10: {
                                manage.DuHocPhi();
                                break;
                            }
                            case 11: {
                                manage.DatHocBong();
                                break;
                            }
                            case 12: {
                                manage.HocLai();
                                break;
                            }
                            case 13: {
                                manage.SapXepGPA();
                                manage.VietFile1();
                                break;
                            }
                            case 14: {
                                manage.SapXepTheoTen();
                                manage.VietFile1();
                                break;
                            }
                            case 15: {
                                manage.SapXepTheoId();
                                manage.VietFile1();
                                break;
                            }
                            case 16: {
                                manage.ThongTinhAll();
                                break;
                            }
                            case 17: {
                                newjdbc.ChenDl(DS);
                                System.out.println("Chèn dữ liệu thành công");
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 18: {
                                System.out.println("Bạn đang thao tác với file,failed!");
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 19: {
                                choosequanly = false;
                                break;
                            }
                            default: {
                                System.out.println("Nhập sai,nhập lại");
                                break;
                            }
                        }
                    }
                    break;
                }

                // cho sinh vien

                case 2: {
                    SinhVien result = new SinhVien();
                    List<SinhVien> account = new ArrayList<>();
                    manage.LayTatCaSinhVien(account);
                    DangNhapSv(sc, account, result);
                    boolean checkstudent = true;
                    while (checkstudent) {

                        MenuThaoTacSv();
                        int x1 = sc.nextInt();
                        switch (x1) {
                            case 1: {
                                result.ThayDoiThongTinCuThe(sc);
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.VietFile1();
                                break;
                            }
                            case 2: {
                                result.CheckLichHoc();
                                break;
                            }
                            case 3: {
                                result.CheckLichThi();
                                break;
                            }
                            case 4: {
                                result.DongHoc(sc);
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.VietFile1();
                                break;
                            }
                            case 5: {
                                result.KiemtraGpa();
                                break;
                            }
                            case 6: {
                                result.KhaiBaoYTe();
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.VietFile1();
                                break;
                            }
                            case 7: {
                                result.XemThongTin();
                                break;
                            }
                            case 8: {
                                checkstudent = false;
                                break;
                            }
                            default: {
                                System.out.println("Không hợp lệ,nhập lại");
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("Thoát !");
                    flat = false;
                    break;
                }
                default: {
                    System.out.println("Không hợp lệ,nhập lại");
                }
            }
        }
    }

    // thao tác với JDBC
    public static void ThaoTacJdbc() throws Exception {
        Scanner sc = new Scanner(System.in);
        QuanLySinhVien manage = new QuanLySinhVien();
        JDBC_thaotac newjdbc = new JDBC_thaotac();
        List<SinhVien> resultjdbc = new ArrayList<>();
        newjdbc.LayDl(resultjdbc);
        resultjdbc.forEach(System.out::println);
        manage.LayTatCaSinhVien1(resultjdbc);
        boolean flat = true;
        while (flat) {
            TieuDeLogin();
            String x1=sc.nextLine();
            int x = Integer.parseInt(x1);
            switch (x) {
                // cho quan ly
                case 1: {
                    DangNhapAdmin(sc);

                    boolean choosequanly = true;
                    while (choosequanly) {
                        MenuThaoTacQl();
                        String choose1=sc.nextLine();
                        int yourchoose = Integer.parseInt(choose1);
                        // sc.nextLine();
                        switch (yourchoose) {
                            case 1: {
                                System.out.println("Nhập id: ");
                                String newId = sc.nextLine();
                                manage.TimKiemBangId(newId);
                                break;
                            }
                            case 2: {
                                System.out.println("Nhập id: ");
                                String newId = sc.nextLine();
                                manage.XoaBangId(newId);
                                manage.UpdateJbdc();
                                break;
                            }
                            case 5: {
                                manage.ThemSV();
                                manage.UpdateJbdc();
                                break;
                            }
                            case 6: {
                                manage.ThemDanhSachSV();
                                manage.UpdateJbdc();
                                break;
                            }
                            case 3: {
                                System.out.println("Nhập số cmt: ");
                                String cmt = sc.nextLine();
                                manage.TimKiemBangSoCMT(cmt);
                                break;
                            }
                            case 4: {
                                System.out.println("Nhập số cmt: ");
                                String cmt = sc.nextLine();
                                manage.XoaBangSoCMT(cmt);
                                manage.UpdateJbdc();
                                break;
                            }
                            case 7: {
                                System.out.println("Nhập tình trạng bệnh(F0|F1|F2|F3|F4|NONE)");
                                String statusf = sc.nextLine();
                                manage.SearchTinhTrangSucKheo(statusf);
                                break;
                            }
                            case 8: {
                                System.out.println("Điều kiện:không là F1,F2 và tiêm 2 mũi trở lên");
                                manage.DuDieuKien();
                                break;
                            }
                            case 9: {
                                manage.ThieuHocPhi();
                                break;
                            }
                            case 10: {
                                manage.DuHocPhi();
                                break;
                            }
                            case 11: {
                                manage.DatHocBong();
                                break;
                            }
                            case 12: {
                                manage.HocLai();
                                break;
                            }
                            case 13: {
                                manage.SapXepGPA();
                                manage.UpdateJbdc();
                                break;
                            }
                            case 14: {
                                manage.SapXepTheoTen();
                                manage.UpdateJbdc();
                                break;
                            }
                            case 15: {
                                manage.SapXepTheoId();
                                manage.UpdateJbdc();
                                break;
                            }
                            case 16: {
                                manage.ThongTinhAll();
                                break;
                            }
                            case 17: {
                                System.out.println("Bạn đang thao tác với Sql,failed!");
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 18: {
                                manage.VietFile1();
                                System.out.println("Chèn dữ liệu thành công");
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 19: {
                                choosequanly = false;
                                break;
                            }
                            default: {
                                System.out.println("Nhập sai,nhập lại");
                                break;
                            }
                        }
                    }
                    break;
                }
                // cho sinh vien

                case 2: {
                    // manage.ThongTinhAll();
                    SinhVien result = new SinhVien();
                    List<SinhVien> account = new ArrayList<>();
                    manage.LayTatCaSinhVien(account);
                    DangNhapSv(sc, account, result);
                    boolean checkstudent = true;
                    while (checkstudent) {

                        MenuThaoTacSv();
                        String choose1=sc.nextLine();
                        int choice = Integer.parseInt(choose1);
                        switch (choice) {
                            case 1: {
                                result.ThayDoiThongTinCuThe(sc);
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.UpdateJbdc();
                                break;
                            }
                            case 2: {
                                result.CheckLichHoc();
                                break;
                            }
                            case 3: {
                                result.CheckLichThi();
                                break;
                            }
                            case 4: {
                                result.DongHoc(sc);
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.UpdateJbdc();
                                break;
                            }
                            case 5: {
                                result.KiemtraGpa();
                                break;
                            }
                            case 6: {
                                result.KhaiBaoYTe();
                                manage.XoaBangId1(result.getId());
                                manage.ThemSV1(result);
                                manage.UpdateJbdc();
                                break;
                            }
                            case 7: {
                                result.XemThongTin();
                                break;
                            }
                            case 8: {
                                checkstudent = false;
                                break;
                            }
                            default: {
                                System.out.println("Không hợp lệ,nhập lại");
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("Thoát !");
                    flat = false;
                    break;
                }
                default: {
                    System.out.println("Không hợp lệ,nhập lại");
                }
            }
        }

    }

    // đăng nhập với admin
    public static void DangNhapAdmin(Scanner sc) {
        while (true) {
            System.out.println("----------Nhập tài khoản----------");
            String ID = "admin";
            String PASSWORD = "admin";
            System.out.println("Nhập id: ");
            String newid = sc.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String newpass = sc.nextLine();
            newid = newid.trim();
            newpass = newpass.trim();
            if (ID.equals(newid) && PASSWORD.equals(newpass)) {
                System.out.println("Hợp lệ");
                break;
            }
            System.out.println("Không hợp lê,nhập lại!");
        }
    }

    // đăng nhập với sinh viên
    public static void DangNhapSv(Scanner sc, List<SinhVien> account, SinhVien result) {
        while (true) {
            sc.nextLine();
            System.out.println("----------Nhập tài khoản----------");
            System.out.println("Nhập id: ");
            String newid = sc.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String newpass = sc.nextLine();
            String newid1 = newid.trim();
            String newpass1 = newpass.trim();
            SinhVien result1 = account.stream().filter(o -> o.getId().equals(newid1) && o.getMatkhau().equals(newpass1)).findFirst().orElse(null);
            if (result1 != null) {
                result.SetTatCaThongTingNguoi(result1);
                System.out.println("Hợp lệ");
                break;
            }
            System.out.println("Không hợp lê,nhập lại!");
        }
    }

    // MenuThaoTac lựa chọn quyền truy cập
    public static void TieuDeLogin() {
        System.out.println("----------Truy cập tài khoản----------");
        System.out.println("----------1.Quan lý----------");
        System.out.println("----------2.Sinh viên----------");
        System.out.println("----------3.Thoát chương trình----------");
        System.out.println("Nhập lựa chọn của bạn: ");
    }

    // Menu thao tác cho sinh viên
    public static void MenuThaoTacSv() {
        System.out.println("1.Thay đổi thông tin");
        System.out.println("2.Kiểm tra lịch học");
        System.out.println("3.Kiểm tra lịch thi");
        System.out.println("4.Đóng học");
        System.out.println("5.Kiểm tra GPA");
        System.out.println("6.Khai báo y tế");
        System.out.println("7.Xem thông tin");
        System.out.println("8.Trở lại menu chính");
        System.out.println("Nhập lựa chọn của bạn: ");
    }

    // Menu thao tác cho quản lý
    public static void MenuThaoTacQl() {
        System.out.println("1.Tìm kiếm thông tin sinh viên theo id");
        System.out.println("2.Xóa sinh viên theo id");
        System.out.println("3.Tìm kiếm thông tin sinh viên theo số cmt");
        System.out.println("4.Xóa sinh viên theo số cmt");
        System.out.println("5.Thêm một sinh viên ");
        System.out.println("6.Thêm nhiều sinh viên");
        System.out.println("7.Xem thông tin sinh viên nhiễm covid");
        System.out.println("8.Kiểm tra thông tin sinh viên đủ điều kiện đến trường");
        System.out.println("9.Kiểm tra thông tin sinh viên chưa đóng học phí");
        System.out.println("10.Kiểm tra thông tin sinh viên đóng đầy đủ học phí");
        System.out.println("11.Kiểm tra thông tin sinh viên đạt học bổng");
        System.out.println("12.Kiểm tra thông tin sinh viên thi lại");
        System.out.println("13.Sắp xếp sinh viên theo điểm GPA");
        System.out.println("14.Sắp xếp sinh viên theo tên");
        System.out.println("15.Sắp xếp sinh viên theo id ");
        System.out.println("16.Xem tất cả thông tin");
        System.out.println("17.Chuyển dữ liệu từ File sang Sql ");
        System.out.println("18.Chuyển dữ liệu từ Sql sang File");
        System.out.println("19.Trở lại menu chính");
        System.out.println("Nhập lựa chọn của bạn");
    }

    // Menu lựa chọn thao tác với file hoặc jdbc
    public static void MenuThaoTac() {
        System.out.println("Nhập lựa chọn: ");
        System.out.println("1.Thao tác với File");
        System.out.println("2.Thao tác với SQL");
        System.out.println("3.Thoát chương trình");
        System.out.println("Nhập lựa chọn của bạn");
    }

}
