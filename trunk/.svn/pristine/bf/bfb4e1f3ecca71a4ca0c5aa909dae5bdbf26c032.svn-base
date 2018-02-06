package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TDepartmentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by admin on 2018/1/15.
 */
@Repository
public interface DepartmentInfoDao extends JpaRepository<TDepartmentInfoEntity,Long> {
    //通过公司ID查看部门
    List<TDepartmentInfoEntity> findByFCompanyId(Long fCompanyId);

    //查看一级二级部门
    List<TDepartmentInfoEntity> findByFLevelAndFCompanyId(String fLevel,Long fCompanyId);

    //通过 父ID查看
    Integer countByFParentIdAndFCompanyId(Long fParentId,Long fCompanyId);

    //一级名称不能重复
    Integer countByFNameAndFLevelAndFCompanyId(String fName,String fLevel,Long fCompanyId);
    //同一父级的二级名称不能重复
    Integer countByFNameAndFLevelAndFParentIdAndFCompanyId(String fName,String fLevel,Long fParentId,Long fCompanyId);

}
