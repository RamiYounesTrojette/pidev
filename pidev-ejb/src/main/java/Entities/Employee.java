package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlRootElement
public class Employee  implements Serializable {
	
	private static long serialVersionUID = 1L;
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	
	/*public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//@OneToMany(mappedBy="employe")
	//private List<Commentaire> commentaires;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String photo;
	
	private String password;
	
	private int phone;
	
	private Date birthday;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		Employee.serialVersionUID = serialVersionUID;
	}
	@JsonBackReference
	public EvaluationSheet getEvaluationsheet() {
		return evaluationsheet;
	}
	public void setEvaluationsheet(EvaluationSheet evaluationsheet) {
		this.evaluationsheet = evaluationsheet;
	}
	private Boolean isActif;
	
	//@ManyToMany(mappedBy="Employees", cascade = CascadeType.ALL)
	//private Set<Team> Teams;
	
	@OneToOne private EvaluationSheet evaluationsheet;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonManagedReference
    private Rating rating;

	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Employee() {}
	
	
	public Employee(String firstname, String lastname, String email, String password, int phone, Date birthday,
			Boolean isActif, Role role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.isActif = isActif;
		this.role = role;
	}
	
	public Employee(int id, String firstname, String lastname, String email, String password, int phone, Date birthday,
			Boolean isActif, Role role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.isActif = isActif;
		this.role = role;
	}
	@XmlAttribute(name="id",required=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/*@XmlElement(name="teams")
	public Set<Team> getTeams() {
		return Teams;
	}

	public void setTeams(Set<Team> teams) {
		Teams = teams;
	}*/
	
	
	
	
}