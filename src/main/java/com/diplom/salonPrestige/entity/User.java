package com.diplom.salonPrestige.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "myUsers")
@Data
public class User extends AbstractEntity {

	@NotNull
	private String username;

//	@JsonIgnore
	@NotNull
	private String password;

	@NotNull
	private String fio;

	@NotNull
	private String adres;

	@NotNull
	private String phone;

	@NotNull
	private Date dateBorn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
	private List<Order> myOrders = new ArrayList<Order>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "worker")
	private List<Order> myWorks = new ArrayList<Order>();

	@JsonIgnore
	@Fetch(value = FetchMode.SELECT)
	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_category", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "category_id"), 
				uniqueConstraints = @UniqueConstraint(name = "users_categories", columnNames = {
						"user_id", "category_id" }))
	private List<Category> myTypes = new ArrayList<Category>();

	@JsonIgnore
	@Fetch(value = FetchMode.SELECT)
	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"), 
				uniqueConstraints = @UniqueConstraint(name = "users_roles", columnNames = {
						"user_id", "role_id" }))
	private List<Role> roles = new ArrayList<Role>();

	@JsonIgnore
	@Fetch(value = FetchMode.SELECT)
	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_order_response", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "order_id"), 
				uniqueConstraints = @UniqueConstraint(name = "users_orders", columnNames = {
						"user_id", "order_id" }))
	private List<Order> responses = new ArrayList<Order>();
	
	public User() {
		super();
	}

	public List<String> getRoleListNames() {
		List<String> roleNames = new ArrayList<>();
		for (Role currRole : getRoles()) {
			roleNames.add(currRole.getName());
		}
		return roleNames;
	}

	@Override
	public String toString() {
		return username;
	}

	public void update(String username, String password, String fio, String adres, String phone, Date dateBorn) {
		this.username = username;
		this.password = password;
		this.fio = fio;
		this.adres = adres;
		this.phone = phone;
		this.dateBorn = dateBorn;
	}
	

}
