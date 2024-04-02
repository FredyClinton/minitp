package core;

import java.sql.Connection;


/**
 *
 * @author fredy_fezeu
 */
public abstract class Contact {
    protected String code;
    protected String nom;
    protected String dateDeNaissance;
    protected String address;
    protected String email;
    protected String telNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAddress() {
        return address;
    }

    public void setAdresse(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Contact(String code, String nom, String dateDeNaissance, String address, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
        
        
        
    }
    
    public abstract void insererContact(Connection connection);
    
}
