package com.xrr.assnsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户")
public class UserDto implements Serializable {

    private static final long serialVersionUID = -4463692058892902854L;

    private Long id;


    @ApiModelProperty("专业")
    private String major;

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

    @ApiModelProperty("联系方式")
    private Long telNumber;

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("图片")
    private String userImg;

    @ApiModelProperty("社团列表")
    private List<AssnBasic> assnBasicList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class AssnBasic{

        @ApiModelProperty("社团ID")
        private Long associationId;

        @ApiModelProperty("社团名称")
        private String associationName;

        @ApiModelProperty("职务")
        private String job;

        @ApiModelProperty("身份ID")
        private Long identityId;

        @ApiModelProperty("身份名称")
        private String identityName;

        @ApiModelProperty("身份等级")
        private Long level;

        @ApiModelProperty("社团下的部门列表")
        private List<DepartmentBasic> departmentBasicList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        static class DepartmentBasic {

            @ApiModelProperty("部门ID")
            private Long departmentId;

            @ApiModelProperty("部门名称")
            private String departmentName;
        }
    }

}
