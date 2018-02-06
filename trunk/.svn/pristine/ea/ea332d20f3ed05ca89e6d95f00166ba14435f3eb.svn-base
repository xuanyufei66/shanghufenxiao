package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.*;
import com.payease.scfordermis.bo.requestBo.ReqTransportAddBo;
import com.payease.scfordermis.bo.requestBo.ReqTransportBo;
import com.payease.scfordermis.bo.requestBo.ReqTransportInfoBo;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.bo.responseBo.RespOperationLogBo;
import com.payease.scfordermis.bo.responseBo.RespGoodsBo;
import com.payease.scfordermis.bo.responseBo.RespTransportDetailBo;
import com.payease.scfordermis.entity.TTransportOrderEntity;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YHF on 2018/1/10.
 */
public interface TransportService {

    /**
     * 运单列表查询
     * @param respLoginPCBean
     * @param reqTransportBo
     * @return
     */
    ResultBo transportListSelect(RespLoginPCBean respLoginPCBean, ReqTransportBo reqTransportBo); //运单列表

    /**
     * 运单新增或修改
     * @param respLoginPCBean
     * @param reqTransportAddBo
     * @return
     */
    boolean transportSave(RespLoginPCBean respLoginPCBean ,ReqTransportAddBo reqTransportAddBo);

    /**
     * 运单删除
     * @param respLoginPCBean
     * @param transportNum
     * @param transportStatus
     * @return
     */
    boolean transportDelete(RespLoginPCBean respLoginPCBean,String transportNum,String transportStatus);

    /**
     * 运单详情
     * @param respLoginPCBean
     * @param transportId
     * @return
     */
    RespTransportDetailBo transportDetail(RespLoginPCBean respLoginPCBean,String transportId);

    /**
     * 运输信息 修改
     * @param respLoginPCBean
     * @param reqTransportInfoBo
     * @return
     */
    boolean transportInfoUpdate(RespLoginPCBean respLoginPCBean,ReqTransportInfoBo reqTransportInfoBo);

    /**
     * 备注信息 修改
     * @param respLoginPCBean
     * @param transportId
     * @param remarkContent
     * @return
     */
    boolean transportRemarkInfoUpdate(RespLoginPCBean respLoginPCBean,String transportId,String remarkContent);

    /**
     * 装车按钮接口／与运输完成接口
     * @param respLoginPCBean
     * @param transportOrderId
     * @param transportStatus
     * @return
     */

    boolean load(RespLoginPCBean respLoginPCBean,String transportOrderId,String transportStatus);
    List<RespOperationLogBo> noteSelect(String transportId);

    /**
     * 商品列表查询  每个商品的规格都是列表项，入参为商品编码/商品名称
     * @param respLoginPCBean
     * @return
     */
    List<RespGoodsBo> getGoods(RespLoginPCBean respLoginPCBean);
    boolean deleteGoods(String transportdetailid);//判断是否可以删除商品
    TTransportOrderEntity findTramsById(long fid);//根据运单id获取运单实体
}
