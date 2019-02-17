package it.main.model;

import java.io.Serializable;
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
	
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adventure)) return false;
        Adventure that = (Adventure) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDm(), that.getDm());
    }
   
}
