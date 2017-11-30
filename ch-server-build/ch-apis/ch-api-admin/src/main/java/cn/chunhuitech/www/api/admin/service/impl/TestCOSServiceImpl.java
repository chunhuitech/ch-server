package cn.chunhuitech.www.api.admin.service.impl;
import cn.chunhuitech.www.api.admin.service.TestCOSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
@Service
//@EnableConfigurationProperties({StorageProperties.class})
public class TestCOSServiceImpl implements TestCOSService {


    private final static String imgSavePath = "test/file/";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean isFileExists(String key) {
        return false;
    }




    @Override
    public String uploadFile(InputStream file, long size, int index) {
        String key = "";
        try {
//            byte[] byt = new byte[file.available()];
            key = buildKey(index);
            if (!isFileExists(key)) {
//                PutObjectResult putObjectResult = storageService.putObjectPublic(storageProperties.getBjBucketSkin(), key, file, size);
            }
            return key;
        } catch (Exception ex) {
            logger.error("upload image failed, error message: {}", ex.getMessage());
        }
        return key;
    }

    @Override
    public String generateFileUrl(String key) {
        return "";
    }

    // 生成key
    private String buildKey(int index/*byte[] data*/) {
        StringBuffer stringBuffer = new StringBuffer(imgSavePath);
        stringBuffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        stringBuffer.append("/");
        stringBuffer.append("_");
        stringBuffer.append(index);
        return stringBuffer.toString();
    }
}
