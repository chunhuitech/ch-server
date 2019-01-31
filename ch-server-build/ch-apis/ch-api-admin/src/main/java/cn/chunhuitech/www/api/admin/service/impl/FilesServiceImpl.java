package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.service.FilesService;
import cn.chunhuitech.www.api.common.model.WXErrorCode;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.api.common.util.FunctionUtil;
import cn.chunhuitech.www.core.admin.model.cus.FileInfoModel;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("all")
/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class FilesServiceImpl implements FilesService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${file.path.image}")
    private String imageSavePath;

    @Value("${file.path.return}")
    private String imageReturnPath;


    @Override
    public WXResult.Base upLoadImage(MultipartFile image, HttpServletRequest request) {
        if (image!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=image.getOriginalFilename();// 文件原名称
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("/");
//                    String path2 = request.getServletContext().getRealPath("/upload/excel");
                    ServletRequestContext ctx = new ServletRequestContext(request);
                    //获取上传文件尺寸大小
                    long requestSize = ctx.contentLength();

                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis()) + "." + type.toUpperCase(); //+fileName;
                    // 设置存放图片文件的路径
                    path=realPath+System.getProperty("file.separator")+trueFileName;
                    path=imageSavePath+trueFileName;
                    try {
                        // 转存文件到指定的路径
                        image.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error(e.getMessage());
                    }
                    String returnPath = imageReturnPath + trueFileName;
                    FileInfoModel fileInfoModel = new FileInfoModel();
                    fileInfoModel.setPath(returnPath);
                    fileInfoModel.setSize(requestSize);
                    fileInfoModel.setFileSize(FunctionUtil.getPrintSize(requestSize));
                    fileInfoModel.setType(type.toUpperCase());
                    return new WXResult.Success<>(fileInfoModel);
                }else {
                    logger.info("不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                logger.info("文件类型为空");
            }
        }else {
            logger.info("没有找到相对应的文件");
        }
        return new WXResult.Error(WXErrorCode.ERROR_UNKNOWN.getCode(), WXErrorCode.ERROR_UNKNOWN.getResult());

    }
}
