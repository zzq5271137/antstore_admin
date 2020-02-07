package com.mycomp.antstoreadmin.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Admin [id=" + id + ", username=" + username + ", password="
                + password + "]";
    }
}
