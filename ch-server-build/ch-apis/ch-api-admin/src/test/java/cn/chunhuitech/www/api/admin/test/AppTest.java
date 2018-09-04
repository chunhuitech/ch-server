package cn.chunhuitech.www.api.admin.test;

import cn.chunhuitech.www.api.admin.constant.Constant;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertTrue;

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

        DateTime dt = new DateTime();
        String dts = dt.toString(Constant.DATETIME_FORMAT);
        System.out.println(dts);
    }

    @Test
    public void testSplitTest(){
        String ads = "1,2";
        String[] adArray = ads.split(",");
        System.out.println(adArray.length); // 2

        ads = "1,2,";
        adArray = ads.split(",");
        System.out.println(adArray.length); // 2

        ads = "1";
        adArray = ads.split(",");
        System.out.println(adArray.length); // 1

        ads = "1,";
        adArray = ads.split(",");
        System.out.println(adArray.length); // 1
    }

    @Test
    public void testListFZ(){
        List<Integer> orgList = new ArrayList<>();
        orgList.add(1);
        orgList.add(2);
        orgList.add(3);

        orgList = dealData(orgList);
        assertTrue("不是只有2一个值", orgList.get(0).equals(2));

    }

    private List<Integer> dealData(List<Integer> orgList){
        List<Integer> tarList = new ArrayList<>();
        for (Integer dat : orgList){
            if (dat%2 == 0){
                tarList.add(dat);
            }
        }
        return tarList;
    }

    @Test
    public void testJoin(){
        List<String> cities = Arrays.asList("Milan",
                "London",
                "New York",
                "San Francisco");
        String citiesCommaSeparated = "(" + String.join(",", cities) + ")";
        System.out.println(citiesCommaSeparated);

    }

    @Test
    public void testNumGet() {
        Integer s=20180215;
//        int g = s%10;
//        int sw = s/10%10;
//        int b = s/100%10;
//        int q = s/1000%10;
//        System.out.println("个位数是:"+g+";十位数是:"+sw+";百位数是："+b+";千位数是："+q);
        int day = s%100;
        int month = (s/100)%100;
        int year = (s/10000)%10000;
        System.out.println("天:"+day + "  月:" +month + "  年:" + year);
    }
}
