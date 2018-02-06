package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.requestBo.ReqOrderMoneyBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.bo.responseBo.RespOrderMoneyTotalBean;
import com.payease.scfordermis.service.ICommPageHqlService;
import com.payease.scfordermis.service.IOrderMoneyService;
import com.payease.scfordermis.utils.MoneyUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author : zhangwen
 * @Data : 2018/1/17
 * @Description :
 */

@Service
public class OrderMoneyServiceImpl implements IOrderMoneyService {

    private static final Logger log = LoggerFactory.getLogger(OrderMoneyServiceImpl.class);


    @Autowired
    EntityManager em;

    @Autowired
    private ICommPageHqlService commPageHqlService;

    /**
     * @param session
     * @param orderMoneyBean
     * @Author zhangwen
     * @MethodName getMoney
     * @Params HttpSession session, ReqOrderMoneyBean orderMoneyBean
     * @Return RespOrderMoneyTotalBean
     * @Date 2018/1/17 上午10:55
     * @Desp 获取金额总数接口
     */
    @Override
    public RespOrderMoneyTotalBean getMoney(HttpSession session, ReqOrderMoneyBean orderMoneyBean) throws Exception{
        RespOrderMoneyTotalBean bean = new RespOrderMoneyTotalBean();
        try {
            //1.订单应收金额与已支付金额sql
            RespLoginPCBean userInfo = (RespLoginPCBean) session.getAttribute("userInfo");
            long tCompanyId = userInfo.getfCompanyId();
            String sql = this.getOrderMoneySql(tCompanyId,orderMoneyBean);
            Query query = em.createNativeQuery(sql);
            List<Object[]> moneys = query.getResultList();
            //2.计算金额
            String orderTotalMoney = null!=moneys&&moneys.size()>0&&null!=moneys.get(0)[0]?moneys.get(0)[0].toString():"0.00";
            String paidTotalMoney = "0.00";
            String orderWaitMoney = "0.00";
            if(!"0.00".equals(orderTotalMoney)){
                paidTotalMoney = null!=moneys&&moneys.size()>0&&null!=moneys.get(0)[1]?moneys.get(0)[1].toString():"0.00";
                orderWaitMoney = MoneyUtil.moneySub(orderTotalMoney,paidTotalMoney);
            }
            bean.setPaidTotalMoney(paidTotalMoney);
            bean.setOrderWaitMoney(orderWaitMoney);
            bean.setOrderTotalMoney(orderTotalMoney);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getMoney",e);
            throw e;
        }
        return bean;
    }

    /**
     * @param session
     * @param orderMoneyBean
     * @Author zhangwen
     * @MethodName getList
     * @Params HttpSession session, ReqOrderMoneyBean orderMoneyBean
     * @Return PageResponseCommBean
     * @Date 2018/1/17 上午10:56
     * @Desp 获取订单收款统计列表
     */
    @Override
    public PageResponseCommBean getList(HttpSession session, ReqOrderMoneyBean orderMoneyBean) throws Exception{
        try {
            //1.封装查询与分页的sql
            String queryHql = "select new map(o.fCreatetime as orderTime,c.fName as consumerName,o.fOrderNum as orderNumber,o.fAmount as orderMoney,o.fOrderAmountPay as orderSupposedMoney,o.fPaidMoney as orderPaidMoney,o.fOrderAmountPay-o.fPaidMoney as orderWaitMoney,o.id as orderId ) ";
            RespLoginPCBean userInfo = (RespLoginPCBean) session.getAttribute("userInfo");
            long tCompanyId = userInfo.getfCompanyId();
            String sqlPart = this.getListSql(tCompanyId,orderMoneyBean);
            queryHql = queryHql+sqlPart;
            String countHql = "select count(*) " +sqlPart;
            PageBean bean = new PageBean();
            bean.setSize(orderMoneyBean.getSize());
            bean.setPage(orderMoneyBean.getPage());
            PageResponseCommBean cbean = commPageHqlService.getPage(queryHql,countHql,bean);
            return cbean;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getList ",e);
        }
        return null;
    }


    /**
     * @Author zhangwen
     * @MethodName getOrderMoneySql
     * @Params [companyId, orderMoneyBean]
     * @Return java.lang.String
     * @Date 2018/1/17 下午2:26
     * @Desp 获取订单全部金额与已支付金额的sql
     */
    private String getOrderMoneySql(long companyId,ReqOrderMoneyBean orderMoneyBean){
        StringBuffer sb = new StringBuffer();
        sb.append("select  sum(o.f_order_amount_pay) as orderTotalMoney,sum(o.f_paid_money) as paidTotalMoney from t_order o ");
        sb.append(" where o.f_company_id =  ");
        sb.append(companyId);
        sb.append(" and o.f_createtime BETWEEN '");
        sb.append(orderMoneyBean.getStartTime());
        sb.append("' and DATE_ADD('");
        sb.append(orderMoneyBean.getEndTime());
        sb.append("',INTERVAL 1 DAY)  ");
        if(!"all".equals(orderMoneyBean.getPayStatus())){
            if("unTotal".equals(orderMoneyBean.getPayStatus())){
                sb.append(" and o.f_pay_status in ('part','wait')");
            }else if("total".equals(orderMoneyBean.getPayStatus())){
                sb.append(" and o.f_pay_status = 'completed'");
            }
        }
        if(StringUtils.isNotBlank(orderMoneyBean.getSearchKey())){
            sb.append(" and o.f_search_key like '%");
            sb.append(orderMoneyBean.getSearchKey());
            sb.append("%' ");
        }
        return sb.toString();

    }

    /**
     * @Author zhangwen
     * @MethodName getListSql
     * @Params [companyId, orderMoneyBean]
     * @Return java.lang.String
     * @Date 2018/1/17 下午4:39
     * @Desp 拼接共同部分的hql
     */
    private String getListSql(long companyId,ReqOrderMoneyBean orderMoneyBean){
        StringBuffer sb = new StringBuffer();
        sb.append(" from TOrderEntity o,TConsumerInfoEntity c");
        sb.append(" where  o.fConsumerId = c.fId  and o.fCompanyId =  ");
        sb.append(companyId);
        sb.append(" and o.fCreatetime between '");
        sb.append(orderMoneyBean.getStartTime()+" 00:00:00 '");
        sb.append(" and '");
        sb.append(orderMoneyBean.getEndTime()+" 23:59:59 '");
        if(!"all".equals(orderMoneyBean.getPayStatus())){
            if("unTotal".equals(orderMoneyBean.getPayStatus())){
                sb.append(" and o.fPayStatus in ('part','wait')");
            }else if("total".equals(orderMoneyBean.getPayStatus())){
                sb.append(" and o.fPayStatus = 'completed'");
            }
        }
        if(StringUtils.isNotBlank(orderMoneyBean.getSearchKey())){
            sb.append(" and o.fSearchKey like '%");
            sb.append(orderMoneyBean.getSearchKey());
            sb.append("%' ");
        }
        return sb.toString();

    }


}
