package com.neu.carbon.mes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

/**
 * 排产物料信息对象 mes_product_schedule_material
 * 
 * @author neuedu
 * @date 2023-12-31
 */
public class MesProductScheduleMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 排产编号 */
    @Excel(name = "排产编号")
    private Long scheduleId;

    /** 物料档案编号 */
    @Excel(name = "物料档案编号")
    private Long materialId;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long requireQuantity;

    /** 已用数量 */
    @Excel(name = "已用数量")
    private Long usageQuantity;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private Long leftQuantity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setScheduleId(Long scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId() 
    {
        return scheduleId;
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
    public void setUsageQuantity(Long usageQuantity) 
    {
        this.usageQuantity = usageQuantity;
    }

    public Long getUsageQuantity() 
    {
        return usageQuantity;
    }
    public void setLeftQuantity(Long leftQuantity) 
    {
        this.leftQuantity = leftQuantity;
    }

    public Long getLeftQuantity() 
    {
        return leftQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("scheduleId", getScheduleId())
            .append("materialId", getMaterialId())
            .append("requireQuantity", getRequireQuantity())
            .append("usageQuantity", getUsageQuantity())
            .append("leftQuantity", getLeftQuantity())
            .append("remark", getRemark())
            .toString();
    }
}
