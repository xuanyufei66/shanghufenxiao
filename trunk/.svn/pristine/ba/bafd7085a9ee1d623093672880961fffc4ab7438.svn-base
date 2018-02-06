package com.payease.scfordermis.utils;

/**
 * Created by lch on 2018/1/18.
 * <p>
 * 订单号，运单号生成工具类
 */
public class OrderNumUtil {

    public static final String TRANSPORT_NUM = "100001";//运单号代码
    public static final String ORDER_NUM = "100002";//订单号代码

    /**
     * 运单号（运单号代码+年月日时分秒+8位随机数）
     *
     * @return
     */
    public static String getTransportNum() {
        return OrderNumUtil.TRANSPORT_NUM + DateUtil.formatNow() + RandomUtil.RandomNumber(8);
    }

    /**
     * 订单号（订单号代码+年月日时分秒+8位随机数）
     *
     * @return
     */
    public static String getOrderNum() {
        return OrderNumUtil.ORDER_NUM + DateUtil.formatNow() + RandomUtil.RandomNumber(8);
    }
}
