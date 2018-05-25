package com.balde.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "representations")
public class Representations implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "show_id", nullable = false)
	private Shows show;
	
	
	//private Date when;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Locations location;
	
	@OneToMany(targetEntity = RepresentationUser.class,
			mappedBy = "representation",
			cascade = CascadeType.ALL)
	private List<RepresentationUser> representationUser = new ArrayList<>();

	public Representations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Representations(Shows show, Date when, Locations location) {
		super();
		this.show = show;
		//this.when = when;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

//	public Date getWhen() {
//		return when;
//	}
//
//	public void setWhen(Date when) {
//		this.when = when;
//	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public List<RepresentationUser> getRepresentationUser() {
		return representationUser;
	}

	public void setRepresentationUser(List<RepresentationUser> representationUser) {
		this.representationUser = representationUser;
	}
	
}
