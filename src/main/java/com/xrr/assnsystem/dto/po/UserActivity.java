package com.xrr.assnsystem.dto.po;

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
@ApiModel("用户活动中间表")
public class UserActivity implements Serializable {
    private static final long serialVersionUID = 6035501470214833404L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("人员ID")
    private Long userId;
    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("活动ID")
    private Long activityId;

    @ApiModelProperty("职务")
    private String job;


}