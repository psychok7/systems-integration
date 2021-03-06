/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p"),
    @NamedQuery(name = "Posts.findByIdposts", query = "SELECT p FROM Posts p WHERE p.idposts = :idposts"),
    @NamedQuery(name = "Posts.findByContent", query = "SELECT p FROM Posts p WHERE p.content = :content"),
    @NamedQuery(name = "Posts.findByPrivacy", query = "SELECT p FROM Posts p WHERE p.privacy = :privacy"),
    @NamedQuery(name = "Posts.findByCreationDate", query = "SELECT p FROM Posts p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "Posts.findByUserReceiver", query = "SELECT p FROM Posts p WHERE p.userReceiver = :userReceiver"),
    @NamedQuery(name = "Posts.findByUserSender", query = "SELECT p FROM Posts p WHERE p.userSender = :userSender"),
    @NamedQuery(name = "Posts.findByPhotosIdphotos", query = "SELECT p FROM Posts p WHERE p.photosIdphotos = :photosIdphotos"),
    @NamedQuery(name = "Posts.findByExtraContent", query = "SELECT p FROM Posts p WHERE p.extraContent = :extraContent")})
public class Posts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idposts")
    private Integer idposts;
    @Size(max = 512)
    @Column(name = "content")
    private String content;
    @Column(name = "privacy")
    private Boolean privacy;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_receiver")
    private int userReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_sender")
    private int userSender;
    @Column(name = "photos_idphotos")
    private Integer photosIdphotos;
    @Size(max = 512)
    @Column(name = "extra_content")
    private String extraContent;
    @OneToMany(mappedBy = "postsIdposts")
    private List<Posts> postsList;
    @JoinColumn(name = "posts_idposts", referencedColumnName = "idposts")
    @ManyToOne
    private Posts postsIdposts;

    public Posts() {
    }

    public Posts(Integer idposts) {
        this.idposts = idposts;
    }

    public Posts(Integer idposts, int userReceiver, int userSender) {
        this.idposts = idposts;
        this.userReceiver = userReceiver;
        this.userSender = userSender;
    }

    public Integer getIdposts() {
        return idposts;
    }

    public void setIdposts(Integer idposts) {
        this.idposts = idposts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(int userReceiver) {
        this.userReceiver = userReceiver;
    }

    public int getUserSender() {
        return userSender;
    }

    public void setUserSender(int userSender) {
        this.userSender = userSender;
    }

    public Integer getPhotosIdphotos() {
        return photosIdphotos;
    }

    public void setPhotosIdphotos(Integer photosIdphotos) {
        this.photosIdphotos = photosIdphotos;
    }

    public String getExtraContent() {
        return extraContent;
    }

    public void setExtraContent(String extraContent) {
        this.extraContent = extraContent;
    }

    @XmlTransient
    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }

    public Posts getPostsIdposts() {
        return postsIdposts;
    }

    public void setPostsIdposts(Posts postsIdposts) {
        this.postsIdposts = postsIdposts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposts != null ? idposts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.idposts == null && other.idposts != null) || (this.idposts != null && !this.idposts.equals(other.idposts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Posts[ idposts=" + idposts + " ]";
    }
    
}
