import java.util.ArrayList;
import java.util.HashMap;

public interface GestionNotes {
Etudiant rechercherEtudiant(String nom);
Etudiant ajouterEtudiant();
HashMap<String,ArrayList<Double>> ajouterNotesEtudiant();

void calculerMoyenne();
void calculerMoyenneGenerale();

}
