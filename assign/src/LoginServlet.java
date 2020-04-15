

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String u=request.getParameter("username");
		System.out.println(u);
		
		String p=request.getParameter("password");
		/*
		System.out.println(p);
		if(u.equals("admin"))
		{
		if(p.equals("1234"))
		{
			System.out.println("Login Successfull!!!!");
		}
		else
			System.out.println("Password Incorrect!!");
		}*/
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webass","PRATHAM","Pratham@123");
			
			Statement stmt= con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from users");
			boolean flag=false;
			
			
			while(rs.next())
			{
				//System.out.println(rs.getString("username")+ " "+rs.getString("password"));
				
				if(u.equals(rs.getString("username"))&& p.equals(rs.getString("password")))
				{
					System.out.println("Login Successful");
					flag=true;
					response.sendRedirect("home.jsp");
				}
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error caught!!!");
		}
	}

}
