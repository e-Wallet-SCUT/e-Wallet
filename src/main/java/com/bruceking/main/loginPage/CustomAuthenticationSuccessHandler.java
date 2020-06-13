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
        logger.info(authentication.getPrincipal().toString());
        logger.info(authentication.toString());
//        org.springframework.security.authentication.UsernamePasswordAuthenticationToken@42bfbbae: Principal: org.springframework.security.core.userdetails.User@6a68dc6: Username: user1; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_USER; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@43458: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: BBAB1F265C50578D0E8AB7B2A76F4CC4; Granted Authorities: ROLE_USER

        String  redirectUrl = "/"; //缺省的登陆成功页面
        SavedRequest savedRequest = (SavedRequest) httpServletRequest.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if(savedRequest != null) {
            redirectUrl =   savedRequest.getRedirectUrl();
            httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
        }
        httpServletResponse.sendRedirect(redirectUrl);

    }
}
