package service.security;

import javax.ejb.Stateless;

import model.security.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UserAuthenticationServiceBean implements
		UserAuthenticationServiceLocal {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserAuthenticationServiceBean.class);

	@Override
	public UserDTO find(String principalName) {
		LOG.info("search user: {}", principalName);
		final UserDTO user = new UserDTO();
		user.setUsername(principalName);
		return user;
	}

}
