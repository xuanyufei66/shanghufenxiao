package com.payease.scfordermis.utils;

import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import org.springframework.data.domain.Page;

/**
 * Created by zhangzhili on 2018/1/19.
 */
public class PageUtil {

    public static PageResponseCommBean createPageResponseCommBean(Page page){
        PageResponseCommBean pageResponseCommBean = new PageResponseCommBean();
        pageResponseCommBean.setTotalPages(page.getTotalPages());
        pageResponseCommBean.setSize(page.getSize());
        pageResponseCommBean.setNumber(page.getNumber());
        pageResponseCommBean.setTotalElements((int)page.getTotalElements());
        return pageResponseCommBean;
    }
}
