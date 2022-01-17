package BTL_JAVA;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;

import java.util.Scanner;

import static BTL_JAVA.QuanLySinhVien.sc;

public class SinhVien extends Nguoi implements Regex_taikhoan {
    private String Id;
    private String Matkhau;
    private String TinhTrangTaiChinh;
    private String LichHoc;
    private String LichThi;
    private double GPA;
    private String TinhTrangSucKheo;
    private String SoMuiVaccin;
    private String F;

    // constructor khong doi
    public SinhVien() {

    }

    // constructor nhieu doi
    public SinhVien(String Id, String SoCMT, String Matkhau, String HoTen, String GioiTinh, String DiaChi,
                    String Tuoi, String SDT, double GPA,
                    String TinhTrangTaiChinh, String LichHoc, String LichThi, String TinhTrangSucKheo, String SoMuiVaccin, String F) {
        this.Id = Id;
        this.SoCMT = SoCMT;
        this.Matkhau = Matkhau;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Tuoi = Tuoi;
        this.SDT = SDT;
        this.GPA = GPA;
        this.TinhTrangSucKheo = TinhTrangSucKheo;
        this.TinhTrangTaiChinh = TinhTrangTaiChinh;
        this.LichThi = LichThi;
        this.LichHoc = LichHoc;
        this.SoMuiVaccin = SoMuiVaccin;
        this.F = F;

    }

    // constructor swap thong tin 2 doi tuong
    public SinhVien(SinhVien a) {
        super(a);
        this.Id = a.Id;
        this.Matkhau = Matkhau;
        this.TinhTrangTaiChinh = a.TinhTrangTaiChinh;
        this.LichHoc = a.LichHoc;
        this.LichThi = a.LichThi;
        this.GPA = a.GPA;
        this.TinhTrangSucKheo = a.TinhTrangSucKheo;
        this.SoMuiVaccin = a.SoMuiVaccin;
        this.F = a.F;
    }

