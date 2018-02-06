package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TConsumerLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lch on 2018/1/16.
 *
 * 客户等级dao
 */
public interface ConsumerLevelDao extends JpaRepository<TConsumerLevelEntity, Long> {

    List<TConsumerLevelEntity> findByFCompanyId(Long companyId);
}
