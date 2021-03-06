package com.my.count.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/02/24/11:14 PM
 * @Description: 要做耿沁园的男人
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;
    /**
     * 成功返回结果
     *
     * @param message
     */
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }
    /**
     * 成功返回结果
     *
     * @param obj
     * @param message
     */
    public static RespBean success(String message, Object obj) {
        return new RespBean(200, message, obj);
    }
    /**
     * 失败返回结果
     *
     * @param message
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }
    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message,Object obj) {
        return new RespBean(500, message, obj);
    }
}
