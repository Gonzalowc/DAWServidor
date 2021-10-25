package servidor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Seleccionar
 */
@WebServlet("/Seleccionar")
public class Seleccionar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Seleccionar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion!=null && sesion.getAttribute("usuario") == null) {
			response.sendRedirect("LogOut");
		}else {
			request.getRequestDispatcher("seleccionar.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("usuario") != null) {
			String usuario = request.getParameter("usuario");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String correo = request.getParameter("correo");
			String curso = request.getParameter("curso");
			String[] modulos = request.getParameterValues("modulos");
			sesion.setAttribute("nombre", nombre);
			sesion.setAttribute("apellidos", apellidos);
			sesion.setAttribute("correo", correo);
			sesion.setAttribute("modulos",Arrays.toString(modulos));
			Cookie cursoCookie = new Cookie("curso", curso);
			response.addCookie(cursoCookie);
			
			Usuario user = new Usuario();
			System.out.println(sesion.getAttribute("usuario")+" "+usuario);
			user.setUsuario((String)sesion.getAttribute("usuario"));
			user.setNombre(nombre);
			user.setApellidos(apellidos);
			user.setCorreo(correo);
			user.setCurso(curso);
			user.setModulos(new ArrayList<String>(Arrays.asList(modulos)));
			System.out.println(user);
			sesion.setAttribute("userBean",user);
			response.sendRedirect("Confirmacion");
		}else {
			response.sendRedirect("LogOut");
		}

	}
}
