package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ProductActivityService {
    ErrorMessage report(ProductActivity productActivity);
}
