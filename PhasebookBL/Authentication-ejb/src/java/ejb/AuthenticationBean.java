
package ejb;

import dao.AuthenticationDAO;
import entities.User;
import interfaces.AuthenticationBeanRemote;
import javax.ejb.Stateful;

@Stateful
public class AuthenticationBean implements AuthenticationBeanRemote {

    private User user;

    public AuthenticationBean() {
    }

    @Override
    public boolean authenticate(String email, String password) {

        this.user = new AuthenticationDAO().authenticate(email, password);
        if (this.user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
    
}
