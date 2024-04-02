/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fredy
 */
public class Repertoire {
    private Map<String, Contact> listeDeContact ;
    
    
    
    
    
    public Contact rechercherContact(String nom) {
        for (Map.Entry<String, Contact> entry: listeDeContact.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(nom)){
                return entry.getValue();
            }
        }
        return null;
    }
    
    public void ajouterContact(Contact contact) {
        if(listeDeContact.containsValue(contact) ||listeDeContact.containsKey(contact.getNom()))
        {
            System.out.println("Nom deja utilise, changez de nom");
        }
        else{
            this.listeDeContact.put(contact.getNom(), contact);
        }
    }
    
    
    public void modifierContact(Contact contact) {
        if(listeDeContact.containsValue(contact))
            listeDeContact.replace(contact.getNom(), contact);
    }
    
    public Repertoire() {
        this.listeDeContact = new HashMap<>();
    }
    
    public Repertoire(HashMap<String, Contact> listeDeContact) {
        this.listeDeContact = listeDeContact;
    }

    public Map<String, Contact> getListeDeContact() {
        return listeDeContact;
    }

    public void setListeDeContact(HashMap<String, Contact> listeDeContact) {
        this.listeDeContact = listeDeContact;
    }
    
    public void setListeDeContact() {
        this.listeDeContact = new HashMap<String, Contact>();
    }
    
}
