/**
 * INF2120 - Groupe 10 Professeur: Melanie Lord
 *
 * @author Guillaume Gagnon
 * Code Permanent: GAGG15048002
 * Courriel: gagnon.guillaume.5@courrier.uqam.ca
 * @version 2014-02-12
 *
 * Description de la classe: La classe Fournisseur est une classe concrete qui
 * herite de la classe Utilisateur.
 */

public class Fournisseur extends Utilisateur {

    /**
     * CONSTANTES
     */
    private static final int EVAL_MIN = 1; // Note d'evaluation minimum
    private static final int EVAL_MAX = 5; // Note d'evaluation maximum

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private Produit[] produits; // Tableau des produits vendus par ce fournisseur
    private int nbrProduits; // Le nombre de produits vendus (presents dans le tableau des produits)

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Fournisseur avec le pseudo, le motPasse et le courriel
     * donnes en parametres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau des produits vendus par ce
     * fournisseurs est initialisee a Utilisateur.LONG_TAB et nbrProduits est a
     * 0. La longueur du tableau evaluations est initialisee a
     * Utilisateur.LONG_TAB et nbrEval est a 0.
     *
     * @param pseudo Le nom d'utilisateur (pseudonyme) de ce fournisseurs.
     * @param motPasse Le mot de passe de ce fournisseurs.
     * @param courriel Le courriel de ce fournisseurs.
     *
     * ANTECEDENTS : le pseudo, le motPasse et le courriel sont des valeurs
     * valides non vides et non egales a null. On suppose aussi que ces valeurs
     * sont uniques pour chaque utilisateur.
     */
    public Fournisseur(String pseudo, String motPasse, String courriel) {
        super(pseudo, motPasse, courriel);
        produits = new Produit[Utilisateur.LONG_TAB];
        nbrProduits = 0;
    }

    /**
     * Constructeur de copie. Pour tests seulement.
     *
     * @param fournisseur Le fournisseurs dont on veut une copie.
     */
    public Fournisseur(Fournisseur fournisseur) {
        super(fournisseur);
    }

    /**
     * REDEFINITION METHODES
     */
    /**
     * Retourne un tableau contenant toutes les categories differentes recensees
     * sur les produits vendus par ce fournisseur (produits dans le tableau des
     * produits). Seuls les produits dont la quantite en stock (voir attribut
     * quantite de la classe Produit) est strictement plus grande que 0 sont
     * consideres pour recenser les categories.
     *
     * @return produitsEnVente Tableau contenant toutes les categories
     * differentes recensees sur les produits vendus par ce fournisseur.
     */
    @Override
    public String[] compilerProfil() {
        String[] produitsEnVente = new String[Utilisateur.LONG_TAB];
        int nbrProduitsEnVente = 0;

        for (int i = 0; i < produits.length && produits != null; i++) {
            if (produits[i] instanceof Produit
                    && !(TabUtils.elemEstDansTab(produits[i].getCategorie(), produitsEnVente))
                    && produits[i].getQuantite() > 0) {
                // Alors on ajoute la categorie au tableau!
                produitsEnVente[nbrProduitsEnVente] = produits[i].getCategorie();
                nbrProduitsEnVente = nbrProduitsEnVente + 1;
            }
        }
        // Ajuste longueur du tab ou mise a null avant retour
        if (nbrProduitsEnVente > 0) {
            produitsEnVente = TabUtils.copieTab(produitsEnVente, nbrProduitsEnVente);
        } else {
            produitsEnVente = null;
        }
        return produitsEnVente;
    }

    /**
     * Cette methode permet à ce fournisseur d’evaluer un consommateur (recu en
     * parametre).
     *
     * @param consommateur Consommateur a evaluer.
     * @param evalScore Note de l'evaluation.
     *
     * @throws ClassCastException Si l’utilisateur passe en parametre n’est pas
     * de type Consommateur.
     * @throws NullPointerException Si l’utilisateur passe en parametre est
     * null.
     * @throws Exception Si le consommateur passe en parametre n’a jamais achete
     * de produit(s) de ce fournisseur OU si l’evaluation passee en parametre
     * est invalide.
     */
    @Override
    public void evaluer(Utilisateur consommateur, int evalScore)
            throws ClassCastException, NullPointerException, Exception {
        if (consommateur == null) {
            throw new NullPointerException();
        } else if (!(consommateur instanceof Consommateur)) {
            throw new ClassCastException();
        } else if (evalScore < EVAL_MIN || evalScore > EVAL_MAX) {
            throw new Exception(Utilisateur.MSG_ERR_EVAL_3);
        } else if (!(TabUtils.elemEstDansTab(this.getId(),
                ((Consommateur) consommateur).fournisseurs()))) {
            // Si n'est pas dans tableau... j'ai fait un cast car consommateur en parametre
            // est de type Utilisateur donc methode fournisseurs() n'etait pas visible...
            throw new Exception(Utilisateur.MSG_ERR_EVAL_1);
        } else {
            consommateur.ajouterEvaluation(evalScore);
        }
    }

