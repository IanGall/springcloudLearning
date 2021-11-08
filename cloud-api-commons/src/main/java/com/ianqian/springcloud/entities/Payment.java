package com.ianqian.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author IanQian
 * @date 2021/11/7 13:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * ID
     */
    private Long id;

    private String serial;

    private static final long serialVersionUID = 1L;
}