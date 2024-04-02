package core;

import java.sql.*;


public class Agent extends Contact {
    private String salaire;
    private String statut;
    private String categorie;
    private int indiceDeSalaire;
    private String occupation;

   

    

    public Agent(String code, String nom, String dateDeNaissance, String address, String email, String telNumber,
            String salaire, String statut, String categorie, int indiceDeSalaire, String occupation) {
        super(code, nom, dateDeNaissance, address, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceDeSalaire = indiceDeSalaire;
        this.occupation = occupation;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIndiceDeSalaire() {
        return indiceDeSalaire;
    }

    public void setIndiceDeSalaire(int indiceDeSalaire) {
        this.indiceDeSalaire = indiceDeSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    


    @Override
    public void insererContact(Connection connection) {   
        String requete = "INSERT INTO agent VALUES (?, ?, ?,?, ?, ?,?,?,?,?,?)";
        //Agent contact = new Agent(salaire, statut, categorie,  indiceDeSalaire, occupation,  code,  nom,  dateDeNaissance,  address,  email,  telNumber);
        //String dateString = "2024-03-31";
        
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" );
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, getCode());
                preparedStatement.setString(2, getNom());
                preparedStatement.setString(3, getDateDeNaissance());
                preparedStatement.setString(4, getAddress());
                preparedStatement.setString(5, getEmail());
                preparedStatement.setString(6, getTelNumber());
                preparedStatement.setString(7, getSalaire());
                preparedStatement.setString(8, getStatut());
                preparedStatement.setString(9, getCategorie());
                preparedStatement.setInt(10, getIndiceDeSalaire());
                preparedStatement.setString(11, getOccupation());
               
                preparedStatement.executeUpdate();
                System.out.println("insertion contact success !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("iinsertion contact faillure !");
        }
    }
}
  
