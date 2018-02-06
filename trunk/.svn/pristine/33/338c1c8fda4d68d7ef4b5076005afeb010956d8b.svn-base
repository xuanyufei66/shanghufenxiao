package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.PageRequest;
import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.dao.UserDao;
import com.payease.scfordermis.entity.User;
import com.payease.scfordermis.service.ICommPageHqlService;
import com.payease.scfordermis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by lch on 2018/1/4.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private ICommPageHqlService commPageHqlService;

    @Autowired
    private UserDao userDao;

    @Autowired
    EntityManager em;

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public List<User> getByExample(String name, String password) {
        List<User> list = userDao.findByUsernameAndPassword(name,password);
        return list;
    }

    @Override
    public Page<User> findUserList(String username, int page, int size) {
//        Sort.Order nameOrder = new Sort.Order(Sort.Direction.DESC, "password");
//        Sort.Order rangeOrder = new Sort.Order(Sort.Direction.ASC, "time");
//        List<Sort.Order> orders = new ArrayList<>();
//        orders.add(nameOrder);//先按password降序
//        orders.add(rangeOrder);//再按time升序
//        Sort sort = new Sort(orders);
        Page<User> userList = userDao.findAllByUsernameOrderByTimeAscAgeAsc(username, PageRequest.of(page,size));

        return userList;

    }

    @Override
    public List<User> findAllEm() {
        List<User> list = em.createNativeQuery("SELECT * FROM `user` ORDER BY age+0 desc",User.class).getResultList();
        return list;

    }


    /**
     * @Author zhangwen
     * @MethodName testPage
     * @Params []
     * @Return com.payease.scfordermis.bo.responseBo.PageResponseCommBean
     * @Date 2018/1/11 下午6:14
     * @Desp 联表分页查询案例
     */
    @Override
    public PageResponseCommBean testPage() {
        String sql = "select new map(u.fId as fId,u.areaId as areaId,u.fName as fName,u.fCode as fCode,t.fName as areaName)  from User  u,TAreaInfoEntity t where t.fId = u.areaId";
        String countSql = "select count(*)  from User  u,TAreaInfoEntity t where t.fId = u.areaId";
        PageBean bean = new PageBean();
        bean.setSize(4);
        bean.setPage(1);
        PageResponseCommBean cbean = commPageHqlService.getPage(sql,countSql,bean);
        return cbean;
    }
}
