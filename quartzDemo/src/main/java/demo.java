import com.alibaba.fastjson.JSONObject;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class demo {
    public static void main(String[] args) throws Exception {
      /*  Date date=new Date();
        System.out.println(date);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
       *//* SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        Date date1=sdf1.parse("2018-03-14 00:00:00");
        System.out.println(sdf.format(date1));*//*
        System.out.println(sdf2.format(date));*/
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND,0);
//        calendar.add(Calendar.DATE,+1);
//        System.out.println(sdf.format(calendar.getTime()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
    }
}
