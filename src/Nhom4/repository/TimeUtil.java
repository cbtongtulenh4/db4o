package Nhom4.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Date convertStringToDateByFormat(String value, String regex){
        SimpleDateFormat dateFormat = new SimpleDateFormat(regex);
        Date date=null;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
