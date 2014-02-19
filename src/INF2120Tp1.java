
import java.util.ArrayList;

public class INF2120Tp1 {
    
    /*

    private static Produit p1
            = new Produit("table cuisine couleur verte", Produit.CATEGORIES[10]);
    private static Produit p2
            = new Produit("ipod gen 5", Produit.CATEGORIES[4]);
    private static Produit p3
            = new Produit("pot de fleur ceramique", Produit.CATEGORIES[16]); // 0 quantite chez tous les fournisseurs
    private static Produit p4
            = new Produit("sac a dos rouge", Produit.CATEGORIES[2]);
    private static Produit p5
            = new Produit("raquette de tennis", Produit.CATEGORIES[15]);

    private static Amizone amizone1 = new Amizone();
    private static Utilisateur f1;
    private static Utilisateur f2;
    private static Utilisateur f3;
    private static Utilisateur f4;
    private static Utilisateur f5;
    private static Utilisateur c6;
    private static Utilisateur c7;
    private static Utilisateur c8;
    private static Utilisateur c9;
    private static Utilisateur c10;



    // FOR DEBUG !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void testRechercherFournisseurParEvaluation() {
        System.out.println("\n##### RECHERCHE FOURNISSEUR PAR EVALUATION (SORTED) #####");
        try {
            ((Fournisseur) f1).ajouterNouveauProduit(p1, 10, 5);
            ((Fournisseur) f1).ajouterNouveauProduit(p2, 10, 39.99);
            ((Fournisseur) f1).ajouterNouveauProduit(p3, 10, 5);
            ((Fournisseur) f1).ajouterNouveauProduit(p4, 10, 39.99);
            ((Fournisseur) f1).ajouterNouveauProduit(p5, 10, 5);

            ((Fournisseur) f2).ajouterNouveauProduit(p1, 10, 21.33);
            ((Fournisseur) f2).ajouterNouveauProduit(p2, 10, 8.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p3, 44, 4.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p4, 25, 200);
            ((Fournisseur) f2).ajouterNouveauProduit(p5, 1002, 5.99);

            ((Fournisseur) f3).ajouterNouveauProduit(p1, 24, 299.00);
            ((Fournisseur) f3).ajouterNouveauProduit(p2, 24, 654.99);
            ((Fournisseur) f3).ajouterNouveauProduit(p3, 50, 39.99);
            ((Fournisseur) f3).ajouterNouveauProduit(p4, 100, 103.45);
            ((Fournisseur) f3).ajouterNouveauProduit(p5, 10, 54.45);

            ((Fournisseur) f4).ajouterNouveauProduit(p1, 24, 299.00);
            ((Fournisseur) f4).ajouterNouveauProduit(p2, 24, 654.99);
            ((Fournisseur) f4).ajouterNouveauProduit(p3, 50, 39.99);
            ((Fournisseur) f4).ajouterNouveauProduit(p4, 100, 103.45);
            ((Fournisseur) f4).ajouterNouveauProduit(p5, 10, 54.45);

            ((Fournisseur) f5).ajouterNouveauProduit(p1, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p2, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p3, 10, 99.99);  // turned off. p3 est notre produit avec 0 quantite chez tous les fournisseurs
            ((Fournisseur) f5).ajouterNouveauProduit(p4, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p5, 10, 99.99);

            amizone1.inscrireUtilisateur(f1);
            amizone1.inscrireUtilisateur(f2);
            amizone1.inscrireUtilisateur(f3);
            amizone1.inscrireUtilisateur(f4);
            amizone1.inscrireUtilisateur(f5);
            amizone1.inscrireUtilisateur(c6);
            amizone1.inscrireUtilisateur(c7);
            amizone1.inscrireUtilisateur(c8);
            amizone1.inscrireUtilisateur(c9);
            amizone1.inscrireUtilisateur(c10);
        } catch (Exception e) {
            System.out.println("Erreur! pendant ajout users dans test du getter" + e);
        }

        // Fait une transaction entre chq consommateur et chq fournisseur
        System.out.println("-> Fait transactions entre chq consommateurs et chq fournisseurs...");
        try {
            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c6, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c6, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c6, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f4, (Consommateur) c6, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c6, 1, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c7, 2, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c7, 2, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c7, 2, 1);
            amizone1.effectuerTransaction((Fournisseur) f4, (Consommateur) c7, 2, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c7, 2, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c8, 3, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c8, 3, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c8, 3, 1);
            amizone1.effectuerTransaction((Fournisseur) f4, (Consommateur) c8, 3, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c8, 3, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c9, 4, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c9, 4, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c9, 4, 1);
            amizone1.effectuerTransaction((Fournisseur) f4, (Consommateur) c9, 4, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c9, 4, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c10, 5, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c10, 5, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c10, 5, 1);
            amizone1.effectuerTransaction((Fournisseur) f4, (Consommateur) c10, 5, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c10, 5, 1);
        } catch (Exception e) {
            System.out.println("Erreur! pendant les transactions avec les fournisseurs " + e);
        }

        // Fait evaluation par tous les consommateurs de tous les fournisseurs
        System.out.println("-> Ajout d'evaluations aux fournisseurs inscrits...");
        try {
            ((Consommateur) c6).evaluer(f1, 5);
            ((Consommateur) c6).evaluer(f2, 4);
            ((Consommateur) c6).evaluer(f3, 3);
            ((Consommateur) c6).evaluer(f4, 2);
            ((Consommateur) c6).evaluer(f5, 1);

            ((Consommateur) c7).evaluer(f1, 5);
            ((Consommateur) c7).evaluer(f2, 4);
            ((Consommateur) c7).evaluer(f3, 3);
            ((Consommateur) c7).evaluer(f4, 2);
            ((Consommateur) c7).evaluer(f5, 1);

            ((Consommateur) c8).evaluer(f1, 5);
            ((Consommateur) c8).evaluer(f2, 4);
            ((Consommateur) c8).evaluer(f3, 3);
            ((Consommateur) c8).evaluer(f4, 2);
            ((Consommateur) c8).evaluer(f5, 1);

            ((Consommateur) c9).evaluer(f1, 5);
            ((Consommateur) c9).evaluer(f2, 4);
            ((Consommateur) c9).evaluer(f3, 3);
            ((Consommateur) c9).evaluer(f4, 2);
            ((Consommateur) c9).evaluer(f5, 1);

            ((Consommateur) c10).evaluer(f1, 5);
            ((Consommateur) c10).evaluer(f2, 4);
            ((Consommateur) c10).evaluer(f3, 3);
            ((Consommateur) c10).evaluer(f4, 2);
            ((Consommateur) c10).evaluer(f5, 1);

        } catch (Exception e) {
            System.out.println("Erreur! pendant l'evaluation des fournisseurs " + e);
        }

        System.out.print("->Test liste en ordre de tous les fournisseurs...");
        System.out.println("DEBUG: F3 moy = " + ((Fournisseur) f3).evaluationMoyenne() + " F4 moy = " + ((Fournisseur) f4).evaluationMoyenne());
        if (!amizone1.rechercherFournisseurParEvaluation(13).isEmpty()) {
            System.out.println("OK! " + amizone1.rechercherFournisseurParEvaluation(13));
        } else {
            System.out.println("FAILED!!!");
        }

    }
    */
    
