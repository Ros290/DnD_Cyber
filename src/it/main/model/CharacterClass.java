package it.main.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import it.main.model.Character;

/**
 * Entity implementation class for Entity: CharacterClass
 *
 */
@Entity
@Table(name="class")

public class CharacterClass implements Serializable {

	   
	@Id
	@Column (name = "id_class")
	private int id;
	@Column (name = "name_class", length = 15)
	private String name;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "charClass")
	private List<Character> listCharacters;
	private static final long serialVersionUID = 1L;

	public CharacterClass() {
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
