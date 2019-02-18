package it.main.controller.character;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Character;
import it.main.utils.CharacterUtilsDAO;

/**
 * Servlet implementation class ReadCharacterServlet
 */
@WebServlet("/character-index")
public class ReadCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharacterUtilsDAO cdao = new CharacterUtilsDAO();
		List<Character> listCharacters = cdao.getListCharacters();
		request.setAttribute("listCharacters", listCharacters);
		request.getRequestDispatcher("/WEB-INF/view/character/index-character.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharacterUtilsDAO cdao = new CharacterUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_character"));
		Character character = cdao.findCharacter(id);
		request.setAttribute("character", character);
		request.getRequestDispatcher("/WEB-INF/view/character/show-character.jsp").forward(request, response);
	}
}
