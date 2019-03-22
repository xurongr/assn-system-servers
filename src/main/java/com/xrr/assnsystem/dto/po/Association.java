package com.xrr.assnsystem.dto.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("社团")
public class Association implements Serializable {
    private static final long serialVersionUID = 8299495086369043760L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("社团名称")
    private String associationName;

    @ApiModelProperty("负责人ID")
    private Long userId;

    @ApiModelProperty("介绍")
    private String content;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Instant createTime;

    @ApiModelProperty("招募状态(0,1)")
    private Integer recruitState;


}