package com.xrr.assnsystem.dto.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xrr.assnsystem.config.InstantJacksonDeserialize;
import com.xrr.assnsystem.config.InstantJacksonSerializer;
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
public class Apply implements Serializable {

    private static final long serialVersionUID = 6914719200192436435L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("申请人ID")
    private Long userId;

    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("类型(0人员变动,1社团解散)")
    private Integer type;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("申请时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant applyTime;

    @ApiModelProperty("状态(0申请中,1通过,2未通过)")
    private Integer state;


}