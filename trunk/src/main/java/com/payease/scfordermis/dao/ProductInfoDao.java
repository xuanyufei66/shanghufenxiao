package com.payease.scfordermis.dao;


import com.payease.scfordermis.entity.TProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljp on 2018/1/11.
 */

public interface ProductInfoDao extends JpaRepository<TProductInfoEntity, Long>, JpaSpecificationExecutor<TProductInfoEntity> {
 //查询商品表中的所属一级分类的个数（用于是否能删除商品分类）
 Long countTProductInfoEntitiesByFCategoryIdOneEquals(Long id);

 //查询商品表中的所属二级分类的个数（用于是否能删除商品分类）
 Long countTProductInfoEntitiesByFCategoryIdTwoEquals(Long id);

 //查询商品表中的单位id的个数（用于是否删除商品单位）
 Long countTProductInfoEntitiesByFUnitId(Long id);

 //查询所有商品
 List<TProductInfoEntity> findAll();

 //验证修改商品名称是否重复
 TProductInfoEntity findByFNameAndFCompanyId(String fName,Long companyId);
 //验证新增商品名称是否重复
 Long countByFNameAndFCompanyId(String fName,Long companyId);
     List<TProductInfoEntity> findByFStatusAndFCompanyId(String fstatus,Long companyId);

 @Query("delete from TProductInfoEntity p where p.fId not in(select t.fProductId from TTransportOrderDetailEntity t) and p.fId=?1")
 @Modifying
 @Transactional
 int deleteProductInfo(Long id);

 //用于把新增二级属性时把一级属性自动转化成二级属性
 List<TProductInfoEntity> findByFCompanyIdAndFCategoryIdOneAndFCategoryIdTwo(Long companyId,Long categoryIdOne,Long categoryIdTwo);
}

