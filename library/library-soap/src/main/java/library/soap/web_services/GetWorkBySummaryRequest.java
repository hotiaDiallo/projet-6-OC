//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.01.16 à 02:58:19 PM CET 
//


package library.soap.web_services;

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
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "summary"
})
@XmlRootElement(name = "getWorkBySummaryRequest")
public class GetWorkBySummaryRequest {

    @XmlElement(required = true)
    protected String summary;

    /**
     * Obtient la valeur de la propriété summary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Définit la valeur de la propriété summary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

}
