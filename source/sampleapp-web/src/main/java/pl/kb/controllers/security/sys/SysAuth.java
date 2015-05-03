package pl.kb.controllers.security.sys;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.security.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.security.UserAuthenticationServiceLocal;

@ManagedBean(name = "sysAuth")
@SessionScoped
public class SysAuth implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(SysAuth.class);
	private UserDTO user;

	@EJB
	private UserAuthenticationServiceLocal userService;

	public UserDTO getUser() {
		if (user == null) {
			Principal principal = FacesContext.getCurrentInstance()
					.getExternalContext().getUserPrincipal();
			if (principal != null) {
				// Find User by j_username.
				user = userService.find(principal.getName());
			}
		}

		return user;
	}

	public String logout() {
		LOG.info("logout invoked");
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/html/index.xhtml?faces-redirect=true";
	}

	public void login() throws IOException {
		final String contextPath = FacesContext.getCurrentInstance()
				.getExternalContext().getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(contextPath + "/html/index.xhtml");
	}

}
