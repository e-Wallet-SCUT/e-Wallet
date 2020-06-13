package com.bruceking.main.loginPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");

        String  redirectUrl = "/"; //缺省的登陆成功页面
        SavedRequest savedRequest = (SavedRequest) httpServletRequest.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if(savedRequest != null) {
            redirectUrl =   savedRequest.getRedirectUrl();
            httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
        }
        httpServletResponse.sendRedirect(redirectUrl);

    }
}
