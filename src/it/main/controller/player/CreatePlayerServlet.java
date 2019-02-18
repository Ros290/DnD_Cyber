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
 * Servlet implementation class CreatePlayerServlet
 */
@WebServlet("/player-create")
public class CreatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/player/create-player.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		Player player = new Player();
		player.setId(0);
		player.setName(request.getParameter("name_player"));
		player.setListCharacters(null);
		try {
			pdao.newPlayer(player);
			String message = "SUCCESS : Player \"" + player.getName() + "\" has been added into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
