package com.neu.carbon.mes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.mes.mapper.MesMeterialApplicationMapper;
import com.neu.carbon.mes.domain.MesMeterialApplication;
import com.neu.carbon.mes.service.IMesMeterialApplicationService;

/**
 * 领料申请Service业务层处理
 * 
 * @author neuedu
 * @date 2023-12-14
 */
@Service
public class MesMeterialApplicationServiceImpl implements IMesMeterialApplicationService 
{
    @Autowired
    private MesMeterialApplicationMapper mesMeterialApplicationMapper;

    /**
     * 查询领料申请
     * 
     * @param id 领料申请ID
     * @return 领料申请
     */
    @Override
    public MesMeterialApplication selectMesMeterialApplicationById(Long id)
    {
        return mesMeterialApplicationMapper.selectMesMeterialApplicationById(id);
    }

    /**
     * 查询领料申请列表
     * 
     * @param mesMeterialApplication 领料申请
     * @return 领料申请
     */
    @Override
    public List<MesMeterialApplication> selectMesMeterialApplicationList(MesMeterialApplication mesMeterialApplication)
    {
        return mesMeterialApplicationMapper.selectMesMeterialApplicationList(mesMeterialApplication);
    }

    /**
     * 新增领料申请
     * 
     * @param mesMeterialApplication 领料申请
     * @return 结果
     */
    @Override
    public int insertMesMeterialApplication(MesMeterialApplication mesMeterialApplication)
    {
        return mesMeterialApplicationMapper.insertMesMeterialApplication(mesMeterialApplication);
    }

    /**
     * 修改领料申请
     * 
     * @param mesMeterialApplication 领料申请
     * @return 结果
     */
    @Override
    public int updateMesMeterialApplication(MesMeterialApplication mesMeterialApplication)
    {
        return mesMeterialApplicationMapper.updateMesMeterialApplication(mesMeterialApplication);
    }

    /**
     * 批量删除领料申请
     * 
     * @param ids 需要删除的领料申请ID
     * @return 结果
     */
    @Override
    public int deleteMesMeterialApplicationByIds(Long[] ids)
    {
        return mesMeterialApplicationMapper.deleteMesMeterialApplicationByIds(ids);
    }

    /**
     * 删除领料申请信息
     * 
     * @param id 领料申请ID
     * @return 结果
     */
    @Override
    public int deleteMesMeterialApplicationById(Long id)
    {
        return mesMeterialApplicationMapper.deleteMesMeterialApplicationById(id);
    }
}
