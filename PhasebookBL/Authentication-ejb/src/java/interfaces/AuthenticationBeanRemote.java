
package interfaces;


import javax.ejb.Remote;


@Remote
public interface AuthenticationBeanRemote {
    
    public boolean authenticate(String email, String password);

    public entities.User getUser();

    public void setUser(entities.User user);

   
}
