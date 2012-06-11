
package test.artefact.friends;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test.artefact.friends package. 
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
    private final static QName _AddFriend_QNAME = new QName("http://webservices2/", "addFriend");
    private final static QName _AddFriendResponse_QNAME = new QName("http://webservices2/", "addFriendResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test.artefact.friends
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFriendResponse }
     * 
     */
    public AddFriendResponse createAddFriendResponse() {
        return new AddFriendResponse();
    }

    /**
     * Create an instance of {@link AddFriend }
     * 
     */
    public AddFriend createAddFriend() {
        return new AddFriend();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFriend }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "addFriend")
    public JAXBElement<AddFriend> createAddFriend(AddFriend value) {
        return new JAXBElement<AddFriend>(_AddFriend_QNAME, AddFriend.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFriendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "addFriendResponse")
    public JAXBElement<AddFriendResponse> createAddFriendResponse(AddFriendResponse value) {
        return new JAXBElement<AddFriendResponse>(_AddFriendResponse_QNAME, AddFriendResponse.class, null, value);
    }

}
