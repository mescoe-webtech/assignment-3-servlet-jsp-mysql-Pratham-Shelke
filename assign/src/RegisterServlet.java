

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phnumber=request.getParameter("phnumber");
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		System.out.println("1111");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/webass","PRATHAM","Pratham@123");
			//Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/webassuser","PRATHAM" , "Pratham@123");
			System.out.println("2222");
			
			Statement smt1=con1.createStatement();
			//Statement smt2=con2.createStatement();
			System.out.println("333333");
			int a=smt1.executeUpdate("INSERT INTO webassuser values(\""+username+"\",\""+name+"\",\""+email+"\",\""+phnumber+"\")");
			System.out.println("44444");
			if(a==1)
			{
				
				int b=smt1.executeUpdate("INSERT INTO users VALUES(\""+username+"\",\""+pass+"\")");
				System.out.println("User Successfully registered !!");
				response.sendRedirect("home.jsp");
			}
			else
			{
				System.out.println("Error : User already present or Database is down ");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
			
		}
	}

}
