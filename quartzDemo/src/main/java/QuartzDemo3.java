import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzDemo3 {

    //SchedulerFactoryBean
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTime = null;
        if (date != null) {
            formatTime = sdf.format(date);
        }
        return formatTime;
    }

    public static String getCorn(Date date) {
        String farmat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, farmat);
    }

    public static void main(String[] args) {
        System.out.println(getCorn(new Date()));
    }
}
