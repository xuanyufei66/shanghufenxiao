package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TRoleInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/15 下午9:48
 **/
@Repository
public interface RoleInfoDao extends JpaRepository<TRoleInfoEntity,Long> {
        //通过公司ID查找角色表
        List<TRoleInfoEntity> findByFCompanyId(Long fCompanyId);

        Integer countByFNameAndFCompanyId(String fName,Long fCompanyId);
}
