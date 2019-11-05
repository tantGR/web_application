
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("user");
			String pswd = request.getParameter("password");
			String dbname = null;
			String dbpswd = null;
			String sql = "select * from registration where user=? & password=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root","root");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,pswd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dbname = rs.getString(1);
				dbpswd = rs.getString(2);
			}
			if(name.equals(dbname) && pswd.equals(dbpswd)){
				out.println("Log in successful!");
			}
			else {
				//response.sendRedirect("index.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			
			
		} 
		catch (ClassNotFoundException e) {
			out.println("error 1");
			e.printStackTrace();
		} catch (SQLException e) {
			out.println("error 2");
			e.printStackTrace();
		}
	
	}

}
