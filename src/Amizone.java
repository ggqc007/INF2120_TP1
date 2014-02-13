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

    public final static String ERR_MSG_UTILIS_NULL
            = "Erreur, utilisateur null.";
    public final static String ERR_MSG_FOURN_AUCUN_PRODUIT
            = "Erreur, ce fournisseur ne vend aucun produit.";
    public final static String ERR_MSG_UTILIS_EXISTANT
            = "Erreur, cet utilisateur existe deja.";

    /**
     * ATTRIBUTS D'INSTANCE
     */
    private ArrayList<Utilisateur> utilisateurs;

    public Amizone() {
        utilisateurs = new ArrayList<Utilisateur>();
    }

    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

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

    public ArrayList<Utilisateur> recommanderUtilisateurs(Utilisateur utilisateur)
            throws Exception {
        return null; //A FAIRE
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
     * Methodes Prives
     */
    /**
     * Verifie la liste d'utilisateur pour savoir si le id de l'utilisateur en
     * parametre est deja present.
     *
     * @param utilisateur utilisateur a verifier
     * @return vrai si utilisateur est deja present
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
     * Verifie si un fournisseur a un produit en stock a vendre (> 0)
     *
     * @param fournisseur L'utilisateur qui desire s'inscrire
     * @return vrai si l'utilisateur a un produit en stock a vendre
     */
    private boolean fournisseurAvecProduitAVendre(Utilisateur fournisseur) {
        boolean aProduitAVendre = false;
        Produit[] tabProduitsEnVente = ((Fournisseur) fournisseur).getProduits();

        // recherche dans tableau des produits pour un produit avec quantite minimum de 1 item
        for (int i = 0; i < tabProduitsEnVente.length; i++) {
            if (tabProduitsEnVente[i] instanceof Produit) {
                // recherche une quantite minimum TODO - P-E METTRE CETTE VALEUR 0 DANS UNE CONSTANTE EVENTUELLEMENT???
                if (tabProduitsEnVente[i].getQuantite() > 0) {
                    aProduitAVendre = true;
                }
            }
        }
        return aProduitAVendre;
    }

}
