package cn.chunhuitech.www.api.admin.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by hechengjin on 17-10-26.
 */
public class AppTest {

    protected static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    @Test
    public void testMd5()  {
        String md5Value = DigestUtils.md5Hex("abCD1234#()");
        System.out.println(md5Value);
    }

    @Test
    public void testDateTest(){
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.SIMPLIFIED_CHINESE); //Locale.US
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        String dateStr = sdf.format(cd.getTime());
        System.out.println(dateStr);
    }
}
