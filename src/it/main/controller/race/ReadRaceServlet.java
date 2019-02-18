package it.main.controller.race;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Race;
import it.main.utils.RaceUtilsDAO;

/**
 * Servlet implementation class ReadRaceServlet
 */
@WebServlet("/race-index")
public class ReadRaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaceUtilsDAO rdao = new RaceUtilsDAO();
		List<Race> listRaces = rdao.getListRaces();
		request.setAttribute("listRaces", listRaces);
		request.getRequestDispatcher("/WEB-INF/view/race/index-race.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaceUtilsDAO rdao = new RaceUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_race"));
		Race race = rdao.findRace(id);
		request.setAttribute("race", race);
		request.getRequestDispatcher("/WEB-INF/view/race/show-race.jsp").forward(request, response);
	}
}
