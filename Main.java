import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionNotesImp g = new GestionNotesImp();
        HashMap<String, ArrayList<Double>> notes = new HashMap<>();
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("*** Application gestion des notes *** ");

        while (true) {
            System.out.println("1. Ajouter Etudiant.");
            System.out.println("2. Ajouter les notes d'un Etudiant.");
            System.out.println("3. Rechercher un etudiant .");
            System.out.println("4. Calculer la moyenne de chaque matiere.");
            System.out.println("5. Calculer la moyenne de chaque matiere.");
            System.out.println("6. Quitter.");
            System.out.print("Choisissez une option : ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    Etudiant etudiant =g.ajouterEtudiant();
                    ;
                    break;
                case 2:
                    System.out.println("Entrez le nom de l'etudiant à rechercher" );
                    String nomRecherche = s.next();
                    g.rechercherEtudiant(nomRecherche);

                    break;
                case 3:
                    g.ajouterNotesEtudiant();
                    break;
                case 4:
                    g.calculerMoyenne();
                    break;
                case 5:
                    g.calculerMoyenneGenerale();
                    break;
                case 6:
                    System.out.println("Programme terminé.");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }





    }
}
