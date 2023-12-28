package com.neu.carbon.mes.mapper;

import java.util.List;
import com.neu.carbon.mes.domain.MesMeterialApplication;

/**
 * 领料申请Mapper接口
 * 
 * @author neuedu
 * @date 2023-12-14
 */
public interface MesMeterialApplicationMapper 
{
    /**
     * 查询领料申请
     * 
     * @param id 领料申请ID
     * @return 领料申请
     */
    public MesMeterialApplication selectMesMeterialApplicationById(Long id);

    /**
     * 查询领料申请列表
     * 
     * @param mesMeterialApplication 领料申请
     * @return 领料申请集合
     */
    public List<MesMeterialApplication> selectMesMeterialApplicationList(MesMeterialApplication mesMeterialApplication);

    /**
     * 新增领料申请
     * 
     * @param mesMeterialApplication 领料申请
     * @return 结果
     */
    public int insertMesMeterialApplication(MesMeterialApplication mesMeterialApplication);

    /**
     * 修改领料申请
     * 
     * @param mesMeterialApplication 领料申请
     * @return 结果
     */
    public int updateMesMeterialApplication(MesMeterialApplication mesMeterialApplication);

    /**
     * 删除领料申请
     * 
     * @param id 领料申请ID
     * @return 结果
     */
    public int deleteMesMeterialApplicationById(Long id);

    /**
     * 批量删除领料申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesMeterialApplicationByIds(Long[] ids);
}
