/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p"),
    @NamedQuery(name = "Photos.findByIdphotos", query = "SELECT p FROM Photos p WHERE p.idphotos = :idphotos"),
    @NamedQuery(name = "Photos.findByComment", query = "SELECT p FROM Photos p WHERE p.comment = :comment"),
    @NamedQuery(name = "Photos.findByTitle", query = "SELECT p FROM Photos p WHERE p.title = :title")})
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
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "gallery_idgallery", referencedColumnName = "idgallery")
    @ManyToOne
    private Gallery galleryIdgallery;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Gallery getGalleryIdgallery() {
        return galleryIdgallery;
    }

    public void setGalleryIdgallery(Gallery galleryIdgallery) {
        this.galleryIdgallery = galleryIdgallery;
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
