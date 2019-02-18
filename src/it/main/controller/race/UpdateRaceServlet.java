package it.main.controller.race;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Race;
import it.main.utils.RaceUtilsDAO;

/**
 * Servlet implementation class UpdateraceServet
 */
@WebServlet("/race-update")
public class UpdateRaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaceUtilsDAO pdao = new RaceUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_race"));
		Race race = pdao.findRace(id);
		request.setAttribute("race", race);
		request.getRequestDispatcher("/WEB-INF/view/race/update-race.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaceUtilsDAO pdao = new RaceUtilsDAO();
		Race race = new Race();
		race.setId(Integer.parseInt(request.getParameter("id_race")));
		race.setName(request.getParameter("name_race"));
		race.setListCharacters(pdao.findRace(race.getId()).getListCharacters());
		try {
			pdao.newRace(race);
			String message = "SUCCESS : race \"" + race.getName() + "\" has been updated into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
