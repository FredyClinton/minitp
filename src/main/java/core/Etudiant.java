/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author fredy
 */
public class Etudiant extends Contact {
    private String cylce;
    private String niveau;

   

    public Etudiant(String code, String nom, String dateDeNaissance, String address, String email, String telNumber,
            String cylce, String niveau) {
        super(code, nom, dateDeNaissance, address, email, telNumber);
        this.cylce = cylce;
        this.niveau = niveau;
    }

    public String getCylce() {
        return cylce;
    }

    public void setCylce(String cylce) {
        this.cylce = cylce;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public void insererContact(Connection connection) {   
        String requete = "INSERT INTO agent VALUES (?, ?, ?,?, ?, ?,?,?)";
        Etudiant contact = new Etudiant(code,nom,dateDeNaissance,  address, email, telNumber, cylce, niveau);
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, contact.getCode());
                preparedStatement.setString(2, contact.getNom());
                preparedStatement.setString(3, contact.getDateDeNaissance());
                preparedStatement.setString(4, contact.getAddress());
                preparedStatement.setString(5, contact.getEmail());
                preparedStatement.setString(6, contact.getTelNumber());
                preparedStatement.setString(7, contact.getCylce());
                preparedStatement.setString(8, contact.getNiveau());
                preparedStatement.executeUpdate();
                System.out.println("insertion contact success !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("iinsertion contact faillure !");
        }
    }
    
    
}
