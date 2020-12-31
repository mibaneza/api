package com.intocomunity.api.dominio;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 17)
    private String username;

    @NotBlank
    @Size(min = 10)
    private String password;

    @NotBlank
    private String avatar;

    private Boolean verified;

    @NotBlank
    @Size(min = 10)
    private String emaill;

    @NotBlank
    private String name;

    @NotBlank
    private String fullUsername;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkuserautor")
    private List<Post> fkpost = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkuserautorcoment")
    private List<Comments> fkcoments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String avatar, Boolean verified, String emaill, String name,  String fullUsername) {
        this.username = username;
        this.avatar = avatar;
        this.verified = verified;
        this.emaill = emaill;
        this.name = name;
        this.fullUsername = fullUsername;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFinsert() {
        return finsert;
    }

    public void setFinsert(Date finsert) {
        this.finsert = finsert;
    }

    public Date getFupdate() {
        return fupdate;
    }

    public void setFupdate(Date fupdate) {
        this.fupdate = fupdate;
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

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }

    public List<Post> getFkpost() {
        return fkpost;
    }

    public void setFkpost(List<Post> fkpost) {
        this.fkpost = fkpost;
    }

    public List<Comments> getFkcoments() {
        return fkcoments;
    }

    public void setFkcoments(List<Comments> fkcoments) {
        this.fkcoments = fkcoments;
    }
}
