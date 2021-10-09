package com.erha.crmtest.util;

/**
 * @ClassNameServiceFactory
 * @Description TODO
 * @Author DELL
 * @Date 2021/10/815:43
 * @Version 1.0
 **/
public class ServiceFactory {

    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
