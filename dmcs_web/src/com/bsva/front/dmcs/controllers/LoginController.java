package com.bsva.front.dmcs.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import org.apache.log4j.Logger;

import com.bsva.front.dmcs.service.interfaces.DmcsFacadeRemote;

public class LoginController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(LoginController.class);

	@EJB
	DmcsFacadeRemote remoteServiceFacade;

	private String username;
	private String password;
	private String role;

	public LoginController() {

	}

	/**
	 * @return landing page validates if user name and password is correct
	 */
	public String login() {

		// Still to be implemented
		if ("DMCS".equalsIgnoreCase(getUsername()) && "dmcs_1".equals(getPassword())) {

			System.out.println("Successful");

			return "landing.xhtml?faces-redirect=true";
		} else {
			System.out.println("UnSuccessful");

			return "index.xhtml?faces-redirect=true";

		}
	}

	public String logout() {
		setUsername("");
		setPassword("");

		return "index.xhtml?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
