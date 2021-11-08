package com.ianqian.springcloud.dao;

import com.ianqian.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author IanQian
 * @date 2021/11/7 13:02
 */
@Mapper
public interface PaymentMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Payment record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Payment record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Payment selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Payment record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Payment record);
}