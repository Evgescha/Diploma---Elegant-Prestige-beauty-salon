package com.diplom.salonPrestige.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Status extends AbstractEntity {
	String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private List<Order> orders = new ArrayList<Order>();

	@Override
	public String toString() {
		return name;
	}
}
