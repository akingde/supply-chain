package com.bs.rest.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bs.api.modules.uc.dto.AuthorizationDTO;
import com.bs.api.modules.uc.dto.OrganizationDTO;
import com.bs.api.modules.uc.dto.UserDTO;

public class CustomUserDetails extends User{

	private static final long serialVersionUID = 1L;
	/**
	 * 登录用户信息
	 */
	private UserDTO user;
	/**
	 * 登录机构信息
	 */
	private OrganizationDTO organization;
	/**
	 * 登录权限信息
	 */
	private List<AuthorizationDTO> authorizations;
	
	public CustomUserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}

	public List<AuthorizationDTO> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(List<AuthorizationDTO> authorizations) {
		this.authorizations = authorizations;
	}
}
