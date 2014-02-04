

/**
 * Cette classes contient des methodes utiles pour la gestion des tableaux.
 * @author melanie lord
 * @version 23/01/2014
 */
public class TabUtils {
   
   /**
    * Retourne vrai si elem est dans tab, faux sinon.
    * C'est la methode equals des elements qui est uilisee pour comparer 
    * l'egalite entre elem et les elements de tab.
    * @param elem l'element dont on veut savoir s'il est dans tab.
    *        Si elem est null, retourne false (null n'est pas considere
    *        comme un element valide ici).
    * @param tab le tableau dans lequel chercher elem.
    *        Si tab est null ou vide (longueur 0), retourne false.
    * @return true si elem est dans tab, false sinon.
    */
   public static boolean elemEstDansTab (Object elem, Object[] tab) {
      int i = 0;
      boolean estDans = false;
      
      if (tab != null && tab.length > 0 && elem != null) {
         while (i < tab.length && !estDans) {
            estDans = elem.equals(tab[i]);
            i++;
         }
      }
      return estDans;
   }
   

   /**
    * Cette methode cree un nouveau tableau de longueur n, contenant les n 
    * premiers elements de tab.
    * @param tab le tableau a copier (de 0 a n - 1)
    *        ANTECEDENTS : - tab ne doit pas etre null ou de longeur 0.
    *                      - 0 < n <= longueur tab
    * @param n la longueur du tableau retourne (ou le nombre d'elements a copier).
    * @return un nouveau tableau de longueur n, contenant les n premiers elements 
    *         de tab.
    */
   public static String[] copieTab (String[] tab, int n) {
      String[] tab2 = new String[n];
      for (int i = 0 ; i < tab2.length ; i++) {
         tab2[i] = tab[i];
      }
      return tab2;
   }
   
   
   /**
    * Cette methode cree un nouveau tableau de longueur n, contenant les n 
    * premiers elements de tab.
    * @param tab le tableau a copier (de 0 a n - 1)
    *        ANTECEDENTS : - tab ne doit pas etre null ou de longeur 0.
    *                      - 0 < n <= longueur tab
    * @param n la longueur du tableau retourne (ou le nombre d'elements a copier).
    * @return un nouveau tableau de longueur n, contenant les n premiers elements 
    *         de tab.
    */
   
   public static Integer[] copieTab (Integer[] tab, int n) {
      Integer[] tab2 = new Integer[n];
      for (int i = 0 ; i < tab2.length ; i++) {
         tab2[i] = tab[i];
      }
      return tab2;
   }
   
}
