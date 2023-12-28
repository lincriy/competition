package com.neu.carbon.mes.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 领料申请对象 mes_meterial_application
 * 
 * @author neuedu
 * @date 2023-12-14
 */
@ApiModel("领料申请")
public class MesMeterialApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 领料单号 */
    @ApiModelProperty("领料单号")
    @Excel(name = "领料单号")
    private Long applyOrderNumber;

    /** 生产计划 */
    @ApiModelProperty("生产计划")
    @Excel(name = "生产计划")
    private String producePlan;

    /** 计划排产 */
    @ApiModelProperty("计划排产")
    @Excel(name = "计划排产")
    private String planningAndScheduling;

    /** 产品型号 */
    @ApiModelProperty("产品型号")
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品规格 */
    @ApiModelProperty("产品规格")
    @Excel(name = "产品规格")
    private String productStandard;

    /** 单位 */
    @ApiModelProperty("单位")
    @Excel(name = "单位")
    private Long unit;

    /** 领取日期 */
    @ApiModelProperty(value="领取日期",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "领取日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionDate;

    /** 申请人 */
    @ApiModelProperty("申请人")
    @Excel(name = "申请人")
    private String proposer;

    /** 申请时间 */
    @ApiModelProperty(value="申请时间",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeOfApplication;

    /** 申请状态 */
    @ApiModelProperty("申请状态")
    @Excel(name = "申请状态")
    private String applicationStatus;

    /** 审核人 */
    @ApiModelProperty("审核人")
    @Excel(name = "审核人")
    private String auditor;

    /** 审核时间 */
    @ApiModelProperty(value="审核时间",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核状态 */
    @ApiModelProperty("审核状态")
    @Excel(name = "审核状态")
    private String auditStatus;

    /** 状态 */
    @ApiModelProperty("状态")
    @Excel(name = "状态")
    private String state;

    /** 待产数量 */
    @ApiModelProperty("待产数量")
    private Long numberOfExpectantBirths;

    /** 生产日期 */
    @ApiModelProperty(value="生产日期",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfManufacture;

    /** 物料 */
    @ApiModelProperty("物料")
    private String material;

    /** 需求数量 */
    @ApiModelProperty("需求数量")
    private Long quantityRequired;

    /** 已领数量 */
    @ApiModelProperty("已领数量")
    private Long quantityClaimed;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyOrderNumber(Long applyOrderNumber) 
    {
        this.applyOrderNumber = applyOrderNumber;
    }

    public Long getApplyOrderNumber() 
    {
        return applyOrderNumber;
    }
    public void setProducePlan(String producePlan) 
    {
        this.producePlan = producePlan;
    }

    public String getProducePlan() 
    {
        return producePlan;
    }
    public void setPlanningAndScheduling(String planningAndScheduling) 
    {
        this.planningAndScheduling = planningAndScheduling;
    }

    public String getPlanningAndScheduling() 
    {
        return planningAndScheduling;
    }
    public void setProductModel(String productModel) 
    {
        this.productModel = productModel;
    }

    public String getProductModel() 
    {
        return productModel;
    }
    public void setProductStandard(String productStandard) 
    {
        this.productStandard = productStandard;
    }

    public String getProductStandard() 
    {
        return productStandard;
    }
    public void setUnit(Long unit) 
    {
        this.unit = unit;
    }

    public Long getUnit() 
    {
        return unit;
    }
    public void setCollectionDate(Date collectionDate) 
    {
        this.collectionDate = collectionDate;
    }

    public Date getCollectionDate() 
    {
        return collectionDate;
    }
    public void setProposer(String proposer) 
    {
        this.proposer = proposer;
    }

    public String getProposer() 
    {
        return proposer;
    }
    public void setTimeOfApplication(Date timeOfApplication) 
    {
        this.timeOfApplication = timeOfApplication;
    }

    public Date getTimeOfApplication() 
    {
        return timeOfApplication;
    }
    public void setApplicationStatus(String applicationStatus) 
    {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatus() 
    {
        return applicationStatus;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setNumberOfExpectantBirths(Long numberOfExpectantBirths) 
    {
        this.numberOfExpectantBirths = numberOfExpectantBirths;
    }

    public Long getNumberOfExpectantBirths() 
    {
        return numberOfExpectantBirths;
    }
    public void setDateOfManufacture(Date dateOfManufacture) 
    {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getDateOfManufacture() 
    {
        return dateOfManufacture;
    }
    public void setMaterial(String material) 
    {
        this.material = material;
    }

    public String getMaterial() 
    {
        return material;
    }
    public void setQuantityRequired(Long quantityRequired) 
    {
        this.quantityRequired = quantityRequired;
    }

    public Long getQuantityRequired() 
    {
        return quantityRequired;
    }
    public void setQuantityClaimed(Long quantityClaimed) 
    {
        this.quantityClaimed = quantityClaimed;
    }

    public Long getQuantityClaimed() 
    {
        return quantityClaimed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyOrderNumber", getApplyOrderNumber())
            .append("producePlan", getProducePlan())
            .append("planningAndScheduling", getPlanningAndScheduling())
            .append("productModel", getProductModel())
            .append("productStandard", getProductStandard())
            .append("unit", getUnit())
            .append("collectionDate", getCollectionDate())
            .append("proposer", getProposer())
            .append("timeOfApplication", getTimeOfApplication())
            .append("applicationStatus", getApplicationStatus())
            .append("auditor", getAuditor())
            .append("auditTime", getAuditTime())
            .append("auditStatus", getAuditStatus())
            .append("state", getState())
            .append("numberOfExpectantBirths", getNumberOfExpectantBirths())
            .append("dateOfManufacture", getDateOfManufacture())
            .append("material", getMaterial())
            .append("quantityRequired", getQuantityRequired())
            .append("quantityClaimed", getQuantityClaimed())
            .toString();
    }
}
