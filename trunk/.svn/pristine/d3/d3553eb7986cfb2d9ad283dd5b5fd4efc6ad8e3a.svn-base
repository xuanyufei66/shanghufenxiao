package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TConsumerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lch on 2018/1/15.
 *
 * 客户dao
 */
@Repository
public interface ConsumerInfoDao extends JpaRepository<TConsumerInfoEntity,Long>{

    List<TConsumerInfoEntity> findByFNameContainingAndFCompanyId(String consumerName,Long companyId);

    List<TConsumerInfoEntity> findByFCompanyIdAndFIsDelete(Long companyId,String isDelete);

    List<TConsumerInfoEntity> findByFLevelId(Long levelId);
    //登录根据账号查询
    List<TConsumerInfoEntity> findByFIndentNo(String fIndentNo);


    @Query("select t from TConsumerInfoEntity t where fCompanyId = :companyId")
    List<TConsumerInfoEntity> findByFCompanyId(@Param(value = "companyId") Long companyId);

    //  通过 字段：  f_indent_status   f_is_delete 来验证是否发送短信验证码
    Integer countByFPhoneAndFIndentStatusAndFIsDelete(String fPhone, String fIndentStatus, String fIsDelete);

}
