
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
     * fournisseurs est initialisee a Utilisateur.LONG_TAB et nbrProduits est a
     * 0. La longueur du tableau evaluations est initialisee a
     * Utilisateur.LONG_TAB et nbrEval est a 0.
     *
     * @param pseudo le nom d'utilisateur (pseudonyme) de ce fournisseurs.
     * @param motPasse le mot de passe de ce fournisseurs
     * @param courriel le courriel de ce fournisseurs
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
     * @param fournisseur le fournisseurs dont on veut une copie.
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
            if (produits[i] instanceof Produit) {
                if (!(TabUtils.elemEstDansTab(produits[i].getCategorie(), produitsEnVente)) && produits[i].getQuantite() > 0) {
                    if (produitsEnVente == null) {
                        produitsEnVente = new String[Utilisateur.LONG_TAB];
                    }
                    produitsEnVente[nbrProduitsEnVente] = produits[i].getCategorie();
                    nbrProduitsEnVente = nbrProduitsEnVente + 1;
                }
            }
        }

        if (produitsEnVente != null) {
            // resize
            produitsEnVente = TabUtils.copieTab(produitsEnVente, nbrProduitsEnVente);
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
        } else if (!(TabUtils.elemEstDansTab(this.getId(), ((Consommateur) consommateur).fournisseurs()))) {
            // si n'est pas dans tableau... j'ai fait un cast vue que consommateur en parametre est de type Utilisateur
            // donc methode fournisseurs() n'etait pas visible...
            throw new Exception(Utilisateur.MSG_ERR_EVAL_1);
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

        if (produits != null) {
            for (int i = 0; i < produits.length && produitTrouve == null; i++) {
                if (produits[i] instanceof Produit) {
                    if (produits[i].getCode() == codeProduit) {
                        produitTrouve = produits[i];
                    }
                }
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
        Produit produitTrouve = null;

        for (int i = 0; i < produits.length; i++) {
            if (produits[i] instanceof Produit) {
                if (produits[i].getCode() == codeProduit) {
                    produitTrouve = produits[i];
                }
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
