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
@Table(name = "gallery")
@NamedQueries({
    @NamedQuery(name = "Gallery.findAll", query = "SELECT g FROM Gallery g"),
    @NamedQuery(name = "Gallery.findByIdgallery", query = "SELECT g FROM Gallery g WHERE g.idgallery = :idgallery"),
    @NamedQuery(name = "Gallery.findByName", query = "SELECT g FROM Gallery g WHERE g.name = :name"),
    @NamedQuery(name = "Gallery.findByDescription", query = "SELECT g FROM Gallery g WHERE g.description = :description")})
public class Gallery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgallery")
    private Integer idgallery;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "galleryIdgallery")
    private Collection<Photos> photosCollection;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User userIduser;

    public Gallery() {
    }

    public Gallery(Integer idgallery) {
        this.idgallery = idgallery;
    }

    public Integer getIdgallery() {
        return idgallery;
    }

    public void setIdgallery(Integer idgallery) {
        this.idgallery = idgallery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Photos> getPhotosCollection() {
        return photosCollection;
    }

    public void setPhotosCollection(Collection<Photos> photosCollection) {
        this.photosCollection = photosCollection;
    }

    public User getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(User userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgallery != null ? idgallery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gallery)) {
            return false;
        }
        Gallery other = (Gallery) object;
        if ((this.idgallery == null && other.idgallery != null) || (this.idgallery != null && !this.idgallery.equals(other.idgallery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gallery[ idgallery=" + idgallery + " ]";
    }
    
}
