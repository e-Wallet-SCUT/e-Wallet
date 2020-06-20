package com.bruceking.main.loginPage;

import com.bruceking.redis.redisComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("CustomAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private com.bruceking.redis.redisComponent redisComponent;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String[] detail2List = authentication.getDetails().toString().split(": ");
        String sessionID = detail2List[detail2List.length-1];
        logger.info(sessionID);
        redisComponent.setSet(sessionID,600,authentication.getName());
        logger.info(redisComponent.getSet(sessionID).toString());

        String  redirectUrl = "/"; //缺省的登陆成功页面
        SavedRequest savedRequest = (SavedRequest) httpServletRequest.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if(savedRequest != null) {
            logger.info(savedRequest.getRedirectUrl());
            redirectUrl =   savedRequest.getRedirectUrl();
            httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
        }
//        String requestReferer = httpServletRequest.getHeader("Referer");
//        logger.info(httpServletRequest.getRequestURI());
//        logger.info(requestReferer);
//        logger.info(String.valueOf(httpServletRequest.getSession().getAttributeNames()));
//        if (requestReferer!=null){
//            redirectUrl = requestReferer;
//        }
        httpServletResponse.sendRedirect(redirectUrl);

    }
}
