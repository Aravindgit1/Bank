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
 * Servlet implementation class passchange
 */
@WebServlet("/passchange")
public class passchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passchange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String s=request.getParameter("mail");
		String p1=request.getParameter("pwd");
		String s1="";
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			Statement st=con.createStatement();
			String sql1="select password from bankapp1 where email='"+s+"'";
			ResultSet r=st.executeQuery(sql1);
			if(r.next()){
				s1=r.getString(1);
			
			
				
			String sql="update bankapp1 set password='"+p1+"' where email='"+s+"'";
			int i=st.executeUpdate(sql);
			if(i>0){
				response.sendRedirect("http://localhost:8065/Bank_App/changepass.jsp");
			}}
			else{
				response.setContentType("text/html");
				
				p.println("Enter your correct mail");
				RequestDispatcher rd=request.getRequestDispatcher("/pass.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.println(e);
		}
	}

}
