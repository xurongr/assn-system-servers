package com.xrr.assnsystem.dto;

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
@ApiModel("公告")
public class NoticeDto implements Serializable {

    private static final long serialVersionUID = -210653088058215160L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("发布人ID")
    private Long userId;

    @ApiModelProperty("发布人姓名")
    private String name;

    @ApiModelProperty("所属社团ID")
    private Long associationId;

    @ApiModelProperty("所属社团名称")
    private String associationName;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("发布时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant createTime;

    @ApiModelProperty("类型(0系统公告,1社团公告)")
    private Integer type;


}