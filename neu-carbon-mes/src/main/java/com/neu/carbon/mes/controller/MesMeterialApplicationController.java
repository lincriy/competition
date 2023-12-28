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
import com.neu.carbon.mes.domain.MesMeterialApplication;
import com.neu.carbon.mes.service.IMesMeterialApplicationService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 领料申请Controller
 * 
 * @author neuedu
 * @date 2023-12-14
 */
@Api(tags = {"领料申请"})
@RestController
@RequestMapping("/mes/RequisitionApply")
public class MesMeterialApplicationController extends BaseController
{
    @Autowired
    private IMesMeterialApplicationService mesMeterialApplicationService;

    /**
     * 查询领料申请列表
     */
    @GetMapping("/list")
    @ApiOperation("查询领料申请列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = MesMeterialApplication.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(MesMeterialApplication mesMeterialApplication)
    {
        startPage();
        List<MesMeterialApplication> list = mesMeterialApplicationService.selectMesMeterialApplicationList(mesMeterialApplication);
        return getDataTable(list);
    }

    /**
     * 导出领料申请列表
     */
    @ApiOperation("导出领料申请列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('mes:RequisitionApply:export')")
    @Log(title = "领料申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesMeterialApplication mesMeterialApplication)
    {
        List<MesMeterialApplication> list = mesMeterialApplicationService.selectMesMeterialApplicationList(mesMeterialApplication);
        ExcelUtil<MesMeterialApplication> util = new ExcelUtil<MesMeterialApplication>(MesMeterialApplication.class);
        return util.exportExcel(list, "RequisitionApply");
    }

    /**
     * 获取领料申请详细信息
     */
    @ApiOperation("获取领料申请详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = MesMeterialApplication.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesMeterialApplicationService.selectMesMeterialApplicationById(id));
    }

    /**
     * 新增领料申请
     */
    @ApiOperation("新增领料申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:RequisitionApply:add')")
    @Log(title = "领料申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesMeterialApplication mesMeterialApplication)
    {
        return toAjax(mesMeterialApplicationService.insertMesMeterialApplication(mesMeterialApplication));
    }

    /**
     * 修改领料申请
     */
    @ApiOperation("修改领料申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:RequisitionApply:edit')")
    @Log(title = "领料申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesMeterialApplication mesMeterialApplication)
    {
        return toAjax(mesMeterialApplicationService.updateMesMeterialApplication(mesMeterialApplication));
    }

    /**
     * 删除领料申请
     */
    @ApiOperation("删除领料申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('mes:RequisitionApply:remove')")
    @Log(title = "领料申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesMeterialApplicationService.deleteMesMeterialApplicationByIds(ids));
    }
}
