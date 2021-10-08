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
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idU;
@Column(length=100)
private String nom;
@Column(length=100)
private String prenom;
@Column(length=100)
private String login;
@Column(length=100)
private String password;
@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
private List<UserRole> userrole = new ArrayList<UserRole>();
public User() {
}
public int getIdU() {
	return idU;
}
public void setIdU(int idU) {
	this.idU = idU;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<UserRole> getUserrole() {
	return userrole;
}
public void setUserrole(List<UserRole> userrole) {
	this.userrole = userrole;
}

}
