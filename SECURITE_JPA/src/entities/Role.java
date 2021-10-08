package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idR;
	@Column(length=100)
	private String libR;
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
	private List<UserRole> userrole = new ArrayList<UserRole>();
	public 	Role() {
		
	}
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public String getLibR() {
		return libR;
	}
	public void setLibR(String libR) {
		this.libR = libR;
	}
	public List<UserRole> getUserrole() {
		return userrole;
	}
	public void setUserrole(List<UserRole> userrole) {
		this.userrole = userrole;
	}
	
}


