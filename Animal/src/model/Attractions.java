package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attractions")
public class Attractions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private int id;
	@Column(name = "LOCATION_NAME")
	private String location;
	@Column(name = "TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PRESENTER_ID")
	private Presenter presenter;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "animals_on_list", joinColumns = {
			@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ANIMAL_ID", referencedColumnName = "ANIMAL_ID", unique = true) })
	private List<Animals> listofAnimals;

	public Attractions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attractions(int id, String location, LocalDate tripDate, Presenter presenter, List<Animals> listofAnimals) {
		super();
		this.id = id;
		this.location = location;
		this.tripDate = tripDate;
		this.presenter = presenter;
		this.listofAnimals = listofAnimals;
	}

	public Attractions(String location, LocalDate tripDate, Presenter presenter, List<Animals> listofAnimals) {
		super();
		this.location = location;
		this.tripDate = tripDate;
		this.presenter = presenter;
		this.listofAnimals = listofAnimals;
	}

	public Attractions(String location, LocalDate tripDate, Presenter presenter) {
		super();
		this.location = location;
		this.tripDate = tripDate;
		this.presenter = presenter;
	}

	public Presenter getPresenter() {
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public List<Animals> getListofAnimals() {
		return listofAnimals;
	}

	public void setListofAnimals(List<Animals> listofAnimals) {
		this.listofAnimals = listofAnimals;
	}

	@Override
	public String toString() {
		return "Attractions [id=" + id + ", location=" + location + ", tripDate=" + tripDate + ", presenter="
				+ presenter + ", listofAnimals=" + listofAnimals + "]";
	}

}
