package com.baizhi.cache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Set;

/**
 *
 *  执行增删改清除该模块所有的redis缓存
 *
 */
@Component
public class FlushRedisCacheAdvice implements MethodInterceptor {


    @Autowired
    private RedisTemplate redisTemplate;


    public Object invoke(MethodInvocation invocation) throws Throwable {
        //调用业务方法
        try {
            Object proceed = invocation.proceed();//执行增删改

            if(!invocation.getMethod().isAnnotationPresent(Cache.class)){
                //生成key
                StringBuilder key = new StringBuilder();
                //类的名称
                String className = invocation.getThis().getClass().getName();//当前类

                key.append(DigestUtils.md5DigestAsHex(className.getBytes())).append("*");// key ："类名的MD5*"

                Set<String> keys = redisTemplate.keys(key.toString());

                redisTemplate.delete(keys);
            }
            return  proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return null;
    }
}



