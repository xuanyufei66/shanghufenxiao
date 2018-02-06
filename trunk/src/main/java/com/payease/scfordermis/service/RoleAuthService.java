package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;

import javax.servlet.http.HttpSession;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/15 下午1:55
 **/
public interface RoleAuthService {

      ResultBo saveName(HttpSession session, Long roleId, String roleName) throws Exception;

      ResultBo saveAuth(HttpSession session, Long roleId,String roleMenus) throws Exception;

      ResultBo authDetail(HttpSession session, Long roleId) throws Exception;
}
