package it.main.controller.adventure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.utils.AdvUtilsDAO;

/**
 * Servlet implementation class Adventure
 */
@WebServlet("/adventure-index")
public class ReadAdventureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvUtilsDAO adao = new AdvUtilsDAO();
		request.setAttribute("listAdv", adao.getListAdv());
		request.getRequestDispatcher("/WEB-INF/view/adventure/index-adv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
