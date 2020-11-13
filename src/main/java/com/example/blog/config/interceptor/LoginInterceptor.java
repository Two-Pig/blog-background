package com.example.blog.config.interceptor;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    /*@Autowired
    private RedisService redisService;
    @Value("${server.port}")
    private String port;
    @Value("${currentIp}")
    private String currentIp;
    //前端登陆页面url
    private String loginUrl = String.format("%s:%s/", currentIp, port);
*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器出发了。。。" + request.getRequestURL());
//        String localAddr = request.getLocalAddr();
//        System.out.println(localAddr);
//        //多用户可能的token列表
//        List<String> tokens = Arrays.asList("adminToken", "studentToken", "teacherToken");
//
//        String token = "";
//        for (String tokenFlag :
//                tokens) {
//            //在cookie中查找token
//            token = CookieUtil.getCookie(request, tokenFlag);
///*
//            CookieUtil.printCookie(request);
//*/
//            //在header中找token(这个是为了使用postman调试时找到token)
//            String token2 = request.getHeader(tokenFlag);
//            if (token2 != null) {
//                token = token2;
//            }
//            if (!Strings.isEmpty(token)) {
//                break;
//            }
//        }
//
//        //token为空，一定没登陆
//        //token不为空,不一定登录
//
//        if (token != null && !token.isEmpty()) {
//            String userId = redisService.get(token);
//            if (userId == null || token.isEmpty()) {
//                //重定向到前端的登陆页面
//                response.sendRedirect(loginUrl);
//                return false;
//            }
//        } else {
//            response.sendRedirect("/");
//            return false;
//        }
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

        System.out.println("postHandle...");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
