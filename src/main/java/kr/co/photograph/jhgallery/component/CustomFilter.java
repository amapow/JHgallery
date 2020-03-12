package kr.co.photograph.jhgallery.component;
//
//import lombok.AllArgsConstructor;
//import org.apache.catalina.core.ApplicationContext;
//import org.apache.tomcat.util.http.SameSiteCookies;
//import org.hibernate.query.criteria.internal.expression.ConcatExpression;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;
//import org.springframework.stereotype.Component;
//
//@Component
//@AllArgsConstructor
//public class SameSiteInjector {
//
//    private final ApplicationContext applicationContext;
//
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        DefaultCookieSerializer cookieSerializer = applicationContext.
//        cookieSerializer.setSameSite("None");
//    }
//}


import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse)response;
        resp.setHeader("Set-Cookie", "locale=kr; HttpOnly; SameSite=None");
        chain.doFilter(request, response);
    }
}
