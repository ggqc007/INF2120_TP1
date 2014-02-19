
public class TestsAmizone {

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
    private static Produit p6
            = new Produit("Antidote", Produit.CATEGORIES[9]);
    private static Produit p7
            = new Produit("huile a moteur", Produit.CATEGORIES[1]);
    private static Produit p8
            = new Produit("coussin pour chat", Produit.CATEGORIES[0]);
    private static Produit p9
            = new Produit("macbook pro", Produit.CATEGORIES[4]);
    private static Produit p10
            = new Produit("creme hydratante", Produit.CATEGORIES[14]);
    private static Produit p11
            = new Produit("chaise bistro", Produit.CATEGORIES[16]);
    private static Produit p12
            = new Produit("pot fleur plastique rouge", Produit.CATEGORIES[16]);
    private static Produit p13
            = new Produit("chaise bistro", Produit.CATEGORIES[16]);
    private static Produit p14
            = new Produit("ensemble pation blanc", Produit.CATEGORIES[16]);
    private static Produit p15
            = new Produit("ipod 4", Produit.CATEGORIES[4]);
    private static Produit p16
            = new Produit("chaine ipod stereo", Produit.CATEGORIES[4]);
    private static Produit p17
            = new Produit("potentiometre", Produit.CATEGORIES[4]);
    private static Produit p18
            = new Produit("chaine stereo haute fidelite", Produit.CATEGORIES[4]);
    private static Produit p19
            = new Produit("station d'accueil pour ipod", Produit.CATEGORIES[4]);
    private static Produit p20
            = new Produit("mini speaker pour ipod", Produit.CATEGORIES[4]);
    private static Produit p21
            = new Produit("personne vend ca", Produit.CATEGORIES[4]); // personne vend ce produit

    private static Amizone amizone1;
    private static Utilisateur f0; // utilisateur null!
    private static Utilisateur f1;
    private static Utilisateur f2;
    private static Utilisateur f3;
    private static Utilisateur f4; // vend rien
    private static Utilisateur f5;// vend tout avec minimum 10 items stock
    private static Utilisateur c6;
    private static Utilisateur c7;
    private static Utilisateur c8;
    private static Utilisateur c9;
    private static Utilisateur c10;
    private static Utilisateur c11; // utilisateur null!

    public static void main(String[] args) {
        testConstructeur();
        testInscrireUtilisateur();
        testGetUtilisateurs();
        testRecommanderUtilisateurs();
        testRecommanderProduits();
        testEffectuerTransaction();
        testRechercherProduitsParMotCle();
        testRechercherFournisseurParEvaluation();

    }

