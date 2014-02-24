
package be.bierhuis.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.bierhuis.services.BrouwerService;

@WebServlet("/brouwers.htm")
public class BrouwersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/brouwers.jsp";
	private final BrouwerService brouwerService = new BrouwerService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("brouwers", brouwerService.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
