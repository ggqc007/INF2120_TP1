
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

    private static final int EVAL_MIN = 1;
    private static final int EVAL_MAX = 5;
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
     * Cette méthode retourne un tableau de type String représentant le profil
     * de l’utilisateur et ne prend aucun paramètre.
     *
     * @return tableau de type String représentant le profil de l’utilisateur
     */
    public abstract String[] compilerProfil();

    /**
     * Cette méthode permet à un utilisateur d’évaluer un autre utilisateur. En
     * effet, les utilisateurs du site Amizone peuvent s’évaluer entre eux. Un
     * fournisseur (respectivement consommateur) peut évaluer un consommateur
     * (respectivement fournisseur) en lui attribuant une note d’appréciation
     * (une évaluation) basée sur l’expérience d’une transaction conclue avec ce
     * consommateur (respectivement fournisseur). Une évaluation valide est une
     * note comprise entre 1 et 5 où 5 constitue la meilleure évaluation.
     *
     *
     * @param user l’utilisateur évalué (type Utilisateur)
     * @param evalScore l’évaluation donnée à l’utilisateur
     *
     * Cette méthode leve une Exception (type Exception) lorsque 1)
     * l’utilisateur évalué n’a jamais conclu de transaction avec l’utilisateur
     * qui l’évalue ou lorsque 2) l’évaluation donnée en paramètre n’est pas
     * valide
     */
    public abstract void evaluer(Utilisateur user, int evalScore);

    /**
     * GETTERS ET SETTERS
     */
    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public String getCourriel() {
        return courriel;
    }

    public int[] getEvaluations() {
        return evaluations;
    }

    public int getNbrEval() {
        return nbrEval;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * REDEFINITION METHODES
     */
    @Override
    public boolean equals(Object autreUtilisateur) {
        return autreUtilisateur != null
                && this.getId() == ((Utilisateur) autreUtilisateur).getId();
    }
    /*
     @Override
     public boolean equals(Object autreItem) {
     return autreItem != null &&
     //N.B. getClass() retourne le type dynamique ici
     this.getClass() == autreItem.getClass() &&
     //this.getClass().equals(autreItem.getClass()) &&
     // AUSSI, ne pas oublier de cast l'objet pour le rendre compatible avec Item dans 
     // le cas ou ItemInventaire serait l'objet passe en parametre par la classe enfant...
     this.prix == ((Item)autreItem).prix
     }
     */

    /**
     * Retourne une representation de cet utilisateur sous forme d'une chaine de
     * caracteres (son id, son pseudonyme, son mot de passe, son courriel et le
     * nombre de ses evaluations reçues).
     *
     * @return une representation de cet utilisateur sous forme d'une chaine de
     * caracteres.
     */
    public String toString() {
        return id + " : " + pseudo + " - " + motPasse + " - " + courriel
                + " - " + nbrEval;
    }

    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
    /**
     * Cette méthode calcule et retourne la moyenne de toutes les évaluations de
     * cet utilisateur (contenues dans le tableau evaluations).
     *
     * @return Moyenne des évaluations ou 0 si pas d'évaluations.
     */
    public double evaluationMoyenne() {
        double totalScore = 0;

        for (int i = 0; i < evaluations.length; i++) {
            totalScore = totalScore + evaluations[i];
        }
        return (double) Math.round((totalScore / nbrEval) * 100) / 100;
    }

    /**
     * Cette méthode permet d’ajouter une nouvelle évaluation reçue au tableau
     * des évaluations de cet utilisateur.
     *
     * @param evalScore Note d'évaluation
     * @throws java.lang.Exception InvalideEvalException Cette méthode leve une Exception (type
     * Exception) contenant le message Utilisateur.MSG_ERR_EVAL_3 lorsque
     * l’évaluation donnée en paramètre n’est pas valide.
     */
    public void ajouterEvaluation(int evalScore) throws Exception {
        if (evalScore < EVAL_MIN || evalScore > EVAL_MAX) {
            throw new Exception(MSG_ERR_EVAL_3);
        } else {
            evaluations[nbrEval] = evalScore;
            nbrEval++;
        }
    }

}
