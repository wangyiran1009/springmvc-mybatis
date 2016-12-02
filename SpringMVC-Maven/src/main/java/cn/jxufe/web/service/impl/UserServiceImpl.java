package cn.jxufe.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxufe.web.dao.UserMapper;
import cn.jxufe.web.entity.User;
import cn.jxufe.web.service.UserService;
import cn.jxufe.web.util.DataSource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired  
    private UserMapper mapper;
    
    @DataSource(name=DataSource.wangyiran)
    public void saveUser() {
        User user = new User("lisi8888", new Integer(25));
        mapper.insertUser(user);
    }

}
