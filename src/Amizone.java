/**
 * INF2120 - Groupe 10
 * Professeur: Melanie Lord
 *
 * @author Guillaume Gagnon
 * Code Permanent: GAGG15048002
 * Courriel: gagnon.guillaume.5@courrier.uqam.ca
 * @version 2014-02-21
 *
 * Description de la classe: Cette classe met en relation les consommateurs et
 * les fournisseurs. Elle permet, entre autres, a un utilisateur de s’inscrire
 * au site dans le but de consommer des produits vendus par des fournisseurs ou
 * de vendre des produits aux consommateurs. Elle fournit aussi des services de
 * recommandations (d’utilisateurs et de produits) ainsi que des services de
 * recherche de produits.
 */

import java.util.ArrayList;

public class Amizone {

    /**
     * CONSTANTES
     */
    public final static String ERR_MSG_UTILIS_NULL
            = "Erreur, utilisateur null.";
    public final static String ERR_MSG_FOURN_AUCUN_PRODUIT
            = "Erreur, ce fournisseur ne vend aucun produit.";
    public final static String ERR_MSG_UTILIS_EXISTANT
            = "Erreur, cet utilisateur existe deja.";
    private final static int QTY_MIN_STOCK_AJOUT_FOURNISSEUR = 1; // Quantite min
    // d'un produit en inventaire a vendre pour permettre l'inscription d'un nouveau
    // fournisseur.

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private ArrayList<Utilisateur> utilisateurs;

    /**
     * CONSTRUCTEURS
     */
    /**
     * Constructeur sans argument qui instancie la liste des utilisateurs. La
     * liste est initialement vide.
     */
    public Amizone() {
        utilisateurs = new ArrayList<Utilisateur>();
    }

    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
    /**
     * Cette methode ajoute l’utilisateur en parametre a la liste des
     * utilisateurs d’Amizone.
     *
     * @param utilisateur Utilisateur a ajouter.
     * @throws Exception Si l’utilisateur donne est null OU si l’utilisateur
     * donne est un fournisseur (type Fournisseur) et qu’il ne vend aucun
     * produit dont la quantite est strictement plus grande que 0 OU si
     * l’utilisateur donne est deja dans la liste des utilisateurs d’Amizone.
     */
    public void inscrireUtilisateur(Utilisateur utilisateur) throws Exception {
        if (utilisateur == null) {
            throw new Exception(ERR_MSG_UTILIS_NULL);
        } else if (estDejaMembre(utilisateur)) {
            throw new Exception(ERR_MSG_UTILIS_EXISTANT);
        } else if (utilisateur instanceof Fournisseur && !fournisseurAvecProduitAVendre(utilisateur)) {
            throw new Exception(ERR_MSG_FOURN_AUCUN_PRODUIT);
        } else {
            utilisateurs.add(utilisateur);
        }
    }

    /**
     * Cette methode permet de recommander a un consommateur des fournisseurs
     * potentiellement interessants pour ce consommateur ou bien de recommander
     * a un fournisseur des consommateurs potentiellement interesses par les
     * produits que vend ce fournisseur. Cette recommandation se fait sur la
     * base des profils des utilisateurs. Deux utilisateurs qui ont des profils
     * similaires sont potentiellement interessants l’un pour l’autre. Deux
     * utilisateurs ont des profils similaires s’ils ont au moins
     * MIN_CATEGORIE_RECOMMAND categorie en commun dans leur profil.
     *
     * @param utilisateur Fournisseur ou Consommateur qui recherche un
     * utilisateur, de type inverse au sien,avec un profile comparable.
     * @return Liste d’utilisateurs potentiellement interessants pour
     * l’utilisateur donne. Lorsqu'aucun utilisateur de profil similaire n'est
     * trouve, la methode retourne une liste vide.
     * @throws Exception Si l’utilisateur donne est null.
     */
    public ArrayList<Utilisateur> recommanderUtilisateurs(Utilisateur utilisateur)
            throws Exception {
        ArrayList<Utilisateur> utilisateurInteressant;

        if (utilisateur == null) {
            throw new Exception(ERR_MSG_UTILIS_NULL);
        } else {
            utilisateurInteressant = rechUtilisateursInteressants(utilisateur);
        }
        return utilisateurInteressant;
    }

