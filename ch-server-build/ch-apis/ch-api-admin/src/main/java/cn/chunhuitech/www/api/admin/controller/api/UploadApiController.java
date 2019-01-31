package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.AdminUserLoginParaBo;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.core.common.annotation.Skip;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by hechengjin on 18-2-22.
 */
@Controller
@RequestMapping(value = "/api/upload")
public class UploadApiController {
    @Skip
    @RequestMapping(value = "/upForm", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public void uploadPatch2(@RequestParam(value = "username") String userName,
                                           @RequestParam(value = "password") String passWord,
                                           @RequestParam("aaaa") MultipartFile upFile,
                                           HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(userName);
        System.out.println(passWord);
        String name = upFile.getName(); // aaaa
        String fullName = upFile.getOriginalFilename();
        String path = "dd";
    }

    @Skip
    @RequestMapping(value = "/upForm2", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public void login(@RequestBody AdminUserLoginParaBo adminUserLoginParaBo) throws Exception{
        System.out.println(adminUserLoginParaBo.getUsername());
        System.out.println(adminUserLoginParaBo.getPassword());
        String path = "dd";
    }


    @Skip
    @RequestMapping(value = "/upFile", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_MULTIPART_FORM_DATA)
    public void uploadPatch(HttpServletRequest request, HttpServletResponse response, @RequestParam("aaaa") MultipartFile upFile) throws Exception{

        String path = request.getRealPath("/upload") + "/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String name = upFile.getName(); // aaaa
        String fullName = upFile.getOriginalFilename();
        try {
            String destPath = path + fullName;
            File file = new File(destPath);
            OutputStream out = new FileOutputStream(file);
            InputStream in = upFile.getInputStream();
            int length = 0;
            byte[] buf = new byte[1024];
            // in.read(buf) 每次读到的数据存放在buf 数组中
            while ((length = in.read(buf)) != -1) {
                //在buf数组中取出数据写到（输出流）磁盘上
                out.write(buf, 0, length);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("success", true);
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
    }

    @Skip
    @RequestMapping(value = "/uploadimg2", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_MULTIPART_FORM_DATA)
    public void uploadFile2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //////////////////////
        String path = request.getSession().getServletContext().getRealPath("lupload");

        /////////////

        System.out.println("request.getContentType(): " + request.getContentType());

        if (!request.getContentType().split(";")[0].equals("multipart/form-data"))
            return;
        Collection<Part> parts = request.getParts();
        System.out.println(parts);
        for(Part part:parts){
            System.out.println(part);
            FileProcess(part);
        }

        response.getWriter().print("end");
    }

    private void FileProcess(Part part) throws IOException {
        System.out.println("part.getName(): " + part.getName());

        if(part.getName().equals("aaaa")){
            String cd = part.getHeader("Content-Disposition");
            String[] cds = cd.split(";");
            String filename = cds[2].substring(cds[2].indexOf("=")+1).substring(cds[2].lastIndexOf("//")+1).replace("\"", "");
            String ext = filename.substring(filename.lastIndexOf(".")+1);

            System.out.println("filename:" + filename);
            System.out.println("ext:" + ext);

            InputStream is = part.getInputStream();

            if(Arrays.binarySearch(ImageIO.getReaderFormatNames(),ext) >= 0) {
                imageProcess(filename, ext, is);
            }
            else{
                commonFileProcess(filename, is);
            }
        }
    }

    private void commonFileProcess(String filename, InputStream is) {
        FileOutputStream fos = null;
        try{
            String pathFile = getClass().getResource("/").getPath()+filename;
            fos=new FileOutputStream(new File(pathFile));
            int b = 0;
            while((b = is.read())!=-1){
                fos.write(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void imageProcess(String filename, String ext, InputStream is) throws IOException {
        Iterator<ImageReader> irs = ImageIO.getImageReadersByFormatName(ext);
        ImageReader ir = irs.hasNext()?irs.next():null;
        if(ir == null)
            return;
        ir.setInput(ImageIO.createImageInputStream(is));//必须转换为ImageInputStream，否则异常

        ImageReadParam rp = ir.getDefaultReadParam();
        Rectangle rect = new Rectangle(0,0,200,200);
        rp.setSourceRegion(rect);

        int imageNum = ir.getNumImages(true);//allowSearch必须为true，否则有些图片格式imageNum为-1。

        System.out.println("imageNum:" + imageNum);

        for(int imageIndex = 0;imageIndex < imageNum;imageIndex++){
            BufferedImage bi = ir.read(imageIndex,rp);
            ImageIO.write(bi, ext, new File(getClass().getResource("/").getPath()+filename));
        }
    }

    @Skip
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_MULTIPART_FORM_DATA)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取文件需要上传到的路径
        String path = request.getRealPath("/upload") + "/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

        request.setCharacterEncoding("utf-8");  //设置编码
        //获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //如果没以下两行设置的话,上传大的文件会占用很多内存，
        //设置暂时存放的存储室,这个存储室可以和最终存储文件的目录不同
        /**
         * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上，
         * 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
         * 然后再将其真正写到对应目录的硬盘上
         */
        factory.setRepository(dir);
        //设置缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
        factory.setSizeThreshold(1024 * 1024);
        //高水平的API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request); //这步没成功
            FileItem picture = null;
            for (FileItem item : list) {
                //获取表单的属性名字
                String name = item.getFieldName();
                //如果获取的表单信息是普通的 文本 信息
                if (item.isFormField()) {
                    //获取用户具体输入的字符串
                    String value = item.getString();
                    request.setAttribute(name, value);
                } else {
                    picture = item;
                }
            }
            String fiName = request.getAttribute("upFile") + ".jpg";
            //自定义上传图片的名字为userId.jpg
            String fileName = request.getAttribute("userId") + ".jpg";
            String destPath = path + fileName;

            //真正写到磁盘上
            File file = new File(destPath);
            OutputStream out = new FileOutputStream(file);
            InputStream in = picture.getInputStream();
            int length = 0;
            byte[] buf = new byte[1024];
            // in.read(buf) 每次读到的数据存放在buf 数组中
            while ((length = in.read(buf)) != -1) {
                //在buf数组中取出数据写到（输出流）磁盘上
                out.write(buf, 0, length);
            }
            in.close();
            out.close();
        } catch (FileUploadException e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("success", true);
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
    }

}
