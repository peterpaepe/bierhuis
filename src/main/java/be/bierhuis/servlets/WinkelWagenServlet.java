package be.bierhuis.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.bierhuis.entities.BestelBon;
import be.bierhuis.entities.Bier;
import be.bierhuis.services.BestelBonService;
import be.bierhuis.services.BierService;
import be.bierhuis.valueobjects.Adres;
import be.bierhuis.valueobjects.BestelBonLijn;

@WebServlet("/winkelwagen.htm")
public class WinkelWagenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW="/WEB-INF/JSP/winkelwagen.jsp";
	private static final String REDIRECT_URL="/bevestiging.htm";
	private final BierService bierService = new BierService();
	private final BestelBonService bestelbonService = new BestelBonService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			ConcurrentHashMap<Long, Long> winkelwagen = (ConcurrentHashMap<Long, Long>) session.getAttribute("winkelwagen");
			if (winkelwagen != null) {
				Set<Long> bierNrs = winkelwagen.keySet();
				Set<BestelBonLijn> bestelbonlijnen = new HashSet<>();
				for(Long bierNr : bierNrs){
					Bier bier = bierService.read(bierNr);
					long aantalBakken = winkelwagen.get(bierNr);
					BestelBonLijn bestelbonlijn = new BestelBonLijn(bier, aantalBakken);
					bestelbonlijnen.add(bestelbonlijn);
				}
				BestelBon bestelbon = new BestelBon(bestelbonlijnen);
				request.setAttribute("bestelbon", bestelbon);
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> fouten = new HashMap<>();
		BestelBon bestelBon = new BestelBon();
		
		if (request.getParameter("naam").isEmpty()) {
			fouten.put("naam", "Naam niet ingevuld!");
		} else {
			bestelBon.setNaam(request.getParameter("naam").toString());
		}
		
		if( request.getParameter("straat").isEmpty() ||
				request.getParameter("huisnr").isEmpty() ||
				request.getParameter("postcode").isEmpty() ||
				request.getParameter("gemeente").isEmpty() 
			){
			if (request.getParameter("straat").isEmpty()) {
				fouten.put("straat", "Straat niet ingevuld!");
			}
			if (request.getParameter("huisnr").isEmpty()) {
				fouten.put("huisnr", "Huisnr. niet ingevuld!");
			}
			if (request.getParameter("postcode").isEmpty()) {
				fouten.put("postcode", "Postcode niet ingevuld!");
			}
			if (request.getParameter("gemeente").isEmpty()) {
				fouten.put("gemeente", "Gemeente niet ingevuld!");
			}
		}
		bestelBon.setAdres(new Adres(request.getParameter("straat").toString(),
				request.getParameter("huisnr").toString(),
				Integer.parseInt(request.getParameter("postcode").toString()),
				request.getParameter("gemeente").toString()));
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			ConcurrentHashMap<Long, Long> winkelwagen = (ConcurrentHashMap<Long, Long>) session.getAttribute("winkelwagen");
			if (winkelwagen != null) {
				Set<Long> bierNrs = winkelwagen.keySet();
				for(Long biernr : bierNrs){
					Bier bier = bierService.read(biernr);
					long aantalBakken = winkelwagen.get(biernr);
					BestelBonLijn bestelbonlijn = new BestelBonLijn(bier, aantalBakken);
					bestelBon.addBestelbonlijnen(bestelbonlijn);
				}
			}
		}		
		if (!fouten.isEmpty()) {
			request.setAttribute("fouten", fouten);			
			request.setAttribute("bestelbon", bestelBon);
			request.getRequestDispatcher(VIEW).forward(request, response);
		} else {
			if (session != null) {
				bestelbonService.create(bestelBon);
				session.invalidate();
				response.sendRedirect(response.encodeRedirectURL(request
						.getContextPath()
						+ REDIRECT_URL
						+ "?bestelbonnr="
						+ bestelBon.getBonNr()));
			}
		}
	}

}
