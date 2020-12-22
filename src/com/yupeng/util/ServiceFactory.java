package com.yupeng.util;

/**
 * @author Yupeng
 * @create 2020-12-21 22:25
 */
public class ServiceFactory {
    /**
     *
     * @param service 目标对象
     * @return 代理对象
     */
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
