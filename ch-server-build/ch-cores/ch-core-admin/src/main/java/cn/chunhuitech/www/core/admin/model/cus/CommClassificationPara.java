package cn.chunhuitech.www.core.admin.model.cus;

import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "接受分享参数")
public class CommClassificationPara {
    @ApiModelProperty(value = "类id")
    private Integer id;
    @ApiModelProperty(value = "父类id")
    private Integer parentId;
    @ApiModelProperty(value = "同步时间")
    private long syncTime;

}
