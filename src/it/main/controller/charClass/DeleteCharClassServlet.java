package it.main.controller.charClass;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.CharacterClass;
import it.main.utils.CharClassUtilsDAO;

/**
 * Servlet implementation class DeleteCharClassServlet
 */
@WebServlet("/char_class-delete")
public class DeleteCharClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_charClass"));
		CharacterClass charClass = ccdao.findCharacterClass(id);
		try {
			ccdao.removeCharacterClass(charClass);
			String message = "SUCCESS : Character Class \"" + charClass.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("char_class-index").include(request, response);

	}

}
