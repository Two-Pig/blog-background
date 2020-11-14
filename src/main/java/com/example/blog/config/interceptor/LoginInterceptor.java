package com.example.blog.config.interceptor;

import com.example.blog.config.GlobalConstant;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.config.exceptionHandle.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(request.getRequestURI());
        final String token = request.getHeader(GlobalConstant.TOKEN_NAME);
        //token为空，一定没登陆
        //token不为空,不一定登录,还要看服务器中token是否有效
        if (token == null) {
            throw new UserException(ResultEnum.NOT_LOGIN);
        } else {
            HttpSession session = request.getSession();
            Object tokenValue = session.getAttribute("token");
            if (tokenValue == null) {
                throw new UserException(ResultEnum.NOT_LOGIN);
            }
        }
        return true;
    }

    /**
     * 被拦截的函数执行之后才会执行该函数
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
