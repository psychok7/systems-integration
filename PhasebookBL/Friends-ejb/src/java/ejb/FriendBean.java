/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.FriendsDAO;
import entities.Friends;
import entities.FriendsPK;
import interfaces.FriendBeanRemote;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Nickerson
 */
@Stateless
public class FriendBean implements FriendBeanRemote{

    List<Friends> friends;
    List<Friends> pendingRequests;
    
    @Override
    public List<Friends> getFriends(Integer userId) {
        this.friends = new FriendsDAO().listFriends(userId);
        return this.friends;
    }

    @Override
    public List<Friends> getPendingRequests(Integer userId) {
        this.pendingRequests = new FriendsDAO().listPendingRequests(userId);
        return this.pendingRequests;
    }

    @Override
    public List<Friends> getFriendsByID(int userId) {
        return new FriendsDAO().listFriends(userId);
    }

    @Override
    public boolean addFriend(int userId, int friendId) {

        this.friends = this.getFriends(userId);
        if (!this.isFriend(userId, friendId)) {
            System.out.println("You ain't friends");
            Friends f = new Friends(userId, friendId);
            f.setFriendsPK(new FriendsPK(friendId, userId));
            f.setStatus('p'); //pendente
            Boolean add = new FriendsDAO().addAsFriend(f);
            if (add) {
                System.out.println("You and " + f + f.getFriendsPK().getUserIduser() + " are now Friends");
                return true;
            }
        } else {
            System.out.println("You are already friends!");

        }
        return false;
    }

    
    @Override
    public boolean acceptRequest(int userId, int friendId) {
        System.out.println("ACCEPT FRIEND!!!");
        this.pendingRequests = this.getPendingRequests(userId);
        System.out.println("PENDING: " + this.pendingRequests.size());

        for (int i = 0; i < this.pendingRequests.size(); i++) {

            Friends f = this.pendingRequests.get(i);
            if (userId == f.getFriendsPK().getUserIduser() && friendId == f.getFriendsPK().getUserIduser1()) {
                f.setStatus((Character) 'y');
                
                return new FriendsDAO().acceptRequest(f);
            } 
        }
        return false;
    }

    @Override
    public boolean isFriend(int userId, int friendId) {
        if (this.friends == null) {
            this.friends = this.getFriends(userId);
        }
        for (int i = 0; i < friends.size(); i++) {
            Friends f = friends.get(i);
            if (f.getFriendsPK().getUserIduser() == friendId) {
                return true;
            }
            if (f.getFriendsPK().getUserIduser1() == friendId){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPending(int userId, int friendId) {
        if (this.pendingRequests == null) {
            this.pendingRequests = this.getPendingRequests(userId);
        }
        for (int i = 0; i < this.pendingRequests.size(); i++) {
            Friends f = this.pendingRequests.get(i);
            if (f.getFriendsPK().getUserIduser1() == friendId) {
                return true;
            }
             if (f.getFriendsPK().getUserIduser() == friendId){
                return true;
            }
        }
        return false;
    }

    
}
