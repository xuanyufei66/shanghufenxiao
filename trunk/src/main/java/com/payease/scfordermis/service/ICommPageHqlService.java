package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;

/**
 * @Author : zhangwen
 * @Data : 2018/1/11
 * @Description :
 */
public interface ICommPageHqlService {


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
    PageResponseCommBean getPage(String hql,String countHql, PageBean page);

}
