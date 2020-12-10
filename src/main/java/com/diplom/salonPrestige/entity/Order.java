package com.diplom.salonPrestige.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "myUsers")
@Data
public class Order extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "creator_id")
	User creator;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	ServiceOrder service;

	Date dateCreated;

	Date dateEnded;
	
	@ManyToOne
	@JoinColumn(name = "worker_id")
	User worker;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	Status status;

	@ManyToMany(mappedBy = "responses", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<User>();
}