    /**
     * Cette methode retourne une liste de tous les produits vendus par le
     * fournisseur donne qui sont potentiellement interessants pour le
     * consommateur donne. Les produits potentiellement interessants pour le
     * consommateur donne sont ceux qui possedent une categorie qui est presente
     * dans le profil du consommateur.
     *
     * @param fournisseur Le fournisseur
     * @param consommateur Le consommateur
     * @return Liste de tous les produits vendus par le fournisseur qui sont
     * potentiellement interessants pour le consommateur.
     * @throws Exception Si le fournisseur ou le consommateur donne est null.
     */
    public ArrayList<Produit> recommanderProduits(Fournisseur fournisseur,
            Consommateur consommateur) throws Exception {
        ArrayList<Produit> listeDesProduits = new ArrayList<Produit>();
        String[] profilConsommateur;
        Produit[] produitsFournisseur;

        if (fournisseur == null || consommateur == null) {
            throw new Exception(ERR_MSG_UTILIS_NULL);
        } else {
            profilConsommateur = consommateur.compilerProfil();
            produitsFournisseur = fournisseur.getProduits();

            if (profilConsommateur != null) {
                for (int i = 0; i < produitsFournisseur.length; i++) {
                    if (produitsFournisseur[i] instanceof Produit
                            && produitsFournisseur[i].getQuantite() > 0) {
                        if (TabUtils.elemEstDansTab(produitsFournisseur[i].getCategorie(), profilConsommateur)) {
                            listeDesProduits.add(produitsFournisseur[i]);
                        }
                    }
                }
            }
        }
        return listeDesProduits;
    }

    /**
     * Cette methode permet d’effectuer une transaction achat/vente entre un
     * fournisseur et un consommateur. Elle permet au fournisseur donne de
     * vendre le produit du code donne, de la quantite donnee, au consommateur
     * donne (autrement dit, permet au consommateur donne, d’acheter le produit
     * du code donne, de la quantite donnee, et du fournisseur donne).
     *
     * @param fournisseur Le fournisseur qui vend le Produit.
     * @param consommateur Le consommateur qui achete le Produit.
     * @param codeProduit Le code du Produit pour cette transaction.
     * @param quantite La quantite du produit transige
     * @throws Exception Si le code du produit donne ne correspond a aucun des
     * produits vendus par le fournisseur donne OU si la quantite donnee est
     * plus petite ou egale a 0 ou si elle est plus grande que la quantite en
     * stock du produit ayant le code donne, chez le fournisseur donne.
     */
    public void effectuerTransaction(Fournisseur fournisseur,
            Consommateur consommateur, int codeProduit, int quantite)
            throws Exception {
        Produit produitTransige = fournisseur.obtenirProduit(codeProduit);

        if (produitTransige == null) {
            throw new Exception(Utilisateur.MSG_ERR_VENTE_PROD);
        } else if (quantite <= 0 || quantite > produitTransige.getQuantite()) {
            throw new Exception(Utilisateur.MSG_ERR_QTE);
        } else {
            // NB. consommateur.acheter doit etre traite avant fournisseur.vendre
            // sinon la quantite de la copie du Produit dans consommateur est invalide,
            // la quantite de l'instance du Produit etant diminue dans la fonction
            // vendre de fournisseur.
            consommateur.acheter(produitTransige, quantite); // Achat du consommateur
            fournisseur.vendre(codeProduit, quantite); // Vente du fournisseur
        }
    }

