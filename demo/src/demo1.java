import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Created by zhang on 2017/12/21.
 */
public class demo1 {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//    public static void main(String[] args) throws Exception {
//       timer(sdf.parse("20180301184100"));
//        timer(sdf.parse("20180301184110"));
//        timer(sdf.parse("20180301184115"));
//        timer(sdf.parse("20180301184120"));
//        System.out.println(123);
//    }
//    public static   void timer(  Date startTime ) throws Exception{
//        long daySpan = 24 * 60 * 60 * 1000*15;//15天执行一次
//
//   // 如果今天的已经过了 首次运行时间就改为明天
//        if(System.currentTimeMillis() > startTime.getTime())
//            startTime = new Date(startTime.getTime() + daySpan);
//
//        Timer t = new Timer();
//
//        TimerTask task = new TimerTask(){
//            @Override
//            public void run() {
//                // 要执行的代码
//                System.err.println("xxxxxxxxx");
//            }
//        };
//
//        // 以每24小时执行一次
//        t.scheduleAtFixedRate(task, startTime, daySpan);
//    }


    public static void main(String[] args) throws Exception {
        circle(100);
    }

    public static void circle(int requestData) throws Exception {
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            private int count;

            @Override
            public void run() {
                this.count++;
                System.out.println(count);
//                if (count == 5) {
//                    System.out.println(requestData);
//                    System.out.println("定时器停止了");
                timer.cancel();// 停止定时器
//                }
            }
        };
        timer.schedule(task, 5000, 1000);// 1秒一次
    }
}
