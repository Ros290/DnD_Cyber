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
import it.main.utils.DmUtilsDAO;

/**
 * Servlet implementation class UpdateAdventureController
 */
@WebServlet("/adventure-update")
public class UpdateAdventureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvUtilsDAO adao = new AdvUtilsDAO();
		DmUtilsDAO dmdao = new DmUtilsDAO();
		int idAdv = Integer.parseInt(request.getParameter("id_adv"));
		Adventure adv = adao.findAdv(idAdv);
		request.setAttribute("adv", adv);
		request.setAttribute("listDm", dmdao.getListDm());
		request.getRequestDispatcher("/WEB-INF/view/adventure/update-adv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUtilsDAO dmdao = new DmUtilsDAO();
		AdvUtilsDAO adao = new AdvUtilsDAO();
		Adventure adv = new Adventure();
		adv.setId(Integer.parseInt(request.getParameter("id_adv")));
		adv.setName(request.getParameter("name_adv"));
		adv.setDm(dmdao.findDm(Integer.parseInt(request.getParameter("id_dm"))));
		try {
			adao.newAdv(adv);
			String message = "SUCCESS : Adventure \"" + adv.getName() + "\" has been updated into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.setAttribute("id_adv", adv.getId());
		doGet(request, response);
	}

}
