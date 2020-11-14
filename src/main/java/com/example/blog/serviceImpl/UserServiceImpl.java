package com.example.blog.serviceImpl;

import com.example.blog.config.GlobalConstant;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.config.exceptionHandle.UserException;
import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
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

    public String saveToken(HttpSession session, int userId, int tokenMaxAge) {
        String token = UUID.randomUUID().toString().replace("-", "");
        session.setAttribute(token, userId);
        session.setMaxInactiveInterval(tokenMaxAge);
        return token;
    }
}
