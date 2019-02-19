package it.main.controller.character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Adventure;
import it.main.model.Character;
import it.main.model.CharacterClass;
import it.main.model.Player;
import it.main.model.Race;
import it.main.utils.AdvUtilsDAO;
import it.main.utils.CharClassUtilsDAO;
import it.main.utils.CharacterUtilsDAO;
import it.main.utils.PlayerUtilsDAO;
import it.main.utils.RaceUtilsDAO;

/**
 * Servlet implementation class UpdateCharacterServlet
 */
@WebServlet("/character-update")
public class UpdateCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharacterUtilsDAO cdao = new CharacterUtilsDAO();
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		RaceUtilsDAO rdao = new RaceUtilsDAO();
		AdvUtilsDAO adao = new AdvUtilsDAO();
		List<Player> listPlayers = pdao.getListPlayers();
		List<CharacterClass> listCharClasses = ccdao.getListCharacterClasses();
		List<Race> listRaces = rdao.getListRaces();
		List<Adventure> listAdventures = adao.getListAdv();
		request.setAttribute("listPlayers",listPlayers);
		request.setAttribute("listCharClasses", listCharClasses);
		request.setAttribute("listRaces", listRaces);
		int id = Integer.parseInt(request.getParameter("id_character"));
		Character character = cdao.findCharacter(id);
		listAdventures.removeAll(character.getListAdventures());
		request.setAttribute("listAdventures", listAdventures);
		request.setAttribute("character", character);
		request.getRequestDispatcher("/WEB-INF/view/character/update-character.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUtilsDAO pdao = new PlayerUtilsDAO();
		CharClassUtilsDAO ccdao = new CharClassUtilsDAO();
		RaceUtilsDAO rdao = new RaceUtilsDAO();
		CharacterUtilsDAO cdao = new CharacterUtilsDAO();
		AdvUtilsDAO adao = new AdvUtilsDAO();
		String name = request.getParameter("name_character");
		int idPlayer = Integer.parseInt(request.getParameter("id_player"));
		int idCharClass = Integer.parseInt(request.getParameter("id_charClass"));
		int idRace = Integer.parseInt(request.getParameter("id_race"));
		int idCharacter = Integer.parseInt(request.getParameter("id_character"));
		List<Adventure> listAdventures = cdao.findCharacter(idCharacter).getListAdventures();
		if (request.getParameterValues("addAdventures") != null) {
			String arrayIdAdventures [] = request.getParameterValues("addAdventures");
			int i = 0;
			try {
				while (true) {
					int idAdventure = Integer.parseInt(arrayIdAdventures[i]);
					Adventure adventure = adao.findAdv(idAdventure);
					listAdventures.add(adventure);
					++i;
				}
			}
			catch (IndexOutOfBoundsException e) {
			}
		}
		if (request.getParameterValues("removeAdventures") != null) {
			String arrayIdAdventures [] = request.getParameterValues("removeAdventures");
			int i = 0;
			try {
				while (true) {
					int idAdventure = Integer.parseInt(arrayIdAdventures[i]);
					Adventure adventure = adao.findAdv(idAdventure);
					listAdventures.remove(adventure);
					++i;
				}
			}
			catch (IndexOutOfBoundsException e) {
			}
		}
		Character character = new Character();
		character.setId(idCharacter);
		character.setName(name);
		character.setCharClass(ccdao.findCharacterClass(idCharClass));
		character.setRace(rdao.findRace(idRace));
		character.setPlayer(pdao.findPlayer(idPlayer));
		character.setListAdventures(listAdventures);
		try {
			cdao.newCharacter(character);
			String message = "SUCCESS : Character \"" + character.getName() + "\" has been updated into database!";
			request.setAttribute("SUCCESS", message);
		}
		catch(RollbackException e) {
			String message = e.getMessage();
			request.setAttribute("ERROR", message);
		}
		doGet(request, response);
	}

}
