package com.intocomunity.api.dominio;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tileCategories;

    private String description;

    private String linkLogo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkportcatogori")
    private List<Post> fkpostCatogories = new ArrayList<>();

    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;

    public Categories( String tileCategories, String description, String linkLogo, List<Post> fkpostCatogories) {
        this.tileCategories = tileCategories;
        this.description = description;
        this.linkLogo = linkLogo;
        this.fkpostCatogories = fkpostCatogories;
    }

    public Categories() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTileCategories() {
        return tileCategories;
    }

    public void setTileCategories(String tileCategories) {
        this.tileCategories = tileCategories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }

    public List<Post> getFkpostCatogories() {
        return fkpostCatogories;
    }

    public void setFkpostCatogories(List<Post> fkpostCatogories) {
        this.fkpostCatogories = fkpostCatogories;
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
}
