/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "bet")
@NamedQueries({
    @NamedQuery(name = "Bet.findAll", query = "SELECT b FROM Bet b"),
    @NamedQuery(name = "Bet.findByIdbet", query = "SELECT b FROM Bet b WHERE b.betPK.idbet = :idbet"),
    @NamedQuery(name = "Bet.findByUserIduser", query = "SELECT b FROM Bet b WHERE b.betPK.userIduser = :userIduser"),
    @NamedQuery(name = "Bet.findByNumber", query = "SELECT b FROM Bet b WHERE b.number = :number")})
public class Bet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetPK betPK;
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "published")
    private Boolean published;
    
    
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Bet() {
    }

    public Bet(BetPK betPK) {
        this.betPK = betPK;
    }

    public Bet(int idbet, int userIduser) {
        this.betPK = new BetPK(idbet, userIduser);
    }

    public BetPK getBetPK() {
        return betPK;
    }

    public void setBetPK(BetPK betPK) {
        this.betPK = betPK;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (betPK != null ? betPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bet)) {
            return false;
        }
        Bet other = (Bet) object;
        if ((this.betPK == null && other.betPK != null) || (this.betPK != null && !this.betPK.equals(other.betPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bet[ betPK=" + betPK + " ]";
    }
    
}
