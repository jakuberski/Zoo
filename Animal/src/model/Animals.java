package model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animals")

public class Animals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANIMAL_ID")
	private int id;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "Area")
	private String area;

	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animals(String type, String area) {
		super();
		this.type = type;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return type + ":" + area;
	}

}
