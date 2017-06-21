package com.dgv.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.Customer;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long paramter = Long.parseLong(request.getParameter("Login"));
		long customerId = getCustomerId(paramter);
			
		if (customerId != -1L) {
			HttpSession session = request.getSession();
			session.setAttribute("C" + customerId, customerId);	
			
			JsonObject object = new JsonObject();
			object.addProperty("Response", customerId);
			
			response.setContentType("application/json");
			response.getWriter().write(object.toString());
		} else {
			JsonObject object = new JsonObject();
			object.addProperty("Response", customerId);
			
			response.setContentType("application/json");
			response.getWriter().write(object.toString());
		}
	}
	
	long getCustomerId (long customerId) {
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId", Customer.class);
		query.setParameter("customerId", customerId);
		
		try {
			Customer c = query.getSingleResult();
			return c.getCustomerId();
		} catch (NoResultException e) {
			return -1L;
		} finally {
			entityManager.close();
		}
	}

}
