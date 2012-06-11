
package client.artefact.posts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.artefact.posts package. 
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
    private final static QName _ListPostsByUserIdResponse_QNAME = new QName("http://webservices2/", "listPostsByUserIdResponse");
    private final static QName _ListPostsByUserId_QNAME = new QName("http://webservices2/", "listPostsByUserId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.artefact.posts
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
     * Create an instance of {@link ListPostsByUserIdResponse }
     * 
     */
    public ListPostsByUserIdResponse createListPostsByUserIdResponse() {
        return new ListPostsByUserIdResponse();
    }

    /**
     * Create an instance of {@link ListPostsByUserId }
     * 
     */
    public ListPostsByUserId createListPostsByUserId() {
        return new ListPostsByUserId();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostsByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "listPostsByUserIdResponse")
    public JAXBElement<ListPostsByUserIdResponse> createListPostsByUserIdResponse(ListPostsByUserIdResponse value) {
        return new JAXBElement<ListPostsByUserIdResponse>(_ListPostsByUserIdResponse_QNAME, ListPostsByUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostsByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "listPostsByUserId")
    public JAXBElement<ListPostsByUserId> createListPostsByUserId(ListPostsByUserId value) {
        return new JAXBElement<ListPostsByUserId>(_ListPostsByUserId_QNAME, ListPostsByUserId.class, null, value);
    }

}
