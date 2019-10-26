package com.websitebanlaptop.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbRole", schema = "dbo", catalog = "WebsiteBanLaptop")
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 128196304423535713L;
	private int roleId;
	private String name;

	// Reference
	private Set<UserEntity> users = new HashSet<UserEntity>(0);

	@Id
	@Column(name = "roleid")
	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getRoleId() {
		return roleId;
	}

	public RoleEntity() {
		super();
	}

	public RoleEntity(int roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
}
