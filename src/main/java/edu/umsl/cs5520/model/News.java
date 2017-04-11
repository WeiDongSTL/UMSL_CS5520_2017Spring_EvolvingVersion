/*Name: Wei Dong
 *Course: UMSL CS5520-2017Spring
 *Project: Power News Management System
 */

/* The purpose of the program is to develop 
 * a Java web application using Srping Boot,
 * Spring MVC, Spring Data JPA, PostgreSQL, 
 * and Maven to extract news from various 
 * sources.
 * 
 * Development of web-applications with the 
 * help of Spring MVC implies creation of 
 * several logical layers of architecture. 
 * Among the layers, service layer (via JPA)
 * is responsible for communication with a 
 * PostgreSQL database, which is used to store 
 * the news and related information. The program 
 * is mainly a Spring MVC application using 
 * annotations. A simple form with spring's 
 * tags is used to initiate the extraction 
 * request to the webpage, and after the data 
 * are received and parsed by Google API through
 * Javascript, they will be saved and persisted 
 * in a PostgreSQL database. 
 *  
 * For each news, these are properties need to 
 * store:
 * 
 * 1. the unique ID associated with the news,
 * 2. the name of source providing the news, 
 * 3. the title associated with the news,
 * and
 * 4. the content of the news.
 * 
 * Same news will be saved into the table 
 * only once, by checking its ID extracted 
 * from the page. After news has been 
 * put into the database, the news will 
 * be displayed on the current page at the 
 * lower part of the user interface.
 * 
 * Main technologies used are:
 * 1) Spring Boot 1.5
 * 2) Spring MVC 4
 * 3) Spring Data JPA
 * 4) PostgreSQL 7.4
 * 5) Maven 4
 * 6) JDK 1.8
 * 
 * Development IDE: Eclipse Mars (4.5.0)
 * Operation System: Ubuntu 12.04
 *--------------------------------
 * To represent News entity within the 
 * application and to persist News  objects 
 * we use a News class with all required 
 * fields. This is a simple java bean with 
 * some JPA annotations. @Entity tells 
 * that the class is a model class that maps 
 * to a table in the database. The name attribute 
 * of '@Table' specifies the table name in the 
 * database. @Id tells that the related column 
 * is going to represent the 'primary key' for 
 * the table and @GeneratedValue show auto 
 * increment nature for related column. Other 
 * fields without '@Column' attribute imply that 
 * related column names are same as those of the 
 * field properties. 
 */

package edu.umsl.cs5520.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dav on 3/18/17.
 */
@Entity
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer id;
    private String source;
    private String title;
    private String content;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "source", nullable = true, insertable = true, updatable = true, length = 36)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 240)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (!id.equals(news.id)) return false;
        if (source != null ? !source.equals(news.source) : news.source != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
