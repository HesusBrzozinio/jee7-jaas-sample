package service.security;

import javax.ejb.Local;

import model.security.UserDTO;

@Local
public interface UserAuthenticationServiceLocal {

	UserDTO find(String principalName);
}
