package cn.chunhuitech.www.api.admin.test;


import cn.chunhuitech.www.api.admin.Application;
import cn.chunhuitech.www.api.admin.service.TestCOSService;
import com.sun.xfile.XFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * author: hcj
 * date: 2017-11-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class COSTest {

    private final static int fileCount = 1;
    private final static int fileContLineCount = 8200;
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TestCOSService testCOSService;

    @Test
    public void testGenFile() {

        OutputStream output = null;
        for (int i= 0; i < fileCount; i++){
            String filePath = "/home/hechengjin" + File.separator + "demo" + File.separator + "test"+ Integer.valueOf(i).toString() + ".txt";
            try{
                //1:使用File类创建一个要操作的文件路径
                File file = new File(filePath);
                if(!file.getParentFile().exists()){ //如果文件的目录不存在
                    file.getParentFile().mkdirs(); //创建目录
                }
                //2: 实例化OutputString 对象
                output = new FileOutputStream(file);
                //3: 准备好实现内容的输出
                String msg = "HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld　HelloWorld\n";
                //将字符串变为字节数组
                int countLine = fileContLineCount;
                byte data[] = msg.getBytes();
                if(i == 0){
                    countLine = fileContLineCount;
                } else if( i == 1){
                    countLine = fileContLineCount*5;
                } else if(i == 2){
                    countLine = fileContLineCount*10;
                } else if(i == 3){
                    countLine = fileContLineCount*20;
                } else if(i == 4){
                    countLine = fileContLineCount*50;
                } else if(i == 5){
                    countLine = fileContLineCount*80;
                } else if(i == 6){
                    countLine = fileContLineCount*100;
                } else if(i == 7){
                    countLine = fileContLineCount*200;
                }


                for(int j = 0; j < countLine; j++){
                    output.write(data);
                }
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 完毕，关闭所有链接
                try {
                    //4: 资源操作的最后必须关闭
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testUploadFile() {

        for (int i= 0; i < fileCount; i++){
            String filePath = "/home/hechengjin" + File.separator + "demo" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
            File f = new File(filePath);
            if (!f.exists()) {
                System.out.print(filePath + "文件不存在");
                continue;
            }
            String fileSize = getPrintSize(f.length());
            System.out.println("--------------文件大小:" + fileSize + "----------------------");
            logger.info("--------------file Size:" +fileSize + "----------------------");

            Ks3UploadFile(i, fileSize);
            copyLocalFile(i, fileSize);
            copyNFSFile(i, fileSize);
        }
    }

    private void Ks3UploadFile(int i, String fileSize){
        try {
            String filePath = "/home/hechengjin" + File.separator + "demo" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
            File f = new File(filePath);

            if (!f.exists()) {
                System.out.print(filePath + "文件不存在");
                return;
            }
            InputStream input = new FileInputStream(f);
            byte[] byt = new byte[input.available()];
            long size = byt.length;
            long startTime=System.currentTimeMillis();
            String key = testCOSService.uploadFile(input, size, i);
            long endTime=System.currentTimeMillis();
            String fileUrl = testCOSService.generateFileUrl(key);
            System.out.println("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "KS3 文件上传耗时："+ (endTime-startTime) +"ms 文件存放路径:"+fileUrl);
            logger.info("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "KS3 File upload time consuming:"+ (endTime-startTime) +"ms File storage path:"+fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyLocalFile(int i, String fileSize) {
        String inputFileName = "/home/hechengjin" + File.separator + "demo" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
        String destFileName = "/home/hechengjin" + File.separator + "demo" + File.separator + "local" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
        //获取进程
        Runtime run = Runtime.getRuntime();
        Process p = null;
        String command = "cp  "+inputFileName+"  "+ destFileName;
        try {
            long startTime=System.currentTimeMillis();
            p = run.exec(command);
            long endTime=System.currentTimeMillis();
            System.out.println("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "复制耗时："+ (endTime-startTime) +"ms");
            logger.info("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "Local Replicating time consuming:"+ (endTime-startTime) +"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyNFSFile(int i, String fileSize) {
        String inputFileName = "/home/hechengjin" + File.separator + "demo" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
        String destFileName = "/mnt/nfs" + File.separator + "test" + Integer.valueOf(i).toString() + ".txt";
        //获取进程
        Runtime run = Runtime.getRuntime();
        Process p = null;
        String command = "cp  "+inputFileName+"  "+ destFileName;
        try {
            long startTime=System.currentTimeMillis();
            p = run.exec(command);
            long endTime=System.currentTimeMillis();
            System.out.println("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "NFS复制耗时："+ (endTime-startTime) +"ms");
            logger.info("*********** " + fileSize + " test" + Integer.valueOf(i).toString() + ".txt "+ "NFS Replicating time consuming:"+ (endTime-startTime) +"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }

}
