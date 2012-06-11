/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nickerson
 */
@Entity
@Table(name = "posts", catalog = "phasebookdb", schema = "")
public class Posts implements Serializable {
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany(mappedBy = "postsIdposts")
    private Collection<Posts> postsCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idposts", nullable = false)
    private Integer idposts;
    @Size(max = 512)
    @Column(name = "content", length = 512)
    private String content;
    @Column(name = "privacy")
    private Boolean privacy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_receiver", nullable = false)
    private int userReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_sender", nullable = false)
    private int userSender;
    @Column(name = "photos_idphotos")
    private Integer photosIdphotos;
    @Size(max = 512)
    @Column(name = "extra_content", length = 512)
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

    public Collection<Posts> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Posts> postsCollection) {
        this.postsCollection = postsCollection;
    }
    
}
