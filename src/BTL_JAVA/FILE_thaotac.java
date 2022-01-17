package BTL_JAVA;

//import java.util.F

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FILE_thaotac {

    private static final String NameFile = "data.txt";

    public static void DocFile(List<SinhVien> result) {
        try {
            FileReader fr = new FileReader(NameFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                String[] SubResult = line.split("//");
                // for(String o: SubResult) System.out.println(o);
                result.add(new SinhVien(SubResult[0], SubResult[1], SubResult[2], SubResult[3], SubResult[4],
                        SubResult[5], SubResult[6],
                        SubResult[7], Double.parseDouble(SubResult[8]), SubResult[9], SubResult[10], SubResult[11],
                        SubResult[12], SubResult[13], SubResult[14]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void GhiFile(List<SinhVien> result) throws Exception {
        if (result.isEmpty()) {
            System.out.println("KHONG CO SIINH VIEN TRONG FILE");
            return;
        }
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (SinhVien o : result) {
                // System.out.println(o.toString());
                bw.write(o.toStringFile());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void UpdateFile(List<SinhVien> result) {
        if (result.isEmpty()) {
            System.out.println("KHONG CO SIINH VIEN TRONG FILE");
            return;
        }
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (SinhVien o : result) {
                // System.out.println(o.toString());
                bw.write(o.toStringFile());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
