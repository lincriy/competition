package com.neu.carbon.mes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 领料单物料明细对象 mes_material_requisition_detail
 * 
 * @author neuedu
 * @date 2023-12-30
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class MesMaterialRequisitionDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 领料单id */
    @Excel(name = "领料单id")
    private Long materialRequisitionId;

    /** 物料档案id */
    @Excel(name = "物料档案id")
    private Long materialId;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long requireQuantity;

    /** 已领数量 */
    @Excel(name = "已领数量")
    private Long receiveQuantity;

    /** 备注 */
    @Excel(name = "备注")
    private String detailRemark;


    private String name;

    private String model;

    private String specification;

    private String unit;



    /** 领取日期 */
    @ApiModelProperty(value="领取日期",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "领取日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requisitionDate;

    /** 申请人 */
    @ApiModelProperty("申请人")
    @Excel(name = "申请人")
    private String applyUser;

    /** 申请时间 */
    @ApiModelProperty(value="申请时间",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 申请状态 */
    @ApiModelProperty("申请状态")
    @Excel(name = "申请状态")
    private String applyStatus;

    /** 审核人 */
    @ApiModelProperty("审核人")
    @Excel(name = "审核人")
    private String auditUser;

    /** 审核时间 */
    @ApiModelProperty(value="审核时间",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核状态 */
    @ApiModelProperty("审核状态")
    @Excel(name = "审核状态")
    private String auditStatus;

    /** 审核意见 */
    @ApiModelProperty("审核意见")
    @Excel(name = "审核意见")
    private String auditComment;

    /** 状态 */
    @ApiModelProperty("状态")
    @Excel(name = "状态")
    private String status;

}
