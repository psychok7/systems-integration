/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "photos")
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p"),
    @NamedQuery(name = "Photos.findByIdphotos", query = "SELECT p FROM Photos p WHERE p.idphotos = :idphotos"),
    @NamedQuery(name = "Photos.findByComment", query = "SELECT p FROM Photos p WHERE p.comment = :comment")})
public class Photos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idphotos")
    private Integer idphotos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Size(max = 150)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "gallery_idgallery", referencedColumnName = "idgallery")
    @ManyToOne
    private Gallery galleryIdgallery;
    @OneToMany(mappedBy = "photosIdphotos")
    private Collection<Posts> postsCollection;
    @OneToMany(mappedBy = "photosIdphotos")
    private Collection<Profile> profileCollection;

    public Photos() {
    }

    public Photos(Integer idphotos) {
        this.idphotos = idphotos;
    }

    public Photos(Integer idphotos, byte[] content) {
        this.idphotos = idphotos;
        this.content = content;
    }

    public Integer getIdphotos() {
        return idphotos;
    }

    public void setIdphotos(Integer idphotos) {
        this.idphotos = idphotos;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Gallery getGalleryIdgallery() {
        return galleryIdgallery;
    }

    public void setGalleryIdgallery(Gallery galleryIdgallery) {
        this.galleryIdgallery = galleryIdgallery;
    }

    public Collection<Posts> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Posts> postsCollection) {
        this.postsCollection = postsCollection;
    }

    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idphotos != null ? idphotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.idphotos == null && other.idphotos != null) || (this.idphotos != null && !this.idphotos.equals(other.idphotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Photos[ idphotos=" + idphotos + " ]";
    }
    
}
