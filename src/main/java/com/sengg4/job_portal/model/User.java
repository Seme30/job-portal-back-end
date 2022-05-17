package com.sengg4.job_portal.model;

import javax.persistence.*;



@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    private long id;

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;
    
}
