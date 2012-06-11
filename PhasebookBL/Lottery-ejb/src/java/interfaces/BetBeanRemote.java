/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Bet;
import java.util.List;

/**
 *
 * @author Nickerson
 */
public interface BetBeanRemote {
    
    public boolean doBet(Integer number, Integer userId, Integer betId ) throws Exception;   
    public List<Bet> listBetsUnpublished(Integer betId);
}
