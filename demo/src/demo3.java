import java.util.Timer;
import java.util.TimerTask;

public class demo3 {
    public static void main(String[] args) {
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            private int count;

            @Override
            public void run() {
                this.count++;
                System.out.println(count);
                if (count == 10) {
                    System.out.println("定时器停止了");
                    timer.cancel();// 停止定时器
                }
            }
        };
        timer.schedule(task, 0, 1000);// 1秒一次
    }
}
