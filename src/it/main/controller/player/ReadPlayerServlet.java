package it.main.controller.player;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Player;
import it.main.utils.PlayerUtilsDAO;

/**
 * Servlet implementation class ReadPlayerServlet
 */
@WebServlet("/player-index")
public class ReadPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		List<Player> listPlayers = pdao.getListPlayers();
		request.setAttribute("listPlayers", listPlayers);
		request.getRequestDispatcher("/WEB-INF/view/player/index-player.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_player"));
		Player player = pdao.findPlayer(id);
		request.setAttribute("player", player);
		request.getRequestDispatcher("/WEB-INF/view/player/show-player.jsp").forward(request, response);
	}

}
