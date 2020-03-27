package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presenter")
public class Presenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRESENTER_ID")
	private int id;
	@Column(name = "PRESENTER_NAME")
	private String presenterName;

	public Presenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Presenter(int id, String presenterName) {
		super();
		this.id = id;
		this.presenterName = presenterName;
	}

	public Presenter(String presenterName) {
		super();
		this.presenterName = presenterName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPresenterName() {
		return presenterName;
	}

	public void setPresenterName(String presenterName) {
		this.presenterName = presenterName;
	}

	@Override
	public String toString() {
		return "Presenter [id=" + id + ", presenterName=" + presenterName + "]";
	}

}
