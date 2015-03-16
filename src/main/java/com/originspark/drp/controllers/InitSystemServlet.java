package com.originspark.drp.controllers;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.originspark.drp.authority.RoleEnum;
import com.originspark.drp.util.AuthUtil;


public class InitSystemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("------------------------系统正在初始化...-----------------------------");
//        final String controllerPackageName = "com.originspark.drp.controllers";
//        Map<RoleEnum,Set<String>> auths = AuthUtil.initAuth(controllerPackageName);
//        System.out.println(auths);
//        this.getServletContext().setAttribute("auths", auths);
        System.out.println("------------------------系统初始化成功-----------------------------");
    }

}
