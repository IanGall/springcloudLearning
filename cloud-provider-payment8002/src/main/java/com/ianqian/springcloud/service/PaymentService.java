package com.ianqian.springcloud.service;

import com.ianqian.springcloud.entities.Payment;

/**
* @author  IanQian
* @date  2021/11/7 13:02
*/
public interface PaymentService{


int deleteByPrimaryKey(Long id);

int insert(Payment record);

int insertSelective(Payment record);

Payment selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Payment record);

int updateByPrimaryKey(Payment record);

}
