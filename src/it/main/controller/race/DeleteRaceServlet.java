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
 * Servlet implementation class DeleteraceServlet
 */
@WebServlet("/race-delete")
public class DeleteRaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaceUtilsDAO pdao = new RaceUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_race"));
		Race race = pdao.findRace(id);
		try {
			pdao.removeRace(race);
			String message = "SUCCESS : Race \"" + race.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("race-index").include(request, response);
	}
}
