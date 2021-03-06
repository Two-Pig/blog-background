package com.example.blog.serviceImpl;

import com.example.blog.config.GlobalConstant;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.config.exceptionHandle.UserException;
import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public String login(User user, HttpSession session) {

        User findUser = userMapper.queryUserByUserName(user.getUsername());
        if (findUser == null) {
            throw new UserException(ResultEnum.NOTFOUND_USER);
        }
        if (!user.getPassword().equals(findUser.getPassword())) {
            throw new UserException(ResultEnum.PASSWORD_ERROR);
        }
        String token = saveToken(session, findUser.getId(), GlobalConstant.TOKEN_MAX_AGE);
        return token;
    }

    @Override
    public Map queryUserByPage(Integer pageNo, Integer pageSize) {
        return queryUsersByPage(null, pageNo, pageSize);
    }

    @Override
    public Map queryUsersByPage(User user, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<List> list = userMapper.pageQuery(user, pageNo, pageSize);
        List<User> types = (List<User>) list.get(0);
        int totalNum = (int) list.get(1).get(0);
        map.put("users", types);
        map.put("totalNum", totalNum);
        return map;
    }

    @Override
    public Integer saveUser(User user) {
        LocalDateTime date= LocalDateTime.now();
        user.setCreateTime(date);
        return userMapper.insert(user);
    }

    public String saveToken(HttpSession session, int userId, int tokenMaxAge) {
        String token = UUID.randomUUID().toString().replace("-", "");
        session.setAttribute(token, userId);
        session.setMaxInactiveInterval(tokenMaxAge);
        return token;
    }
}
