package com.intocomunity.api.service.dto;

import com.intocomunity.api.dominio.Role;
import com.intocomunity.api.dominio.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {
    private String avatar;
    private String name;
    private Set<Role> roles ;

    public UserDTO(User user) {
        this.avatar = "https://cdn.discordapp.com/avatars/"+user.getUsername()+"/"+user.getAvatar()+".png";
        this.name = user.getName();
        this.roles = user.getRoles();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
