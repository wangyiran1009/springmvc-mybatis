package cn.jxufe.web.util;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.wangyiran;
    public static String wangyiran = "wangyiran";
    
    public static String test = "test";
}
