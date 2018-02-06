package com.payease.scfordermis.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加允许跨域
 */

public class CrossDomainInterceptor extends HttpServlet implements HandlerInterceptor {

	private static final long serialVersionUID = 1L;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpServletResponse resp = (HttpServletResponse) response;
    resp.setContentType("text/html; charset=UTF-8");
      String url = request.getHeader("Origin");
      if (!StringUtils.isEmpty(url)) {
          String val = response.getHeader("Access-Control-Allow-Origin");
          if (StringUtils.isEmpty(val)) {
              response.addHeader("Access-Control-Allow-Origin", url);
              response.addHeader("Access-Control-Allow-Credentials", "true");
              response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
          }
      }
      return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    return;
    
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    return;
  }

	 

}
