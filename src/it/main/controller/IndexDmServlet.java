package it.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Dm;
import it.main.utils.DmUtilsDAO;

/**
 * Servlet implementation class DmServlet
 */
@WebServlet("/dm-index")
public class IndexDmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUtilsDAO dmdao = new DmUtilsDAO();
		List<Dm> listDm = dmdao.getListDm();
		request.setAttribute("listDm", listDm);
		request.getRequestDispatcher("/WEB-INF/view/dm/index-dm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUtilsDAO dmdao = new DmUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_dm"));
		Dm dm = dmdao.findDm(id);
		request.setAttribute("dm", dm);
		request.getRequestDispatcher("/WEB-INF/view/dm/show-dm.jsp").forward(request, response);
	}

}
