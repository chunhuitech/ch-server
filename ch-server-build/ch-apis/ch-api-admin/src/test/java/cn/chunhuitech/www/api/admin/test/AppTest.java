package cn.chunhuitech.www.api.admin.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by hechengjin on 17-10-26.
 */
public class AppTest {

    @Test
    public void testMd5()  {

        String md5Value = DigestUtils.md5Hex("abCD1234#()");
        System.out.println(md5Value);
    }
}
