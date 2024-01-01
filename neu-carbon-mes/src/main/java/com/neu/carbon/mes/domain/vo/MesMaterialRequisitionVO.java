package com.neu.carbon.mes.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neu.carbon.mes.domain.MesMaterialRequisitionDetail;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 领料单对象 mes_material_requisition
 * 
 * @author neuedu
 * @date 2024-01-01
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("领料单")
@Data
@ToString
public class MesMaterialRequisitionVO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    @Excel(name = "编号")
    private Long id;

    /** 领料单号 */
    @ApiModelProperty("领料单号")
    private String serialNo;

    /** 生产计划 */
    @ApiModelProperty("生产计划")
    @Excel(name = "生产计划")
    private String productPlan;

    /** 计划排产 */
    @ApiModelProperty("计划排产")
    @Excel(name = "计划排产")
    private String productSchedule;

    /** 产品 */
    @ApiModelProperty("产品")
    @Excel(name = "产品")
    private String productName;

    /** 型号 */
    @ApiModelProperty("型号")
    @Excel(name = "型号")
    private String model;

    /** 规格 */
    @ApiModelProperty("规格")
    @Excel(name = "规格")
    private String specification;


    /** 单位 */
    @ApiModelProperty("单位")
    @Excel(name = "单位")
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

    /** 领料单物料明细信息 */
	@ApiModelProperty(hidden = true)
    private List<MesMaterialRequisitionDetail> mesMaterialRequisitionDetailList;
}
