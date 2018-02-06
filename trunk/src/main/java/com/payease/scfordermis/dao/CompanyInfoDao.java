package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TCompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by zhoushijie on 2018/1/16.
 * 公司信息接口
 */
@Repository
public interface CompanyInfoDao extends JpaRepository<TCompanyInfoEntity,Long> {



}
