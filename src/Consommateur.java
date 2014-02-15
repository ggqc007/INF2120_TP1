/**
 * INF2120 - Groupe 10 Professeur: Melanie Lord
 *
 * @author Guillaume Gagnon
 * @version 2014-02-12
 *
 * Description de la classe: La classe Consommateur est une classe concrete qui
 * herite de la classe Utilisateur.
 *
 * Informations sur l'etudiant: Gagnon Guillaume GAGG15048002
 * gagnon.guillaume.5@courrier.uqam.ca
 */

public class Consommateur extends Utilisateur {

    /**
     * CONSTANTES
     */
    private static final int EVAL_MIN = 1; // Note d'evaluation minimum
    private static final int EVAL_MAX = 5; // Note d'evaluation maximum

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private Produit[] achats; // Tableau des produits achetes par ce consommateur
    private int nbrAchats; // Nombre de produits achetes (presents dans tableau achats)

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Consommateur avec le pseudo, le motPasse et le courriel
     * passes en parametres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau des achats de ce consommateur est
     * initialisee a Utilisateur.LONG_TAB et nbrAchats est a 0. La longueur du
     * tableau evaluations est initialisee a Utilisateur.LONG_TAB et nbrEval est
     * a 0.
     *
     * @param pseudo Le nom d'utilisateur (pseudonyme) de ce consommateur.
     * @param motPasse Le mot de passe de ce consommateur.
     * @param courriel Le courriel de ce consommateur.
     *
     * ANTECEDENTS : le pseudo, le motPasse et le courriel doivent etre valides
     * (non null, non vides, correctement formes, etc.). On suppose aussi que
     * ces valeurs sont uniques pour chaque utilisateur cree.
     */
    public Consommateur(String pseudo, String motPasse, String courriel) {
        super(pseudo, motPasse, courriel);
        achats = new Produit[Utilisateur.LONG_TAB];
        nbrAchats = 0;
    }

    /**
     * Constructeur de copie. Pour tests seulement.
     *
     * @param consommateur Le consommateur dont on veut une copie.
     */
    public Consommateur(Consommateur consommateur) {
        super(consommateur);
    }

    /**
     * REDEFINITION METHODES
     */
    /**
     * Cette methode retourne un tableau de type String representant le profil
     * de l’utilisateur. (Les categories de produits qu’il a achetes par le
     * passe.).
     *
     * @return Tableau de type String ou null si aucun produit n'a encore ete
     * achete.
     */
    @Override
    public String[] compilerProfil() {
        String[] categoriesAchete = new String[Utilisateur.LONG_TAB];
        int categoriesUniqueTrouve = 0;

        for (int i = 0; i < achats.length; i++) {
            if (achats[i] instanceof Produit
                    && !TabUtils.elemEstDansTab(achats[i].getCategorie(), categoriesAchete)) {
                categoriesAchete[categoriesUniqueTrouve] = achats[i].getCategorie();
                categoriesUniqueTrouve = categoriesUniqueTrouve + 1;
            }
        }
        // Mise a null si rien trouve ou ajuste longueur du tableau avant le retour...
        if (categoriesUniqueTrouve == 0) {
            categoriesAchete = null;
        } else {
            categoriesAchete = TabUtils.copieTab(categoriesAchete, categoriesUniqueTrouve);
        }
        return categoriesAchete;
    }

