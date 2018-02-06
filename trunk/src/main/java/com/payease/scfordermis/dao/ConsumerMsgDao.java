package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TConsumerMsgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuxiaoming on 2018/1/16.
 *
 * 客户端（APP）-消息dao
 */
@Repository
public interface ConsumerMsgDao extends JpaRepository<TConsumerMsgEntity, Long> {

        //通过  fcompanyId fConsumerId fMsgStatus 查询数据
        List<TConsumerMsgEntity> findByFCompanyIdAndFConsumerIdAndFMsgStatus(Long fCompanyId, Long fConsumerId,String fMsgStatus);
        //通过  fcompanyId fConsumerId fMsgStatus 统计数据
        Integer countByFCompanyIdAndFConsumerIdAndFMsgStatus(Long fCompanyId, Long fConsumerId,String fMsgStatus);
}
