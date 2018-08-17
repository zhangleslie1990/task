import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class demo5 {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws Exception {

        circle("2018-03-23 15:33:30", "111", "2222", "333");

    }

    public static void circle(String time, String orderNo, String responseData, String id) {
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                try {
                    Date date1 = new Date();
                    Date date2 = sdf.parse(time);//"2018-03-23 13:00:00"
                    long time1 = date1.getTime();
                    long time2 = date2.getTime();
                    System.out.println("date1" + sdf.format(date1));
                    System.out.println("date2" + sdf.format(date2));
                    double hour = (time1 - time2) / (double) (1000 * 60 * 60);
                    System.out.println("hour" + hour);
                    if ("SUCCEED".equals(responseData)) {
                        System.out.println("1:----" + hour + "--------" + sdf.format(date1));
                        timer.cancel();
                    } else if (hour > 60000) {//四小时截止
                        System.out.println("调用还款接口");
                        timer.cancel();// 停止定时器
                    }
                    System.out.println("111111111111111");
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        };
        timer.schedule(task, 2000, 2000);
    }

}
