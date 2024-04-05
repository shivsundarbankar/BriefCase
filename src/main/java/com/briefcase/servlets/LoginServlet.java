package com.briefcase.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briefcase.dao.UserDao;
import com.briefcase.entities.User;
import com.briefcase.helper.FactoryProvider;

/**
 * Servlet implementation class LoginServlet
 */

@MultipartConfig
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			//authenticate the user
			UserDao userDao = new UserDao(FactoryProvider.getFactory());
			User user = userDao.getUserByEmailAndPassword(email, password);
			
			HttpSession session = request.getSession();
			if(user==null) {
				
				session.setAttribute("message", "Invalid Credentials!");
				response.sendRedirect("login.jsp");
				return;
			}else {
				
				session.setAttribute("current-user", user);
				
				if(user.getRole().equals("admin")) {
					response.sendRedirect("admin.jsp");
				}else if(user.getRole().equals("normal")) {
					response.sendRedirect("normal.jsp");
				}else {
					out.println("We have not identified user role");
				}
			}
		}
	}
	
}
