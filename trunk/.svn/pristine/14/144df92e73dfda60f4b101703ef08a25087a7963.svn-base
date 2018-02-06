package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TProductFormatEntity;
import com.payease.scfordermis.entity.TProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductFormatDao extends JpaRepository<TProductFormatEntity,Long> {
    List<TProductFormatEntity> findByFProductId(Long productId);
    List<TProductFormatEntity> findByFProductIdAndFCompanyIdOrderByFPriceAsc(Long productId,Long companyId);
    void deleteByFProductId(Long productId);
    Long countByFProductId(Long productId);
    //查询存在fName的条数，用于判断是否有重复的名称
    Long countByFCodeAndFCompanyId(String fCode,Long companyId);
    //删除商品对应的规格
    @Query("delete from TProductFormatEntity p where p.fProductId=?1")
    @Modifying
    @Transactional
    int deleteProductFormat(Long id);
    //根据商品编码和companyId 查询
    TProductFormatEntity findByFCompanyIdAndFCode(Long companyId,String fCode);


}
