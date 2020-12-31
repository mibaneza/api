package com.intocomunity.api.dominio;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_usercomendt", nullable = false)
    private User fkuserautorcoment;

    @ManyToOne
    @JoinColumn(name = "fk_postcomment", nullable = false)
    private Post fkpostcomment;

    private String comment;

    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;

    public Comments(User fkuserautorcoment, Post fkpostcomment, String comment) {
        this.fkuserautorcoment = fkuserautorcoment;
        this.fkpostcomment = fkpostcomment;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFkuserautorcoment() {
        return fkuserautorcoment;
    }

    public void setFkuserautorcoment(User fkuserautorcoment) {
        this.fkuserautorcoment = fkuserautorcoment;
    }

    public Post getFkpostcomment() {
        return fkpostcomment;
    }

    public void setFkpostcomment(Post fkpostcomment) {
        this.fkpostcomment = fkpostcomment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
