package cn.chunhuitech.www.api.admin.service;


import cn.chunhuitech.www.api.common.model.WXResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 19-1-24.
 */
public interface FilesService {
    WXResult.Base upLoadImage(MultipartFile image, HttpServletRequest request);
}
