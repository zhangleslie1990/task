import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class demo6 {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(sdf.format(date));
        Date time = sdf.parse("2018-04-01 13:00:00");
        long time1 = date.getTime();
        long time2 = time.getTime();
        System.out.println((time1 - time2) / 24 / 60 / 60 / 1000);


    }
}
