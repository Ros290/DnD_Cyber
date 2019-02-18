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
 * Servlet implementation class CreateCharClassServlet
 */
@WebServlet("/char_class-create")
public class CreateCharClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/charClass/create-char_class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		CharacterClass cc = new CharacterClass();
		cc.setId(0);
		cc.setName(request.getParameter("name_charClass"));
		cc.setListCharacters(null);
		try {
			ccdao.newCharacterClass(cc);
			String message = "SUCCESS : Character Class \"" + cc.getName() + "\" has been created into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
