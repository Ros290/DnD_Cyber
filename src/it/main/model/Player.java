package it.main.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
@Table (name = "player")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_player")
	private int id;
	@Column (name = "name_player", length = 15)
	private String name;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "player")
	private List<Character> listCharacters;
	
	public Player() {
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
	
	public List<Character> getListCharacters(){
		return listCharacters;
	}
	
	public void setListCharacters(List<Character> listCharacters) {
		this.listCharacters = listCharacters;
	}
}
