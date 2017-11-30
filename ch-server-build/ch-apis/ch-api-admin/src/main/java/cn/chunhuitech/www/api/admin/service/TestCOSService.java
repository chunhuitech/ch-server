package cn.chunhuitech.www.api.admin.service;

import java.io.InputStream;

/**
 * Created by hcj on 11/20/17.
 */
public interface TestCOSService {

    boolean isFileExists(String key);


    String uploadFile(InputStream file, long size, int index);
    String generateFileUrl(String key);
}
