package model.dto;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Date year;
	private String brand;
	private String color;

	public Car(int id, Date year, String brand, String color) {
		this.id = id;
		this.year = year;
		this.brand = brand;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public Date getYear() {
		return year;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}
}
