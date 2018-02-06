package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TRemarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lch on 2018/1/16.
 *
 * 备注dao
 */
public interface RemarkDao extends JpaRepository<TRemarkEntity, Long> {

    List<TRemarkEntity> findByFTransportOrderIdAndTType(Long orderId,String type);
}
