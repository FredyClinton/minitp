import core.Contact;
import core.Repertoire;
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;



/**
 *
 * @author fredy
 */
public class MainApplication {
    public static Repertoire repertoire;
    public static Connection connection;
    public static void main(String[] args) {
        
        //Repertoire repertoire = new Repertoire();
        String jdbcUrl = "jdbc:mysql://localhost:3306/minitp"; // URL de connexion à la base de données
        String username = "fredy"; // Nom d'utilisateur MySQL
        String password = "12021997"; 
  
        System.out.println("MainFrmApplication: database connection succes");
        
        try{
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        }catch(SQLException e){
            e.printStackTrace();
            connection = null;
            System.out.println("MainFrmApplication: database connection faillure");
        }
    }
    
    
     public static void enregistrerContact(Connection connection){
        for(Entry<String, Contact> entry: repertoire.getListeDeContact().entrySet()){
            try{
                entry.getValue().insererContact(connection);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
}
