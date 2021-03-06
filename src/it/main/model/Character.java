package it.main.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Character
 *
 */
@Entity
@Table(name="pc")

public class Character implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_pc")
	private int id;
	@Column(name = "name_pc", length = 20)
	private String name;
	@ManyToOne
	@JoinColumn (name = "id_race")	
	private Race race;
	@ManyToOne
	@JoinColumn (name = "id_class")
	private CharacterClass charClass;
	@ManyToOne
	@JoinColumn (name = "id_player")
	private Player player;
	
	@ManyToMany
	@JoinTable(name = "party",
	        joinColumns = @JoinColumn(name = "id_pc"),
	        inverseJoinColumns = @JoinColumn(name = "id_adv")
	    )
	private List<Adventure> adventures = new ArrayList<Adventure>();
	private static final long serialVersionUID = 1L;

	public Character() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}   
	public CharacterClass getCharClass() {
		return this.charClass;
	}

	public void setCharClass(CharacterClass charClass) {
		this.charClass = charClass;
	}   
	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
   
	public List<Adventure> getListAdventures(){
		return adventures;
	}
	
	public void setListAdventures(List<Adventure> adventures) {
		this.adventures = adventures;
	}
}
