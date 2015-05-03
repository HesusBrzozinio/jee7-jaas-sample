package service;

import java.util.List;

import javax.ejb.Local;

import model.dto.Car;

@Local
public interface CarServiceLocal {
	List<Car> getCars();
}
