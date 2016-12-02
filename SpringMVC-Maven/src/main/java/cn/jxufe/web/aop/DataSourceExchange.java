package cn.jxufe.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import cn.jxufe.web.util.DataSource;
import cn.jxufe.web.util.DbContextHolder;

public class DataSourceExchange implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        DataSource dataSource = invocation.getMethod().getAnnotation(DataSource.class);
        if(dataSource!=null){
            DbContextHolder.putDataSourceName(dataSource.name());
        }
        return invocation.proceed();
    }
}
