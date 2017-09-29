package com.bs.rest.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.AuthorizationDTO;
import com.bs.api.modules.uc.dto.UserDTO;
import com.bs.api.modules.uc.service.IAuthorizationService;
import com.bs.api.modules.uc.service.IUserService;

public class CustomUserDetailsService implements UserDetailsService {

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IUserService userApi;
	
	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IAuthorizationService authorizationApi;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ResultData<UserDTO> userResultData = userApi.getUserByAccount(username);
        if(userResultData == null){
             throw new UsernameNotFoundException("user account："+ username + "non exist！");
        }
        String code = userResultData.getCode();
        if (code != null && !code.equals(ResultCode.RCODE_SUCCESS)) {
        	throw new UsernameNotFoundException("user account："+ username + "non exist！");
        }
        //用户对象
        UserDTO userDTO = userResultData.getData();
        //主键id
        Long userId = userDTO.getId();
        Integer isAdmin = userDTO.getIsAdmin() == null?0:userDTO.getIsAdmin();
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        //查询权限信息
        ResultData<List<AuthorizationDTO>> authResultData = authorizationApi.listAuthByUserId(userId, isAdmin);
        List<AuthorizationDTO> authorizations = null;
        if (authResultData != null) {
        	String rcode = authResultData.getCode();
        	if (rcode != null && code.equals(ResultCode.RCODE_SUCCESS)) {
        		authorizations = authResultData.getData();
        		for (AuthorizationDTO authorization:authorizations) {
        			Long authCode = authorization.getCode();
        			collection.add(new SimpleGrantedAuthority(String.valueOf(authCode)));
        		}
        	}
        }
        //设置登录用户信息，如果需要可能自定义增加
        CustomUserDetails customUserDetails = new CustomUserDetails(username,userDTO.getPassword(),collection);
        userDTO.setPassword(null);
        customUserDetails.setUser(userDTO);
        customUserDetails.setAuthorizations(authorizations);
        
        return customUserDetails;
    }

}
