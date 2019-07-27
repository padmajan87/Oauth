package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Role")
public class Role {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@Column(name="name")
private String name;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
			name="permission_role",
			joinColumns= {
					@JoinColumn(name="role_id",referencedColumnName="id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="permission_id",referencedColumnName="id")
			}
		)
private List<Permission> permissions;

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
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the permissions
 */
public List<Permission> getPermissions() {
	return permissions;
}

/**
 * @param permissions the permissions to set
 */
public void setPermissions(List<Permission> permissions) {
	this.permissions = permissions;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Role [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
}


}
