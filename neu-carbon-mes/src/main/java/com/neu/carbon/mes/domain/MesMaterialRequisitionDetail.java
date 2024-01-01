package com.neu.carbon.mes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

/**
 * 领料单物料明细对象 mes_material_requisition_detail
 * 
 * @author neuedu
 * @date 2024-01-01
 */
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialRequisitionId(Long materialRequisitionId) 
    {
        this.materialRequisitionId = materialRequisitionId;
    }

    public Long getMaterialRequisitionId() 
    {
        return materialRequisitionId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setRequireQuantity(Long requireQuantity) 
    {
        this.requireQuantity = requireQuantity;
    }

    public Long getRequireQuantity() 
    {
        return requireQuantity;
    }
    public void setReceiveQuantity(Long receiveQuantity) 
    {
        this.receiveQuantity = receiveQuantity;
    }

    public Long getReceiveQuantity() 
    {
        return receiveQuantity;
    }
    public void setDetailRemark(String detailRemark) 
    {
        this.detailRemark = detailRemark;
    }

    public String getDetailRemark() 
    {
        return detailRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialRequisitionId", getMaterialRequisitionId())
            .append("materialId", getMaterialId())
            .append("requireQuantity", getRequireQuantity())
            .append("receiveQuantity", getReceiveQuantity())
            .append("detailRemark", getDetailRemark())
            .toString();
    }
}