    // setter, getter

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMatkhau() {
        return this.Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getTinhTrangTaiChinh() {
        return this.TinhTrangTaiChinh;
    }

    public void setTinhTrangTaiChinh(String TinhTrangTaiChinh) {
        this.TinhTrangTaiChinh = TinhTrangTaiChinh;
    }

    public String getLichHoc() {
        return this.LichHoc;
    }

    public void setLichHoc(String LichHoc) {
        this.LichHoc = LichHoc;
    }

    public String getLichThi() {
        return this.LichThi;
    }

    public void setLichThi(String LichThi) {
        this.LichThi = LichThi;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getTinhTrangSucKheo() {
        return this.TinhTrangSucKheo;
    }

    public void setTinhTrangSucKheo(String TinhTrangSucKheo) {
        this.TinhTrangSucKheo = TinhTrangSucKheo;
    }

    public String getSoMuiVaccin() {
        return this.SoMuiVaccin;
    }

    public void setSoMuiVaccin(String SoMuiVaccin) {
        this.SoMuiVaccin = SoMuiVaccin;
    }

    public String getF() {
        return this.F;
    }

    public void setF(String F) {
        this.F = F;
    }

    // to string
    @Override
    public String toString() {
        return "SinhVien{" +
                "HoTen='" + HoTen + '\'' +
                ", Tuoi='" + Tuoi + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", SDT='" + SDT + '\'' +
                ", SoCMT='" + SoCMT + '\'' +
                ", Id='" + Id + '\'' +
                ", Matkhau='" + Matkhau + '\'' +
                ", TinhTrangTaiChinh='" + TinhTrangTaiChinh + '\'' +
                ", LichHoc='" + LichHoc + '\'' +
                ", LichThi='" + LichThi + '\'' +
                ", GPA=" + GPA +
                ", TinhTrangSucKheo='" + TinhTrangSucKheo + '\'' +
                ", SoMuiVaccin='" + SoMuiVaccin + '\'' +
                ", F='" + F + '\'' +
                '}';
    }

    // chuan hoa du lieu truyen vao file
    public String toStringFile() {
        return Id + "//" + SoCMT + "//" + Matkhau + "//" + HoTen + "//" + GioiTinh + "//" + DiaChi + "//" + Tuoi + "//" + SDT + "//" + GPA + "//" + TinhTrangTaiChinh + "//" +
                LichHoc + "//" + LichThi + "//" + TinhTrangSucKheo + "//" + SoMuiVaccin + "//" + F;
    }

    // Khai báo y tế
    public void KhaiBaoYTe() {
        System.out.println("---------Khai báo y tế---------");
        System.out.println("Nhập tình trạng sức khẻo (XAU|TOT|KHEO) ?");
        setTinhTrangSucKheo(sc.nextLine());
        System.out.println("Bạn đã tiêm mấy mũi vaccin ? ");
        setSoMuiVaccin(sc.nextLine());
        System.out.println("Bạn là F mấy(F1,F2,F3,...) ?");
        setF(sc.nextLine());
    }

    // thay doi thong tin cu the cua sinh vien
    public void ThayDoiThongTinCuThe(Scanner sc) {
        int x1 = 1;

        while (x1 != 0) {
            MenuThaoTacThayDoiThongTinCuThe();
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1: {
                    String newsk;
                    do {
                        System.out.println("Nhập tình trạng sức khẻo (XAU|TOT|NHIEMCOVID)");
                        newsk = sc.nextLine();
                    } while (!regex_tinhtrangsuckhoe(newsk));
                    System.out.println("Hợp lệ");
                    setTinhTrangSucKheo(newsk);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    String newsomui;
                    do {
                        System.out.println("Nhập số mũi vaccin đã tiêm(VD: 2) ");
                        newsomui = sc.nextLine();
                    } while (!regex_somuivaccin(newsomui));
                    System.out.println("Hợp lệ");
                    setSoMuiVaccin(newsomui);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    String newf;
                    do {
                        System.out.println("Bạn là F mấy ( VD: F0|F1|F2|F3|F4|NONE) ");
                        newf = sc.nextLine();
                    } while (!regex_F(newf));
                    System.out.println("Hợp lệ");
                    setF(newf);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }  break;
                }
                case 4: {
                    String hoten;
                    do {
                        System.out.println("Nhập họ tên ( VD: NGUYEN VAN A ) ");
                        hoten = sc.nextLine();
                    } while (!regex_hoten(hoten));
                    System.out.println("Hợp lệ");
                    setHoTen(hoten);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }  break;
                }
                case 5: {
                    String newtuoi;
                    do {
                        System.out.println("Nhập tuổi( VD: 18 )");
                        newtuoi = sc.nextLine();
                    } while (!regex_tuoi(newtuoi));
                    System.out.println("Hợp lê");
                    setTuoi(newtuoi);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    } break;
                }
                case 6: {
                    String newdiachi;
                    do {
                        System.out.println("Nhập địa chỉ (VD: HA NOI)");
                        newdiachi = sc.nextLine();
                    } while (!regex_diachi(newdiachi));
                    System.out.println("Hợp lệ");
                    setDiaChi(newdiachi);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }    break;
                }
                case 7: {
                    String newgioitinh;
                    do {
                        System.out.println("Nhập giới tính( NAM|NU|THUBA )");
                        newgioitinh = sc.nextLine();
                    } while (!regex_gioitinh(newgioitinh));
                    System.out.println("Hợp lệ");
                    setGioiTinh(newgioitinh);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }   break;
                }
                case 8: {
                    String newsdt;
                    do {
                        System.out.println("Nhập SDT ( so 0 DUNG DAU,10 CHU SO )");
                        newsdt = sc.nextLine();
                    } while (!regex_sdt(newsdt));
                    System.out.println("Hợp lệ");
                    setSDT(newsdt);
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }    break;
                }
                case 9: {
                    System.out.println("Không được thay đổi số cmt");
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 10: {
                    System.out.println("Không thể thay đổi");
                    try {
                        System.in.read();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 11: {
                    x1 = 0;
                    break;
                }
                default: {
                    System.out.println("Không hợp lê, nhập lại !");
                }
            }
        }

    }

    // MenuThaoTac thay doi thong tin ca nhan
    public void MenuThaoTacThayDoiThongTinCuThe() {
        System.out.println("1.Thau đổi tình trạng sức khẻo: ");
        System.out.println("2.Thay đổi số mũi vaccin đã tiêm: ");
        System.out.println("3.Thay đổi F: ");
        System.out.println("4.Thay đổi họ tên: ");
        System.out.println("5.Thay đổi tuổi: ");
        System.out.println("6.Thay đổi địa chỉ: ");
        System.out.println("7.Thay đổi giới tính: ");
        System.out.println("8.Thay đổi sdt: ");
        System.out.println("9.Thay đổi số cmt: ");
        System.out.println("10.Thay đổi tình trạng tài chính: ");
        System.out.println("11.Thoát chương trình: ");
        System.out.println("Nhập lựa chọn của bạn");
    }

    //swap thong tin 2 sinh vien
    public void SetTatCaThongTingNguoi(SinhVien a) {
        super.SetTatCaThongTingNguoi(a);
        this.Id = a.Id;
        this.Matkhau = a.Matkhau;
        this.TinhTrangTaiChinh = a.TinhTrangTaiChinh;
        this.LichHoc = a.LichHoc;
        this.LichThi = a.LichThi;
        this.GPA = a.GPA;
        this.TinhTrangSucKheo = a.TinhTrangSucKheo;
        this.SoMuiVaccin = a.SoMuiVaccin;
        this.F = a.F;

    }

    // xem lich hoc
    public void CheckLichHoc() {
        System.out.println("----------Lịch học----------");
        System.out.println(getLichHoc());
        try {
            System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // xem lich thi
    public void CheckLichThi() {
        System.out.println("----------Lich thi----------");
        System.out.println(getLichThi());
        try {
            System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // dong hoc phi
    public void DongHoc(Scanner sc) {
        String s = getTinhTrangTaiChinh();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
                result += Character.toString(s.charAt(i));
            }
        }
        if (result.isEmpty()) {
            System.out.println("Đóng đủ học phí");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        result = result.trim();
        double DebtFee = Double.parseDouble(result);

        if (DebtFee == 0) {
            System.out.println("Đóng đủ học phí");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("Thieu:" + DebtFee);
        System.out.println("Nhập số tiền muốn đóng: ");
        sc.nextLine();
        String tien = sc.nextLine();
        double x = 0;
        try {
            x = Double.parseDouble(tien);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DebtFee = DebtFee - x;
        if (DebtFee > 0) {
            System.out.println("Số tiền còn thiếu: " + Math.abs(DebtFee));
            setTinhTrangTaiChinh("Thieu: " + DebtFee);
        } else if (DebtFee < 0) {
            System.out.println("Số tiền còn thừa: " + Math.abs(DebtFee));
            setTinhTrangTaiChinh("Thua: " + -DebtFee);
        } else {
            setTinhTrangTaiChinh("Đóng đủ học phí");

        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // xem thong tin sinh vien
    public void XemThongTin() {
        System.out.println("----------Thông tin của sinh viên là----------");
        System.out.println(toString());
        try {
            System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //kiem tra diem GPA
    public void KiemtraGpa() {
        System.out.println("Điểm GPA của bạn là: " + GPA);
        try {
            System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // phan regex
    // regex_account
    @Override
    public boolean regex_cmt(String cmt) {
        String regex_cmt = "^[0-9]{12}$";
        if (cmt.matches(regex_cmt))
            return true;
        return false;
    }

    // regex -id
    @Override
    public boolean regex_id(String id) {
        String regex_id = "^20(21|20|19|18)[0-9]{6}";
        if (id.matches(regex_id))
            return true;
        return false;
    }

    // regex- mat khau
    @Override
    public boolean regex_matkhau(String matkhau) {
        // At least 8 chars
        // Contains at least one digit
        // Contains at least one lower alpha char and one upper alpha char
        // Contains at least one char within a set of special chars (@#%$^ etc.)
        // Does not contain space, tab, etc.
        String regex_matkhau = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        if (matkhau.matches(regex_matkhau))
            return true;
        return false;
    }

    // regex sdt
    @Override
    public boolean regex_sdt(String sdt) {
        String regex_std = "^0[0-9]{9}$";
        if (sdt.matches(regex_std))
            return true;
        return false;
    }

    // regex F
    @Override
    public boolean regex_F(String f) {
        // TODO Auto-generated method stub
        String regex_f = "^(F0|F1|F2|F3|F4|NONE)$";
        if (f.matches(regex_f)) return true;
        return true;
    }

    // regex_GPA
    @Override
    public boolean regex_GPA(double gpa) {
        String regex_gpa = "^[0-9]+.[0-9]+$";
        String newgpa = String.valueOf(gpa);
        if (newgpa.matches(regex_gpa))
            return true;
        return false;
    }

    //regex dia chi
    @Override
    public boolean regex_diachi(String diachi) {
        String regex_diachi = "^.{4,}$";
        if (diachi.matches(regex_diachi))
            return true;
        return false;
    }

    // regex gioi tinh
    @Override
    public boolean regex_gioitinh(String gioitinh) {
        String regex_gioitinh = "^(NAM|NU|THUBA)$";
        if (gioitinh.matches(regex_gioitinh))
            return true;
        return false;
    }

    // regex ho ten
    @Override
    public boolean regex_hoten(String hoten) {
        String regex_hoten = "^([A-Z ]+)+$";
        if (hoten.matches(regex_hoten))
            return true;
        return false;
    }

    // regex lich hoc
    @Override
    public boolean regex_lichhoc(String lichhoc) {
        // TODO Auto-generated method stub
        return true;
    }

    // regex lich thi
    @Override
    public boolean regex_lichthi(String lichthi) {
        // TODO Auto-generated method stub
        return true;
    }

    //re gex so mui vacxin
    @Override
    public boolean regex_somuivaccin(String s) {
        // TODO Auto-generated method stub\
        try {
            int somui = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    // regex Nhập tình trạng sức khẻo
    @Override
    public boolean regex_tinhtrangsuckhoe(String s) {
        // TODO Auto-generated method stub
        String regex_tinhtrang = "^(TOT|XAU|NHIEMCOVID)$";
        if (s.matches(regex_tinhtrang))
            return true;
        return false;
    }

    // regex tuoi
    @Override
    public boolean regex_tuoi(String tuoi) {
        // TODO Auto-generated method stub
        String regex_tuoi = "^[0-9]{1,2}$";
        if (tuoi.matches(regex_tuoi))
            return true;
        return false;
    }

    // regex tai chinh
    @Override
    public boolean regex_taichinh(String taichinh) {
        String regex_taichinh = "thieu: (0|[0-9]+)";
        if (taichinh.matches(regex_taichinh)) return true;
        return true;
    }
}
