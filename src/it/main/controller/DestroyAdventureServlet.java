package it.main.controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Adventure;
import it.main.utils.AdvUtilsDAO;

/**
 * Servlet implementation class DestroyAdventureServlet
 */
@WebServlet("/adventure-destroy")
public class DestroyAdventureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvUtilsDAO adao = new AdvUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_adv"));
		Adventure adv = adao.findAdv(id);
		try {
			adao.removeAdv(adv);
			String message = "SUCCESS : Adventure \"" + adv.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("adventure-index").include(request, response);
	}
}
