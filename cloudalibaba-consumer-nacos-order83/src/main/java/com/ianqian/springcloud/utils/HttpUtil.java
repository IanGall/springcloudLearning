package com.ianqian.springcloud.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Http工具类
 *
 * @author IanQian
 * @date 2021/10/28
 */
@Component
@Slf4j
public class HttpUtil {

    private static RestTemplate restTemplate;

    // /**
    //  * 发送POST请求
    //  *
    //  * @param url        请求url
    //  * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
    //  * @return 指定的返回类型
    //  */
    // public static <T> T doPostByJson(String url, Class<T> returnType) {
    //     return doPostByJson(url, null, returnType);
    // }

    /**
     * 发送POST请求
     *
     * @param url        请求url
     * @param data       发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static <T, E> T doPostByJson(String url, E data, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_JSON, returnType);
    }

    /**
     * 发送POST请求
     *
     * @param url        请求url
     * @param data       发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static <T> T doPostByFormData(String url, MultiValueMap<String, String> data, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_FORM_URLENCODED, returnType);
    }

    /**
     * 发送GET请求
     *
     * @param url   请求url
     * @param clazz 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static <T> T doGet(String url, Class<T> clazz) {
        log.info("GET_REQUEST: {}, {}", url, clazz.getName());

        T result = restTemplate.getForObject(url, clazz);
        log.info("GET_RESPONSE: {}", result);

        return result;
    }

    /**
     * 发送POST请求
     *
     * @param url         请求url
     * @param data        发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param requestType 请求头类型
     * @param returnType  返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static <T, E> T doPost(String url, E data, MediaType requestType, Class<T> returnType) {
        log.info("POST_REQUEST: {}, {}, {}, {}", url, data, requestType, returnType.getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(requestType);
        HttpEntity<E> entity = new HttpEntity<>(data, headers);

        T result = restTemplate.postForObject(url, entity, returnType);

        log.info("POST_RESPONSE: {}", result);
        return result;
    }

    public static RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        HttpUtil.restTemplate = restTemplate;
    }
}