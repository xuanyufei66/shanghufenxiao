package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.service.ICommPageHqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @Author : zhangwen
 * @Data : 2018/1/11
 * @Description :
 */
@Service
public class CommPageHqlServiceImpl implements ICommPageHqlService {

    @Autowired
    EntityManager em;

    /**
     * @Author zhangwen
     * @MethodName getPage
     * @Params [queryHql, countHql, page]
     * @Return com.payease.scfordermis.bo.responseBo.PageResponseCommBean
     * @Date 2018/1/11 下午6:09
     * @Desp 分页查询插件
     *          第一个参数为查询列表使用的hql，返回列需要定义为map
     *          例如：select new map(u.fId as fId,u.areaId as areaId,u.fName as fName,u.fCode as fCode,t.fName as areaName) from User u,TAreaInfoEntity t where t.fId = u.areaId;
     *          第二个参数为查询总条数使用的hql
     *          例如：select count(*) from User u,TAreaInfoEntity t where t.fId = u.areaId
     *          第三个参数为分页配置
     */
    @Override
    public PageResponseCommBean getPage(String queryHql,String countHql, PageBean page) {
        PageResponseCommBean bean = new PageResponseCommBean();
        Query query = em.createQuery(queryHql);
        query.setMaxResults(page.getSize());
        query.setFirstResult((page.getPage()-1)*page.getSize());
        List<Map<String,Object>> list = query.getResultList();

        int totals = Integer.parseInt(String.valueOf(em.createQuery(countHql).getSingleResult()));
        bean.setContent(list);
        bean.setTotalElements(totals);
        int t1 = totals/page.getSize();
        if( totals%page.getSize()>0){
            t1 = t1+1;
        }
        bean.setTotalPages(t1);
        bean.setSize(page.getSize());
        bean.setNumber(page.getPage());
        return bean;
    }
}
