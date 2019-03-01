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
@ApiModel("用户")
public class User implements Serializable {
    private static final long serialVersionUID = 4676032315587799669L;
    private Long id;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("所属部门ID")
    private Long departmentId;

    @ApiModelProperty("所属社团ID")
    private Long associationId;

    @ApiModelProperty("用户名或学号")
    private String userName;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Byte sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("职称")
    private String job;

    @ApiModelProperty("联系方式")
    private Long telNumber;

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("图片")
    private String userImg;


}