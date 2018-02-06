package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TEmployeeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeInfoDao extends JpaRepository<TEmployeeInfoEntity,Long> {

    //根据账号查用户
    List<TEmployeeInfoEntity> findByFAccountOrFMobile(String fAccount,String fMobile);
    List<TEmployeeInfoEntity> findByFAccountAndFCompanyId(String fAccount,Long fCompanyId);

    //查看手机号是否重复(暂不做公司id查询)
    Integer countByFMobile(String fMobile);
    Integer countByFAccountAndFCompanyId(String fAccount,Long fCompanyId);



}
