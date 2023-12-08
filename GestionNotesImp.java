import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GestionNotesImp implements GestionNotes {
    private final ArrayList<Etudiant> etudiants = new ArrayList<>();
    private final HashMap<String, ArrayList<Double>> matieres = new HashMap<>();
    private final ArrayList<Double> notes = new ArrayList<>();

    private final Scanner s = new Scanner(System.in);


    @Override
    public Etudiant rechercherEtudiant(String nom) {


        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNom().equalsIgnoreCase(nom)) {
                System.out.println(etudiant.toString());

                return etudiant;
            }
        }
        System.out.println("etudiant n existe pas");

        return null;
    }

    @Override
    public Etudiant ajouterEtudiant() {


        System.out.println("Entrez l'appogge de l'étudiant : ");
        String appoge = s.next();

        System.out.println("Entrez le nom de l'étudiant : ");
        String nom = s.next();

        System.out.println("Entrez prenom de l'étudiant : ");
        String prenom = s.next();


        Etudiant e = new Etudiant(appoge, nom, prenom, matieres);
        etudiants.add(e);
        System.out.println(e.toString());
        return e;
    }

    @Override
    public HashMap<String, ArrayList<Double>> ajouterNotesEtudiant() {

        System.out.print("Entrez le nom de l'étudiant  .. entrez exit pour sortir: ");
        String nomEtudiant = s.next();

        Etudiant exist = rechercherEtudiant(nomEtudiant);

        if (exist != null) {
            System.out.println("Entrez le nom de la matiére  : ");
            String matiere = s.next();


            if (!matieres.containsKey(matiere)) {
                matieres.put(matiere, new ArrayList<>());
                System.out.println("matiere" + matieres);
                int i=1;

                System.out.println("Entrez les notes de cette matiere et tapez 99 pour terminer : ");
                while (true) {
                    System.out.println("la note " +i);
                    double n;
                    n = s.nextDouble();

                    if (n == 99) {
                        break;
                    } else if (n < 0.0 || n > 20.0) {
                        System.out.println("Entrez une note comprise entre 0 et 20 ");
                    } else {
                        matieres.get(matiere).add(n);
                        i++;
                    }


                }
                System.out.println("La matiére avec les notes :"+ matieres);

            }
            else {
                System.out.println("Cette matiere deja  existe ");



            }
        }
        else {
            System.out.println("Cet etudiant n'existe ");
            ajouterEtudiant();
            ajouterNotesEtudiant();

        }
            return matieres;
    }

    @Override
    public void calculerMoyenne() {
        System.out.println("Entrez le nom de l'etudiant");
        String nomEtudiant = s.next();
        Etudiant exist = rechercherEtudiant(nomEtudiant);
        if (exist == null) {
            System.out.println("etudiant n existe pas");
        } else {
            System.out.println("Entrez le nom de la matiere");
            String matiere = s.next();
            if (exist.getNotes().containsKey(matiere)) {
                ArrayList<Double> notesMatiere = exist.getNotes().get(matiere);
                double somme = 0;
                for (double note : notesMatiere) {
                    somme += note;
                }
                double moyenne = somme / notesMatiere.size();
                System.out.println("La moyenne de " + matiere + " = " + moyenne);
            } else System.out.println("matiere n 'existe pas ");


        }


    }

    @Override
    public void calculerMoyenneGenerale() {
        System.out.println("Entrez le nom de l'étudiant : ");
        String nomEtudiant = s.next();
        Etudiant exist = rechercherEtudiant(nomEtudiant);
        ArrayList<Double> ListeNotesGenerales = new ArrayList<>();
        double moyenneG = 0;

        if (exist == null) {
            System.out.println("Étudiant n'existe pas.");
        } else {
            for (ArrayList<Double> n : matieres.values()) {
                ListeNotesGenerales.addAll(n);
            }
            double somme = 0;
            for (Double note : ListeNotesGenerales) {
                somme += note;
            }
            moyenneG = somme / ListeNotesGenerales.size();

            System.out.println("La moyenne générale de l'étudiant " + nomEtudiant + " est : " + moyenneG);
        }
    }


    }

