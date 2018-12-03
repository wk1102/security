package com.security.learn.serviceImpl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 自定义认证逻辑的处理
 * @ClassName UserDetailServiceImpl
 * @Description ToDo
 * @Author Administrator
 * @Date 2018/12/2 21:57
 */
public class UserDetailServiceImpl implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
