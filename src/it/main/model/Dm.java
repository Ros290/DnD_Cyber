package it.main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: dm
 *
 */
@Entity
@Table(name = "dm")
public class Dm implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_dm")
	private int id;
	@Column(name = "name_dm")
	private String name;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "dm")
	private List<Adventure> listAdventures;
	
	public Dm () {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Adventure> getListAdventures(){
		return listAdventures;
	}
	
	public void setListAdventures(List<Adventure> listAdventures) {
		this.listAdventures = listAdventures;
	}
   
}
