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
@ApiModel("部门")
public class DepartmentDto implements Serializable {

    private static final long serialVersionUID = -267859214530967164L;

    @ApiModelProperty("部门ID")
    private Long id;

    @ApiModelProperty("所属社团ID")
    private Long associationId;

    @ApiModelProperty("所属社团名称")
    private String associationName;

    @ApiModelProperty("部长ID")
    private Long ministerUserId;

    @ApiModelProperty("部长姓名")
    private String ministerUserName;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("简介")
    private String content;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    private Instant createTime;


}