package com.wutengcoding.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * Created by wuteng on 2017/5/9.
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("HelloServlet's constructor");
    }
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        String user = servletConfig.getInitParameter("user");
        System.out.println(user);

        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("-->name: " + name + ", value = " + value);
        }

        System.out.println("************");
        ServletContext servletContext = servletConfig.getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println("**> name: " + name + ", value = " + value);
        }

        String realPath = servletContext.getRealPath("/index.jsp");
        System.out.println("the file  path is " + realPath);

        String contextPath = servletContext.getContextPath();
        System.out.println("The contextPath is " + contextPath);

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        System.out.println("1: " + is);

        //相对于app根目录的路径
        InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        System.out.println("2: " + is2);
    }

    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
