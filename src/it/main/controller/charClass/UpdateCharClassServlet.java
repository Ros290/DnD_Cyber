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
 * Servlet implementation class UpdateCharClassServlet
 */
@WebServlet("/char_class-update")
public class UpdateCharClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_charClass"));
		CharacterClass cc = ccdao.findCharacterClass(id);
		request.setAttribute("charClass", cc);
		request.getRequestDispatcher("/WEB-INF/view/charClass/update-char_class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		CharacterClass cc = new CharacterClass();
		cc.setId(Integer.parseInt(request.getParameter("id_charClass")));
		cc.setName(request.getParameter("name_charClass"));
		cc.setListCharacters(ccdao.findCharacterClass(cc.getId()).getListCharacters());
		try {
			ccdao.newCharacterClass(cc);
			String message = "SUCCESS : Character Class \"" + cc.getName() + "\" has been updated into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
