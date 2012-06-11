package interfaces;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.ejb.Remote;

/**
 *
 * @author Nickerson
 */
    @Remote
public interface FriendBeanRemote {
    
 //   public List<Friends> getFriends(Integer userId); 
 //   public List<Friends> getPendingRequests(Integer userId);

 //   public List<Friends> getFriendsByID(int userId);

    public boolean addFriend(int userId, int friendId);

    public boolean acceptRequest(int userId, int friendId);

    public boolean isFriend(int userId, int friendId);

    public boolean isPending(int userId, int friendId);

    
}
