package com.diplom.salonPrestige.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
public class Category extends AbstractEntity {
	String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<ServiceOrder> services = new ArrayList<ServiceOrder>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "myTypes"
    //, fetch = FetchType.EAGER
    )
    private List<User> users = new ArrayList<User>();

	@Override
	public String toString() {
		return name;
	}
}
