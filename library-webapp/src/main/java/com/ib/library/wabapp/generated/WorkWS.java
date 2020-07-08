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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour workWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="workWS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="books" type="{http://library/soap/web-services}bookWS"/&gt;
 *         &lt;element name="author" type="{http://library/soap/web-services}authorWS"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workWS", propOrder = {
    "id",
    "title",
    "summary",
    "releaseDate",
    "books",
    "author"
})
public class WorkWS {

    protected int id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String summary;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar releaseDate;
    @XmlElement(required = true)
    protected BookWS books;
    @XmlElement(required = true)
    protected AuthorWS author;

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
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

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

    /**
     * Obtient la valeur de la propriété releaseDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    /**
     * Définit la valeur de la propriété releaseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReleaseDate(XMLGregorianCalendar value) {
        this.releaseDate = value;
    }

    /**
     * Obtient la valeur de la propriété books.
     * 
     * @return
     *     possible object is
     *     {@link BookWS }
     *     
     */
    public BookWS getBooks() {
        return books;
    }

    /**
     * Définit la valeur de la propriété books.
     * 
     * @param value
     *     allowed object is
     *     {@link BookWS }
     *     
     */
    public void setBooks(BookWS value) {
        this.books = value;
    }

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link AuthorWS }
     *     
     */
    public AuthorWS getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorWS }
     *     
     */
    public void setAuthor(AuthorWS value) {
        this.author = value;
    }

}
