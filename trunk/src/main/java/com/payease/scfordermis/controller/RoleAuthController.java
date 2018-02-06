package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.RespRoleMenusBean;
import com.payease.scfordermis.service.RoleAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午4:21
 **/
@RestController
@RequestMapping("/roleauth")
@Api(tags = {"首页-设置-角色权限-刘晓明"})
public class RoleAuthController {
    private static final Logger log = LoggerFactory.getLogger(RoleAuthController.class);

    @Autowired
    private RoleAuthService roleAuthService;

    @PostMapping(value = "savename")
    @ApiOperation(value = "角色名字修改",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色ID",paramType = "query",required = true),
            @ApiImplicitParam(name = "roleName",value = "角色名字: 若为“系统管理员” 会报错提示“角色名称不允许是系统管理员” ",paramType = "query",required = true)
    })
    public ResultBo savename(HttpSession session, Long roleId, String roleName) throws Exception{
        return roleAuthService.saveName(session, roleId, roleName);
//        ResultBo result = ResultBo.build();
//        return result;
    }


    @PostMapping(value = "saveauth")
    @ApiOperation(value = "角色权限修改",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色ID",paramType = "query",required = true),
            @ApiImplicitParam(name = "roleMenus",value = "菜单权限",paramType = "query",required = true)
    })
    public ResultBo saveauth(HttpSession session, Long roleId,String roleMenus) throws Exception{
        return roleAuthService.saveAuth(session, roleId, roleMenus);
//        ResultBo result = ResultBo.build();
//        return result;
    }

    @GetMapping(value = "authdetail")
    @ApiOperation(value = "角色权限明细",response = RespRoleMenusBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色ID",paramType = "query",required = true)
    })
    public ResultBo authdetail(HttpSession session, Long roleId) throws Exception{
        return roleAuthService.authDetail(session, roleId);
//        ResultBo result = ResultBo.build();
//        TRoleInfoEntity entity = new TRoleInfoEntity();
//        entity.setfMenus("1234556");
//
//        RespRoleMenusBean resp = new RespRoleMenusBean();
//        resp.setRoleMenus(entity.getfMenus());
//        result.setResultBody(resp);
//        return result;
    }

}
