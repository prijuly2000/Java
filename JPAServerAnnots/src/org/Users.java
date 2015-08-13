package org;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQueries({
		@NamedQuery(name="getAllEmails",query="select email from Users user"),
		@NamedQuery(name="getUserData",query="select object(User) from Users user where user.userName=:name")
})
public class Users
{
	@Id
	@Column(name="username")
		String userName;
	@Column(name="password")
		String password;
	@Column(name="name")
		String name;
	@Column(name="email")
		String email;
	
	public Users()
	{}

	public Users(String username, String password, String name, String email)
	{
		super();
		this.userName = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUsername()
	{
		return userName;
	}

	public void setUsername(String username)
	{
		this.userName = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	

}
