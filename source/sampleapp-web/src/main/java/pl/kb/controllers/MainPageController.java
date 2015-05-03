package pl.kb.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.dto.Car;
import service.CarServiceLocal;

@ManagedBean(name = "mainPage")
@SessionScoped
public class MainPageController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Car> cars;

	@EJB
	private CarServiceLocal carService;

	@PostConstruct
	private void init() {
		cars = carService.getCars();
	}

	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void buttonAction(ActionEvent actionEvent) {
		addMessage("Invoked");
	}

	public List<Car> getCars() {
		return cars;
	}
}
