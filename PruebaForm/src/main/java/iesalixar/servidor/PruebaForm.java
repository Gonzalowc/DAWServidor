package iesalixar.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaForm
 */
public class PruebaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Login</title><head>");
		out.println("<body>");
		out.println("<p><h1>LOGIN</h1></p>");

		out.println("<form method=\"post\">");
		out.println("<label for=\"Usuario\">Usuario:</label><input id=\"usuario\" type=\"text\" name=\"usuario\"><br>");
		out.println(
				"<label for=\"password\">Password:</label><input id=\"pass\" type=\"password\" name=\"pass\"><br>");
		out.println("<button type=\"submit\" name=\"submit\">Enviar</button>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration paramEnumeration = request.getParameterNames();
		boolean usuario = false;
		boolean pass = false;
		if(!paramEnumeration.hasMoreElements()) {
			out.println("No hay Elementos");
		}else {
			while(paramEnumeration.hasMoreElements()) {
				String param = (String) paramEnumeration.nextElement();
				if(param.equals("usuario")) {
					if("admin".equals(request.getParameter(param))) {
						usuario = true;
					}
				}else {
					if(param.equals("pass")) {
						if("admin".equals(request.getParameter(param))) {
							pass= true;
						}
					}
				}
			}
		}
		if(usuario && pass) {
			out.println("<h1>Has iniciado sesion</h1>");
		}else {
			doGet(request,response);
		}
	}
}
