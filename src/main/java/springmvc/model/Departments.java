package springmvc.model;
//no classes is linked

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Departments implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	/*@OneToMany
	private List<Programs> program;*/
	
	/*@OneToMany
	private List<AdditionalFields> additionalFields;
*/
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


	
	/*public List<Programs> getProgram() {
		return program;
	}

	public void setProgram(List<Programs> program) {
		this.program = program;
	}*/

	/*public List<AdditionalFields> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(List<AdditionalFields> additionalFields) {
		this.additionalFields = additionalFields;
	}
	*/
	
}
