
/**
 * Cette classe modelise un utilisateur d'un site de commerce electronique
 * integrant un systeme de recommandations basees sur l'evaluation des pairs
 * ainsi que les preferences (le profil) des utilisateurs.
 *
 * @author melanie lord
 * @version 21/01/2014
 */
public abstract class Utilisateur {

    /**
     * CONSTANTES
     */
    //Messages d'erreurs
    public static final String MSG_ERR_EVAL_1 = "Erreur, ce fournisseur ne peut "
            + "pas evaluer ce consommateur.";
    public static final String MSG_ERR_EVAL_2 = "Erreur, ce consommateur ne peut "
            + "pas evaluer ce fournisseur.";
    public static final String MSG_ERR_EVAL_3 = "Erreur, l'evaluation doit etre "
            + "un nombre entier entre 1 et 5 inclusivement.";
    public static final String MSG_ERR_QTE = "Erreur, quantite invalide.";
    public static final String MSG_ERR_PRIX = "Erreur, prix invalide.";
    public static final String MSG_ERR_AJOUT_PROD = "Erreur, ce produit ne peut "
            + "etre ajoute car il existe deja.";
    public static final String MSG_ERR_VENTE_PROD = "Erreur, ce produit n'est pas "
            + "vendu par ce fournisseur.";
    public static final String MSG_ERR_ACHAT = "Erreur, ce produit n'est vendu par "
            + "aucun fournisseur.";

    //longueur des tableaux
    public static final int LONG_TAB = 100; //longueur des tableaux

    /**
     * VARIABLE DE CLASSE
     */
    //sequence pour assigner un numero unique (id) a un utilisateur
    private static int seqId = 1;

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private int id;
    private String pseudo;
    private String motPasse;
    private String courriel;
    private int[] evaluations;
    private int nbrEval;

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Utilisateur avec le pseudo, le motPasse et le courriel
     * donnes en paramètres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau evaluations est initialisee a
     * LONG_TAB et nbrEval est a 0.
     *
     * @param pseudo le nom d'utilisateur (pseudonyme) de cet utilisateur.
     * @param motPasse le mot de passe de cet utilisateur
     * @param courriel le courriel de cet utilisateur
     *
     * ANTECEDENTS : le pseudo, le motPasse et le courriel doivent etre valides
     * (non null, non vides, correctement formes, etc.). On suppose aussi que
     * ces valeurs sont uniques pour chaque utilisateur cree.
     */
    public Utilisateur(String pseudo, String motPasse, String courriel) {
        this.pseudo = pseudo;
        this.motPasse = motPasse;
        this.courriel = courriel;
        this.id = seqId;
        seqId++;
        this.evaluations = new int[LONG_TAB];
        this.nbrEval = 0;
    }

    /**
     * Constructeur de copie. POUR TESTS SEULEMENT.
     *
     * @param utilisateur l'utilisateur dont on veut une copie.
     */
    public Utilisateur(Utilisateur utilisateur) {
        this.pseudo = utilisateur.pseudo;
        this.motPasse = utilisateur.motPasse;
        this.courriel = utilisateur.courriel;
        this.evaluations = utilisateur.evaluations;
        this.nbrEval = utilisateur.nbrEval;
        this.id = utilisateur.id;
    }

    /**
     * METHODES ABSTRAITES
     */
    
    /**
     * GETTERS ET SETTERS
     */
    
    /**
     * REDEFINITION METHODES
     */
    
    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
}
