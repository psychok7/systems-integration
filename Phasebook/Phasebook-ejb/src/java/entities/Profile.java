/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "profile")
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByIdprofile", query = "SELECT p FROM Profile p WHERE p.idprofile = :idprofile"),
    @NamedQuery(name = "Profile.findByGender", query = "SELECT p FROM Profile p WHERE p.gender = :gender"),
    @NamedQuery(name = "Profile.findByLatitude", query = "SELECT p FROM Profile p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Profile.findByLongitude", query = "SELECT p FROM Profile p WHERE p.longitude = :longitude"),
    @NamedQuery(name = "Profile.findByNickname", query = "SELECT p FROM Profile p WHERE p.nickname = :nickname"),
    @NamedQuery(name = "Profile.findByRelationship", query = "SELECT p FROM Profile p WHERE p.relationship = :relationship")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofile")
    private Integer idprofile;
    @Column(name = "gender")
    private Character gender;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Size(max = 45)
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "relationship")
    private Character relationship;
    @JoinColumn(name = "photos_idphotos", referencedColumnName = "idphotos")
    @ManyToOne
    private Photos photosIdphotos;
    @JoinColumn(name = "user_userid", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User userUserid;

    public Profile() {
    }

    public Profile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public Integer getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Character getRelationship() {
        return relationship;
    }

    public void setRelationship(Character relationship) {
        this.relationship = relationship;
    }

    public Photos getPhotosIdphotos() {
        return photosIdphotos;
    }

    public void setPhotosIdphotos(Photos photosIdphotos) {
        this.photosIdphotos = photosIdphotos;
    }

    public User getUserUserid() {
        return userUserid;
    }

    public void setUserUserid(User userUserid) {
        this.userUserid = userUserid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofile != null ? idprofile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idprofile == null && other.idprofile != null) || (this.idprofile != null && !this.idprofile.equals(other.idprofile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profile[ idprofile=" + idprofile + " ]";
    }
    
}
