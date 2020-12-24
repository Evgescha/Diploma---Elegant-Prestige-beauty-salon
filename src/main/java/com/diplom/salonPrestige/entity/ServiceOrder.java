package com.diplom.salonPrestige.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ServiceOrder extends AbstractEntity {

	String name;

	@Column(length = 3000)
	String description;

	float price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;

	@Override
	public String toString() {
		return name + ", " + price + ", " + category;
	}

	

}