    /**
     * Retourne une representation sous forme de chaine de caracteres de ce
     * Fournisseur.
     *
     * @return une representation sous forme de chaine de caracteres de ce
     * Fournisseur.
     */
    @Override
    public String toString() {
        return super.toString() + " - " + nbrProduits;
    }

    /**
     * METHODES D'INSTANCE PUBLIQUES
     */
    /**
     * Permet d’ajouter un nouveau produit à vendre dans le tableau des produits
     * de ce fournisseur, si celui-ci n’y est pas deja.
     *
     * @param produit Le nouveau produit à ajouter au tableau des produits.
     * @param quantite La quantite en stock initiale de ce nouveau produit a
     * vendre.
     * @param prix Le prix de vente de ce nouveau produit à vendre.
     *
     * @throws ExceptionProduitInvalide Si le produit donne en parametre est
     * null.
     * @throws Exception Si la quantite en stock donnee est plus petite ou egale
     * a 0 OU si le prix de vente donne est plus petit ou egal à 0 OU si le
     * produit donne en parametre existe deja dans le tableau des produits de ce
     * fournisseur.
     */
    public void ajouterNouveauProduit(Produit produit, int quantite, double prix)
            throws Exception {
        if (produit == null) {
            throw new ExceptionProduitInvalide();
        } else if (quantite <= 0) {
            throw new Exception(Utilisateur.MSG_ERR_QTE);
        } else if (prix <= 0) {
            throw new Exception(Utilisateur.MSG_ERR_PRIX);
        } else if (TabUtils.elemEstDansTab(produit, produits)) {
            throw new Exception(Utilisateur.MSG_ERR_AJOUT_PROD);
        } else {
            produits[nbrProduits] = new Produit(produit);
            produits[nbrProduits].setIdFournisseur(this.getId());
            produits[nbrProduits].setQuantite(quantite);
            produits[nbrProduits].setPrix(prix);

            nbrProduits = nbrProduits + 1;
        }
    }

    /**
     * Cette methode recherche, dans le tableau des produits de ce fournisseur,
     * le produit ayant le code donne.
     *
     * @param codeProduit Le code du produit recherche.
     * @return Le produit (type Produit) s’il a ete trouve, sinon elle retourne
     * la valeur null.
     */
    public Produit obtenirProduit(int codeProduit) {
        Produit produitTrouve = null;

        if (produits != null) {
            for (int i = 0; i < produits.length && produitTrouve == null; i++) {
                if (produits[i] instanceof Produit
                        && produits[i].getCode() == codeProduit) {
                    produitTrouve = produits[i];
                }
            }
        }
        return produitTrouve;
    }

    /**
     * Cette methode permet de diminuer la quantite en stock d’un produit vendu.
     *
     * @param codeProduit Code du produit dont on veut diminuer la quantite en
     * stock.
     * @param quantite La quantite vendue qu’on veut soustraire a la quantite en
     * stock.
     *
     * @throws Exception Si le code du produit donne ne correspond a aucun des
     * produits vendus par ce fournisseur OU si la quantite vendue donnee est
     * plus petite ou egale a 0 ou si elle est plus grande que la quantite en
     * stock du produit ayant le code donne.
     */
    public void vendre(int codeProduit, int quantite) throws Exception {
        Produit produitTrouve = null;

        // Recherche le produit dans le tableau
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] instanceof Produit
                    && produits[i].getCode() == codeProduit) {
                produitTrouve = produits[i];
            }
        }

        if (produitTrouve == null) {
            throw new Exception(Utilisateur.MSG_ERR_VENTE_PROD);
        } else if (quantite <= 0 || quantite > produitTrouve.getQuantite()) {
            throw new Exception(Utilisateur.MSG_ERR_QTE);
        } else {
            produitTrouve.diminuerQte(quantite);
        }
    }

    /**
     * Getter & Setters
     */
    /**
     * Retourne le tableau des produits vendus par ce fournisseur.
     * @return produits Tableau des produits vendus par ce fournisseur.
     */
    public Produit[] getProduits() {
        return produits;
    }

    /**
     * Retourne Le nombre de produits vendus (presents dans le tableau des produits).
     * @return Le nombre de produits vendus (presents dans le tableau des produits).
     */
    public int getNbrProduits() {
        return nbrProduits;
    }
}
