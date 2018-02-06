package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqEmpAccNumBean;
import com.payease.scfordermis.bo.requestBo.ReqEmpSaveBean;

import javax.servlet.http.HttpSession;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/15 下午1:55
 **/
public interface EmpAccNumService {

    ResultBo getEmpAccNumList(HttpSession session,ReqEmpAccNumBean reqEmpAccNumBean) throws Exception;

    ResultBo empDetail(Long employeeInfoId) throws Exception;

    ResultBo save(HttpSession session,ReqEmpSaveBean req) throws Exception;

    ResultBo deleteEmpAccNumById(HttpSession session,Long id) throws Exception;

    ResultBo authList(HttpSession session,Long employeeInfoId) throws Exception;

    ResultBo resetPwd(HttpSession session,Long employeeInfoId,String fPassword) throws Exception;

}
