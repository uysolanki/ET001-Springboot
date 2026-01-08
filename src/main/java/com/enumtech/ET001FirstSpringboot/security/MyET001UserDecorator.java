package com.enumtech.ET001FirstSpringboot.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.enumtech.ET001FirstSpringboot.entity.Role;
import com.enumtech.ET001FirstSpringboot.entity.User;

public class MyET001UserDecorator implements UserDetails {

	private User user;
	public MyET001UserDecorator(User user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accExpiryDate=this.user.getAccountExpiryDate();	//15-Jan-2026 expiry date
		LocalDate todaysDate=LocalDate.now();						//09-Jan-2026
		if(accExpiryDate.isAfter(todaysDate))
		return true;
		else
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		int accLockStatus=this.user.getAccountLockedStatus();
		if(accLockStatus==1)
		return true;
		else
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		LocalDate credsExpiryDate=this.user.getCredentialsExpiryDate();	//15-Jan-2026 expiry date
		LocalDate todaysDate=LocalDate.now();						    //09-Jan-2026
		if(credsExpiryDate.isAfter(todaysDate))
		return true;
		else
		return false;
	}

	@Override
	public boolean isEnabled() {
		int accEnablesStatus=this.user.getEnabledStatus();
		if(accEnablesStatus==1)
		return true;
		else
		return false;
	}

}
