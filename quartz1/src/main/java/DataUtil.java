
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return s.format(new Date());
    }
}
