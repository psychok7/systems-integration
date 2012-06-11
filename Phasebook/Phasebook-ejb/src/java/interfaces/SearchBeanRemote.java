/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Nickerson
 */
@Remote
public interface SearchBeanRemote {
  
    public List<User> searchPeople(String pattern);    
    
}