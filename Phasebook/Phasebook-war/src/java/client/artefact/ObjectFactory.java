
package client.artefact;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.artefact package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginWS_QNAME = new QName("http://webservices/", "loginWS");
    private final static QName _LoginWSResponse_QNAME = new QName("http://webservices/", "loginWSResponse");
    private final static QName _Exception_QNAME = new QName("http://webservices/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.artefact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginWSResponse }
     * 
     */
    public LoginWSResponse createLoginWSResponse() {
        return new LoginWSResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link LoginWS }
     * 
     */
    public LoginWS createLoginWS() {
        return new LoginWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "loginWS")
    public JAXBElement<LoginWS> createLoginWS(LoginWS value) {
        return new JAXBElement<LoginWS>(_LoginWS_QNAME, LoginWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "loginWSResponse")
    public JAXBElement<LoginWSResponse> createLoginWSResponse(LoginWSResponse value) {
        return new JAXBElement<LoginWSResponse>(_LoginWSResponse_QNAME, LoginWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
