package com.wutengcoding.mvcapp.servlet;

import com.wutengcoding.mvcapp.dao.CriteriaCustomer;
import com.wutengcoding.mvcapp.dao.CustomerDAO;
import com.wutengcoding.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.wutengcoding.mvcapp.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by wuteng on 2017/5/18.
 */
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1, servletPath.length() - 3);
        System.out.println(methodName);
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        CriteriaCustomer c = new CriteriaCustomer(name, address, phone);
//        List<Customer> customerList = customerDAO.getAll();

        List<Customer> customerList = customerDAO.getForListWithCriteriaCustomer(c);
        request.setAttribute("customers", customerList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete");
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
