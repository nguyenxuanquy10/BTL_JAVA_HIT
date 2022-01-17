package BTL_JAVA;

import java.sql.*;
import java.util.List;

public class JDBC_thaotac {
    // kết nối với JDBC
    Connection connection = getJDBC();
    public Connection getJDBC() {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=SINHVIEN;user=sa;password=11062002";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection demo = DriverManager.getConnection(url);
            return demo;
        } catch (Exception x) {
            x.printStackTrace();
        }
        return null;
    }

    // lấy dữ liệu từ sql
    public void LayDl(List<SinhVien> result) throws SQLException {
        Statement statement = connection.createStatement();
        String sql_LayDl = "select THONGTINSV.ID, THONGTINSV.SOCMT, MATKHAU,HOTEN,GIOITINH,DIACHI,TUOI," +
                "                SDT,GPA,TAICHINH,LICHHOC,LICHTHI,SUCKHEO,SOMUITIEM,F" +
                "                from THONGTINSV inner join THONGTINCHUNG ON " +
                "                THONGTINCHUNG.SOCMT=THONGTINSV.SOCMT" +
                "                inner join THONGTINCOVID on  THONGTINCOVID.ID=THONGTINSV.ID";
        ResultSet resultSet = statement.executeQuery(sql_LayDl);
        boolean flat = true;

        while (resultSet.next()) {
            result.add(new SinhVien(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    Double.parseDouble(resultSet.getString(9)),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15)));
        }
    }

    //chèn dữ liệu vào sql
    public void ChenDl(List<SinhVien> result) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("insert into THONGTINCHUNG values ( ?,?,?,?,?,?)");
        PreparedStatement preparedStatement2 = connection.prepareStatement("insert into THONGTINSV values ( ?,?,?,?,?,?,?)");
        PreparedStatement preparedStatement3 = connection.prepareStatement("insert into THONGTINCOVID values ( ?,?,?,?)");

        for (SinhVien i : result) {
            System.out.println(i.toStringFile());
            preparedStatement1.setString(1, i.getSoCMT());
            preparedStatement1.setString(2, i.getHoTen());
            preparedStatement1.setString(3, i.getTuoi());
            preparedStatement1.setString(4, i.getGioiTinh());
            preparedStatement1.setString(5, i.getSDT());
            preparedStatement1.setString(6, i.getDiaChi());
            preparedStatement2.setString(1, i.getId());
            preparedStatement2.setString(2, i.getSoCMT());
            preparedStatement2.setString(3, i.getMatkhau());
            preparedStatement2.setString(4, i.getTinhTrangTaiChinh());
            preparedStatement2.setString(5, i.getLichHoc());
            preparedStatement2.setString(6, i.getLichThi());
            preparedStatement2.setDouble(7, i.getGPA());
            preparedStatement3.setString(1, i.getId());
            preparedStatement3.setString(2, i.getTinhTrangSucKheo());
            preparedStatement3.setString(3, i.getSoMuiVaccin());
            preparedStatement3.setString(4, i.getF());
            int k1 = preparedStatement1.executeUpdate();
            int k2 = preparedStatement2.executeUpdate();
            int k3 = preparedStatement3.executeUpdate();

        }
    }

    // xoá dữ liệu  trong sql
    public void XoaDl() throws SQLException {
        Statement statement = connection.createStatement();
        String delete_sql1 = "delete from THONGTINSV ";
        String delete_sql2 = "delete from THONGTINCOVID ";
        String delete_sql3 = "delete from THONGTINCHUNG";
        statement.executeUpdate(delete_sql1);
        statement.executeUpdate(delete_sql2);
        statement.executeUpdate(delete_sql3);
    }

    // update dư liệu vào sql
    public void UpdateDl(List<SinhVien> result) throws SQLException {
        XoaDl();
        ChenDl(result);
    }
}
