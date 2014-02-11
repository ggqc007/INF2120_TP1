

/**
 * Classe de tests pour tester les classes Utilisateur, Consommateur et Fournisseur.
 * @author melanie lord
 * @version 6 fevrier 2014
 */
public class TestsUtilisateur {
   
   public static double TOTAL_POINTS = 117.5;
   public static double PONDERATION = 30;
   private static double total = 0;
   
   private static Produit p1 = 
           new Produit ("table cuisine couleur verte", Produit.CATEGORIES[10]);
   private static Produit p2 = 
           new Produit ("ipod gen 5", Produit.CATEGORIES[4]);
   private static Produit p3 = 
           new Produit ("pot de fleur ceramique", Produit.CATEGORIES[16]);
   private static Produit p4 = 
           new Produit ("sac a dos rouge", Produit.CATEGORIES[2]);
   private static Produit p5 = 
           new Produit ("raquette de tennis", Produit.CATEGORIES[15]);
   private static Produit p6 = 
           new Produit ("Antidote", Produit.CATEGORIES[9]);
   private static Produit p7 = 
           new Produit ("huile a moteur", Produit.CATEGORIES[1]);
   private static Produit p8 = 
           new Produit ("coussin pour chat", Produit.CATEGORIES[0]);
   private static Produit p9 = 
           new Produit ("macbook pro", Produit.CATEGORIES[4]);
   private static Produit p10 = 
           new Produit ("creme hydratante", Produit.CATEGORIES[14]);
   private static Produit p11 = 
           new Produit ("chaise bistro", Produit.CATEGORIES[16]);
   private static Produit p12 = 
           new Produit ("pot fleur plastique rouge", Produit.CATEGORIES[16]);
   private static Produit p13 = 
           new Produit ("chaise bistro", Produit.CATEGORIES[16]);
   private static Produit p14 = 
           new Produit ("ensemble pation blanc", Produit.CATEGORIES[16]);
   private static Produit p15 = 
           new Produit ("ipod 4", Produit.CATEGORIES[4]);
   private static Produit p16 = 
           new Produit ("chaine stereo", Produit.CATEGORIES[4]);
   private static Produit p17 = 
           new Produit ("potentiometre", Produit.CATEGORIES[4]);
   private static Produit p18 = 
           new Produit ("chaine stereo haute fidelite", Produit.CATEGORIES[4]);
   private static Produit p19 = 
           new Produit ("station d'accueil pour ipod", Produit.CATEGORIES[4]);
   private static Produit p20 = 
           new Produit ("mini speaker pour ipod", Produit.CATEGORIES[4]);
   
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
   
   
   //NOTES : 
   //Corriger les erreurs des premiers tests, dans l'ordre où elles apparaissent
   //avant de corriger les erreurs des tests suivants.
   
   /**
    * Tests des classes Utilisateur, Consommateur et Fournisseur.
    * @param args un tableau vide.
    */
   public static void main (String [] args)  {
      
      testsConstructeurs();

      testsEquals();
            
      testsAjouterNouveauProduit ();
      
      testsObtenirProduit();
      
      testsVendre();
      
      testsAcheter(); 
      
      testsFournisseurs();
      
      testsCompilerProfil();
      
      testsAjouterEvaluation();
      
      testsEvaluer();
      
      testsEvaluationMoyenne();
      
      System.out.println("\n--------------------------------");
      System.out.println("TOTAL POINTS : " + total + " / 117.5");
      afficherNoteFinale(total);

   }
   
   
   
