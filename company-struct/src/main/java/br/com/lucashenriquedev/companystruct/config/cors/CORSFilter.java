package br.com.lucashenriquedev.companystruct.config.cors;

import br.com.lucashenriquedev.companystruct.config.security.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

    @Autowired
    private SecurityProperties properties;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (properties.getAdminUi().getUrl().equals("*")) {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        } else {
            response.setHeader("Access-Control-Allow-Origin", properties.getAdminUi().getUrl());
        }

        if (("OPTIONS").equals(request.getMethod())
                && (properties.getAdminUi().getUrl().equals(request.getHeader("Origin"))
                || properties.getAdminUi().getUrl().equals("*"))) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, PATCH, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
