import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterOutputStream;
import java.io.IOException;

public class TaskH_2_3 {
    private static String readFile() {
        // FileReader fr = new FileReader("Input.txt");
        String str = null;
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader("Journal.txt")) {
            BufferedReader bfr = new BufferedReader(fr);
            str = bfr.readLine();

            while (str != null) {
                sb.append(str);
                str = bfr.readLine();
            }
            bfr.close();
            System.out.println("Файл прочитан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        str = sb.toString();
        return str.substring(2, str.length() - 2);
    }

    private static void parseStr(String[] str, String[][] result) {

        for (int i = 0; i < str.length; i++) {
            String[] tmp = null;
            tmp = str[i].split(":");
            int k = i % 3;
            int j = i / 3;
            result[j][k] = tmp[1].replace("}", "");
        }
    }

    public static void main(String[] args) {
        String[] arrTmp = readFile().split(",");

        String[][] res = new String[arrTmp.length / 3][3];
        parseStr(arrTmp, res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append("Студент ");
            sb.append(res[i][0].substring(1, res[i][0].length() - 1));
            sb.append(" получил ");
            sb.append(res[i][1].substring(1, res[i][1].length() - 1));
            sb.append(" по предмету ");
            sb.append(res[i][2].substring(1, res[i][2].length() - 1));
            sb.append("\n");
        }
        // System.out.println(sb.toString());
        System.out.println("Вывод массива строк");

        arrTmp = sb.toString().split("\n");
        for (int i = 0; i < arrTmp.length; i++) {
            System.out.println(arrTmp[i]);
        }
    }
}
