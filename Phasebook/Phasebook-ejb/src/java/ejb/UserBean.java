
package ejb;

import dao.FriendsDAO;
import dao.PostDAO;
import dao.UserDAO;
import entities.Friends;
import entities.FriendsPK;
import entities.Posts;
import entities.User;
import interfaces.UserBeanRemote;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class UserBean implements UserBeanRemote {

    private User user;
    private List<Friends> friends;
    private List<Friends> pendingRequests;
    private List<Posts> posts;

    public UserBean() {
    }

    @Override
    public boolean authenticate(String email, String password) {
        System.out.println("entrei viado");
        this.user = new UserDAO().authenticate(email, password);
        if (this.user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List getPosts() {
        return new PostDAO().listPost(this.user.getIduser());
    }

    @Override
    public List getPostsByID(int userId) {
        if (this.isFriend(userId)){
            return new PostDAO().listPost(userId);
        }
        return new PostDAO().listPrivatePost(userId);
    }

    @Override
    public List getFriends() {
        this.friends = new FriendsDAO().listFriends(user.getIduser());
        return this.friends;
    }

    @Override
    public List getPendingRequests() {
        this.pendingRequests = new FriendsDAO().listPendingRequests(user.getIduser());
        return this.pendingRequests;
    }

    @Override
    public List getFriendsByID(int userId) {
        return new FriendsDAO().listFriends(userId);
    }

    @Override
    public boolean addFriend(int friendId) {

        this.friends = this.getFriends();
        if (!this.isFriend(friendId)) {
            System.out.println("You ain't friends");
            Friends f = new Friends(this.getUser().getIduser(), friendId);
            f.setFriendsPK(new FriendsPK(friendId, this.getUser().getIduser()));
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
    public boolean acceptRequest(int friendId) {
        System.out.println("ACCEPT FRIEND!!!");
        this.pendingRequests = this.getPendingRequests();
        System.out.println("PENDING: " + this.pendingRequests.size());

        int userId = this.user.getIduser();
        for (int i = 0; i < this.pendingRequests.size(); i++) {

            Friends f = this.pendingRequests.get(i);
            System.out.println("PENDING: " + f.getUser().getName() + ":" + f.getUser1().getName());
            if (userId == f.getUser().getIduser() && friendId == f.getUser1().getIduser()) {
                f.setStatus((Character) 'y');
                
                return new FriendsDAO().acceptRequest(f);
            } else if (userId == f.getUser1().getIduser() && friendId == f.getUser().getIduser()) {
                f.setStatus((Character) 'y');
                
                return new FriendsDAO().acceptRequest(f);
            }
        }
        return false;
    }

    @Override
    public boolean isFriend(int friendId) {
        if (this.friends == null) {
            this.friends = this.getFriends();
        }
        for (int i = 0; i < friends.size(); i++) {
            Friends f = friends.get(i);
            if (f.getUser1().getIduser() == friendId) {
                return true;
            }
            if (f.getUser().getIduser() == friendId){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPending(int friendId) {
        if (this.pendingRequests == null) {
            this.pendingRequests = this.getPendingRequests();
        }
        for (int i = 0; i < this.pendingRequests.size(); i++) {
            Friends f = this.pendingRequests.get(i);
            if (f.getUser1().getIduser() == friendId) {
                return true;
            }
             if (f.getUser().getIduser() == friendId){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean register(String name, String email, String password) {
        this.user = new User();
        this.user.setEmail(email);
        this.user.setName(name);
        this.user.setPassword(password);
        this.user.setCredit(10);

        boolean flag = new UserDAO().register(this.user);

        if (flag == false) {
            this.user = null;
        }

        return flag;
    }

    @Override
    public void atualizarCredito(User user, Integer valor) {

        UserDAO uDao = new UserDAO();

        user.setCredit(valor);

        uDao.edit(user);

    }

    @Override
    public boolean edit(String name, String email, String password, User old_user) {
        this.user = getUserById(old_user.getIduser());
        this.user.setEmail(email);
        this.user.setName(name);
        this.user.setPassword(password);

        boolean flag = new UserDAO().edit(this.user);

        if (flag == false) {
            this.user = null;
        }

        return flag;
    }

    @Override
    public String getUserEmailById(int id) {
        return new UserDAO().getUserById(id).getEmail();
    }

    @Override
    public User getUserById(int id) {
        return new UserDAO().getUserById(id);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void updateUser() {

        setUser(new UserDAO().getUserById(user.getIduser()));

    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

    @Override
    public int getCredits() {
        return this.user.getCredit();
    }
}
