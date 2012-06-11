
package client.artefact.friends;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.artefact.friends package. 
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

    private final static QName _Exception_QNAME = new QName("http://webservices2/", "Exception");
    private final static QName _GetFriendsByUserId_QNAME = new QName("http://webservices2/", "getFriendsByUserId");
    private final static QName _GetFriendsByUserIdResponse_QNAME = new QName("http://webservices2/", "getFriendsByUserIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.artefact.friends
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetFriendsByUserIdResponse }
     * 
     */
    public GetFriendsByUserIdResponse createGetFriendsByUserIdResponse() {
        return new GetFriendsByUserIdResponse();
    }

    /**
     * Create an instance of {@link GetFriendsByUserId }
     * 
     */
    public GetFriendsByUserId createGetFriendsByUserId() {
        return new GetFriendsByUserId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFriendsByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "getFriendsByUserId")
    public JAXBElement<GetFriendsByUserId> createGetFriendsByUserId(GetFriendsByUserId value) {
        return new JAXBElement<GetFriendsByUserId>(_GetFriendsByUserId_QNAME, GetFriendsByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFriendsByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "getFriendsByUserIdResponse")
    public JAXBElement<GetFriendsByUserIdResponse> createGetFriendsByUserIdResponse(GetFriendsByUserIdResponse value) {
        return new JAXBElement<GetFriendsByUserIdResponse>(_GetFriendsByUserIdResponse_QNAME, GetFriendsByUserIdResponse.class, null, value);
    }

}
