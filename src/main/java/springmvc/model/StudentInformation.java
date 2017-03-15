package springmvc.model;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "student_information")

public class StudentInformation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	private String cin;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	private String email;
	
	private String gender;
	
	private Date dob;
	
	private String Citizenship;
	
	@Column(name = "international_student")
	private int internationalStudent; //0 for no, 1 for yes
	
	//////////////////////////////////////////////////////////
	/*@OneToOne (targetEntity = Users.class,cascade = CascadeType.ALL)
	private Users user;*/
	
	
	@OneToMany(targetEntity = EducationalBackground.class)
	private List <EducationalBackground> educationalBackground;
	
	@OneToOne(targetEntity = Applications.class)
	private Applications applications;
	
	@OneToOne(targetEntity = AcademicRecord.class)
	private AcademicRecord academics;
	
	public AcademicRecord getAcademics() {
		return academics;
	}

	public void setAcademics(AcademicRecord academics) {
		this.academics = academics;
	}
	
	public List<EducationalBackground> getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(List<EducationalBackground> educationalBackground) {
		this.educationalBackground = educationalBackground;
	}

	
	public Applications getApplications() {
		return applications;
	}

	public void setApplications(Applications applications) {
		this.applications = applications;
	}

	//////////////////////////////////////////////////////////
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	public String getCitizenship() {
		return Citizenship;
	}

	public void setCitizenship(String citizenship) {
		Citizenship = citizenship;
	}

	public int getInternationalStudent() {
		return internationalStudent;
	}

	public void setInternationalStudent(int internationalStudent) {
		this.internationalStudent = internationalStudent;
	}
/*
	public List<EducationalBackground> getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(List<EducationalBackground> educationalBackground) {
		this.educationalBackground = educationalBackground;
	}
*//*
	public List<Applications> getApplications() {
		return applications;
	}

	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}*/

	/*public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}*/
	
	
}
