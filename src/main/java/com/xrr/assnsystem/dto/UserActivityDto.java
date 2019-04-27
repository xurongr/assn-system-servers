package com.xrr.assnsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户活动中间表(成员)")
public class UserActivityDto implements Serializable {
    private static final long serialVersionUID = -4193316638998345498L;

    private Long id;

    @ApiModelProperty("人员ID")
    private Long userId;

    @ApiModelProperty("人员姓名")
    private String name;

    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("社团名称")
    private String associationName;

    @ApiModelProperty("部门ID(0表示社团记录，不包括部门)")
    private Long departmentId;

    @ApiModelProperty("社团名称")
    private String departmentName;

    @ApiModelProperty("活动ID")
    private Long activityId;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("职务")
    private String job;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("身份名称")
    private String identityName;


}