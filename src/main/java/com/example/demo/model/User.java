package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

	public User() {}
	public User(User user) {
	    this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountIsExpired = user.isAccountIsExpired();
        this.credIsLocked = user.isCredIsLocked();
        this.accountIsLocked = user.isAccountIsLocked();
        this.roles = user.getRoles();
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@Column(name="username")
private String userName;

@Column(name="password")
private String password;

@Column(name="email")
private String email;

@Column(name="enabled")
private boolean enabled;

@Column(name="accountnonexpired")
private boolean accountIsExpired;

@Column(name="credentialsnonexpired")
private boolean credIsLocked;

@Column(name="accountnonlocked")
private boolean accountIsLocked;

@ManyToMany(fetch=FetchType.EAGER)
@JoinTable(
		name="role_user",joinColumns= {@JoinColumn(name="user_id", referencedColumnName="id")}
		,inverseJoinColumns= {@JoinColumn(name="role_id",referencedColumnName="id")}
)
private List<Role> roles;

/**
 * @return the id
 */
public Integer getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}
/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the enabled
 */
public boolean isEnabled() {
	return enabled;
}
/**
 * @param enabled the enabled to set
 */
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
/**
 * @return the accountIsExpired
 */
public boolean isAccountIsExpired() {
	return accountIsExpired;
}
/**
 * @param accountIsExpired the accountIsExpired to set
 */
public void setAccountIsExpired(boolean accountIsExpired) {
	this.accountIsExpired = accountIsExpired;
}
/**
 * @return the credIsLocked
 */
public boolean isCredIsLocked() {
	return credIsLocked;
}
/**
 * @param credIsLocked the credIsLocked to set
 */
public void setCredIsLocked(boolean credIsLocked) {
	this.credIsLocked = credIsLocked;
}
/**
 * @return the accountIsLocked
 */
public boolean isAccountIsLocked() {
	return accountIsLocked;
}
/**
 * @param accountIsLocked the accountIsLocked to set
 */
public void setAccountIsLocked(boolean accountIsLocked) {
	this.accountIsLocked = accountIsLocked;
}
/**
 * @return the roles
 */
public List<Role> getRoles() {
	return roles;
}
/**
 * @param roles the roles to set
 */
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", enabled="
			+ enabled + ", accountIsExpired=" + accountIsExpired + ", credIsLocked=" + credIsLocked
			+ ", accountIsLocked=" + accountIsLocked + ", roles=" + roles + "]";
}

}
