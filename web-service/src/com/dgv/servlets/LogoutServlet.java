package com.dgv.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("Logout");
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			if (session.getAttribute("C" + customerId) != null) {
				session.setAttribute("C" + customerId, null);
			}
			session.invalidate();
		}
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("Response", "success");
		
		response.setContentType("application/json");
		response.getWriter().write(jsonObject.toString());
	}

}
