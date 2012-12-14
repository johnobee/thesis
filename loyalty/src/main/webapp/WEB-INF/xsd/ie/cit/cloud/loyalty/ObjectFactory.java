//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.14 at 10:14:37 PM GMT 
//


package ie.cit.cloud.loyalty;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ie.cit.cloud.loyalty package. 
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

    private final static QName _LoyaltyRequestProductCode_QNAME = new QName("http://cloud.cit.ie/loyalty", "productCode");
    private final static QName _LoyaltyRequestProductQuantity_QNAME = new QName("http://cloud.cit.ie/loyalty", "productQuantity");
    private final static QName _LoyaltyRequestProductDiscount_QNAME = new QName("http://cloud.cit.ie/loyalty", "productDiscount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ie.cit.cloud.loyalty
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SalesTransactionRequest }
     * 
     */
    public SalesTransactionRequest createSalesTransactionRequest() {
        return new SalesTransactionRequest();
    }

    /**
     * Create an instance of {@link LoyaltyResponse }
     * 
     */
    public LoyaltyResponse createLoyaltyResponse() {
        return new LoyaltyResponse();
    }

    /**
     * Create an instance of {@link SalesTransactionResponse }
     * 
     */
    public SalesTransactionResponse createSalesTransactionResponse() {
        return new SalesTransactionResponse();
    }

    /**
     * Create an instance of {@link LoyaltyRequest }
     * 
     */
    public LoyaltyRequest createLoyaltyRequest() {
        return new LoyaltyRequest();
    }

    /**
     * Create an instance of {@link SalesTransactionRequest.Item }
     * 
     */
    public SalesTransactionRequest.Item createSalesTransactionRequestItem() {
        return new SalesTransactionRequest.Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/loyalty", name = "productCode", scope = LoyaltyRequest.class)
    public JAXBElement<BigInteger> createLoyaltyRequestProductCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_LoyaltyRequestProductCode_QNAME, BigInteger.class, LoyaltyRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/loyalty", name = "productQuantity", scope = LoyaltyRequest.class)
    public JAXBElement<BigInteger> createLoyaltyRequestProductQuantity(BigInteger value) {
        return new JAXBElement<BigInteger>(_LoyaltyRequestProductQuantity_QNAME, BigInteger.class, LoyaltyRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/loyalty", name = "productDiscount", scope = LoyaltyRequest.class)
    public JAXBElement<BigDecimal> createLoyaltyRequestProductDiscount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LoyaltyRequestProductDiscount_QNAME, BigDecimal.class, LoyaltyRequest.class, value);
    }

}
