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
@ApiModel("身份")
public class Identity implements Serializable {
    private static final long serialVersionUID = -924300068956281220L;
    private Long id;

    @ApiModelProperty("身份名称")
    private String identityName;

    @ApiModelProperty("等级")
    private Long level;


}