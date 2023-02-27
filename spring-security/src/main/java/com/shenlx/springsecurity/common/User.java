package com.shenlx.springsecurity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @program: spring-5
 * @description:
 * @author: shenlx
 * @create: 2023-02-27 22:29
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private List<GrantedAuthority> authorities;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.authorities;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
