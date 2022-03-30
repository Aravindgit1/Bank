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
 * Servlet implementation class myprofile
 */
@WebServlet("/myprofile")
public class myprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession ses=request.getSession();
	PrintWriter pw=response.getWriter();
	String s=(String) ses.getAttribute("pwd");
	try {
		DriverManager.registerDriver(new OracleDriver());
	Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	Statement st=con.createStatement();
	String sql="select * from bankapp1 where password=+'"+s+"'";
	ResultSet rs=st.executeQuery(sql);
	if(rs.next()){
		String name=rs.getString(1);
		Long mobile=rs.getLong(2);
		Long adhar=rs.getLong(3);
		String mail=rs.getString(4);
		int bal=rs.getInt(5);
		String password=rs.getString(6);
		ses.setAttribute("nmd", name);
		ses.setAttribute("mob", mobile);
		ses.setAttribute("adh", adhar);
		ses.setAttribute("mail", mail);
		ses.setAttribute("bal", bal);
		ses.setAttribute("pass", password);
		response.sendRedirect("http://localhost:8065/Bank_App/viewdetails.jsp");
		
	}
	else{
		response.setContentType("text/html");
		
		pw.println("invalid Password or mobile");
		RequestDispatcher rd=request.getRequestDispatcher("/login.html");
		rd.include(request,response);
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		pw.println(e+s);
	}
		
		
	}

}
