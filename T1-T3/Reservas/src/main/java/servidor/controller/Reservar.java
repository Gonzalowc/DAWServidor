package servidor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import servidor.model.Reserva;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Main.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if(sesion!=null) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
		}else {
			//quiere entrar sin logearse
			response.sendRedirect("Logout");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		
		if(sesion!=null) {
			System.out.println("Haciendo reserva");
			String fechaInicio = request.getParameter("fInicio");
			String fechaFin = request.getParameter("fFin");
			int numPersonas = Integer.parseInt(request.getParameter("NPersonas"));
			ArrayList<String> servicios = new ArrayList<String>(Arrays.asList(request.getParameterValues("servicios")));
			Reserva reserva = new Reserva();
			reserva.setfInicio(fechaInicio);
			reserva.setfFin(fechaFin);
			reserva.setNPersonas(numPersonas);
			reserva.setServicios(servicios);
			
			sesion.setAttribute("reserva", reserva);
			
			response.sendRedirect("Confirmar");
			
		}else {
			logger.info("Intenta entrar en la vista sin permiso");
			response.sendRedirect("Logout");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
