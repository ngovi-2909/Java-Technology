package tdtu.edu.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" ,unique = true)
	private Integer id;
	private String name;
	private String email;
	private String password;
	public User() {}
	public User(String name, String email, String password) 
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User(int id, String name, String email, String password) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
