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
@ApiModel("部门")
public class Department implements Serializable {
    private static final long serialVersionUID = 7761851492469198192L;
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("社团ID")
    private Long associationId;

    @ApiModelProperty("部长ID")
    private Long ministerUserId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("简介")
    private String content;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant createTime;


}