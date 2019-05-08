package kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessService.LogInMetode;
import model.Admin;
import model.User;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet(description = "ovo je servlet za login", urlPatterns = { "/LogInServlet" })
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		LogInMetode metode = new LogInMetode();
		
if(metode.daLiPostojiUser(userName)) {
			
			if(metode.daLiJeDobarPassword(userName, password)) {
				User user = metode.vratiUsera(userName, password);
				if( user!= null) {
					
					HttpSession sesija = request.getSession();
					sesija.setAttribute("ovdeCuvamUsera", user);
					
					Admin admin = new Admin();
					
					if(userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {
						response.sendRedirect("jsp/admin.jsp");
					}else {
						response.sendRedirect("jsp/user.jsp");
					}
					
				}else {
					response.sendRedirect("loginError.html");
				}
			}else {
				response.sendRedirect("loginError.html");
			}
				
		}else {
			response.sendRedirect("loginError.html");
		}
		
		
	}

}