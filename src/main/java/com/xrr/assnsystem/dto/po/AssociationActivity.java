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
@ApiModel("社团活动")
public class AssociationActivity implements Serializable {
    private static final long serialVersionUID = -8048444669557233965L;
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("负责人ID")
    private Long userId;

    @ApiModelProperty("介绍")
    private String content;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("图片")
    private String image;

    @ApiModelProperty("学分")
    private Double score;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant startTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant endTime;


}