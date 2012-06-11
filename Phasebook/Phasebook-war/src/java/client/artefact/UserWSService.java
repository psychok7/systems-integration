
package client.artefact;

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
@WebServiceClient(name = "UserWSService", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8081/WebServices_1/UserWS?wsdl")
public class UserWSService
    extends Service
{

    private final static URL USERWSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(client.artefact.UserWSService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = client.artefact.UserWSService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8081/WebServices_1/UserWS?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8081/WebServices_1/UserWS?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        USERWSSERVICE_WSDL_LOCATION = url;
    }

    public UserWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserWSService() {
        super(USERWSSERVICE_WSDL_LOCATION, new QName("http://webservices/", "UserWSService"));
    }

    /**
     * 
     * @return
     *     returns UserWS
     */
    @WebEndpoint(name = "UserWSPort")
    public UserWS getUserWSPort() {
        return super.getPort(new QName("http://webservices/", "UserWSPort"), UserWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserWS
     */
    @WebEndpoint(name = "UserWSPort")
    public UserWS getUserWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "UserWSPort"), UserWS.class, features);
    }

}
