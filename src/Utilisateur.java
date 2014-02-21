/**
 * INF2120 - Groupe 10
 * Professeur: Melanie Lord
 *
 * @author Guillaume Gagnon
 * Code Permanent: GAGG15048002
 * Courriel: gagnon.guillaume.5@courrier.uqam.ca
 * @version 2014-02-12
 * 
 * Description de la classe: Cette classe modelise un utilisateur d'un site de
 * commerce electronique integrant un systeme de recommandations basees sur
 * l'evaluation des pairs ainsi que les preferences (le profil) des
 * utilisateurs.
 */

public abstract class Utilisateur {
    
    /**
     * CONSTANTES
     */
    // Messages d'erreurs
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
    // Longueur des tableaux
    public static final int LONG_TAB = 100; // Longueur des tableaux

    /**
     * VARIABLE DE CLASSE
     */
    // Sequence pour assigner un numero unique (id) a un utilisateur
    private static int seqId = 1;

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private int id; // Numero d’identification unique pour cet utilisateur
    private String pseudo; // Le nom d'utilisateur (pseudonyme) de cet utilisateur
    private String motPasse; // Le mot de passe de cet utilisateur
    private String courriel; // Le courriel de cet utilisateur
    private int[] evaluations; // Le tableau des evaluations reçues
    private int nbrEval; // Le nombre d’evaluations dans le tableau evaluations 

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Utilisateur avec le pseudo, le motPasse et le courriel
     * donnes en paramètres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau evaluations est initialisee a
     * LONG_TAB et nbrEval est a 0.
     *
     * @param pseudo Le nom d'utilisateur (pseudonyme) de cet utilisateur.
     * @param motPasse Le mot de passe de cet utilisateur.
     * @param courriel Le courriel de cet utilisateur.
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
     * @param utilisateur L'utilisateur dont on veut une copie.
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
     * Cette méthode retourne un tableau de type String representant le profil
     * de l’utilisateur et ne prend aucun parametre.
     *
     * @return Tableau de type String representant le profil de l’utilisateur.
     */
    public abstract String[] compilerProfil();

    /**
     * Cette methode permet a un utilisateur d’evaluer un autre utilisateur. Une
     * evaluation valide est une note comprise entre EVAL_MIN et EVAL_MAX ou 
     * EVAL_MAX constitue la meilleure evaluation.
     *
     * @param user L’utilisateur evalue (type Utilisateur).
     * @param evalScore L’evaluation donnee à l’utilisateur.
     *
     * @throws Exception Si 1) evaluation donnee en parametre n’est pas valide
     *         ou si 2) l’utilisateur evalue n’a jamais conclu de transaction
     *         avec l’utilisateur qui l’evalue.
     */
    public abstract void evaluer(Utilisateur user, int evalScore) throws Exception;

    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
    /**
     * Calcule et retourne la moyenne de toutes les evaluations de cet
     * utilisateur (contenues dans le tableau evaluations).
     *
     * @return Moyenne des evaluations (ou 0 si pas d'evaluations).
     */
    public double evaluationMoyenne() {
        double totalScore = 0;

        for (int i = 0; i < evaluations.length; i++) {
            totalScore = totalScore + evaluations[i];
        }
        return (double) Math.round((totalScore / nbrEval) * 100) / 100;
    }

    /**
     * Cette methode permet d’ajouter une nouvelle evaluation reçue au tableau
     * des evaluations de cet utilisateur.
     *
     * @param evalScore Note d'evaluation
     * @throws Exception InvalideEvalException Si l’evaluation donnee en parametre
     *         n’est pas valide.
     */
    public void ajouterEvaluation(int evalScore) throws Exception {
        if (evalScore < EVAL_MIN || evalScore > EVAL_MAX) {
            throw new Exception(MSG_ERR_EVAL_3);
        } else {
            evaluations[nbrEval] = evalScore;
            nbrEval++;
        }
    }

    /**
     * GETTERS ET SETTERS
     */
    /**
     * Retourne l'identificateur unique de l'utilisateur.
     *
     * @return Identificateur unique de l'utilisateur.
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le nom de l'utilisateur (son pseudonyme).
     *
     * @return Nom d'utilisateur (pseudonyme).
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Retourne le mot de passe de l'utilisateur.
     *
     * @return Mot de passe.
     */
    public String getMotPasse() {
        return motPasse;
    }

    /**
     * Retourne le courriel de l'utilisateur.
     *
     * @return Courriel de l'utilisateur.
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Retourne le tableau des evaluations recues.
     *
     * @return Tableau de type int des evaluations recues.
     */
    public int[] getEvaluations() {
        return evaluations;
    }

    /**
     * Retourne le nombre d'evalusations dans le tableau d'evaluations.
     *
     * @return Nombre d'evalusations dans le tableau d'evaluations.
     */
    public int getNbrEval() {
        return nbrEval;
    }

    /**
     * Modifie le nom de l'utilisateur (son pseudonyme).
     *
     * @param pseudo Le nouveau nom d'utilisateur (pseudonyme).
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Modifie le mot de passe de l'utilisateur.
     *
     * @param motPasse Le nouveau mot de passe de l'utilisateur.
     */
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    /**
     * Modifie le courriel de l'utilisateur.
     *
     * @param courriel Nouveau courriel de l'utilisateur.
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * REDEFINITION METHODES
     */
    /**
     * Deux utilisateurs sont consideres comme etant egaux s’ils ont le meme id.
     *
     * @param autreUtilisateur utilisateur a comparer.
     * @return true si id de l'utilisateur en parametre est identique a celui de
     *         l'instance.
     */
    @Override
    public boolean equals(Object autreUtilisateur) {
        return autreUtilisateur != null
                && getClass() == autreUtilisateur.getClass()
                && this.getId() == ((Utilisateur) autreUtilisateur).getId();
    }

    /**
     * Retourne une representation de cet utilisateur sous forme d'une chaine de
     * caracteres (son id, son pseudonyme, son mot de passe, son courriel et le
     * nombre de ses evaluations reçues).
     *
     * @return une representation de cet utilisateur sous forme d'une chaine de
     *         caracteres.
     */
    @Override
    public String toString() {
        return id + " : " + pseudo + " - " + motPasse + " - " + courriel
                + " - " + nbrEval;
    }

}
