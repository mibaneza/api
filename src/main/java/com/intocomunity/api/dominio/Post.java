package com.intocomunity.api.dominio;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlePost;

    private String containerhtml;

    private String container;

    @ManyToOne
    @JoinColumn(name = "fk_user", nullable = false)
    private User fkuserautor;

    @ManyToOne
    @JoinColumn(name = "fk_categoriepost", nullable = false)
    private Categories fkportcatogori;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkpostcomment")
    private List<Comments> fkpostcoments = new ArrayList<>();

    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;

    public Post(Long id, String titlePost, String containerhtml, User fkuserautor, Categories fkportcatogori, List<Comments> fkpostcoments) {
        this.titlePost = titlePost;
        this.containerhtml = containerhtml;
        this.fkuserautor = fkuserautor;
        this.fkportcatogori = fkportcatogori;
        this.fkpostcoments = fkpostcoments;
    }

    public Post(String titlePost, String container, User fkuserautor, Categories fkportcatogori, List<Comments> fkpostcoments) {
        this.titlePost = titlePost;
        this.container = container;
        this.fkuserautor = fkuserautor;
        this.fkportcatogori = fkportcatogori;
        this.fkpostcoments = fkpostcoments;
    }

    public Post() { }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getContainerhtml() {
        return containerhtml;
    }

    public void setContainerhtml(String containerhtml) {
        this.containerhtml = containerhtml;
    }

    public User getFkuserautor() {
        return fkuserautor;
    }

    public void setFkuserautor(User fkuserautor) {
        this.fkuserautor = fkuserautor;
    }

    public Categories getFkportcatogori() {
        return fkportcatogori;
    }

    public void setFkportcatogori(Categories fkportcatogori) {
        this.fkportcatogori = fkportcatogori;
    }

    public List<Comments> getFkpostcoments() {
        return fkpostcoments;
    }

    public void setFkpostcoments(List<Comments> fkpostcoments) {
        this.fkpostcoments = fkpostcoments;
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
