package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TPaymentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lch on 2018/1/16.
 *
 * 收款记录dao
 */
public interface PaymentHistoryDao extends JpaRepository<TPaymentHistoryEntity, Long> {

    List<TPaymentHistoryEntity> findByFOrderId(Long orderId);
}
