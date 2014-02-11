
public class Consommateur extends Utilisateur {

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private Produit[] achats;
    private int nbrAchats;

    /**
     * CONSTRUCTEURS
     */
    /**
     * Construit un Consommateur avec le pseudo, le motPasse et le courriel
     * passes en paramètres. L'attribut id (numero unique) est assigne
     * automatiquement. La longueur du tableau des achats de ce consommateur est
     * initialisee a Utilisateur.LONG_TAB et nbrAchats est a 0. La longueur du
     * tableau evaluations est initialisee a Utilisateur.LONG_TAB et nbrEval est
     * a 0.
     *
     * @param pseudo le nom d'utilisateur (pseudonyme) de ce consommateur
     * @param motPasse le mot de passe de ce consommateur
     * @param courriel le courriel de ce consommateur
     *
     * ANTECEDENTS : le pseudo, le motPasse et le courriel doivent être valides
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
     * @param consommateur le consommateur dont on veut une copie.
     */
    public Consommateur(Consommateur consommateur) {
        super(consommateur);
    }

    /**
     * METHODES
     */
    /**
     * Cette méthode retourne un tableau de type String représentant le profil
     * de l’utilisateur et ne prend aucun paramètre.
     *
     * @return tableau de type String représentant le profil de l’utilisateur
     */
    @Override
    public String[] compilerProfil() {
        String[] categoriesAchete = null;
        int categoriesUniqueTrouve = 0;

        if (achats[0] != null) {
            categoriesAchete = new String[Utilisateur.LONG_TAB];

            for (int i = 0, j = 0; i < achats.length; i++) {
                //if (achats[i] != null && stringEstDansTab(categoriesAchete, achats[i].getCategorie())) {
                    if (achats[i] != null && TabUtils.elemEstDansTab(achats[i].getCategorie(), categoriesAchete)) {
                    categoriesAchete[j] = achats[i].getCategorie();
                    categoriesUniqueTrouve++;
                }
            }
        }
        // Ajuste longueur du tableau avant le retour...
        if (categoriesAchete != null) {
            categoriesAchete = TabUtils.copieTab(categoriesAchete, categoriesUniqueTrouve);
        }
        return categoriesAchete;
    }

    /**
     * Cette méthode permet à un utilisateur d’évaluer un autre utilisateur. En
 effet, les utilisateurs du site Amizone peuvent s’évaluer entre eux. Un
 fournisseurs (respectivement consommateur) peut évaluer un consommateur
 (respectivement fournisseurs) en lui attribuant une note d’appréciation
 (une évaluation) basée sur l’expérience d’une transaction conclue avec ce
 consommateur (respectivement fournisseurs). Une évaluation valide est une
 note comprise entre 1 et 5 où 5 constitue la meilleure évaluation.
     *
     *
     * @param fournisseur l’utilisateur évalué (type Utilisateur)
     * @param evalScore l’évaluation donnée à l’utilisateur
     *
     * Cette méthode leve une Exception (type Exception) lorsque 1)
     * l’utilisateur évalué n’a jamais conclu de transaction avec l’utilisateur
     * qui l’évalue ou lorsque 2) l’évaluation donnée en paramètre n’est pas
     * valide
     * @throws java.lang.Exception
     */
    @Override
    public void evaluer(Utilisateur fournisseur, int evalScore) throws ClassCastException, NullPointerException, Exception {
        if (fournisseur == null) {
            throw new NullPointerException();
        } else if (!(fournisseur instanceof Fournisseur)) {
            throw new ClassCastException();
        } else if (evalScore < 0 || evalScore > 5) {
            throw new Exception(Utilisateur.MSG_ERR_EVAL_3);
        } else if (!(TabUtils.elemEstDansTab(fournisseur.getId(), fournisseurs()))) {
            // recherche dans tab fournisseurs de cette classe pour savoir si utilisateur en parametre est present
            throw new Exception(Utilisateur.MSG_ERR_EVAL_2);
        } else {
            fournisseur.ajouterEvaluation(evalScore);
        }
    }

    public void acheter(Produit produit, int quantite) throws Exception {
        if (produit == null) {
            throw new ExceptionProduitInvalide();
        } else if (produit.getIdFournisseur() == 0) {
            throw new Exception(Utilisateur.MSG_ERR_ACHAT);
        } else if (quantite <= 0 || quantite > produit.getQuantite()) {
            throw new Exception(Utilisateur.MSG_ERR_QTE);
        } else {
            // on ajoute une copie du produit!
            achats[nbrAchats] = new Produit(produit);
            achats[nbrAchats].setQuantite(quantite);
            nbrAchats = nbrAchats + 1;
        }
    }

    /**
     * 
     * @return 
     */
    public Integer[] fournisseurs() {
        Integer[] tabFournisseursUtilise = null;
        int nbrFournisseurUtilise = 0;
        
        for (int i = 0; i < achats.length; i++) {
            if (achats[i] instanceof Produit) {
                // initialiste tab
                if (nbrFournisseurUtilise == 0) {
                    tabFournisseursUtilise = new Integer[Utilisateur.LONG_TAB];
                }
                // ajoute les elements si pas deja presents
                if (!(TabUtils.elemEstDansTab(achats[i].getIdFournisseur(), tabFournisseursUtilise))) {
                    tabFournisseursUtilise[nbrFournisseurUtilise] = achats[i].getIdFournisseur();
                    nbrFournisseurUtilise = nbrFournisseurUtilise + 1;
                }
            }
        }
        
        // ajuste longueur du tab
        if (tabFournisseursUtilise != null) {
            tabFournisseursUtilise = TabUtils.copieTab(tabFournisseursUtilise, nbrFournisseurUtilise);
        }
        return tabFournisseursUtilise;
    }

    /**
     * Retourne une representation sous forme de chaine de caracteres de ce
     * consommateur.
     *
     * @return une representation sous forme de chaine de caracteres de ce
     * consommateur.
     */
    @Override
    public String toString() {
        return super.toString() + " - " + nbrAchats;
    }

    /**
     * Getter & Setters
     * 
     */
    
    /**
     * @return
     */
    public Produit[] getAchats() {
        return achats;
    }

    public int getNbrAchats() {
        return nbrAchats;
    }

    /**
     * METHODES DE CLASSE PRIVE
     */
    /*
    private boolean stringEstDansTab(String[] tab, String item) {
        boolean foundItem = false;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equalsIgnoreCase(item)) {
                foundItem = true;
            }
        }
        return foundItem;
    }
    */
 
    /*
        private boolean intEstDansTab(int[] tab, int item) {
        boolean foundItem = false;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == item) {
                foundItem = true;
            }
        }
        return foundItem;
    }
    */
}
