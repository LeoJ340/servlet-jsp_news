package com.jsj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码过滤器
 */
@WebFilter(urlPatterns = "/*",initParams = { @WebInitParam(name = "CharacterEncoding", value = "UTF-8"),
        @WebInitParam(name = "ContentType", value = "text/html;charset=UTF-8") })
public class CharacterEncodingFilter implements Filter {

    private String characterEncoding;

    private String contentType;

    @Override
    public void init(FilterConfig filterConfig) {
        this.characterEncoding = filterConfig.getInitParameter("CharacterEncoding");
        this.contentType = filterConfig.getInitParameter("ContentType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(characterEncoding);
        response.setContentType(contentType);
        filterChain.doFilter(request,response);
    }
}
