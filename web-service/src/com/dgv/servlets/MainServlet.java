package com.dgv.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.setups.EntityCreation;
import com.dgv.tests.Test;
import com.google.gson.JsonObject;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }  


	@Override
	public void init(ServletConfig config) throws ServletException {
		JPAEntityManagerFactory.createEntityManagerFactory();
		
		EntityCreation.setupDB();
		Test.addCustomer();
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("Request");
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("C" + customerId) != null) {
			
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("CustomerId", "" + session.getAttribute("C" + customerId));
				
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
		} else {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("CustomerId", "" + -1L);
				
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
		}	
	}
	

	@Override
	public void destroy() {
		JPAEntityManagerFactory.getEntityManagerFactory().close();
	}

}
