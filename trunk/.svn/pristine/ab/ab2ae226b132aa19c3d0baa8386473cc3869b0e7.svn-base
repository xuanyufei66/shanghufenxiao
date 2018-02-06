package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Created by lch on 2018/1/4.
 */
public interface UserDao extends JpaRepository<User,Long> {


    List<User> findByUsernameAndPassword(String username,String password);

    Page<User> findAllByUsernameOrderByTimeAscAgeAsc(String username,Pageable pageable);

    @Query(value = "select * from user where username=:username",nativeQuery = true)
    List<User> findUserList(@Param("username") String username);
}
