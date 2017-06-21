package com.baizhi.cache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;


@Component
public class RedisCacheAdvice implements MethodInterceptor {


    @Autowired
    private RedisTemplate redisTemplate;

    public Object invoke(MethodInvocation invocation) throws Throwable {

        //生成key
        StringBuilder key = new StringBuilder();

        //类的名称
        String className = invocation.getThis().getClass().getName();
        key.append(DigestUtils.md5DigestAsHex(className.getBytes()));  //key :  "类名的MD5"

        //方法签名
        Method method = invocation.getMethod();
        String methodName = method.getName(); //方法签名  com。baizhi。service。BannerServiceImpl.queryAll(Integer row,Integer page)


        //方法的参数
        Object[] arguments = invocation.getArguments();  //方法的参数 实际参数列表  2   1
        if(arguments!=null && arguments.length!=0){
            for (int i = 0; i < arguments.length; i++) {
                Object argument = arguments[i];
                methodName += argument.toString();
            }
        }
        key.append("-");  // key： "类名的MD5" +"-"
        key.append(DigestUtils.md5DigestAsHex(methodName.getBytes()));// key： "类名的MD5" +"-" +"（方法名+参数）的MD5 "

        ValueOperations valueOperations = redisTemplate.opsForValue();
        //检查是否存在缓存
        if(valueOperations.get(key.toString())!=null){
            return valueOperations.get(key.toString());
        }else{
            //不存在加入缓存
            System.out.println(invocation.getMethod().isAnnotationPresent(Cache.class));
            if(invocation.getMethod().isAnnotationPresent(Cache.class)){
                //执行目标方法
                Object proceed = invocation.proceed();
                //根据可以放入redis中
                valueOperations.set(key.toString(),proceed );
                return proceed;
            }
        }
        return  invocation.proceed();
    }
}
