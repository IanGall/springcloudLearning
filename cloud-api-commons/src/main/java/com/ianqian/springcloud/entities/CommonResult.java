package com.ianqian.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author IanQian
 * @date 2021/11/7 12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static CommonResult fail(Integer code, String msg) {
        return new CommonResult(code, msg, null);
    }

    public static CommonResult success() {
        return new CommonResult(200, "成功", null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "成功", data);
    }
}
