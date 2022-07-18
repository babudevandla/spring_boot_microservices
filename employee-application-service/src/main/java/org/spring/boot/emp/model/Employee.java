package org.spring.boot.emp.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee  implements Serializable {

	public Employee() {

	}

	public Employee(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	private Integer id;
	
	@NotEmpty(message = "first name must not be empty")
    private String firstName;
 
    @NotEmpty(message = "last name must not be empty")
    private String lastName;
 
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ",lastName=" + lastName + ", email=" + email + "]";
    }

}
