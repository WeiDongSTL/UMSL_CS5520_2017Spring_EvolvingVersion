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
 *----------------------------------
 * Users class represents a user who will
 * use the system.
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
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

    private int id;
    private String email;
    private String name;
    private String username;
    private String password;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
