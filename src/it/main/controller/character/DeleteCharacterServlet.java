package it.main.controller.character;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Character;
import it.main.utils.CharacterUtilsDAO;

/**
 * Servlet implementation class DeleteCharacterServlet
 */
@WebServlet("/character-delete")
public class DeleteCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharacterUtilsDAO cdao = new CharacterUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_character"));
		Character character = cdao.findCharacter(id);
		try {
			cdao.removeCharacter(character);
			String message = "SUCCESS : Character \"" + character.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("character-index").include(request, response);
	}

}
