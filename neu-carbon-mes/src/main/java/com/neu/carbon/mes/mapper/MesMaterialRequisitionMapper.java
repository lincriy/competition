package com.neu.carbon.mes.mapper;

import java.util.List;
import com.neu.carbon.mes.domain.MesMaterialRequisition;
import com.neu.carbon.mes.domain.MesMaterialRequisitionDetail;

/**
 * 领料单Mapper接口
 * 
 * @author neuedu
 * @date 2024-01-01
 */
public interface MesMaterialRequisitionMapper 
{
    /**
     * 查询领料单
     * 
     * @param id 领料单ID
     * @return 领料单
     */
    public MesMaterialRequisition selectMesMaterialRequisitionById(Long id);

    /**
     * 查询领料单列表
     * 
     * @param mesMaterialRequisition 领料单
     * @return 领料单集合
     */
    public List<MesMaterialRequisition> selectMesMaterialRequisitionList(MesMaterialRequisition mesMaterialRequisition);

    /**
     * 新增领料单
     * 
     * @param mesMaterialRequisition 领料单
     * @return 结果
     */
    public int insertMesMaterialRequisition(MesMaterialRequisition mesMaterialRequisition);

    /**
     * 修改领料单
     * 
     * @param mesMaterialRequisition 领料单
     * @return 结果
     */
    public int updateMesMaterialRequisition(MesMaterialRequisition mesMaterialRequisition);

    /**
     * 删除领料单
     * 
     * @param id 领料单ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionById(Long id);

    /**
     * 批量删除领料单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionByIds(Long[] ids);

    /**
     * 批量删除领料单物料明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionDetailByMaterialRequisitionIds(Long[] ids);
    
    /**
     * 批量新增领料单物料明细
     * 
     * @param mesMaterialRequisitionDetailList 领料单物料明细列表
     * @return 结果
     */
    public int batchMesMaterialRequisitionDetail(List<MesMaterialRequisitionDetail> mesMaterialRequisitionDetailList);
    

    /**
     * 通过领料单ID删除领料单物料明细信息
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionDetailByMaterialRequisitionId(Long id);
}
