package servidor.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PASSWORD_REGEX =
	        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
	private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(PASSWORD_REGEX);
	final static Logger logger = Logger.getLogger(Inicio.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew()) {
			sesion.setMaxInactiveInterval(300);
			if(password.equals(confPassword) && 
					PASSWORD_PATTERN.matcher(password).matches() && 
					PASSWORD_PATTERN.matcher(confPassword).matches()) {
				
				sesion.setAttribute("usuario", request.getParameter("usuario"));
				
				Date date = new Date();
				date.setTime(sesion.getCreationTime());
				sesion.setAttribute("horaLogin", new SimpleDateFormat().format(date));
				System.out.println("creando la sesion");
				response.sendRedirect("Reservar");
			}else {
				logger.info("Las contraseñas no son validad");
				response.sendRedirect("Logout");
			}
		}else {
			logger.info("Error: Intenta logear ya estando logeado");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
