
package test.artefact.user;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "UserWS2Service", targetNamespace = "http://webservices2/", wsdlLocation = "http://localhost:8080/PhasebookWSEJB/UserWS2?wsdl")
public class UserWS2Service
    extends Service
{

    private final static URL USERWS2SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(test.artefact.user.UserWS2Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = test.artefact.user.UserWS2Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/PhasebookWSEJB/UserWS2?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/PhasebookWSEJB/UserWS2?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        USERWS2SERVICE_WSDL_LOCATION = url;
    }

    public UserWS2Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserWS2Service() {
        super(USERWS2SERVICE_WSDL_LOCATION, new QName("http://webservices2/", "UserWS2Service"));
    }

    /**
     * 
     * @return
     *     returns UserWS2
     */
    @WebEndpoint(name = "UserWS2Port")
    public UserWS2 getUserWS2Port() {
        return super.getPort(new QName("http://webservices2/", "UserWS2Port"), UserWS2.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserWS2
     */
    @WebEndpoint(name = "UserWS2Port")
    public UserWS2 getUserWS2Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices2/", "UserWS2Port"), UserWS2.class, features);
    }

}
