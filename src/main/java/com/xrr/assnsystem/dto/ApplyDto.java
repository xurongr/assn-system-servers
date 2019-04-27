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
@ApiModel("申请记录")
public class ApplyDto implements Serializable {

    private static final long serialVersionUID = 3751620456557971196L;

    private Long id;

    @ApiModelProperty("申请人ID")
    private Long userId;

    @ApiModelProperty("申请人姓名")
    private String name;

    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("社团名称")
    private String associationName;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("身份名称")
    private String identityName;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("申请时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Instant applyTime;

    @ApiModelProperty("状态(0申请中,1通过,2未通过)")
    private Integer state;


}