package filter;

import javax.servlet.*;
import java.io.IOException;


public class CharsetFilter implements Filter {
    public void destroy() {
        System.out.println("-----------------------destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("uft-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("-----------------------inital");

    }

}
