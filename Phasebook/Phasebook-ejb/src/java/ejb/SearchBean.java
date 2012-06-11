
package ejb;

import dao.SearchDAO;
import entities.User;
import interfaces.SearchBeanRemote;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class SearchBean implements SearchBeanRemote {

    @Override
    public List<User> searchPeople(String pattern) {

        return new SearchDAO().searchPeople(pattern);

    }

    
}
