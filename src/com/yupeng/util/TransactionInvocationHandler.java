package com.yupeng.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yupeng
 * @create 2020-12-21 22:06
 */
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try {
            session = SqlSessionUtil.getSession();
            // 处理业务逻辑
            obj = method.invoke(target, args);
            // 处理业务逻辑完毕后，提交事务
            session.commit();
        } catch (Exception exception) {
            session.rollback();
            exception.printStackTrace();
        } finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
