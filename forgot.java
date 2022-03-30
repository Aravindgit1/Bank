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

import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class forgot
 */
@WebServlet("/forgot")
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		Long l=Long.parseLong(request.getParameter("mobile"));
		String s=request.getParameter("mail");
		try {
			DriverManager.registerDriver(new OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			Statement st=con.createStatement();
			String sql="select * from bankapp1 where email='"+s+"' and mobile="+l;
			ResultSet r=st.executeQuery(sql);
			if(r.next()){
				response.sendRedirect("http://localhost:8065/Bank_App/welcome.html");
				
			}
			else{
				response.setContentType("text/html");
				p.println("You have entered invalid mail or number");
				RequestDispatcher rd=request.getRequestDispatcher("/for.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			p.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
