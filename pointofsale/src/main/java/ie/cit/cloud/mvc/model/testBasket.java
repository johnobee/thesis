package ie.cit.cloud.mvc.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="productQuantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="productDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="basketAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="loyaltyCard" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="transactionID" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productCodeAndProductQuantityAndProductDiscount"
})
@XmlRootElement(name = "testBasket")
public class testBasket {

    @XmlElementRefs({
        @XmlElementRef(name = "productQuantity", namespace = "http://www.cit.ie/shopping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productCode", namespace = "http://www.cit.ie/shopping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productDiscount", namespace = "http://www.cit.ie/shopping", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends Comparable>> productCodeAndProductQuantityAndProductDiscount;
    @XmlAttribute(name = "basketAmount", required = true)
    protected BigDecimal basketAmount;
    @XmlAttribute(name = "loyaltyCard", required = true)
    protected BigDecimal loyaltyCard;
    @XmlAttribute(name = "transactionID", required = true)
    protected BigDecimal transactionID;

    /**
     * Gets the value of the productCodeAndProductQuantityAndProductDiscount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productCodeAndProductQuantityAndProductDiscount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductCodeAndProductQuantityAndProductDiscount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Comparable>> getProductCodeAndProductQuantityAndProductDiscount() {
        if (productCodeAndProductQuantityAndProductDiscount == null) {
            productCodeAndProductQuantityAndProductDiscount = new ArrayList<JAXBElement<? extends Comparable>>();
        }
        return this.productCodeAndProductQuantityAndProductDiscount;
    }

    /**
     * Gets the value of the basketAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBasketAmount() {
        return basketAmount;
    }

    /**
     * Sets the value of the basketAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBasketAmount(BigDecimal value) {
        this.basketAmount = value;
    }

    /**
     * Gets the value of the loyaltyCard property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLoyaltyCard() {
        return loyaltyCard;
    }

    /**
     * Sets the value of the loyaltyCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLoyaltyCard(BigDecimal value) {
        this.loyaltyCard = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransactionID(BigDecimal value) {
        this.transactionID = value;
    }

}
