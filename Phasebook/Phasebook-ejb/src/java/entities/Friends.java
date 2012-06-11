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

@Entity
@Table(name = "friends")
@NamedQueries({
    @NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f"),
    @NamedQuery(name = "Friends.findByUserIduser", query = "SELECT f FROM Friends f WHERE f.friendsPK.userIduser = :userIduser"),
    @NamedQuery(name = "Friends.findByUserIduser1", query = "SELECT f FROM Friends f WHERE f.friendsPK.userIduser1 = :userIduser1"),
    @NamedQuery(name = "Friends.findByStatus", query = "SELECT f FROM Friends f WHERE f.status = :status")})
public class Friends implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendsPK friendsPK;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "user_iduser1", referencedColumnName = "iduser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public Friends() {
    }

    public Friends(FriendsPK friendsPK) {
        this.friendsPK = friendsPK;
    }

    public Friends(int userIduser, int userIduser1) {
        this.friendsPK = new FriendsPK(userIduser, userIduser1);
    }

    public FriendsPK getFriendsPK() {
        return friendsPK;
    }

    public void setFriendsPK(FriendsPK friendsPK) {
        this.friendsPK = friendsPK;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendsPK != null ? friendsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.friendsPK == null && other.friendsPK != null) || (this.friendsPK != null && !this.friendsPK.equals(other.friendsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Friends[ friendsPK=" + friendsPK + " ]";
    }
    
}
