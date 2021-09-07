package com.java.api.filters;

import com.java.api.models.TokenInfo;
import com.java.api.service.AuthTokenServiceImpl;
import com.java.api.service.IAuthTokenService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter implements Filter {

    private IAuthTokenService authTokenService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        authTokenService = AuthTokenServiceImpl.getInstance();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        TokenInfo tokenInfo = authTokenService.validateToken(token);
        if(tokenInfo!=null) {
            System.out.println("logged in user: "+tokenInfo.getEmail());
            chain.doFilter(request, response);
        }
        else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(401);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
