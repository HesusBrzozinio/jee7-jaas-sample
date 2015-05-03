package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.dto.Car;

@Stateless
public class CarServiceBean implements CarServiceLocal {
	
	private static final Logger LOG = LoggerFactory.getLogger(CarServiceBean.class);
	private List<Car> cars;
	
	@PostConstruct
	private void init() {
		LOG.info("CarServiceBean created");
		cars = new ArrayList<Car>();
		cars.add(new Car(1, new Date(), "Porshe", "czerwony"));
		cars.add(new Car(2, new Date(), "Fiat", "granatowy"));
		cars.add(new Car(3, new Date(), "Oldsmobille", "czarny"));
		cars.add(new Car(4, new Date(), "Polones", "zielony"));
		cars.add(new Car(5, new Date(), "Skoda", "niebieski"));
		cars.add(new Car(6, new Date(), "BMW", "srebrny"));
		cars.add(new Car(7, new Date(), "Chevrolet", "biały"));
		cars.add(new Car(8, new Date(), "Daihatsu", "czarny"));
	}

	@Override
	public List<Car> getCars() {
		return cars;
	}
}
