package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TAreaInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lch on 2018/1/16.
 *
 * 销售区域dao
 */
@Repository
public interface AreaInfoDao extends JpaRepository<TAreaInfoEntity, Long> {

    //查看一级二级销售区域
    List<TAreaInfoEntity> findByFLevelAndFCompanyId(String fLevel, Long fCompanyId);

    //通过 父ID查看
    Integer countByFParentIdAndFCompanyId(Long fParentId,Long fCompanyId);

    //一级名称不能重复
    Integer countByFNameAndFLevelAndFCompanyId(String fName,String fLevel, Long fCompanyId);
    //同一父级的二级名称不能重复
    Integer countByFNameAndFLevelAndFParentIdAndFCompanyId(String fName,String fLevel,Long fParentId, Long fCompanyId);
}
