package be.bierhuis.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.bierhuis.entities.Bier;
import be.bierhuis.services.BierService;

@WebServlet("/bierreservatie.htm")
public class BierReservatie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW="/WEB-INF/JSP/bierreservatie.jsp";
	private static final String REDIRECT_URL="/winkelwagen.htm";
	private final BierService bierService = new BierService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bierNr = Long.parseLong(request.getParameter("bierNr"));
		Bier bier = bierService.read(bierNr);
		if( bier != null){
			request.setAttribute("bier", bier);
			HttpSession session = request.getSession(false);
			if (session != null) {
				@SuppressWarnings("unchecked")
				Map<Long, Long> winkelwagen = (Map<Long, Long>) session.getAttribute("winkelwagen");
				if (winkelwagen != null) {
					request.setAttribute("aantalBakken", winkelwagen.get(bierNr));
				}
			}
		}else{
			request.setAttribute("fouten", Arrays.asList("Bier niet gevonden!"));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bierNr = Long.parseLong(request.getParameter("bierNr"));
		List<String> fouten = new ArrayList<>();
		try{
			long aantalBakken = Long.parseLong(request.getParameter("aantalBakken"));
			if( aantalBakken > 0){				
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Map<Long, Long> winkelwagen = (Map<Long, Long>) session.getAttribute("winkelwagen");
				if (winkelwagen == null) {
					winkelwagen = new ConcurrentHashMap<Long, Long>();
				}
				winkelwagen.put(bierNr, Long.parseLong(request.getParameter("aantalBakken")));
				session.setAttribute("winkelwagen", winkelwagen);
			}else{
				 fouten.add("aantal is ongeldig!");
			}
		}catch(NumberFormatException ex){
			fouten.add("aantal is ongeldig!");
		}
		if(fouten.isEmpty()){
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL));
		}else{
			request.setAttribute("fouten", fouten);
			request.setAttribute("bier", bierService.read(bierNr));
			request.getRequestDispatcher(VIEW).forward(request, response);		
		}
	}
}
