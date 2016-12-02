package cn.jxufe.web.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.jxufe.web.entity.User;

@CacheNamespace//二级缓存，相当配xml文件中的 <cache/>
public interface UserMapper {
    //用注解就不可以不用配置UserMapper.xml文件
    @Insert("INSERT INTO user (name, age) VALUES (#{name}, #{age} )")
    public void insertUser(User user);
    @Select("select * from user where name=#{name}")
    @Results({
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age"),
       })
    @Options(useCache=false)//当前select查询禁用二级缓存
    public User getUser(String name);
}
