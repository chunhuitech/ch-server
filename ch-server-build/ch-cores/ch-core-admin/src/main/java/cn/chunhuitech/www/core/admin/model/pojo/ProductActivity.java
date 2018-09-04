package cn.chunhuitech.www.core.admin.model.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductActivity {
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "客户端标志", required = true)
    private String clientFlag;

    @ApiModelProperty(value = "产品名称")
    private String procName;

    @ApiModelProperty(value = "产品版本")
    private String procVersion;

    @ApiModelProperty(value = "产品id")
    private Long procId;

    @ApiModelProperty(value = "操作系统")
    private String os;

    @ApiModelProperty(value = "事件名称")
    private String eventName;

    @ApiModelProperty(value = "内网ip")
    private String ip;

    @ApiModelProperty(value = "外网ip")
    private String netIp;

    @ApiModelProperty(value = "地区")
    private String area;

    @ApiModelProperty(value = "事件发生次数")
    private Integer eventCount;

    private Long modifyTime;

    private Long createTime;

    private String remarks;

    private Byte status;
}