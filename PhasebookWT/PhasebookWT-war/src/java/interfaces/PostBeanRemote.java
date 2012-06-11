/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Posts;
import entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Nickerson
 */
@Remote
public interface PostBeanRemote {
    
    public boolean insertPost(Posts post,User sender,User receiver);
    public List<Posts> listPost(int isUser);
    
}
