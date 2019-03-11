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
@ApiModel("公告")
public class Notice implements Serializable {
    private static final long serialVersionUID = -5594100113210930413L;
    private Long id;

    @ApiModelProperty("发布人ID")
    private Long userId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("所属社团ID")
    private Long associationId;

    @ApiModelProperty("发布时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant createTime;

    @ApiModelProperty("类型(0系统公告,1社团公告)")
    private Integer type;


}