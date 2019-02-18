package it.main.controller.dm;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Dm;
import it.main.utils.DmUtilsDAO;

/**
 * Servlet implementation class CreateDmServlet
 */
@WebServlet("/dm-create")
public class CreateDmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/dm/create-dm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUtilsDAO dmdao = new DmUtilsDAO();
		Dm dm = new Dm();
		dm.setId(0);
		dm.setName(request.getParameter("name_dm"));
		dm.setListAdventures(null);
		try {
			dmdao.newDm(dm);
			String message = "SUCCESS : DM \"" + dm.getName() + "\" has been added into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
