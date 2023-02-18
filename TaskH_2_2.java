import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class TaskH_2_2 {
    private static int[] fillArray(){
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= random.nextInt(20);
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(TaskH_2_2.class.getName());
        FileHandler fh = new FileHandler("log.log");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        int[] arr = fillArray();
        System.out.println(Arrays.toString(arr));
        logger.info("Массив до сортировки: "+Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            //logger.info("Test message");
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    String strLog = "Меняем " + Integer.toString(arr[j+1]) +" на "+ Integer.toString(arr[j]);
                    logger.info(strLog);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        logger.info("Массив после сортировки: "+Arrays.toString(arr));
    }
}
