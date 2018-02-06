package com.payease.scfordermis.utils;

import java.util.Arrays;

/**
 * @Author : zhangwen
 * @Data : 2018/1/15
 * @Description :
 */
public class ArrayUtil {

    /**
     * @Author zhangwen
     * @MethodName isContains
     * @Params [arr, targetValue]
     * @Return boolean
     * @Date 2018/1/15 下午3:31
     * @Desp 判断数组中是否含有某个key
     */
    public static boolean isContains(String[] arr,String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }
}
