/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Posts;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Nickerson
 */
@Remote
public interface PostBeanRemote {
    
    public boolean insertPost(Posts post,Integer sender,Integer receiver);
    public List<Posts> listPost(int isUser);
    
}
