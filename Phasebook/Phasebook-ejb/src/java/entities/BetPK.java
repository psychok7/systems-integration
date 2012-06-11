/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author psychok7
 */
@Embeddable
public class BetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbet")
    private int idbet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_iduser")
    private int userIduser;

    public BetPK() {
    }

    public BetPK(int idbet, int userIduser) {
        this.idbet = idbet;
        this.userIduser = userIduser;
    }

    public int getIdbet() {
        return idbet;
    }

    public void setIdbet(int idbet) {
        this.idbet = idbet;
    }

    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idbet;
        hash += (int) userIduser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetPK)) {
            return false;
        }
        BetPK other = (BetPK) object;
        if (this.idbet != other.idbet) {
            return false;
        }
        if (this.userIduser != other.userIduser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BetPK[ idbet=" + idbet + ", userIduser=" + userIduser + " ]";
    }
    
}
