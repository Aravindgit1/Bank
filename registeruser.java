package acc;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class registeruser
 */
@WebServlet("/registeruser")
public class registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registeruser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int i=0;
		try{
		String name=request.getParameter("name");
		 String m1=request.getParameter("mobile");
		 String a1=request.getParameter("adhar");
		String mail=request.getParameter("email");
		String pas=request.getParameter("pwd");
		Long m=Long.parseLong(m1);
		Long a=Long.parseLong(a1);
		
		int bal=0;
		
			DriverManager.registerDriver(new OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			PreparedStatement pt=con.prepareStatement("insert into bankapp1 values(?,?,?,?,?,?)");
			pt.setString(1, name);
			pt.setLong(2, m);
			pt.setLong(3, a);
			pt.setString(4, mail);
			pt.setInt(5, bal);
			pt.setString(6, pas);
			 i=pt.executeUpdate();
			 if(i>0){
				 response.setContentType("text/html");
					RequestDispatcher rd=request.getRequestDispatcher("/registersucess.jsp");
					rd.forward(request,response);
				}
				else{
					response.setContentType("text/html");
					pw.println("invalid user details");
					RequestDispatcher rd=request.getRequestDispatcher("/register.html");
					rd.include(request, response);
					
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("aravind"+e);

	
	}
		
		

}}
