package com.neu.carbon.mes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.neu.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.neu.carbon.mes.domain.MesMaterialRequisitionDetail;
import com.neu.carbon.mes.mapper.MesMaterialRequisitionMapper;
import com.neu.carbon.mes.domain.MesMaterialRequisition;
import com.neu.carbon.mes.service.IMesMaterialRequisitionService;

/**
 * 领料单Service业务层处理
 * 
 * @author neuedu
 * @date 2024-01-01
 */
@Service
public class MesMaterialRequisitionServiceImpl implements IMesMaterialRequisitionService 
{
    @Autowired
    private MesMaterialRequisitionMapper mesMaterialRequisitionMapper;

    /**
     * 查询领料单
     * 
     * @param id 领料单ID
     * @return 领料单
     */
    @Override
    public MesMaterialRequisition selectMesMaterialRequisitionById(Long id)
    {
        return mesMaterialRequisitionMapper.selectMesMaterialRequisitionById(id);
    }

    /**
     * 查询领料单列表
     * 
     * @param mesMaterialRequisition 领料单
     * @return 领料单
     */
    @Override
    public List<MesMaterialRequisition> selectMesMaterialRequisitionList(MesMaterialRequisition mesMaterialRequisition)
    {
        return mesMaterialRequisitionMapper.selectMesMaterialRequisitionList(mesMaterialRequisition);
    }

    /**
     * 新增领料单
     * 
     * @param mesMaterialRequisition 领料单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesMaterialRequisition(MesMaterialRequisition mesMaterialRequisition)
    {
        int rows = mesMaterialRequisitionMapper.insertMesMaterialRequisition(mesMaterialRequisition);
        insertMesMaterialRequisitionDetail(mesMaterialRequisition);
        return rows;
    }

    /**
     * 修改领料单
     * 
     * @param mesMaterialRequisition 领料单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesMaterialRequisition(MesMaterialRequisition mesMaterialRequisition)
    {
        mesMaterialRequisitionMapper.deleteMesMaterialRequisitionDetailByMaterialRequisitionId(mesMaterialRequisition.getId());
        insertMesMaterialRequisitionDetail(mesMaterialRequisition);
        return mesMaterialRequisitionMapper.updateMesMaterialRequisition(mesMaterialRequisition);
    }

    /**
     * 批量删除领料单
     * 
     * @param ids 需要删除的领料单ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesMaterialRequisitionByIds(Long[] ids)
    {
        mesMaterialRequisitionMapper.deleteMesMaterialRequisitionDetailByMaterialRequisitionIds(ids);
        return mesMaterialRequisitionMapper.deleteMesMaterialRequisitionByIds(ids);
    }

    /**
     * 删除领料单信息
     * 
     * @param id 领料单ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesMaterialRequisitionById(Long id)
    {
        mesMaterialRequisitionMapper.deleteMesMaterialRequisitionDetailByMaterialRequisitionId(id);
        return mesMaterialRequisitionMapper.deleteMesMaterialRequisitionById(id);
    }

    /**
     * 新增领料单物料明细信息
     * 
     * @param mesMaterialRequisition 领料单对象
     */
    public void insertMesMaterialRequisitionDetail(MesMaterialRequisition mesMaterialRequisition)
    {
        List<MesMaterialRequisitionDetail> mesMaterialRequisitionDetailList = mesMaterialRequisition.getMesMaterialRequisitionDetailList();
        Long id = mesMaterialRequisition.getId();
        if (StringUtils.isNotNull(mesMaterialRequisitionDetailList))
        {
            List<MesMaterialRequisitionDetail> list = new ArrayList<MesMaterialRequisitionDetail>();
            for (MesMaterialRequisitionDetail mesMaterialRequisitionDetail : mesMaterialRequisitionDetailList)
            {
                mesMaterialRequisitionDetail.setMaterialRequisitionId(id);
                list.add(mesMaterialRequisitionDetail);
            }
            if (list.size() > 0)
            {
                mesMaterialRequisitionMapper.batchMesMaterialRequisitionDetail(list);
            }
        }
    }
}
