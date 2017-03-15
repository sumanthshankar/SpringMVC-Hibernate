package springmvc.model;

//students_info and user_role classes include this


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "users")

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	 @Column(name = "last_name")
	 private String lastName;
	
	 @Column(name = "first_name")
	 private String firstName;
	
	 @Column(name = "email_id")
	 private String email;
	
	 private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserRole role;
	
	@OneToMany
	private List<StudentInformation> studentsInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<StudentInformation> getStudentsInfo() {
		return studentsInfo;
	}

	public void setStudentsInfo(List<StudentInformation> studentsInfo) {
		this.studentsInfo = studentsInfo;
	}

	
	
}