   /**
    * Tests des constructeurs.
    */
   public static void testsConstructeurs () {
      double nbr = 0;
      
      System.out.println("\n--------------------------------");
      System.out.println("TESTS CONSTRUCTEUR");
      System.out.println("--------------------------------\n");
      
      try {
         System.out.print("Construction de 5 fournisseurs et 5 consommateurs... ");
         
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
         
         //Tests fournisseurs
         if (((Fournisseur)f4).getProduits().length == 100) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, la longueur du tableau des produits "
                    + "devrait etre 100");
         }
         if (((Fournisseur)f4).getNbrProduits() == 0) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le nombre de produits devrait etre 0");
         }
         if (((Fournisseur)f4).getPseudo().equals("pseudoF4")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le pseudo devrait etre \"pseudoF4\".");
         }
         if (((Fournisseur)f4).getMotPasse().equals("motPasseF4")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le mot de passe devrait etre "
                    + "\"motPasseF4\".");
         }
         if (((Fournisseur)f4).getCourriel().equals("courrielF4")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le courriel devrait etre "
                    + "\"courrielF4\".");
         }
         if (((Fournisseur)f4).getId() == 4) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, l'id devrait etre 4.");
         }
         if (((Fournisseur)f4).getEvaluations().length == 100) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, la longueur du tableau des evaluations "
                    + "devrait etre 100.");
         }
         if (((Fournisseur)f4).getNbrEval() == 0) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le nombre d'evaluations devrait etre 0.");
         }
          
         
         //Tests consommateurs
         if (((Consommateur)c7).getAchats().length == 100) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, la longueur du tableau des achats "
                    + "devrait etre 100");
         }
         if (((Consommateur)c7).getNbrAchats() == 0) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le nombre des achats devrait etre 0");
         }
         if (((Consommateur)c7).getPseudo().equals("pseudoC7")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le pseudo devrait etre \"pseudoC7\".");
         }
         if (((Consommateur)c7).getMotPasse().equals("motPasseC7")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le mot de passe devrait etre "
                    + "\"motPasseC7\".");
         }
         if (((Consommateur)c7).getCourriel().equals("courrielC7")) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le courriel devrait etre "
                    + "\"courrielC7\".");
         }
         if (((Consommateur)c7).getId() == 7) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le id devrait etre 7.");
         }
         if (((Consommateur)c7).getEvaluations().length == 100) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, la longueur du tableau des evaluations "
                    + "devrait etre 100.");
         }
         if (((Consommateur)c7).getNbrEval() == 0) {
            nbr = nbr + 0.5;
         } else {
            System.out.println("\nERREUR, le nombre des evaluations devrait "
                    + "etre 0.");
         }
      
         if (nbr == 8) {
            System.out.println("OK");
         } else {
            System.out.println();
         }

      } catch (Exception e) {
         System.out.println("ERREUR, ne devrait pas lever d'Exception.");
      }
      
      System.out.println("\nPOINTS : " + nbr + " / 8.0");
      total = total + nbr;
   }
   
   
   /**
    * Tests de la methode equals.
    */
   public static void testsEquals () {
      
      double nbr = 0;
      
      System.out.println("\n--------------------------------");
      System.out.println("TESTS EQUALS");
      System.out.println("--------------------------------\n");

      Utilisateur ff1 = new Fournisseur("Paul", "bizbizbiz", "paul@gmail.com");
      Utilisateur cc1 = new Consommateur("Paul", "bizbizbiz", "paul@gmail.com");
      
      if (!ff1.equals(cc1)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, ff1.equals(cc1) doit retourner false");
      }
      
      Utilisateur ff2 = new Fournisseur("ff2", "pass2", "courriel2");
      Utilisateur ff3 = new Fournisseur((Fournisseur)ff2);
      
      if (ff2.equals(ff3)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, ff2.equals(ff3) doit retourner true");
      }
      
      Utilisateur ff4 = new Fournisseur("f4", "pass4", "courriel4");
      Fournisseur ff5 = new Fournisseur((Fournisseur)ff4);
      
      if (ff4.equals(ff5)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, ff4.equals(ff5) doit retourner true");
      }
      
      Consommateur cc2 = new Consommateur("cc2", "pass2", "courriel2");
      Utilisateur cc3 = new Consommateur(cc2);
      
      if (cc2.equals(cc3)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, cc2.equals(cc3) doit retourner true");
      }
      
      Consommateur cc4 = new Consommateur("c4", "pass4", "courriel4");
      Utilisateur cc5 = new Consommateur(cc4);
      
      if (cc4.equals(cc5)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, cc4.equals(cc5) doit retourner true");
      }
      
      if (!f1.equals(f2)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, f1.equals(f2) doit retourner false");
      }
      
      if (!c6.equals(c7)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, c6.equals(c7) doit retourner false");
      }
      
      if (c7.equals(c7)) {
         nbr = nbr + 0.5;
      } else {
         System.out.println("ERREUR, c7.equals(c7) doit retourner true");
      }
      
      System.out.println("POINTS : " + nbr + " / 4.0");
      total = total + nbr;
   }
   
   
   
   /**
    * Tests methode ajouterNouveauProduit.
    */
   public static void testsAjouterNouveauProduit () {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS AJOUTER NOUVEAU PRODUIT");
      System.out.println("--------------------------------\n");
      
      System.out.print("Tentative d'ajout de p1 au fournisseur f1 avec quantite "
              + "invalide (0)... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, 0, 153.29);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();

      System.out.print("Tentative d'ajout de p1 au fournisseur f1 avec quantite "
              + "invalide (-1)... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, -1, 153.29);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'ajout de p1 au fournisseur f1 avec prix "
              + "invalide (0)... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, 10, 0);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_PRIX)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'ajout d'un produit null au fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(null, 10, 123.35);
         System.out.println("\nERREUR, devrait lever une ExceptionProduitInvalide.");
      } catch (ExceptionProduitInvalide epi) {
         nbr = nbr + 0.5;
         System.out.print("OK.");
      } catch (Exception e) {
         System.out.println("\nERREUR, ne leve pas le bon type d'exception.");
      }
      System.out.println();
      
      System.out.print("Ajout du produit p1 au fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, 10, 123.35);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      System.out.print("Tentative d'ajout d'un produit existant (p1) au "
              + "fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p1, 3, 129.10);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_AJOUT_PROD)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
     
      System.out.print("Ajout du produit p4 au fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p4, 100, 43.56);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      System.out.print("Ajout du produit p5 au fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p5, 23, 207.99);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      System.out.print("Ajout du produit p10 au fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p10, 12, 12.98);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      System.out.print("Tentative d'ajout d'un produit existant (p4) au "
              + "fournisseur f1... ");
      try {
         ((Fournisseur)f1).ajouterNouveauProduit(p4, 3, 129.10);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_AJOUT_PROD)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      try {
         System.out.print("Ajout de 8 produits au fournisseur f2... ");
         ((Fournisseur)f2).ajouterNouveauProduit(p12, 13, 21.33);
         ((Fournisseur)f2).ajouterNouveauProduit(p14, 45, 8.99);
         ((Fournisseur)f2).ajouterNouveauProduit(p8, 4, 4.99);
         ((Fournisseur)f2).ajouterNouveauProduit(p15, 25, 200);
         ((Fournisseur)f2).ajouterNouveauProduit(p17, 1002, 5.99);
         ((Fournisseur)f2).ajouterNouveauProduit(p18, 3, 3089.99);
         ((Fournisseur)f2).ajouterNouveauProduit(p16, 10, 1245.67);
         ((Fournisseur)f2).ajouterNouveauProduit(p6, 24, 103.99);
         if (((Fournisseur)f2).getNbrProduits() == 8) {
            System.out.println("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, le nombre de produits de f2 devrait "
                    + "etre 8.");
         }

         System.out.print("Ajout de 6 produits au fournisseur f3... ");
         ((Fournisseur)f3).ajouterNouveauProduit(p1, 2, 299.00);    
         ((Fournisseur)f3).ajouterNouveauProduit(p14, 2, 654.99);   
         ((Fournisseur)f3).ajouterNouveauProduit(p13, 50, 39.99);   
         ((Fournisseur)f3).ajouterNouveauProduit(p6, 100, 103.45);  
         ((Fournisseur)f3).ajouterNouveauProduit(p11, 10, 54.45);   
         ((Fournisseur)f3).ajouterNouveauProduit(p12, 26, 19.99);   
         if (((Fournisseur)f3).getNbrProduits() == 6) {
            System.out.println("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, le nombre de produits de f2 devrait "
                    + "etre 8.");
         }

      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever d'Exception.");
      }
      System.out.println();
      
      System.out.print("Verification du tableau des produits de f1... ");
      Produit[] produits = ((Fournisseur)f1).getProduits();
      int[] tabTest = {1, 4, 5, 10};
      boolean test = comparerTabProduitsCode(produits, tabTest, 4);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les codes de produits dans le tableau des "
                 + "produits sont incorrects.");
         System.out.println("\tcodes  trouves : " + codes(produits, 4) );
         System.out.println("\tcodes attendus : 1, 4, 5, 10," );
      }
      int[] tabTest2 = {10, 100, 23, 12};
      test = comparerTabProduitsQte(produits, tabTest2, 4);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les quantites dans le tableau des produits "
                 + "sont incorrectes.");
         System.out.println("\tquantites  trouvees : " + quantites(produits, 4) );
         System.out.println("\tquantites attendues : 10, 100, 23, 12," );   
      }
      
      double [] tabTest3 = {123.35, 43.56, 207.99, 12.98};
      test = comparerTabProduitsPrix(produits, tabTest3, 4);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les prix dans le tableau des produits sont "
                 + "incorrects.");
         System.out.println("\tprix  trouves : " + lesPrix(produits, 4) );
         System.out.println("\tprix attendus : 123.35, 43.56, 207.99, 12.98," );   
      }
      
      int [] tabTest4 = {1, 1, 1, 1};
      test = comparerTabProduitsIdFourn(produits, tabTest4, 4);
      if (test) {
         nbr++;
      } else {
         System.out.println("\nERREUR, les ids des fournisseurs dans le tableau "
                 + "des produits sont incorrectes.");
         System.out.println("\tids  trouves : " + idsFourn(produits, 4) );
         System.out.println("\tids attendus : 1, 1, 1, 1," );   
      }

      if (nbr == 18.5) {
         System.out.println("OK.");
      } else {
         System.out.println();
      }
      
      System.out.print("Verification du tableau des produits de f2... ");
      produits = ((Fournisseur)f2).getProduits();
      int[] tabTest5 = {12, 14, 8, 15, 17, 18, 16, 6};
      test = comparerTabProduitsCode(produits, tabTest5, 8);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les codes de produits dans le tableau des "
                 + "produits sont incorrects.");
         System.out.println("\tcodes  trouves : " + codes(produits, 8) );
         System.out.println("\tcodes attendus : 12, 14, 8, 15, 17, 18, 16, 6," );
      }
      
      int[] tabTest6 = {13, 45, 4, 25, 1002, 3, 10, 24};;
      test = comparerTabProduitsQte(produits, tabTest6, 8);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les quantites dans le tableau des produits "
                 + "sont incorrectes.");
         System.out.println("\tquantites  trouvees : " + quantites(produits, 8) );
         System.out.println("\tquantites attendues : 13, 45, 4, 25, 1002, 3, 10, 24," );   
      }
      
      double [] tabTest7 = {21.33, 8.99, 4.99, 200, 5.99, 3089.99, 1245.67, 103.99};
      test = comparerTabProduitsPrix(produits, tabTest7, 8);
      if (test) {
         nbr = nbr + 2;
      } else {
         System.out.println("\nERREUR, les prix dans le tableau des produits sont "
                 + "incorrects.");
         System.out.println("\tprix  trouves : " + lesPrix(produits, 8) );
         System.out.println("\tprix attendus : 21.33, 8.99, 4.99, 200, 5.99, "
                 + "3089.99, 1245.67, 103.99," );   
      }
      
      int [] tabTest8 = {2, 2, 2, 2, 2, 2, 2, 2};
      test = comparerTabProduitsIdFourn(produits, tabTest8, 8);
      if (test) {
         nbr++;
      } else {
         System.out.println("\nERREUR, les ids des fournisseurs dans le tableau "
                 + "des produits sont incorrectes.");
         System.out.println("\tids  trouves : " + idsFourn(produits, 8) );
         System.out.println("\tids attendus : 2, 2, 2, 2, 2, 2, 2, 2," );   
      }

      if (nbr == 25.5) {
         System.out.println("OK.");
      } else {
         System.out.println();
      }
      
      System.out.println("\nPOINTS : " + nbr + " / 25.5");
      
      total = total + nbr;

   }
   
   /**
    * Tests de la methode obtenirProduit.
    */
   public static void testsObtenirProduit() {
      
      double nbr = 0;
      Produit p;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS OBTENIR PRODUIT");
      System.out.println("--------------------------------\n");
      
      System.out.print("Tentative d'obtenir un produit inexistant... ");
      p = ((Fournisseur)f3).obtenirProduit(7);
      if (p == null) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, le produit retourne devrait etre null.");
      }
      System.out.println();
      
      System.out.print("Obtention d'un produit existant (p12) du fournisseur f3... ");
      p = ((Fournisseur)f3).obtenirProduit(12);
      if (p != null && p.getCode() == 12 && p.getIdFournisseur() == 3) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, le produit retourne est incorrect.");
      }
      System.out.println();
      
      System.out.print("Obtention d'un produit existant (p12) du fournisseur f2... ");
      p = ((Fournisseur)f2).obtenirProduit(12);
      if (p != null && p.getCode() == 12 && p.getIdFournisseur() == 2) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, le produit retourne est incorrect.");
      }
      System.out.println();
      
      System.out.println("\nPOINTS " + nbr + " / 3.0");
      total = total + nbr;
   }

   /**
    * Tests de la methode vendre.
    */
   public static void testsVendre() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS VENDRE");
      System.out.println("--------------------------------\n");
      
      System.out.print("Tentative de vendre un produit qui n'est pas dans le "
              + "tableau des produits... ");
      try {
         ((Fournisseur)f2).vendre(9, 12);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_VENTE_PROD)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      
      System.out.print("Tentative de vendre un produit avec quantite invalide (0)... ");
      try {
         ((Fournisseur)f2).vendre(6, 0);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative de vendre un produit avec quantite invalide (-1)... ");
      try {
         ((Fournisseur)f2).vendre(6, -1);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative de vendre un produit avec quantite > qte en stock... ");
      try {
         ((Fournisseur)f2).vendre(6, 25);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Vente du produit p6 par le fournisseur f2 (qte = 8)... ");
      try {
         ((Fournisseur)f2).vendre(6, 8);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, Ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      
      System.out.print("Verification de la quantite du produit vendu... ");
      Produit p = Produit.obtenirProduit(6, ((Fournisseur)f2).getProduits());
      
      if (p != null) {
      
         if (p.getQuantite() == 16) {
            nbr++;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, la quantite du produit devrait etre "
                    + "16 et non " + p.getQuantite());
         }
         System.out.println();

         System.out.print("Verification du nombre de produit dans le tableau des "
                 + "produits... ");
         if (((Fournisseur)f2).getNbrProduits() == 8) {
            nbr++;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, le nombre de produit dans le tableau "
                    + "des produits devrait etre 8 et non " + 
                    ((Fournisseur)f2).getNbrProduits());;
         }
         System.out.println();
      } else {
         System.out.println("\nERREUR INATENDUE, verifiez le tableau des produits.");
      }
      
      System.out.print("Vente du produit p6 par le fournisseur f2 (qte = 16)... ");
      try {
         ((Fournisseur)f2).vendre(6, 16);
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, Ne devrait pas lever une Exception.");
      }
      System.out.println();
      
      System.out.print("Verification de la quantite du produit vendu... ");
      p = Produit.obtenirProduit(6, ((Fournisseur)f2).getProduits());
      
      if (p != null) {
      
         if (p.getQuantite() == 0) {
            nbr++;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, la quantite du produit devrait etre 0 "
                    + "et non " + p.getQuantite());
         }
         System.out.println();

         System.out.print("Verification du nombre de produit dans le tableau des "
                 + "produits... ");
         if (((Fournisseur)f2).getNbrProduits() == 8) {
            nbr++;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, le nombre de produit dans le tableau "
                    + "des produits devrait etre 8 et non " + 
                    ((Fournisseur)f2).getNbrProduits());
         }
         System.out.println();
      } else {
         System.out.println("\nERREUR INATENDUE, verifiez le tableau des produits.");
      }
      
      
      System.out.print("Tentative de vendre un produit dont la quantite en stock "
              + "est 0... ");
      try {
         ((Fournisseur)f2).vendre(6, 1);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();

      System.out.print("Vente de divers produits par le fournisseur f3... ");
      //cas normaux
      try {
         ((Fournisseur)f3).vendre(1, 1);     
         ((Fournisseur)f3).vendre(11, 6);    
         ((Fournisseur)f3).vendre(13, 25);   
         ((Fournisseur)f3).vendre(14, 1);    
         ((Fournisseur)f3).vendre(11, 2);    
         
         System.out.println("OK.");
         nbr++;
         
      } catch (Exception e) {
         System.err.println("\nERREUR, ne devrait pas lever une Exception.");
      }
      
      Produit[] produits = ((Fournisseur)f3).getProduits();
      System.out.print("Verification du nombre de produits dans le tableau des "
              + "produits de f3... ");
      if (((Fournisseur)f3).getNbrProduits() == 6) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, le nombre de produits devrait etre 6 et non "
                 + ((Fournisseur)f3).getNbrProduits());
      }
      System.out.println();
      
      System.out.print("Verification des codes des produits dans le tableau des "
              + "produits de f3... ");
      int[] tabTest2 = {1, 14, 13, 6, 11, 12};
      boolean test = comparerTabProduitsCode(produits, tabTest2, 6);
      if (test) {
         nbr = nbr + 2;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les codes dans le tableau des produits "
                 + "sont incorrects.");
         System.out.println("\tcodes  trouves : " + quantites(produits, 6) );
         System.out.println("\tcodes attendus : 1, 14, 13, 6, 11, 12," );   
      }
      System.out.println();
      
      System.out.print("Verification des quatites dans le tableau des produits "
              + "de f3... ");
      int[] tabTest = {1, 1, 25, 100, 2, 26};
      test = comparerTabProduitsQte(produits, tabTest, 6);
      if (test) {
         nbr = nbr + 2;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les quantites dans le tableau des produits "
                 + "sont incorrectes.");
         System.out.println("\tquantites  trouvees : " + quantites(produits, 6) );
         System.out.println("\tquantites attendues : 1, 1, 25, 100, 2, 26," );   
      }
      System.out.println();
      
      System.out.println("\nPOINTS : " + nbr + " / 17.0");
      total = total + nbr;
   }
   
   
   /**
    * Tests de la methode acheter.
    */
   public static void testsAcheter() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS ACHETER");
      System.out.println("--------------------------------\n");
      
      System.out.print("Tentative d'achat d'un produit null... ");
      try {
         ((Consommateur)c6).acheter(null, 2);
         System.out.println("\nERREUR, devrait lever une ExceptionProduitInvalide.");
      } catch (ExceptionProduitInvalide epi) {
         System.out.print("OK");
         nbr++;
      } catch (Exception e) {
         System.err.println("\nERREUR, leve une autre exception que "
                 + "ExceptionProduitInvalide.");
      }
      System.out.println();
      
      System.out.print("Tentative d'achat d'un produit qui n'est vendu par "
              + "aucun fournisseur... ");
      try {
         ((Consommateur)c6).acheter(p1, 2);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_ACHAT)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'achat d'une quantite invalide (0)... ");
      try {
         ((Consommateur)c6).acheter(Produit.obtenirProduit(13, 
                 ((Fournisseur)f3).getProduits()), 0);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'achat d'une quantite invalide (-1)... ");
      try {
         ((Consommateur)c6).acheter(Produit.obtenirProduit(13, 
                 ((Fournisseur)f3).getProduits()), -1);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'achat d'un produit dont la quatite en stock est 0... ");
      try {
         ((Consommateur)c6).acheter(Produit.obtenirProduit(6, 
                 ((Fournisseur)f2).getProduits()), 1); 
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'achat d'un produit dont la quatite en "
              + "stock < quantite achetee... ");
      try {
         ((Consommateur)c6).acheter(Produit.obtenirProduit(8, 
                 ((Fournisseur)f2).getProduits()), 5);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_QTE)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         }  else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Verification du nombre d'achats... ");
      if (((Consommateur)c6).getNbrAchats() == 0) {
         nbr++;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, le nombre d'achats devrait etre 0 et non "
                 + ((Consommateur)c6).getNbrAchats());
      }
      System.out.println();
      
      try {
         System.out.print("Achats du consommateur c6... ");
         ((Consommateur)c6).acheter(Produit.obtenirProduit(1, 
                 ((Fournisseur)f1).getProduits()), 3); 
         ((Consommateur)c6).acheter(Produit.obtenirProduit(10, 
                 ((Fournisseur)f1).getProduits()), 4);
         ((Consommateur)c6).acheter(((Fournisseur)f2).obtenirProduit(15), 3); 
         ((Consommateur)c6).acheter(((Fournisseur)f1).obtenirProduit(4), 7); 
         ((Consommateur)c6).acheter(((Fournisseur)f1).obtenirProduit(1), 1); 
         if (((Consommateur)c6).getNbrAchats() == 5) {
            nbr = nbr + 1;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, nombre d'achats de c6 incorrect.");
         }
         System.out.println();
         
         System.out.print("Achats du consommateur c7... ");
         ((Consommateur)c7).acheter(((Fournisseur)f3).obtenirProduit(14), 1);
         ((Consommateur)c7).acheter(((Fournisseur)f3).obtenirProduit(12), 2); 
         ((Consommateur)c7).acheter(((Fournisseur)f2).obtenirProduit(8), 1);  
         ((Consommateur)c7).acheter(((Fournisseur)f2).obtenirProduit(15), 1); 
         ((Consommateur)c7).acheter(((Fournisseur)f3).obtenirProduit(12), 1); 
         if (((Consommateur)c7).getNbrAchats() == 5) {
            nbr = nbr + 1;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, nombre d'achats de c7 incorrect.");
         }
         System.out.println();
         
         System.out.print("Achats du consommateur c8... ");
         ((Consommateur)c8).acheter(((Fournisseur)f2).obtenirProduit(15), 10); 
         ((Consommateur)c8).acheter(((Fournisseur)f2).obtenirProduit(15), 4); 
         ((Consommateur)c8).acheter(((Fournisseur)f2).obtenirProduit(16), 1); 
         ((Consommateur)c8).acheter(((Fournisseur)f2).obtenirProduit(18), 1); 
         ((Consommateur)c8).acheter(((Fournisseur)f1).obtenirProduit(4), 1);  
         ((Consommateur)c8).acheter(((Fournisseur)f2).obtenirProduit(16), 9); 
         ((Consommateur)c8).acheter(((Fournisseur)f3).obtenirProduit(1), 1);  
         if (((Consommateur)c8).getNbrAchats() == 7) {
            nbr = nbr + 1;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, nombre d'achats de c8 incorrect.");
         }
         System.out.println();
         
         System.out.print("Achats du consommateur c9... ");
         ((Consommateur)c9).acheter(((Fournisseur)f1).obtenirProduit(5), 1);  
         ((Consommateur)c9).acheter(((Fournisseur)f3).obtenirProduit(6), 2); 
         if (((Consommateur)c9).getNbrAchats() == 2) {
            nbr = nbr + 2;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, nombre d'achats de c8 incorrect.");
         }
         System.out.println();
         
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever d'exception.");
      }
      
      Produit [] achats = ((Consommateur)c8).getAchats();
      
      System.out.print("Verification des codes des produits dans le tableau des "
              + "achats de c8... ");
      int[] tabTest1 = {15, 15, 16, 18, 4, 16, 1};
      boolean test = comparerTabProduitsCode(achats, tabTest1, 7);
      if (test) {
         nbr = nbr + 2;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les codes dans le tableau des achats sont "
                 + "incorrects.");
         System.out.println("\tcodes  trouves : " + codes(achats, 7) );
         System.out.println("\tcodes attendus : 15, 15, 16, 18, 4, 16, 1," );   
      }
      System.out.println();
      
      System.out.print("Verification des quatites dans le tableau des achats de c8... ");
      int[] tabTest2 = {10, 4, 1, 1, 1, 9, 1};
      test = comparerTabProduitsQte(achats, tabTest2, 7);
      if (test) {
         nbr = nbr + 2;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les quantites dans le tableau des achats "
                 + "sont incorrectes.");
         System.out.println("\tquantites  trouvees : " + quantites(achats, 7) );
         System.out.println("\tquantites attendues : 10, 4, 1, 1, 1, 9, 1," );   
      }
      System.out.println();
      
      System.out.print("Verification des ids fournisseurs des produits dans le "
              + "tableau des achats de c8... ");
      int[] tabTest3 = {2, 2, 2, 2, 1, 2, 3};
      test = comparerTabProduitsIdFourn(achats, tabTest3, 7);
      if (test) {
         nbr = nbr + 1;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les ids des fournisseurs dans le tableau "
                 + "des achats sont incorrects.");
         System.out.println("\tids  trouves : " + idsFourn(achats, 7) );
         System.out.println("\tids attendus : 2, 2, 2, 2, 1, 2, 3," );   
      }
      System.out.println();  
      
      System.out.print("Verification des quantites de produits dans le tableau "
              + "des produits de f2... ");
      int[] tabTest4 = {13, 45, 4, 25, 1002, 3, 10, 0};
      test = comparerTabProduitsQte(((Fournisseur)f2).getProduits(), tabTest4, 8);
      if (test) {
         nbr = nbr + 2;
         System.out.print("OK.");
      } else {
         System.out.println("\nERREUR, les quantites dans le tableau des produits "
                 + "de f2 sont incorrectes.");
         System.out.println("\tquantites  trouvees : " + 
                 quantites(((Fournisseur)f2).getProduits(), 8) );
         System.out.println("\tquantites attendues : 13, 45, 4, 25, 1002, 3, 10, 0," );   
      }
      System.out.println();  
      
      System.out.println("\nPOINTS : " + nbr + " / 19.0");
      total = total + nbr;
   }

   
   /**
    * tests de la methode fournisseurss.
    */
   public static void testsFournisseurs() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS FOURNISSEURS ");
      System.out.println("--------------------------------\n");
      
      System.out.print("Verification des fournisseurs de c6... ");
      Integer [] tabTest1 = {1, 2};
      if (comparerTab(((Consommateur)c6).fournisseurs(), tabTest1)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, fournisseurs retournes incorrects, "
                 + "devraient etre {1, 2}, dans cet ordre.");
      }
      System.out.println();
      
      System.out.print("Verification des fournisseurs de c7... ");
      Integer [] tabTest2 = {3, 2};
      if (comparerTab(((Consommateur)c7).fournisseurs(), tabTest2)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, fournisseurs retournes incorrects, "
                 + "devraient etre {3, 2}, dans cet ordre.");
      }
      System.out.println();
      
      System.out.print("Verification des fournisseurs de c8... ");
      Integer [] tabTest3 = {2, 1, 3};
      if (comparerTab(((Consommateur)c8).fournisseurs(), tabTest3)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, fournisseurs retournes incorrects, "
                 + "devraient etre {2, 1, 3}, dans cet ordre.");
      }
      System.out.println();
      
      System.out.print("Verification des fournisseurs de c9... ");
      Integer [] tabTest4 = {1, 3};
      if (comparerTab(((Consommateur)c9).fournisseurs(), tabTest4)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, fournisseurs retournes incorrects, "
                 + "devraient etre {1, 3}, dans cet ordre.");
      }
      System.out.println();
      
      System.out.print("Verification des fournisseurs de c9... ");
      Integer [] tabTest5 = null;
      if (comparerTab(((Consommateur)c10).fournisseurs(), tabTest5)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, fournisseurs retournes incorrects, "
                 + "devraient etre null.");
      }
      System.out.println();

      System.out.println("\nPOINTS : " + nbr + " / 5.0");
      total = total + nbr;
   }
   
   
   /**
    * Tests de la methode compilerProfil.
    */
   public static void testsCompilerProfil() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS COMPILER PROFIL ");
      System.out.println("--------------------------------\n");
      
      System.out.print("Verification du profil du fournisseur f1... ");
      String [] tabTest1 = {"MAISON ET CUISINE", "BAGAGES ET SACS", 
         "SPORTS ET PLEIN AIR", "SANTE ET SOINS PERSONNELS"};
      if (comparerTabProfils(f1.compilerProfil(),tabTest1)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"MAISON ET CUISINE\", \"BAGAGES ET SACS\", "
                 + "\"SPORTS ET PLEIN AIR\", \"SANTE ET SOINS PERSONNELS\"" );
      }
      System.out.println();
      
      System.out.print("Verification du profil du fournisseur f2... ");
      String [] tabTest2 = {"TERRASSE ET JARDIN", "ANIMALERIE", "ELECTRONIQUE"};
      if (comparerTabProfils(f2.compilerProfil(),tabTest2)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"TERRASSE ET JARDIN\", \"ANIMALERIE\", "
                 + "\"ELECTRONIQUE\"" );
      }
      System.out.println();
      
      System.out.print("Verification du profil du fournisseur f3... ");
      String [] tabTest3 = {"MAISON ET CUISINE", "TERRASSE ET JARDIN", "LOGICIELS"};
      if (comparerTabProfils(f3.compilerProfil(),tabTest3)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"MAISON ET CUISINE\", \"TERRASSE ET JARDIN\", "
                 + "\"LOGICIELS\"" );
      }
      System.out.println();
      
      System.out.print("Verification du profil du fournisseur f3 apres la mise "
              + "a 0 de la quantite de p1... ");
      Produit.obtenirProduit(1, ((Fournisseur)f3).getProduits()).setQuantite(0);
      String [] tabTest4 = {"TERRASSE ET JARDIN", "LOGICIELS"};
      if (comparerTabProfils(f3.compilerProfil(),tabTest4)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"TERRASSE ET JARDIN\", \"LOGICIELS\"" );
      }
      System.out.println();
      
      System.out.print("Verification du profil du consommateur c6... ");
      String [] tabTest5 = {"MAISON ET CUISINE", "SANTE ET SOINS PERSONNELS", 
         "ELECTRONIQUE", "BAGAGES ET SACS"};
      if (comparerTabProfils(c6.compilerProfil(),tabTest5)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"MAISON ET CUISINE\", \"SANTE ET SOINS PERSONNELS\", "
                 + "\"ELECTRONIQUE\", \"BAGAGES ET SACS\"" );
      }
      System.out.println();
      
      System.out.print("Verification du profil du consommateur c10... ");
      String [] tabTest6 = null;
      if (comparerTabProfils(c10.compilerProfil(),tabTest6)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait etre null." );
      }
      System.out.println();
      
      System.out.print("Verification du profil du consommateur c8... ");
      String [] tabTest7 = {"ELECTRONIQUE", "BAGAGES ET SACS", "MAISON ET CUISINE"};
      if (comparerTabProfils(c8.compilerProfil(),tabTest7)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, profil incorrect. "
                 + "Devrait contenir \"ELECTRONIQUE\", \"BAGAGES ET SACS\", "
                 + "\"MAISON ET CUISINE\"." );
      }
      System.out.println();
      
      System.out.println("\nPOINTS : " + nbr + " / 7.0");
      total = total + nbr;
   }
   
   /**
    * Tests de la methode ajouterEvaluation.
    */
   public static void testsAjouterEvaluation() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TEST AJOUTER EVALUATION");
      System.out.println("--------------------------------\n");
      
      
      System.out.print("Tentative d'ajout d'une evaluation invalide (0) au "
              + "fournisseur f1... ");
      try {
         f1.ajouterEvaluation(0);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'ajout d'une evaluation invalide (6) au "
              + "fournisseur f1... ");
      try {
         f1.ajouterEvaluation(6);
         System.out.println("\nERREUR, devrait lever une Exception.");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur incorrect.");
         }
      }
      System.out.println();
      
      System.out.print("Ajout d'une evaluation (1) au fournisseur f1... ");
      try {
         f1.ajouterEvaluation(1);
         System.out.print("OK.");
         nbr++;
      } catch(Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever un exception.");
      }
      System.out.println();
      
      System.out.print("Ajout d'une evaluation (5) au fournisseur f1... ");
      try {
         f1.ajouterEvaluation(5);
         System.out.print("OK.");
         nbr++;
      } catch(Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever un exception.");
      }
      System.out.println();
      
      System.out.print("Ajout d'une evaluation (3) au fournisseur f1... ");
      try {
         f1.ajouterEvaluation(3);
         System.out.print("OK.");
         nbr++;
      } catch(Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever un exception.");
      }
      System.out.println();
      
      System.out.print("Verification du nombre d'evaluations de f1... ");
      if (f1.getNbrEval() == 3) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, le nombre d'evaluations devrait etre 3 "
                 + "et non " + f1.getNbrEval());
      }
      System.out.println();
      
      System.out.print("Verification du tableau d'evaluations de f1... ");
      int [] tabTest = {1, 5, 3};
      if (comparerTab(f1.getEvaluations(), tabTest, 3)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, tableau des evaluations incorrects. "
                 + "Devrait etre, dans cet ordre, {1, 5, 3}.");
      }
      System.out.println();
      
      System.out.print("Ajout de 8 evaluations (3, 4, 1, 5, 3, 2, 3, 4) au "
              + "consommateur c8... ");
      try {
         c8.ajouterEvaluation(3);
         c8.ajouterEvaluation(4);
         c8.ajouterEvaluation(1);
         c8.ajouterEvaluation(5);
         c8.ajouterEvaluation(3);
         c8.ajouterEvaluation(2);
         c8.ajouterEvaluation(3);
         c8.ajouterEvaluation(4);
         if (c8.getNbrEval() == 8) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERRREUR, le nombre d'evaluations devrait etre "
                    + "8 et non " + c8.getNbrEval());
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");  
      }
      System.out.println();
      
      System.out.print("Verification du tableau d'evaluations de c8... ");
      int [] tabTest2 = {3, 4, 1, 5, 3, 2, 3, 4};
      if (comparerTab(c8.getEvaluations(), tabTest2, 8)) {
         System.out.print("OK.");
         nbr++;
      } else {
         System.out.println("\nERREUR, tableau des evaluations incorrects. "
                 + "Devrait etre, dans cet ordre, {3, 4, 1, 5, 3, 2, 3, 4}.");
      }
      System.out.println();
      
      System.out.println("\nPOINTS : " + nbr + " / 9.0");
      total = total + nbr;
   }
   
   /**
    * Tests de la methodes evaluer.
    */
   public static void testsEvaluer() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS EVALUER");
      System.out.println("--------------------------------\n");
      
      System.out.println("Tests d'evaluations par un consommateur\n");
      
      System.out.print("Tentative d'evaluation d'un consommateur par un autre "
              + "consommateur... ");
      try {
         c6.evaluer(c8, 3);
         System.out.println("\nERREUR, devrait lever une ClassCastException");
      } catch (ClassCastException cce) {
         System.out.print("OK.");
         nbr++;
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "Exception");
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation d'un utilisateur null... ");
      try {
         c6.evaluer(null, 3);
         System.out.println("\nERREUR, devrait lever une NullPointerException");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "Exception");
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation avec une evaluation invalide (0)... ");
      try {
         c6.evaluer(f1, 0);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation avec une evaluation invalide (6)... ");
      try {
         c6.evaluer(f1, 6);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation d'un fournisseur qui n'a jamais "
              + "vendu a ce consommateur... ");
      try {
         c6.evaluer(f3, 4);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_2)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Evaluation (5) de f1 par c6... ");
      try {
         c6.evaluer(f1, 5);
         if (f1.getNbrEval() == 4) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de f1 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation (4) de f1 par c8... ");
      try {
         c8.evaluer(f1, 4);
         if (f1.getNbrEval() == 5) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de f1 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation (5) de f1 par c9... ");
      try {
         c9.evaluer(f1, 5);
         if (f1.getNbrEval() == 6) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de f1 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.println("\nTests d'evaluations par un fournisseur\n");
      
      System.out.print("Tentative d'evaluation d'un fournisseur par un autre "
              + "fournisseur... ");
      try {
         f2.evaluer(f3, 3);
         System.out.println("\nERREUR, devrait lever une ClassCastException");
      } catch (ClassCastException cce) {
         System.out.print("OK.");
         nbr++;
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "Exception");
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation d'un utilisateur null... ");
      try {
         f2.evaluer(null, 3);
         System.out.println("\nERREUR, devrait lever une NullPointerException");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.print("OK.");
         nbr++;
      } catch (Exception e) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "Exception");
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation avec une evaluation invalide (0)... ");
      try {
         f2.evaluer(c7, 0);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation avec une evaluation invalide (6)... ");
      try {
         f2.evaluer(c7, 6);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_3)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Tentative d'evaluation d'un consommateur qui n'a jamais "
              + "achete de ce fournisseur... ");
      try {
         f2.evaluer(c9, 4);
         System.out.println("\nERREUR, devrait lever une Exception");
      } catch (ClassCastException cce) {
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "ClassCastException");
      } catch (NullPointerException npe) {   
         System.out.println("\nERREUR, devrait lever une autre exception que "
                 + "NullPointerException");
      } catch (Exception e) {
         nbr = nbr + 0.5;
         if (e.getMessage().equals(Utilisateur.MSG_ERR_EVAL_1)) {
            nbr = nbr + 0.5;
            System.out.print("OK.");
         } else {
            System.out.println("\nERREUR, message d'erreur invalide.");
         }
      }
      System.out.println();
      
      System.out.print("Evaluation (5) de c8 par f2... ");
      try {
         f2.evaluer(c8, 5);
         if (c8.getNbrEval() == 9) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de c8 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation (2) de c8 par f1... ");
      try {
         f1.evaluer(c8, 2);
         if (c8.getNbrEval() == 10) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de c8 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation (4) de c8 par f1... ");
      try {
         f3.evaluer(c8, 4);
         if (c8.getNbrEval() == 11) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, nombre d'evaluations de c8 incorrect.");
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.println("\nPOINTS : " + nbr + " / 16.0");
      total = total + nbr;
      
   }
   
   /**
    * Tests de la methode evaluationMoyenne.
    */
   public static void testsEvaluationMoyenne() {
      double nbr = 0;
      System.out.println("\n--------------------------------");
      System.out.println("TESTS EVALUATION MOYENNE");
      System.out.println("--------------------------------\n");
      
      
      double eval;
      System.out.print("Evaluation moyenne de f1... ");
      try {
         eval = f1.evaluationMoyenne();
         if (eval == 3.83) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, l'evaluation moyenne devrait etre "
                    + "3.83 et non " + eval);
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation moyenne de c8... ");
      try {
         eval = c8.evaluationMoyenne();
         if (eval == 3.27) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, l'evaluation moyenne devrait etre "
                    + "3.27 et non " + eval);
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation moyenne de c9... ");
      try {
         eval = c9.evaluationMoyenne();
         if (eval == 0) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, l'evaluation moyenne devrait etre "
                    + "0.0 et non " + eval);
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.print("Evaluation moyenne de c9 apres ajout des evaluations "
              + "5, 4 et 5... ");
      
      try {
         c9.ajouterEvaluation(5);
         c9.ajouterEvaluation(4);
         c9.ajouterEvaluation(5);
         eval = c9.evaluationMoyenne();
         if (eval == 4.67) {
            System.out.print("OK.");
            nbr++;
         } else {
            System.out.println("\nERREUR, l'evaluation moyenne devrait etre "
                    + "4.67 et non " + eval);
         }
      } catch (Exception e) {
         System.out.println("\nERREUR, ne devrait pas lever une exception.");
      }
      System.out.println();
      
      System.out.println("\nPOINTS : " + nbr + " / 4.0");
      total = total + nbr;
      
   }
      

   /***********************
    * METHODES PRIVEES
    ***********************/
   
   
   private static boolean comparerTabProduitsCode 
                                    (Produit[] tab, int[] tabTest, int n) {
      boolean pareil = true;
      int i = 0;
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == n){
            while (i < n && pareil) {
               if (tab[i].getCode() != tabTest[i]) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static boolean comparerTabProduitsQte 
                                       (Produit[] tab, int[] tabTest, int n) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == n){
            while (i < n && pareil) {
               if (tab[i].getQuantite() != tabTest[i]) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      
      return pareil;
   }
   
   private static boolean comparerTab (Integer[] tab, Integer[] tabTest) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == tab.length){
            while (i < tab.length && pareil) {
               if (!tabTest[i].equals(tab[i])) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static boolean comparerTab (int[] tab, int[] tabTest, int n) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null){
            while (i < n && pareil) {
               if (tab[i] != tabTest[i]) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static boolean comparerTabProfils (String[] tab, String[] tabTest) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == tab.length){
            while (i < tabTest.length && pareil) {
               if (!TabUtils.elemEstDansTab(tabTest[i], tab)) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static boolean comparerTabProduitsPrix 
                                 (Produit[] tab, double[] tabTest, int n) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == n){
            while (i < n && pareil) {
               if (tab[i].getPrix() != tabTest[i]) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static boolean comparerTabProduitsIdFourn 
                                    (Produit[] tab, int[] tabTest, int n) {
      boolean pareil = true;
      int i = 0;
      
      try {
         if (tab == null && tabTest == null) {
            pareil = true;
         } else if (tab != null && tabTest != null && tabTest.length == n){
            while (i < n && pareil) {
               if (tab[i].getIdFournisseur() != tabTest[i]) {
                  pareil = false;
               }
               i++;
            }
         } else {
            pareil = false;
         }
      } catch (Exception e) {
         pareil = false;
      }
      return pareil;
   }
   
   private static String codes (Produit[] tab, int n) {
      String s = "";

      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            if (tab[i] == null) {
               s = s + "ERREUR, ";
            } else {
               s = s + tab[i].getCode() + ", ";
            }
         }
      } else {
         s = "null";
      }
      return s;
   }
   
   private static String categories (Produit[] tab, int n) {
      String s = "";
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            if (tab[i] == null) {
               s = s + "ERREUR, ";
            } else {
               s = s + tab[i].getCategorie() + ", ";
            }
         }
      } else {
         s = "null";
      }
      return s;
   }
   
   private static String lesPrix (Produit[] tab, int n) {
      String s = "";
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            if (tab[i] == null) {
               s = s + "ERREUR, ";
            } else {
               s = s + tab[i].getPrix() + ", ";
            }
         }
      } else {
         s = "null";
      }
      return s;
   }
   
   private static String idsFourn (Produit[] tab, int n) {
      String s = "";
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            if (tab[i] == null) {
               s = s + "ERREUR, ";
            } else {
               s = s + tab[i].getIdFournisseur() + ", ";
            }
         }
      } else {
         s = "null";
      }
      return s;
   }
   
   private static String quantites (Produit[] tab, int n) {
      String s = "";
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            if (tab[i] == null) {
               s = s + "ERREUR, ";
            } else {
               s = s + tab[i].getQuantite() + ", ";
            }
         }
      } else {
         s = "null";
      }
      return s;
   }
   
   private static void afficherProduits (Produit[] tab, int n) {
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            System.out.print(tab[i].getCode() + "  ");
         }
      } else {
         System.out.print("null");
      }
      System.out.println();
   }
   
   private static void afficherProduitsDetails (Produit[] tab, int n) {
      if (tab != null) {
         for (int i = 0 ; i < n ; i++) {
            System.out.print(tab[i].getIdFournisseur() + "." + tab[i].getCode() 
                    + "(" + tab[i].getQuantite() + ")  ");
         }
      } else {
         System.out.print("null");
      }
      System.out.println();
   }
   
   private static void afficherCat (String[] tab) {
      if (tab != null) {
         for (int i = 0 ; i < tab.length ; i++) {
            System.out.print(tab[i] + ", ");
         }
      } else {
         System.out.print("null");
      }
      System.out.println();
   }
   
   private static void afficherIdFournisseur (Integer[] tab) {
      if (tab != null) {
         for (int i = 0 ; i < tab.length ; i++) {
            System.out.print(tab[i] + ", ");
         }
      } else {
         System.out.print("null");
      }
      System.out.println();
   }
   
   private static void afficherNoteFinale(double nbrPoints) {
      double note = (nbrPoints * PONDERATION) / TOTAL_POINTS;
      note = Math.round(note * 100) / 100.0;
      
      System.out.println("\nNOTE FINALE  : " + note + " / " + 
              PONDERATION + "\n\n\n");
   }  
}
