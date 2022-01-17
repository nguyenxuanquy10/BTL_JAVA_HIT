package BTL_JAVA;

public class Nguoi {
    protected String HoTen;
    protected String Tuoi;
    protected String DiaChi;
    protected String GioiTinh;
    protected String SDT;
    protected String SoCMT;     

    public Nguoi() {
    }

    public Nguoi(String HoTen, String Tuoi, String DiaChi, String GioiTinh, String SDT,
            String SoCMT) {
        this.HoTen = HoTen;
        this.Tuoi = Tuoi;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.SoCMT = SoCMT;
    }

    public Nguoi(Nguoi a) {
        this.HoTen = a.HoTen;
        this.Tuoi = a.Tuoi;
        this.DiaChi = a.DiaChi;
        this.GioiTinh = a.GioiTinh;
        this.SDT = a.SDT;
        this.SoCMT = a.SoCMT;
    }

    public String getHoTen() {
        return this.HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getTuoi() {
        return this.Tuoi;
    }

    public void setTuoi(String Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getDiaChi() {
        return this.DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return this.GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return this.SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSoCMT() {
        return this.SoCMT;
    }

    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

    @Override
    public String toString() {
        return "{" +
                " HoTen='" + getHoTen() + "'" +
                ", Tuoi='" + getTuoi() + "'" +
                ", DiaChi='" + getDiaChi() + "'" +
                ", GioiTinh='" + getGioiTinh() + "'" +
                ", SDT='" + getSDT() + "'" +
                ", SoCMT='" + getSoCMT() + "',";
    }

    public void XemThongTin() {
        System.out.printf("HoTen:%-15s Tuoi:%-6s DiaChi:%-8s GioiTinh:%-6s SDT:%-15s SOCMT:%-8s\n", HoTen, Tuoi, DiaChi, GioiTinh, SDT, SoCMT);
    }

// xem thogn tin
    // public void XemThongTin(){
    //     System.out.printf("HoTen:");
    // }
    // modifer sinhvien
    // public void InThongTin(){
    //     System.out.println(
    //         "HoTen:"
    //     ); HoTen  "-" + Tuoi + "-" + GioiTinh + "-" + DiaChi + "-" + SDT + "-" + SoCMT;
    // }
    public void SetTatCaThongTingNguoi(Nguoi a) {
        this.HoTen = a.HoTen;
        this.Tuoi = a.Tuoi;
        this.DiaChi = a.DiaChi;
        this.GioiTinh = a.GioiTinh;
        this.SDT = a.SDT;
        this.SoCMT = a.SoCMT;
    }
}