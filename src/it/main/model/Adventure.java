package it.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adventure
 *
 */
@Entity
@Table(name = "adventure")
public class Adventure implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_adv")
	private int id;
	@Column(name = "name_adv", length = 20)
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_dm")
	private Dm dm;
	
	@ManyToMany (mappedBy = "adventures")
	List<Character> party = new ArrayList<Character>();
	
		
	public Adventure() {
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
	
	public Dm getDm() {
		return dm;
	}
	
	public void setDm (Dm dm) {
		this.dm = dm;
	}
	
	public List<Character> getParty(){
		return party;
	}
	
	public void setParty(List<Character> party) {
		this.party = party;
	}
	
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adventure)) return false;
        Adventure that = (Adventure) o;
        return getId() == that.getId();
    }
   
}
