import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskH_2_1 {
    private static String readFile() {
        // FileReader fr = new FileReader("Input.txt");
        String str = null;
        try (FileReader fr = new FileReader("Input.txt")) {
            BufferedReader bfr = new BufferedReader(fr);
            str = bfr.readLine();
            bfr.close();
            System.out.println("Файл прочитан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }

    private static String[][] parseStr(String str) {
        str = str.substring(1, str.length() - 1);
        String[] arrStr = str.split(",");
        String[][] arrStrAll = new String[arrStr.length][2];
        for (int i = 0; i < arrStr.length; i++) {
            arrStrAll[i] = arrStr[i].split(":");
            
        }
        return arrStrAll;
    }

    private static String makerQuery(String[][] arrstr) {
        StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE ");
        for (int i = 0; i < arrstr.length; i++) {
            if (!arrstr[i][1].equals("\"null\"")) {
                sb.append(arrstr[i][0].substring(1, arrstr[i][0].length() - 1));
                sb.append("=");
                sb.append(arrstr[i][1]);
                sb.append(" AND ");
            }
        }
        sb.replace(sb.length() - 5, sb.length(), ";");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = readFile();
        String[][] str1 = parseStr(str);
        System.out.println(makerQuery(str1));
    }
}