        public static void testSortArrayDouble() {
        ArrayList source = new ArrayList();
        /*
        source.add(1.59);
        source.add(31.6);
        source.add(15.9);
        source.add(16.55);
        source.add(51.333);
        source.add(91.77);
        source.add(8.12);
        source.add(16.0);
        */
        source.add(3.0);
        source.add(5.0);
        
        ArrayList sorted = new ArrayList();

        int position;
        for (int i = 0; i < source.size(); i++) {
            // Trouve sa position dans l'ordre
            position = 0;
            while (position < sorted.size() && ((Double) sorted.get(position)).compareTo((Double) source.get(i)) > 0) {
                position = position + 1;
            }
            sorted.add(position, source.get(i));
        }
        System.out.println("Avant: " + source);
        System.out.println("Apres: " + sorted);
    }

    public static void main(String[] args) {
        /*
        f1 = new Fournisseur("pseudoF1", "motPasseF1", "courrielF1");
        f2 = new Fournisseur("pseudoF2", "motPasseF2", "courrielF2");
        f3 = new Fournisseur("pseudoF3", "motPasseF3", "courrielF3");
        f4 = new Fournisseur("pseudoF4", "motPasseF4", "courrielF4");
        f5 = new Fournisseur("pseudoF5", "motPasseF5", "courrielF5");
        c6 = new Consommateur("pseudoC6", "motPasseC6", "courrielC6");
        c7 = new Consommateur("pseudoC7", "motPasseC7", "courrielC7");
        c8 = new Consommateur("pseudoC8", "motPasseC8", "courrielC8");
        c9 = new Consommateur("pseudoC9", "motPasseC9", "courrielC9");
        c10 = new Consommateur("pseudoC10", "motPasseC10", "courrielC10");
        try {
            amizone1.inscrireUtilisateur(f1);
            amizone1.inscrireUtilisateur(f2);
            amizone1.inscrireUtilisateur(f3);
            amizone1.inscrireUtilisateur(f4);
            amizone1.inscrireUtilisateur(f5);
            amizone1.inscrireUtilisateur(c6);
            amizone1.inscrireUtilisateur(c7);
            amizone1.inscrireUtilisateur(c8);
            amizone1.inscrireUtilisateur(c9);
            amizone1.inscrireUtilisateur(c10);
        } catch (Exception e) {
            System.out.println("Erreur: " + e);
        }

        testRechercherFournisseurParEvaluation();
                */

        // Test methode sorting dun array liste de double
        testSortArrayDouble();
    }

}