    /**
     * Permet a ce consommateur d’evaluer un fournisseur (recu en parametre).
     *
     * @param fournisseur Le fournisseur evalue (type Utilisateur).
     * @param evalScore L'evaluation donnee au fournisseur.
     *
     * @throws java.lang.ClassCastException Si l’utilisateur passe en parametre
     * n’est pas de type Fournisseur.
     * @throws java.lang.NullPointerException Si l’utilisateur passe en
     * parametre est null.
     * @throws java.lang.Exception Si le fournisseur passe en parametre n’a
     * jamais vendu de produit(s) a ce consommateur OU si l’evaluation passee en
     * parametre est invalide.
     */
    @Override
    public void evaluer(Utilisateur fournisseur, int evalScore) throws Exception {
        if (fournisseur == null) {
            throw new NullPointerException();
        } else if (!(fournisseur instanceof Fournisseur)) {
            throw new ClassCastException();
        } else if (evalScore < EVAL_MIN || evalScore > EVAL_MAX) {
            throw new Exception(Utilisateur.MSG_ERR_EVAL_3);
        } else if (!(TabUtils.elemEstDansTab(fournisseur.getId(), fournisseurs()))) {
            // Recherche dans tab fournisseurs de cette classe pour savoir si 
            // utilisateur en parametre est present
            throw new Exception(Utilisateur.MSG_ERR_EVAL_2);
        } else {
            fournisseur.ajouterEvaluation(evalScore);
        }
    }

    /**
     * Retourne une representation sous forme de chaine de caracteres de ce
     * consommateur.
     *
     * @return Une representation sous forme de chaine de caracteres de ce
     * consommateur.
     */
    @Override
    public String toString() {
        return super.toString() + " - " + nbrAchats;
    }

    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
    /**
     * Cette methode consiste a ajouter un produit au tableau des achats.             !!!!!!!!!!!!!!!!!!! a ajoute UNE COPIE du produit??????
     *
     * @param produit Le produit a ajouter (Type Produit).
     * @param quantite La quantite achetee.
     * @throws ExceptionProduitInvalide Si le produit donne est null.
     * @throws Exception Si le produit n’est vendu par aucun fournisseur OU si
     * la quantite achetee est plus petite ou egale a 0 ou si elle est plus
     * grande que la quantite en stock du produit.
     */
    public void acheter(Produit produit, int quantite) throws Exception {
        if (produit == null) {
            throw new ExceptionProduitInvalide();
        } else if (produit.getIdFournisseur() == 0) {
            throw new Exception(Utilisateur.MSG_ERR_ACHAT);
        } else if (quantite <= 0 || quantite > produit.getQuantite()) {
            throw new Exception(Utilisateur.MSG_ERR_QTE);
        } else {
            // On ajoute une copie du produit!
            achats[nbrAchats] = new Produit(produit);
            achats[nbrAchats].setQuantite(quantite);
            nbrAchats = nbrAchats + 1;
        }
    }

    /**
     * Retourne un tableau d’entiers (type Integer []) de tous les numeros
     * d’identification des fournisseurs de qui ce consommateur a achete un ou
     * des produits.
     *
     * @return Retourne un tableau d’entiers (type Integer []) ou null si le
     * consommateur n’a encore fait aucun achat.
     */
    public Integer[] fournisseurs() {
        Integer[] tabFournisseursUtilise = new Integer[Utilisateur.LONG_TAB];
        int nbrFournisseurUtilise = 0;

        for (int i = 0; i < achats.length; i++) {
            // Ajoute les id fournisseurs des produits si pas deja presents
            if (achats[i] instanceof Produit
                    && !(TabUtils.elemEstDansTab(achats[i].getIdFournisseur(), tabFournisseursUtilise))) {
                tabFournisseursUtilise[nbrFournisseurUtilise] = achats[i].getIdFournisseur();
                nbrFournisseurUtilise = nbrFournisseurUtilise + 1;
            }
        }
        // Ajuste longueur du tab ou mise a null avant retour
        if (nbrFournisseurUtilise > 0) {
            tabFournisseursUtilise = TabUtils.copieTab(tabFournisseursUtilise, nbrFournisseurUtilise);
        } else {
            tabFournisseursUtilise = null;
        }
        return tabFournisseursUtilise;
    }

    /**
     * Getter & Setters
     */
    /**
     * Retourne le tableau des produits achetes par ce consommateur.
     *
     * @return Tableau des produits achetes par ce consommateur.
     */
    public Produit[] getAchats() {
        return achats;
    }

    /**
     * Retourne le nombre de produits achetes (presents dans tableau achats).
     *
     * @return Le nombre de produits achetes.
     */
    public int getNbrAchats() {
        return nbrAchats;
    }
}
