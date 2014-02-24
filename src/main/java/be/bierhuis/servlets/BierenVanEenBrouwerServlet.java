package be.bierhuis.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.bierhuis.entities.Brouwer;
import be.bierhuis.services.BrouwerService;

@WebServlet("/bierenvaneenbrouwer.htm")
public class BierenVanEenBrouwerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bierenvaneenbrouwer.jsp";
	private final BrouwerService brouwerService = new BrouwerService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long brouwerNr = Long.parseLong(request.getParameter("brouwerNr"));
		Brouwer brouwer = brouwerService.read(brouwerNr);
		if( brouwer != null){
			request.setAttribute("brouwer", brouwer);
		}else{
			request.setAttribute("fouten", Arrays.asList("Brouwer niet gevonden!"));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
