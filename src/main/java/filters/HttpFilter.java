package filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/11/19
 */
public abstract class HttpFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        doFilter(request, response, filterChain);
    }

    public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException, IOException;

    @Override
    public void destroy() {

    }

    protected void init(){

    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }
}
