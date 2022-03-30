
package acc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginapp")
public class loginapp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginapp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		Long m=Long.parseLong(request.getParameter("mobile"));
		boolean alive=true;
		String s=request.getParameter("pwd");
		HttpSession ses=request.getSession(true);
		ses.setAttribute("pwd", s);
		ses.setAttribute("alive", alive);
		try {
			DriverManager.registerDriver(new OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			Statement st=con.createStatement();
			String sql="select * from bankapp1 where mobile="+m+"and password='"+s+"'";
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()){
			
				
				response.sendRedirect("http://localhost:8065/Bank_App/welcome.jsp");
				
			}
			else{
				response.setContentType("text/html");
				pw.println("Invalid username or password");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				rd.include(request,response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pw.println(e);
			e.printStackTrace();
		}
	}

}
