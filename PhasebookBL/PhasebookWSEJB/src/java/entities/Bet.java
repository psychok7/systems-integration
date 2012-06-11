/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "bet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bet.findAll", query = "SELECT b FROM Bet b"),
    @NamedQuery(name = "Bet.findByIdbet", query = "SELECT b FROM Bet b WHERE b.betPK.idbet = :idbet"),
    @NamedQuery(name = "Bet.findByUserIduser", query = "SELECT b FROM Bet b WHERE b.betPK.userIduser = :userIduser"),
    @NamedQuery(name = "Bet.findByNumber", query = "SELECT b FROM Bet b WHERE b.number = :number"),
    @NamedQuery(name = "Bet.findByPublished", query = "SELECT b FROM Bet b WHERE b.published = :published")})
public class Bet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetPK betPK;
    @Column(name = "number")
    private Integer number;
    @Column(name = "published")
    private Boolean published;

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
