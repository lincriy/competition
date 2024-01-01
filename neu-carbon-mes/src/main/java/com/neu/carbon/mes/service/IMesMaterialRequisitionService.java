package com.neu.carbon.mes.service;

import java.util.List;
import com.neu.carbon.mes.domain.MesMaterialRequisition;

/**
 * 领料单Service接口
 * 
 * @author neuedu
 * @date 2024-01-01
 */
public interface IMesMaterialRequisitionService 
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
     * 批量删除领料单
     * 
     * @param ids 需要删除的领料单ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionByIds(Long[] ids);

    /**
     * 删除领料单信息
     * 
     * @param id 领料单ID
     * @return 结果
     */
    public int deleteMesMaterialRequisitionById(Long id);
}
