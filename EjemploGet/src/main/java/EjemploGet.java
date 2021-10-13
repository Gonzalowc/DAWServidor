

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploGet
 */
@WebServlet("/EjemploGet")
public class EjemploGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int numParams = 0;
		
		out.println("<html>");
		out.println("<head><title>Ejemplo de gestión de peticiones GET desde el ServLet</title></head>");
		out.println("<body>");
		
		Enumeration paramEnumeration = request.getParameterNames();
		
		if(!paramEnumeration.hasMoreElements()) {
			out.println("<p><a href=\"?modulo=servidor&profesor=Gonzalo Waack Carneado\">Pincha Aqui</a></p>");
		}else{
			out.print("<ul>");
			while(paramEnumeration.hasMoreElements()) {
				String param = (String) paramEnumeration.nextElement();
				out.write("<li>He recibido parámetro "+param+" con valor "+request.getParameter(param)+"</li>");
				
			}
			out.print("</ul>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
