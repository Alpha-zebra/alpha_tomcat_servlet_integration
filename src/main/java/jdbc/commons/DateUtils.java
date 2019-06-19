package jdbc.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {
    private DateUtils() {
    }

    public static Date strConvertDate(String dateStr, String format) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    public static String dateConvertStr(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