    /**
     * Cette methode retourne une liste de tous les produits (parmi les produits
     * vendus par tous les fournisseurs) dont la description contient le mot cle
     * donne. Pour simplifier la recherche, nous supposerons ici que la
     * description des produits est une suite de mots separes uniquement par un
     * ou des espaces (aucun signe de ponctuation) et que le mot cle donne est
     * un seul mot, sans espace. La recherche ne prend pas compte de la casse.
     * Les produits retournes ont une quantite en stock strictement plus grande
     * que 0. Un meme produit peut revenir plusieurs fois dans la liste
     * retournee si celui-ci est vendu par differents fournisseurs (et qu’il
     * correspond à la recherche, evidemment). Si aucun produit n’est trouve, la
     * methode retourne une liste vide.
     *
     * @param motCle Mot cle recherche.
     * @return Liste de Produit ou liste vide si aucun produit n'est trouve.
     */
    public ArrayList<Produit> rechercherProduitsParMotCle(String motCle) {
        ArrayList<Produit> resultatRech = new ArrayList<Produit>();
        Produit[] produitsFournisseurs;

        // Recherche les listes de produits de tous les fournisseurs
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i) instanceof Fournisseur) {
                produitsFournisseurs = ((Fournisseur) utilisateurs.get(i)).getProduits();
                // Recherche mot cle dans la liste des produits d'un fournisseur
                for (int j = 0; j < produitsFournisseurs.length; j++) {
                    if (produitsFournisseurs[j] instanceof Produit
                            && rechStringDansDescriptionProduit(produitsFournisseurs[j], motCle)
                            && produitsFournisseurs[j].getQuantite() > 0) {
                        resultatRech.add(produitsFournisseurs[j]);
                    }
                }
            }
        }
        return resultatRech;
    }

    /**
     * Cette methode retourne une liste des fournisseurs qui vendent le produit
     * du code donne et dont la quantite (en stock) est strictement plus grande
     * que 0. De plus, les fournisseurs retournes doivent etre ordonnes selon
     * leur evaluation (en ordre decroissant des évaluations : du meilleur (eval
     * 5) au pire (eval 1)). Si aucun fournisseur n’est trouve, la methode
     * retourne une liste vide.
     *
     * @param codeProduit Le produit recherche.
     * @return Liste des fournisseurs avec ce produit a vendre et ordonnes selon
     * leur evaluation (du meilleur (eval 5) au pire (eval 1)). Si aucun
     * fournisseur n’est trouve, la methode retourne une liste vide.
     */
    public ArrayList<Fournisseur> rechercherFournisseurParEvaluation(int codeProduit) {
        ArrayList<Fournisseur> fournisseurs = rechFournisseursDansUtilisateurs();
        ArrayList<Fournisseur> fournisseursAvecLeProduit = new ArrayList<Fournisseur>();

        // Creation d'une liste des fournisseurs avec le produit a vendre et avec
        // la quantite minimum de 1 en inventaire.
        for (int i = 0; i < fournisseurs.size(); i++) {
            if (fournisseurs.get(i).obtenirProduit(codeProduit) != null
                    && fournisseurs.get(i).obtenirProduit(codeProduit).getQuantite() > 0) {
                fournisseursAvecLeProduit.add(fournisseurs.get(i));
            }
        }

        // Mise en ordre des Fournisseur en fonction de l'evaluation
        if (fournisseursAvecLeProduit.size() > 0) {
            fournisseursAvecLeProduit = sortUtilisateursParEval(fournisseursAvecLeProduit);
        }
        return fournisseursAvecLeProduit;
    }

    /**
     * GETTER & SETTER
     */
    /**
     * Cette methode sans argument retourne la liste des utilisateurs.
     *
     * @return La liste des utilisateurs (ArrayList<Utilisateur>).
     */
    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    /**
     * METHODES PRIVEE
     */
    /**
     * Methode utilitaire qui regarde la liste d'utilisateurs pour savoir si le id
     * de l'utilisateur en parametre est deja present.
     *
     * @param utilisateur Utilisateur a verifier.
     * @return Vrai si utilisateur est deja present.
     */
    private boolean estDejaMembre(Utilisateur newUtilisateur) {
        boolean estPresent = false;
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).equals(newUtilisateur)) {
                estPresent = true;
            }
        }
        return estPresent;
    }

    /**
     * Methode utilitaire qui verifie si un fournisseur a un produit en stock a
     * vendre (quantite > 0).
     *
     * @param fournisseur Le fournisseur (Utilisateur) qui desire s'inscrire.
     * @return Vrai si l'utilisateur a au minimum un produit en stock a vendre.
     */
    private boolean fournisseurAvecProduitAVendre(Utilisateur fournisseur) {
        boolean aProduitAVendre = false;
        Produit[] tabProduitsEnVente = ((Fournisseur) fournisseur).getProduits();

        // Recherche dans le tableau pour un Produit avec la quantite minimum de
        // QTY_MIN_STOCK_AJOUT_FOURNISSEUR item.
        for (int i = 0; i < tabProduitsEnVente.length && !aProduitAVendre; i++) {
            if (tabProduitsEnVente[i] instanceof Produit
                    && tabProduitsEnVente[i].getQuantite() >= QTY_MIN_STOCK_AJOUT_FOURNISSEUR) {
                aProduitAVendre = true;
            }
        }
        return aProduitAVendre;
    }

    /**
     * Methode utilitaire qui recherche parmis les utilisateurs du type oppose
     * si au moins MIN_CATEGORIE_RECOMMAND categorie est en commun avec
     * l'utilisateur en parametre.
     *
     * @param utilisateur Utilisateur qui recherche des profils comparables.
     * @return Liste des utilisateurs interessants ou liste vide si aucun
     * trouve.
     */
    private ArrayList<Utilisateur> rechUtilisateursInteressants(Utilisateur utilisateur) {
        ArrayList<Utilisateur> utilisateursComparables = new ArrayList<Utilisateur>();

        if (utilisateur instanceof Consommateur) { //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PEUT-ETRE POSSIBLE DE FAIRE RECHERCHE OPPOSE DU INSTANCEOF ET EVITER DE FAIRE 2 FOR
            // Recherche dans les Fournisseurs
            for (int i = 0; i < utilisateurs.size(); i++) {
                if (utilisateurs.get(i) instanceof Fournisseur) {
                    if (profilComparable(utilisateur, utilisateurs.get(i))) {
                        utilisateursComparables.add(utilisateurs.get(i));
                    }
                }
            }
        } else {
            // Recherche dans les Consommateurs
            for (int i = 0; i < utilisateurs.size(); i++) {
                if (utilisateurs.get(i) instanceof Consommateur) {
                    if (profilComparable(utilisateur, utilisateurs.get(i))) {
                        utilisateursComparables.add(utilisateurs.get(i));
                    }
                }
            }
        }
        // Retourne chaine vide, initialise au debut, si rien trouve
        return utilisateursComparables;
    }

    /**
     * Methode utilitaire qui compare les profils de deux Utilisateurs et
     * retourne vrai si une categorie est en commun.
     * 
     * @param userRecherche Utilisateur qui recherche
     * @param userOffre Utilisateur qui offre
     * @return Vrai si une categorie est presente dans les 2 utilisateurs
     */
    private boolean profilComparable(Utilisateur userRecherche, Utilisateur userOffre) {
        boolean estComparable = false;
        String[] tabProfileUserRecherche = userRecherche.compilerProfil();
        String[] tabProfileUserOffre = userOffre.compilerProfil();

        if (tabProfileUserRecherche != null && tabProfileUserOffre != null) {
            for (int i = 0; i < tabProfileUserRecherche.length && !estComparable; i++) {
                if (TabUtils.elemEstDansTab(tabProfileUserRecherche[i], tabProfileUserOffre)) {
                    estComparable = true;
                }
            }
        }
        return estComparable;
    }

    /**
     * Methode utilitaire qui retourne la liste des fournisseurs (Fournisseur)
     * inscrit au site.
     *
     * @return Liste de fournisseurs ou vide si aucun.
     */
    private ArrayList<Fournisseur> rechFournisseursDansUtilisateurs() {
        ArrayList<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();

        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i) instanceof Fournisseur) {
                listeFournisseurs.add((Fournisseur) utilisateurs.get(i));
            }
        }
        return listeFournisseurs;
    }

    /**
     * Methode utilitaire qui recherche un mot cle à l'interieur de la
     * description d'un produit.
     *
     * @param produit Le produit pour la recherche
     * @param motCle Le mot cle recherche
     * @return true si trouve ou false sinon.
     */
    private boolean rechStringDansDescriptionProduit(Produit produit, String motCle) {
        boolean trouve = false;
        String descriptionProduit = produit.getDescription().toLowerCase(); // Ignore la casse pour la recherche
        motCle = motCle.toLowerCase(); // Ignore la casse pour la recherche
        motCle = ".*\\b" + motCle + "\\b.*"; // Utilisation regex. Ajout de frontiere au mot recherche

        if (descriptionProduit.matches(motCle)) {
            trouve = true;
        }
        return trouve;
    }

    /**
     * Methode utilitaire qui retourne une listes de fournisseurs, dans l'ordre
     * decroissant de la moyenne de leurs notes d'evaluations.
     *
     * @param fournisseurs La liste de fournisseurs a trier.
     * @return La liste de fournisseurs trie.
     */
    private ArrayList<Fournisseur> sortUtilisateursParEval(ArrayList<Fournisseur> fournisseurs) {
        ArrayList<Fournisseur> sortedFournisseurs = new ArrayList<Fournisseur>();
        double meilleureMoyenne; // Meilleure moyenne trouve
        Fournisseur meilleurFournisseur = null; // Meilleur fournisseur trouve

        while (!fournisseurs.isEmpty()) {
            meilleureMoyenne = 0;

            // Trouve le fournisseur avec la meilleure moyenne
            for (int i = 0; i < fournisseurs.size(); i++) {
                if (fournisseurs.get(i).evaluationMoyenne() >= meilleureMoyenne) {
                    meilleureMoyenne = fournisseurs.get(i).evaluationMoyenne();
                    meilleurFournisseur = fournisseurs.get(i);
                }
            }
            // Ajoute au resultat trie, efface de la liste dorigine et loop 
            // pour trouver prochaine meilleure moyenne.
            sortedFournisseurs.add(meilleurFournisseur);
            fournisseurs.remove(meilleurFournisseur); // Retire le fournisseur traite de la liste
        }
        return sortedFournisseurs;
    }
}
