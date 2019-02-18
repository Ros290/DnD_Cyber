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
 * Servlet implementation class DeleteDmServlet
 */
@WebServlet("/dm-delete")
public class DeleteDmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUtilsDAO dmdao = new DmUtilsDAO();
		int id = Integer.parseInt(request.getParameter("id_dm"));
		Dm dm = dmdao.findDm(id);
		try{
			dmdao.removeDm(dm);
			String message = "SUCCESS : DM \"" + dm.getName() + "\" has been deleted from database!";
			request.setAttribute("SUCCESS", message);
		}
		catch (RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		request.getRequestDispatcher("dm-index").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
