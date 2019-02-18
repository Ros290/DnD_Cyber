package it.main.controller.player;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Player;
import it.main.utils.PlayerUtilsDAO;

/**
 * Servlet implementation class DeletePlayerServlet
 */
@WebServlet("/player-delete")
public class DeletePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_player"));
		Player player = pdao.findPlayer(id);
		try {
			pdao.removePlayer(player);
			String message = "SUCCESS : Player \"" + player.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("player-index").include(request, response);
	}
}
