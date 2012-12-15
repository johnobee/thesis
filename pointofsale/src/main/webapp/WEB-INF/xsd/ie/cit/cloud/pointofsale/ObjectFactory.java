//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.15 at 12:37:09 AM GMT 
//


package ie.cit.cloud.pointofsale;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ie.cit.cloud.pointofsale package. 
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

    private final static QName _CreditcardRequestProductCode_QNAME = new QName("http://cloud.cit.ie/pointofsale", "productCode");
    private final static QName _CreditcardRequestProductDiscount_QNAME = new QName("http://cloud.cit.ie/pointofsale", "productDiscount");
    private final static QName _CreditcardRequestProductQuantity_QNAME = new QName("http://cloud.cit.ie/pointofsale", "productQuantity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ie.cit.cloud.pointofsale
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
     * Create an instance of {@link CreditcardResponse }
     * 
     */
    public CreditcardResponse createCreditcardResponse() {
        return new CreditcardResponse();
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
     * Create an instance of {@link CreditcardRequest }
     * 
     */
    public CreditcardRequest createCreditcardRequest() {
        return new CreditcardRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productCode", scope = CreditcardRequest.class)
    public JAXBElement<BigInteger> createCreditcardRequestProductCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreditcardRequestProductCode_QNAME, BigInteger.class, CreditcardRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productDiscount", scope = CreditcardRequest.class)
    public JAXBElement<BigDecimal> createCreditcardRequestProductDiscount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CreditcardRequestProductDiscount_QNAME, BigDecimal.class, CreditcardRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productQuantity", scope = CreditcardRequest.class)
    public JAXBElement<BigInteger> createCreditcardRequestProductQuantity(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreditcardRequestProductQuantity_QNAME, BigInteger.class, CreditcardRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productCode", scope = LoyaltyRequest.class)
    public JAXBElement<BigInteger> createLoyaltyRequestProductCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreditcardRequestProductCode_QNAME, BigInteger.class, LoyaltyRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productDiscount", scope = LoyaltyRequest.class)
    public JAXBElement<BigDecimal> createLoyaltyRequestProductDiscount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CreditcardRequestProductDiscount_QNAME, BigDecimal.class, LoyaltyRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloud.cit.ie/pointofsale", name = "productQuantity", scope = LoyaltyRequest.class)
    public JAXBElement<BigInteger> createLoyaltyRequestProductQuantity(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreditcardRequestProductQuantity_QNAME, BigInteger.class, LoyaltyRequest.class, value);
    }

}
