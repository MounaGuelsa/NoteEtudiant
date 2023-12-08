import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {
    private String appoge;
    private String nom;
    private String prenom;
    private HashMap<String, ArrayList<Double>> notes;

    public Etudiant(String appoge,String nom,String prenom,HashMap<String, ArrayList<Double>> notes) {
        this.appoge = appoge;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;

    }

    public String getAppoge() {
        return appoge;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public HashMap<String, ArrayList<Double>> getNotes() {
        return notes;
    }

    public void setAppoge(String appoge) {
        this.appoge = appoge;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNotes(HashMap<String, ArrayList<Double>> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "appoge='" + appoge + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", notes=" + notes +
                '}';
    }
}
