package it.main.controller.charClass;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.CharacterClass;
import it.main.utils.CharClassUtilsDAO;

/**
 * Servlet implementation class ReadCharClassServlet
 */
@WebServlet("/char_class-index")
public class ReadCharClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO rdao = new CharClassUtilsDAO();
		List<CharacterClass> listCharClasses = rdao.getListCharacterClasses();
		request.setAttribute("listCharClasses", listCharClasses);
		request.getRequestDispatcher("/WEB-INF/view/charClass/index-char_class.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharClassUtilsDAO rdao = new CharClassUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_charClass"));
		CharacterClass charClass = rdao.findCharacterClass(id);
		request.setAttribute("charClass", charClass);
		request.getRequestDispatcher("/WEB-INF/view/charClass/show-char_class.jsp").forward(request, response);
	}
}
