

import java.io.*;
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


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public register() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd1=request.getRequestDispatcher("register.jsp");
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("user");
			String pswd = request.getParameter("password");
			String sql = "insert into registration(user,password) values(?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root","root");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,pswd);
			ps.executeUpdate();
//			/out.println("Welcome!");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