    /**
     * TEST RECHERCHER FOURNISSEUR PAR EVALUATION
     */
    public static void testRechercherFournisseurParEvaluation() {
        System.out.println("\n##### RECHERCHE FOURNISSEUR PAR EVALUATION (SORTED) #####");

        // Fait une transaction entre chq consommateur et chq fournisseur
        System.out.println("-> Fait transactions entre chq consommateurs et chq fournisseurs...");
        try {
            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c6, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c6, 14, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c6, 13, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c6, 13, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c7, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c7, 14, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c7, 13, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c7, 13, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c8, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c8, 14, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c8, 13, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c8, 13, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c9, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c9, 14, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c9, 13, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c9, 13, 1);

            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c10, 1, 1);
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c10, 14, 1);
            amizone1.effectuerTransaction((Fournisseur) f3, (Consommateur) c10, 13, 1);
            amizone1.effectuerTransaction((Fournisseur) f5, (Consommateur) c10, 13, 1);
        } catch (Exception e) {
            System.out.println("Erreur! pendant les transactions avec les fournisseurs " + e);
        }

        // Fait evaluation par tous les consommateurs de tous les fournisseurs
        System.out.println("-> Ajout d'evaluations aux fournisseurs inscrits...");
        try {
            ((Consommateur) c6).evaluer(f1, 1);
            ((Consommateur) c6).evaluer(f2, 4);
            ((Consommateur) c6).evaluer(f3, 3);
            ((Consommateur) c6).evaluer(f5, 1);

            ((Consommateur) c7).evaluer(f1, 1);
            ((Consommateur) c7).evaluer(f2, 4);
            ((Consommateur) c7).evaluer(f3, 3);
            ((Consommateur) c7).evaluer(f5, 1);

            ((Consommateur) c8).evaluer(f1, 1);
            ((Consommateur) c8).evaluer(f2, 4);
            ((Consommateur) c8).evaluer(f3, 3);
            ((Consommateur) c8).evaluer(f5, 1);

            ((Consommateur) c9).evaluer(f1, 1);
            ((Consommateur) c9).evaluer(f2, 4);
            ((Consommateur) c9).evaluer(f3, 3);
            ((Consommateur) c9).evaluer(f5, 1);

            ((Consommateur) c10).evaluer(f1, 1);
            ((Consommateur) c10).evaluer(f2, 4);
            ((Consommateur) c10).evaluer(f3, 3);
            ((Consommateur) c10).evaluer(f5, 1);

        } catch (Exception e) {
            System.out.println("Erreur! pendant l'evaluation des fournisseurs " + e);
        }

        // Ajout produit pour avoir 5 fournisseurs qui vendent l'item 13
        try {
            ((Fournisseur) f1).ajouterNouveauProduit(p13, 26, 19.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p13, 26, 19.99);
            ((Fournisseur) f4).ajouterNouveauProduit(p13, 26, 19.99); // test fournisseur avec moyenne de 0 (pas de vente)
            amizone1.inscrireUtilisateur(f4);  // test fournisseur avec moyenne de 0 (pas de vente)
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Voici la moyenne des Fournisseurs: \nF1 moy = " + ((Fournisseur) f1).evaluationMoyenne()
                + "\nF2 moy = " + ((Fournisseur) f2).evaluationMoyenne()
                + "\nF3 moy = " + ((Fournisseur) f3).evaluationMoyenne()
                + "\nF4 moy = " + ((Fournisseur) f4).evaluationMoyenne()
                + "\nF5 moy = " + ((Fournisseur) f5).evaluationMoyenne());

        System.out.print("->Test liste en ordre de tous les fournisseurs...");
        if (!amizone1.rechercherFournisseurParEvaluation(13).isEmpty()) {
            System.out.println("OK! \n" + amizone1.rechercherFournisseurParEvaluation(13));
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test liste en ordre avec produit 3 (0 item stock par F1 .. donc n'est pas suppose etre la)...");
        if (amizone1.rechercherFournisseurParEvaluation(3).isEmpty()) {
            System.out.println("OK! (" + amizone1.rechercherFournisseurParEvaluation(3) + ")");
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test liste en ordre avec produit que personne vend (retourne liste vide)...");
        if (amizone1.rechercherFournisseurParEvaluation(21).isEmpty()) {
            System.out.println("OK! (" + amizone1.rechercherFournisseurParEvaluation(21) + ")");
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test liste en ordre avec code produit qui n'existe pas (retourne liste vide)...");
        if (amizone1.rechercherFournisseurParEvaluation(51).isEmpty()) {
            System.out.println("OK! (" + amizone1.rechercherFournisseurParEvaluation(51) + ")");
        } else {
            System.out.println("FAILED!!!");
        }

    }

    /**
     * TEST RECHERCHE PRODUIT PAR MOT CLE
     */
    public static void testRechercherProduitsParMotCle() {
        System.out.println("\n##### RECHERCHE PRODUIT PAR MOT CLE #####");
        System.out.print("->Test recherche d'un produit inexistant...");
        if (amizone1.rechercherProduitsParMotCle("nexistepas").isEmpty()) {
            System.out.println("OK! (" + amizone1.rechercherProduitsParMotCle("nexistepas") + ")");
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test recherche d'un produit qui existe mais avec 0 quantite...");
        if (amizone1.rechercherProduitsParMotCle("ceramique").isEmpty()) {
            System.out.println("OK! (" + amizone1.rechercherProduitsParMotCle("ceramique") + ")");
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test recherche d'un produit vendu par 3 fournisseurs differents (ainsi que la casse)...");
        if (!amizone1.rechercherProduitsParMotCle("PoT").isEmpty()) {
            System.out.println("OK! \n" + amizone1.rechercherProduitsParMotCle("PoT"));
        } else {
            System.out.println("FAILED!!!");
        }

        System.out.print("->Test recherche d'un produit avec mot cle en debut, fin et milieu de ligne...");
        if (!amizone1.rechercherProduitsParMotCle("IpOd").isEmpty()) {
            System.out.println("OK! \n" + amizone1.rechercherProduitsParMotCle("IpOd"));
        } else {
            System.out.println("FAILED!!!");
        }

    }

    /**
     * TEST EFFECTUER TRANSACTION
     */
    public static void testEffectuerTransaction() {
        System.out.println("\n##### EFFECTUER TRANSACTION #####");

        try {
            System.out.print("->Test vente d'un produit non disponible avec ce fournisseur...");
            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c6, 2, 1);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }

        try {
            System.out.print("->Test vente d'un produit plus en stock chez ce fournisseur (Quantite 0)...");
            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c6, 3, 1);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }
    }

    /**
     * TEST RECOMMANDER PRODUITS
     */
    public static void testRecommanderProduits() {
        System.out.println("\n##### RECOMMANDER PRODUITS #####");
        try {
            System.out.print("->Test recommander produit avec utilisateur null...");
            amizone1.recommanderProduits((Fournisseur) f0, (Consommateur) c11);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }
        try {
            System.out.print("->Test recommander produit, aucun trouve (chaine vide)...");
            amizone1.recommanderProduits((Fournisseur) f4, (Consommateur) c6);
            if (amizone1.recommanderProduits((Fournisseur) f4, (Consommateur) c6).isEmpty()) {
                System.out.println("OK! (" + amizone1.recommanderProduits((Fournisseur) f4, (Consommateur) c6) + ")");
            } else {
                System.out.println("FAILED!!!");
            }
        } catch (Exception e) {
            System.out.println("testRecommanderProduit #1 failed (" + e + ")");
        }

        try {
            System.out.print("->Test recommander produit...");
            amizone1.recommanderProduits((Fournisseur) f1, (Consommateur) c6);
            System.out.println("OK! \n" + amizone1.recommanderProduits((Fournisseur) f1, (Consommateur) c6) + ")");
        } catch (Exception e) {
            System.out.println("testRecommanderProduit #2 failed (" + e + ")");
        }

        try {
            System.out.print("->Test recommander produit (Item 3 maintenant 0 en stock)...");
            amizone1.effectuerTransaction((Fournisseur) f1, (Consommateur) c6, 3, 8); // vente de tous les items 3 en stock 
            amizone1.recommanderProduits((Fournisseur) f1, (Consommateur) c6);
            System.out.println("OK! (" + amizone1.recommanderProduits((Fournisseur) f1, (Consommateur) c6) + ")");
        } catch (Exception e) {
            System.out.println("testRecommanderProduit #3 failed (" + e + ")");
        }
    }

    /**
     * TEST RECOMMANDER UTILISATEURS
     */
    public static void testRecommanderUtilisateurs() {
        System.out.println("\n##### RECOMMANDER UTILISATEURS #####");
        try {
            System.out.print("->Test recommandation avec utilisateur null...");
            amizone1.recommanderUtilisateurs(f0);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }

        // test les resultats vides
        try {
            System.out.print("->Test recommandation avec un fournisseur pour resultat vide...");
            if (amizone1.recommanderUtilisateurs(f1).isEmpty()) {
                System.out.println("OK! (" + amizone1.recommanderUtilisateurs(f1) + ")");
            }
            System.out.print("->Test recommandation avec un consommateur pour resultat vide...");
            if (amizone1.recommanderUtilisateurs(c6).isEmpty()) {
                System.out.println("OK! (" + amizone1.recommanderUtilisateurs(c6) + ")");
            }
        } catch (Exception e) {
            System.out.println("testRecommanderUtilisateurs #2 failed" + e);
        }

        // test les resultats valides
        try {
            System.out.print("->Test recommandation avec un fournisseur...");
            amizone1.effectuerTransaction((Fournisseur) f2, (Consommateur) c6, 12, 1);
            if (amizone1.recommanderUtilisateurs(f2).isEmpty()) {
                System.out.println("FAILED!!!");
            } else {
                System.out.println("OK! (" + amizone1.recommanderUtilisateurs(f2) + ")");
            }
            System.out.print("->Test recommandation avec un consommateur...");
            if (amizone1.recommanderUtilisateurs(c6).isEmpty()) {
                System.out.println("FAILED!!!");
            } else {
                System.out.println("OK! (" + amizone1.recommanderUtilisateurs(c6) + ")");
            }
        } catch (Exception e) {
            System.out.println("testRecommanderUtilisateurs #3 failed" + e);
        }

    }

    /**
     * TEST GETTER (GET UTILISATEURS)
     */
    public static void testGetUtilisateurs() {
        System.out.println("\n##### TEST GETTER UTILISATEURS (9) #####");
        System.out.println("->Test du getter des utilisateurs: " + amizone1.getUtilisateurs().size() + " sur 9 en memoire!");
    }

    /**
     * TEST INSCRIRE UTILISATEUR
     */
    public static void testInscrireUtilisateur() {
        System.out.println("\n##### TEST INSCRIRE (8) UTILISATEURS #####");
        // Ajoute 8 utilisateurs 
        try {
            ((Fournisseur) f1).ajouterNouveauProduit(p1, 10, 5);
            ((Fournisseur) f1).ajouterNouveauProduit(p3, 8, 39.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p12, 13, 21.33);
            ((Fournisseur) f2).ajouterNouveauProduit(p14, 45, 8.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p8, 4, 4.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p15, 25, 200);
            ((Fournisseur) f2).ajouterNouveauProduit(p17, 1002, 5.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p18, 3, 3089.99);
            ((Fournisseur) f2).ajouterNouveauProduit(p16, 10, 1245.67);
            ((Fournisseur) f2).ajouterNouveauProduit(p6, 24, 103.99);
            ((Fournisseur) f3).ajouterNouveauProduit(p1, 2, 299.00);
            ((Fournisseur) f3).ajouterNouveauProduit(p14, 2, 654.99);
            ((Fournisseur) f3).ajouterNouveauProduit(p13, 50, 39.99);
            ((Fournisseur) f3).ajouterNouveauProduit(p6, 100, 103.45);
            ((Fournisseur) f3).ajouterNouveauProduit(p11, 10, 54.45);
            ((Fournisseur) f3).ajouterNouveauProduit(p12, 26, 19.99);

            ((Fournisseur) f5).ajouterNouveauProduit(p1, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p2, 10, 99.99);
            //((Fournisseur) f5).ajouterNouveauProduit(p3, 10, 99.99);  // turned off. p3 est notre produit avec 0 quantite chez tous les fournisseurs
            ((Fournisseur) f5).ajouterNouveauProduit(p4, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p5, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p6, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p7, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p8, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p9, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p10, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p11, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p12, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p13, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p14, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p15, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p16, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p17, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p18, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p19, 10, 99.99);
            ((Fournisseur) f5).ajouterNouveauProduit(p20, 10, 99.99);

            amizone1.inscrireUtilisateur(f1);
            amizone1.inscrireUtilisateur(f2);
            amizone1.inscrireUtilisateur(f3);
            amizone1.inscrireUtilisateur(f5);
            amizone1.inscrireUtilisateur(c6);
            amizone1.inscrireUtilisateur(c7);
            amizone1.inscrireUtilisateur(c8);
            amizone1.inscrireUtilisateur(c9);
            amizone1.inscrireUtilisateur(c10);
        } catch (Exception e) {
            System.out.println("Erreur! pendant ajout users dans test du getter" + e);
        }

        try {
            System.out.print("->Test du denie de l'ajout d'un fournisseur qui a rien a vendre...");
            amizone1.inscrireUtilisateur(f4);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }

        try {
            System.out.print("->Test du denie de l'ajout d'un utilisateur null...");
            amizone1.inscrireUtilisateur(f0);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }

        try {
            System.out.print("->Test du denie de l'ajout d'un utilisateur existant...");
            amizone1.inscrireUtilisateur(f2);
            System.out.println("FAILED!!!");
        } catch (Exception e) {
            System.out.println("OK! (" + e + ")");
        }
    }

    /**
     * TEST DU CONSTRUCTEUR
     */
    public static void testConstructeur() {
        System.out.println("##### TEST DU CONSTRUCTEUR #####");
        System.out.println("->Construction de 5 fournisseurs et 5 consommateurs... ");
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

        System.out.print("->Construction d'une instance de Amizone...");
        amizone1 = new Amizone();
        if (amizone1 == null) {
            System.out.println("Erreur! Creation failed!");
        } else {
            System.out.println("OK! (" + amizone1 + ")");
        }

        System.out.print("->Verification que la liste d'utilisateur est initialement vide...");
        /*
         // Test le fail de la liste des utilisateurs
         try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, 10, 5);
         amizone1.inscrireUtilisateur(f1);
         } catch (Exception e) {
         System.out.println("Erreur!" + e);
         }
         */
        if (amizone1.getUtilisateurs().isEmpty()) {
            System.out.println("OK! (" + amizone1.getUtilisateurs() + ")");
        } else {
            System.out.println("Erreur! Liste dutilisateur n'est pas vide!");
        }
    }

}
