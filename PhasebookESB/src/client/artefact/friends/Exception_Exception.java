
package client.artefact.friends;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://webservices2/")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private client.artefact.friends.Exception faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public Exception_Exception(String message, client.artefact.friends.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public Exception_Exception(String message, client.artefact.friends.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: client.artefact.friends.Exception
     */
    public client.artefact.friends.Exception getFaultInfo() {
        return faultInfo;
    }

}