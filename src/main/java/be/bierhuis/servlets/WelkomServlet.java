package be.bierhuis.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.bierhuis.services.BierService;

@WebServlet("/welkom.htm")
public class WelkomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW="/WEB-INF/JSP/welkom.jsp";
	private final BierService bierService = new BierService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("aantalbieren", bierService.findAantalBieren());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
