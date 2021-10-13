package iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("destino") != null) {

			if (request.getParameter("destino").equals("A")) {
				//response.sendRedirect("a.jsp");
				request.setAttribute("usuario", "pepe");
				
				
				request.getRequestDispatcher("a.jsp").forward(request, response);

			} else if (request.getParameter("destino").equals("B")) {
				//response.sendRedirect("b.jsp");

				request.setAttribute("usuario", "admin");
				request.getRequestDispatcher("b.jsp").forward(request, response);
				
			} else {
				//response.sendRedirect("error.jsp");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
