package com.jsj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求编码过滤器
 */
@WebFilter(urlPatterns = "/*",initParams = { @WebInitParam(name = "CharacterEncoding", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {

    private String characterEncoding;

    @Override
    public void init(FilterConfig filterConfig) {
        this.characterEncoding = filterConfig.getInitParameter("CharacterEncoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding(characterEncoding);
        filterChain.doFilter(request,servletResponse);
    }
}
