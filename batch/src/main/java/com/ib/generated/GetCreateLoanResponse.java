//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.03.14 à 05:53:31 PM CET 
//


package com.ib.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loan" type="{http://library/soap/web-services}loanWS"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loan"
})
@XmlRootElement(name = "getCreateLoanResponse")
public class GetCreateLoanResponse {

    @XmlElement(required = true)
    protected LoanWS loan;

    /**
     * Obtient la valeur de la propriété loan.
     * 
     * @return
     *     possible object is
     *     {@link LoanWS }
     *     
     */
    public LoanWS getLoan() {
        return loan;
    }

    /**
     * Définit la valeur de la propriété loan.
     * 
     * @param value
     *     allowed object is
     *     {@link LoanWS }
     *     
     */
    public void setLoan(LoanWS value) {
        this.loan = value;
    }

}
