
/**
 * INF2120 - Groupe 10 Professeur: Melanie Lord
 *
 * @author Guillaume Gagnon
 * @version 2014-02-12
 *
 * Description de la classe: !!!!!!!!!!!!!
 *
 * Informations sur l'etudiant: Gagnon Guillaume GAGG15048002
 * gagnon.guillaume.5@courrier.uqam.ca
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
    private final static int QTY_MIN_STOCK_AJOUT_FOURNISSEUR = 0; // Quantite min
    // d'un produit en inventaire a vendre pour permettre l'inscription d'un nouveau
    // fournisseur.
    private final static int MIN_CATEGORIE_RECOMMAND = 1; // Nombre de minimum de 
    // categorie en commun necessaire pour une recommandation.

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
            // Si c'est un fournisseur et qu'il n'a pas de produit stock a vendre...
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
        ArrayList<Utilisateur> utilisateurInteressant;// = new ArrayList<Utilisateur>();

        if (Utilisateur == null) {
            throw new Exception(ERR_MSG_UTILIS_NULL);
        } else {
            utilisateurInteressant = rechUtilisateursInteressants(utilisateur);
        }
        return utilisateurInteressant;
    }

    public ArrayList<Produit> recommanderProduits(Fournisseur fournisseur,
            Consommateur consommateur) throws Exception {
        return null; //A FAIRE
    }

    public void effectuerTransaction(Fournisseur fournisseur,
            Consommateur consommateur, int codeProduit, int quantite)
            throws Exception {
        //A FAIRE
    }

    public ArrayList<Produit> rechercherProduitsParMotCle(String motCle) {
        return null; //A FAIRE
    }

    public ArrayList<Fournisseur> rechercherFournisseurParEvaluation(int codeProduit) {
        return null; //A FAIRE
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
     * Verifie la liste d'utilisateurs pour savoir si le id de l'utilisateur en
     * parametre est deja present.
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
     * Verifie si un fournisseur a un produit en stock a vendre (quantite > 0).
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
                    && tabProduitsEnVente[i].getQuantite() > QTY_MIN_STOCK_AJOUT_FOURNISSEUR) {
                aProduitAVendre = true;
            }
        }
        return aProduitAVendre;
    }

    /**
     * Recherche parmis les utilisateurs du type oppose si au moins
     * MIN_CATEGORIE_RECOMMAND categorie est en commun avec l'utilisateur en
     * parametre.
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
     * Compare les profils de deux Utilisateurs et retourne vrai si
     * MIN_CATEGORIE_RECOMMAND categorie est en commun.
     *
     * @param user1 Utilisateur
     * @param user2
     * @return
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

}
