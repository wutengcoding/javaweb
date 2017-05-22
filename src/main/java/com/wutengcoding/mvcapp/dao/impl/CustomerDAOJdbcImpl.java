package com.wutengcoding.mvcapp.dao.impl;

import com.wutengcoding.mvcapp.dao.CriteriaCustomer;
import com.wutengcoding.mvcapp.dao.CustomerDAO;
import com.wutengcoding.mvcapp.dao.DAO;
import com.wutengcoding.mvcapp.domain.Customer;

import java.util.List;

/**
 * Created by wuteng on 2017/5/17.
 */
public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

    public CustomerDAOJdbcImpl() {
        System.out.println("CustomerDAOJdbcImpl constructor");
    }

    public static void main(String[] args) {
        CustomerDAOJdbcImpl customerDAOJdbc = new CustomerDAOJdbcImpl();
//        Customer c = new Customer();
//        c.setAddress("wuhan");
//        c.setPhone("17720510659");
//        c.setName("liuwen");
//
//        customerDAOJdbc.save(c);

//        List<Customer> all = customerDAOJdbc.getAll();
//        System.out.println(all);

        CriteriaCustomer c = new CriteriaCustomer("g", null, null);
        List<Customer> customerList = customerDAOJdbc.getForListWithCriteriaCustomer(c);
        System.out.println(customerList);


    }

    @Override
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer) {

        String sql = "SELECT id, name, address, phone FROM customers WHERE " +
                "name LIKE ? AND address LIKE ? AND phone LIKE ?";
        return getForList(sql, criteriaCustomer.getName(),
                criteriaCustomer.getAddress(), criteriaCustomer.getPhone());
    }

    public List<Customer> getAll() {
        String sql = "SELECT id, name, address, phone FROM customers";
        return getForList(sql);
    }

    public Customer get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        update(sql, id);
    }

    @Override
    public <E> E getForValue(String sql, Object... args) {
        return super.getForValue(sql, args);
    }

    @Override
    public List<Customer> getForList(String sql, Object... args) {
        return super.getForList(sql, args);
    }

    @Override
    public Customer get(String sql, Object... args) {
        return super.get(sql, args);
    }

    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customers(name, address, phone) VALUES(?, ?, ?)";
        update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
    }

    public long getCountWithName(String name) {
        String sql = "SELECT COUNT(id) FROM customers WHERE name = ?";
        return getForValue(sql, name);
    }
}
