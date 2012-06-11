/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Bet;
import entities.User;

/**
 *
 * @author Nickerson
 */
public interface BetBeanRemote {
    
    public boolean doBet(Integer number, User user ) throws Exception;   
    public void shareResults(Bet bet) throws Exception;
    
}
