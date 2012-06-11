
package interfaces;

import entities.User;
import javax.ejb.Remote;


@Remote
public interface UserBeanRemote {
    
    
    public boolean register(String name,String email, String password);
    public User getUser();
    public void setUser(User user);
    public String getUsername();
    public int getCredits();
    public void updateUser();
    public String getUserEmailById(int i);
    public User getUserById(int parseInt);
    public boolean edit(String name, String email, String password, User user);
//    public java.util.List getPosts();
//    public java.util.List getFriends();
//    public boolean addFriend(int friendID);
//    public java.util.List getFriendsByID(int userId);
//    public java.util.List getPostsByID(int userId);
//   public boolean isFriend(int friendId);
//    public java.util.List getPendingRequests();
//    public boolean isPending(int friendId);
    public void atualizarCredito(entities.User user, java.lang.Integer valor);
//    public boolean acceptRequest(int friendId);

   
}
