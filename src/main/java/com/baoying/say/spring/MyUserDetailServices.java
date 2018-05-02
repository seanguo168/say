package com.baoying.say.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class MyUserDetailServices implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(MyUserDetailServices.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("loadUserByUsername start");

        return new MyUserDetails(new User(username,passwordEncoder.encode("123456"),AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN")));
    }


    private class MyUserDetails implements UserDetails {

        private String password;
        private final String username;
        private final List<GrantedAuthority> authorities;
        private final boolean accountNonExpired;
        private final boolean accountNonLocked;
        private final boolean credentialsNonExpired;
        private final boolean enabled;

        MyUserDetails(UserDetails userDetails) {
            this.password = new String(userDetails.getPassword().getBytes());
            this.username = userDetails.getUsername();
            ArrayList<GrantedAuthority> temp = new ArrayList<>();
            temp.addAll(userDetails.getAuthorities());
            this.authorities = temp;
            this.accountNonExpired = userDetails.isAccountNonExpired();
            this.accountNonLocked = userDetails.isAccountNonLocked();
            this.credentialsNonExpired = userDetails.isCredentialsNonExpired();
            this.enabled = userDetails.isEnabled();
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        @Override
        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }
    }
}
