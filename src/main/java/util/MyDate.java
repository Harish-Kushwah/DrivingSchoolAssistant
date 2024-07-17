package util;

import java.text.SimpleDateFormat;

/**
 *
 * @author haris
 */
public class MyDate {

    public static java.sql.Date getSQLDate(String strDate) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf1.parse(strDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

     public static String getTodayDate() {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        return ft.format(new java.util.Date());
    }
    public static String getFormatedDate(java.util.Date date)
    {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        return ft.format(date);
    }
   
}
