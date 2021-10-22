package servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Confirmacion
 */
@WebServlet("/Confirmacion")
public class Confirmacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		
		if(sesion==null || sesion.getAttribute("usuario")==null) {
			response.sendRedirect("LogOut");
		}else {
			request.getRequestDispatcher("confirmacion.jsp").forward(request, response);
		}
	}

}
