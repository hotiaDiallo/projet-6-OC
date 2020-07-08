//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.03.19 à 12:20:17 PM CET 
//


package com.ib.library.wabapp.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookWS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="esbn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bookStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="work" type="{http://library/soap/web-services}workWS"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookWS", propOrder = {
    "id",
    "esbn",
    "bookStatus",
    "work"
})
public class BookWS {

    protected int id;
    @XmlElement(required = true)
    protected String esbn;
    protected boolean bookStatus;
    @XmlElement(required = true)
    protected WorkWS work;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété esbn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsbn() {
        return esbn;
    }

    /**
     * Définit la valeur de la propriété esbn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsbn(String value) {
        this.esbn = value;
    }

    /**
     * Obtient la valeur de la propriété bookStatus.
     * 
     */
    public boolean isBookStatus() {
        return bookStatus;
    }

    /**
     * Définit la valeur de la propriété bookStatus.
     * 
     */
    public void setBookStatus(boolean value) {
        this.bookStatus = value;
    }

    /**
     * Obtient la valeur de la propriété work.
     * 
     * @return
     *     possible object is
     *     {@link WorkWS }
     *     
     */
    public WorkWS getWork() {
        return work;
    }

    /**
     * Définit la valeur de la propriété work.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkWS }
     *     
     */
    public void setWork(WorkWS value) {
        this.work = value;
    }

}
