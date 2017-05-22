package com.wutengcoding.mvcapp.dao;

import com.wutengcoding.mvcapp.domain.Customer;

import java.util.List;

/**
 * Created by wuteng on 2017/5/17.
 */
public interface CustomerDAO {

    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer);

    public List<Customer> getAll();

    public void save(Customer customer);

    public Customer get(Integer id);

    public void delete(Integer id);

    public long getCountWithName(String name);
}
