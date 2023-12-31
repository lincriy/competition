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
import com.neu.carbon.mes.domain.MesMaterialRequisition;
import com.neu.carbon.mes.service.IMesMaterialRequisitionService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 领料单Controller
 * 
 * @author neuedu
 * @date 2023-12-30
 */
@Api(tags = {"领料单"})
@RestController
@RequestMapping("/mes/requisition")
public class MesMaterialRequisitionController extends BaseController
{
    @Autowired
    private IMesMaterialRequisitionService mesMaterialRequisitionService;

    /**
     * 查询领料单列表
     */
    @GetMapping("/list")
    @ApiOperation("查询领料单列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = MesMaterialRequisition.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(MesMaterialRequisition mesMaterialRequisition)
    {
        startPage();
        List<MesMaterialRequisition> list = mesMaterialRequisitionService.selectMesMaterialRequisitionList(mesMaterialRequisition);
        return getDataTable(list);
    }

    /**
     * 导出领料单列表
     */
    @ApiOperation("导出领料单列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('mes:requisition:export')")
    @Log(title = "领料单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesMaterialRequisition mesMaterialRequisition)
    {
        List<MesMaterialRequisition> list = mesMaterialRequisitionService.selectMesMaterialRequisitionList(mesMaterialRequisition);
        ExcelUtil<MesMaterialRequisition> util = new ExcelUtil<MesMaterialRequisition>(MesMaterialRequisition.class);
        return util.exportExcel(list, "requisition");
    }

    /**
     * 获取领料单详细信息
     */
    @ApiOperation("获取领料单详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = MesMaterialRequisition.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesMaterialRequisitionService.selectMesMaterialRequisitionById(id));
    }

    /**
     * 新增领料单
     */
    @ApiOperation("新增领料单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:requisition:add')")
    @Log(title = "领料单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesMaterialRequisition mesMaterialRequisition)
    {
        return toAjax(mesMaterialRequisitionService.insertMesMaterialRequisition(mesMaterialRequisition));
    }

    /**
     * 修改领料单
     */
    @ApiOperation("修改领料单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:requisition:edit')")
    @Log(title = "领料单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesMaterialRequisition mesMaterialRequisition)
    {
        return toAjax(mesMaterialRequisitionService.updateMesMaterialRequisition(mesMaterialRequisition));
    }

    /**
     * 删除领料单
     */
    @ApiOperation("删除领料单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:requisition:remove')")
    @Log(title = "领料单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesMaterialRequisitionService.deleteMesMaterialRequisitionByIds(ids));
    }
}
