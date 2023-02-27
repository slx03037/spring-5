package com.shenlx.springsecurity.service;

import com.shenlx.springsecurity.common.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @program: spring-5
 * @description:
 * @author: shenlx
 * @create: 2023-02-27 22:34
 **/
@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = Arrays.asList(
                (GrantedAuthority)new SimpleGrantedAuthority("user:add"),
                new SimpleGrantedAuthority("user:view"),
                new SimpleGrantedAuthority("user:update"));

        User user = new User(1L, username, passwordEncoder.encode("123456"), true, authorities);

        if (user == null) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }

        return user;
    }
}
