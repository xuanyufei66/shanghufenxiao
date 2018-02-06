package com.payease.scfordermis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wangshaowu on 2018/1/30.
 */
public class PayCode {
    public static String payCode(){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        return date+"00001000"+getTwo()+"00"+seconds+getTwo();

    }
    /**
     * 产生随机的2位数
     * @return
     */
    public static String getTwo(){
        Random rad=new Random();
        String result  = rad.nextInt(100) +"";
        if(result.length()==1){
            result = "0" + result;
        }
        return result;
    }
}
