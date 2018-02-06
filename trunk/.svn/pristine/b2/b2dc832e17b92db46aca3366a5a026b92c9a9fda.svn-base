package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TConsumerLevelEntity;
import com.payease.scfordermis.entity.TDepartmentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2018/1/16.
 */
@Repository
public interface CustomerLevelDao extends JpaRepository<TConsumerLevelEntity,Long> {

       List<TConsumerLevelEntity> findByFNameAndFCompanyId(String fName,long fCompanyId);

       List<TConsumerLevelEntity>findByFCompanyId(long fCompanyId);


}
