package acc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

/**
 * Servlet Filter implementation class fil1
 */
@WebFilter("/registeruser")
public class fil1 implements Filter {

    private static final String RequestDispatcher = null;

	/**
     * Default constructor. 
     */
    public fil1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String m=request.getParameter("mobile");
		String a=request.getParameter("adhar");
		String mail=request.getParameter("email");
		String pass=request.getParameter("pwd");
		if(m.length()==10&&a.length()==12){
		
		chain.doFilter(request, response);
		}
		else{
			response.setContentType("text/html");
			pw.println("invalid number or adhar");
			RequestDispatcher rd=request.getRequestDispatcher("/registersucess.jsp");
			rd.forward(request,response);
		}}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
