package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TEmployeeRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/15 下午9:51
 **/
@Repository
public interface EmployeeRoleDao extends JpaRepository<TEmployeeRoleEntity,Long> {
    //根据员工ID与公司ID查询 员工角色关系表中的数据
    List<TEmployeeRoleEntity> findByFEmployeeId(Long fEmployeeId);
    List<TEmployeeRoleEntity> findByFEmployeeIdAndFCompanyId(Long fEmployeeId,Long fCompanyId);
}
