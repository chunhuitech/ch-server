package cn.chunhuitech.www.core.admin.model.cus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hechengjin on 18-2-22.
 */
@Getter
@Setter
@ToString
public class CommResourcePara {
    @ApiModelProperty(value = "资源id")
    private Integer id;

    private Integer page;
    private Integer limit;

}
