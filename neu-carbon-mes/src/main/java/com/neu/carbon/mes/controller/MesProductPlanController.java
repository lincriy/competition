package com.neu.carbon.mes.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.neu.common.annotation.Log;
import com.neu.common.core.controller.BaseController;
import com.neu.common.core.domain.AjaxResult;
import com.neu.common.enums.BusinessType;
import com.neu.carbon.mes.domain.MesProductPlan;
import com.neu.carbon.mes.service.IMesProductPlanService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 生产计划Controller
 * 
 * @author neuedu
 * @date 2024-01-01
 */
@Api(tags = {"生产计划"})
@RestController
@RequestMapping("/mes/plan")
public class MesProductPlanController extends BaseController
{
    @Autowired
    private IMesProductPlanService mesProductPlanService;

    /**
     * 查询生产计划列表
     */
    @GetMapping("/list")
    @ApiOperation("查询生产计划列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = MesProductPlan.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(MesProductPlan mesProductPlan)
    {
        startPage();
        List<MesProductPlan> list = mesProductPlanService.selectMesProductPlanList(mesProductPlan);
        return getDataTable(list);
    }

    /**
     * 导出生产计划列表
     */
    @ApiOperation("导出生产计划列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('mes:plan:export')")
    @Log(title = "生产计划", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesProductPlan mesProductPlan)
    {
        List<MesProductPlan> list = mesProductPlanService.selectMesProductPlanList(mesProductPlan);
        ExcelUtil<MesProductPlan> util = new ExcelUtil<MesProductPlan>(MesProductPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 获取生产计划详细信息
     */
    @ApiOperation("获取生产计划详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = MesProductPlan.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesProductPlanService.selectMesProductPlanById(id));
    }

    /**
     * 新增生产计划
     */
    @ApiOperation("新增生产计划")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:plan:add')")
    @Log(title = "生产计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesProductPlan mesProductPlan)
    {
        return toAjax(mesProductPlanService.insertMesProductPlan(mesProductPlan));
    }

    /**
     * 修改生产计划
     */
    @ApiOperation("修改生产计划")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:plan:edit')")
    @Log(title = "生产计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesProductPlan mesProductPlan)
    {
        return toAjax(mesProductPlanService.updateMesProductPlan(mesProductPlan));
    }

    /**
     * 删除生产计划
     */
    @ApiOperation("删除生产计划")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:plan:remove')")
    @Log(title = "生产计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesProductPlanService.deleteMesProductPlanByIds(ids));
    }
}
