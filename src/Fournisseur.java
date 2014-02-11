
public class Fournisseur extends Utilisateur {

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private Produit[] produits;
    private int nbrProduits;

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Fournisseur avec le pseudo, le motPasse et le courriel
     * donnes en parametres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau des produits vendus par ce
     * fournisseur est initialisee a Utilisateur.LONG_TAB et nbrProduits est a
     * 0. La longueur du tableau evaluations est initialisee a
     * Utilisateur.LONG_TAB et nbrEval est a 0.
     *
     * @param pseudo le nom d'utilisateur (pseudonyme) de ce fournisseur.
     * @param motPasse le mot de passe de ce fournisseur
     * @param courriel le courriel de ce fournisseur
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
     * @param fournisseur le fournisseur dont on veut une copie.
     */
    public Fournisseur(Fournisseur fournisseur) {
        super(fournisseur);
    }

    /**
     * METHODES
     */
    /**
     * METHODES
     */
    /**
     * @return produitsEnVente
     */
    @Override
    public String[] compilerProfil() {
        String[] produitsEnVente = null; // ne pas oublier de resize le tableau avant retour
        int nbrProduitsEnVente = 0;

        for (int i = 0; i < produits.length && produits != null; i++) {
            if (!(TabUtils.elemEstDansTab(produits[i].getCategorie(), produitsEnVente)) && produits[i].getQuantite() > 0) {
                if (produitsEnVente == null) {
                    produitsEnVente = new String[Utilisateur.LONG_TAB];
                }
                produitsEnVente[nbrProduitsEnVente] = produits[i].getCategorie();
                nbrProduitsEnVente = nbrProduitsEnVente + 1;
            }
        }

        if (produitsEnVente != null) {
            // resize
            produitsEnVente = TabUtils.copieTab(produitsEnVente, (nbrProduitsEnVente - 1));
        }
        return produitsEnVente;
    }

    @Override
    public void evaluer(Utilisateur consommateur, int evalScore) throws ClassCastException, NullPointerException, Exception {
        if (consommateur == null) {
            throw new NullPointerException();
        } else if (!(consommateur instanceof Consommateur)) {
            throw new ClassCastException();
        } else if (evalScore < 0 || evalScore > 5) {
            throw new Exception(Utilisateur.MSG_ERR_EVAL_3);
        } else if (consommateur != null) {
            // TODO ... trouvé comment savoir si consomateur a deja acheté un produit au consommateur.. 
            // surement une methode a venir dans consommateur???
        } else {
            consommateur.ajouterEvaluation(evalScore);
        }
    }

    public void ajouterNouveauProduit(Produit produit, int quantite, double prix) throws Exception {
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
     *
     */
    public Produit obtenirProduit(int codeProduit) {
        Produit produitTrouve = null;

        for (int i = 0; produits != null && i < produits.length && produitTrouve == null; i++) {
            if (produits[i].getCode() == codeProduit) {
                produitTrouve = produits[i];
            }
        }
        return produitTrouve;
    }

    /**
     *
     * @param codeProduit
     * @param quantite
     * @throws java.lang.Exception
     */
    public void vendre(int codeProduit, int quantite) throws Exception {
        if (quantite <= 0) {
            throw new Exception(Utilisateur.MSG_ERR_VENTE_PROD);
        } else {
            for (int i = 0; i < produits.length; i++) {
                if (produits[i].getCode() == codeProduit) {
                    

                }

            }
        }

    }

    /**
     * Getter & Setters
     */
    /**
     *
     * @return produits
     */
    public Produit[] getProduits() {
        return produits;
    }

    public int getNbrProduits() {
        return nbrProduits;
    }
}
