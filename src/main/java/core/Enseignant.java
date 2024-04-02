
package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Enseignant extends Contact {
 private String statut;  

    

    public Enseignant(String code, String nom, String dateDeNaissance, String address, String email, String telNumber,
        String statut) {
    super(code, nom, dateDeNaissance, address, email, telNumber);
    this.statut = statut;
}

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    @Override
    public void insererContact(Connection connection) {   
        String requete = "INSERT INTO enseignant VALUES (?, ?, ?,?, ?, ?,?)";
        //Enseignant contact = new Enseignant( statut,  code,  nom,  dateDeNaissance,  address,  email,  telNumber);
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, this.getCode());
                preparedStatement.setString(2, this.getNom());
                preparedStatement.setString(3, this.getDateDeNaissance());
                preparedStatement.setString(4, this.getAddress());
                preparedStatement.setString(5, this.getEmail());
                preparedStatement.setString(6, this.getTelNumber());
                preparedStatement.setString(7, this.getStatut());
                preparedStatement.executeUpdate();
                System.out.println("insertion contact success !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("iinsertion contact faillure !");
        }
    }
    
}
