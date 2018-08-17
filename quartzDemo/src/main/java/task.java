import java.util.Calendar;

public class task {

    public static void main(String args[]) {
        final MyTime mt = new MyTime(11, 25);
        //这里，假设程序运行时，是在早上8点半之前的。其他情况，你自行分析
        Calendar cal = Calendar.getInstance();
        //此方法获得当前地域的时间，注意，getInstance是静态方法
//            cal.set(cal.HOUR, mt.hour);//设置你所要等待的时刻
//            cal.set(cal.MINUTE, mt.minute);
        cal.set(2018, 2, 26, 11, 31, 10);
        Calendar cal2 = Calendar.getInstance();//
        long time1 = cal.get(cal.HOUR_OF_DAY) * 3600 + cal.get(cal.MINUTE) * 60;//将两个时刻都转换成秒数，以便进行相减
        long time2 = cal2.get(cal2.HOUR_OF_DAY) * 3600 + cal2.get(cal2.MINUTE) * 60 + cal2.get(cal2.SECOND);
        final long waitTime = time1 - time2;//此时获得当前时刻与要等待时刻的时间差，单位是秒
        //这里说明一下，现在所指的当前时刻是“Calendar cal2=Calendar.getInstance()”这句执行时所获得的时刻
        //获得后，它的各值（秒，分，时）等信息都不会改变。当然，运行几行代码，花不了几毫秒。所以
        //虽然之前的cal2的时间信息与运行三行代码以后的时间信息是差不多的
        System.out.println(waitTime);//此行用于测试
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (long l = 0; l < waitTime; l++) {
                        Thread.sleep(1000);
                        System.out.println("###");//一秒打一个，当然，告诉你正在计时
                        //这里用多线程，因为运行后，可以继续运行主线程。不影响你干其他事儿。
                    }
                } catch (InterruptedException e) {
                }
                System.out.println(mt.hour + ":" + mt.minute + "到了");
            }
        }).start();
        //不过，你说一天要三次计算。这很容易，如何实现，由你自己决定。
    }
}

