package com.uni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.ICustomerDAO;
import com.uni.models.CustomerData;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDAO dao;
	@Override
	public List<CustomerData> getAllCustomer() {
		// TODO Auto-generated method stub
		return (List<CustomerData>) dao.findAll();
	}

}
