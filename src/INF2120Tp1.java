
public class INF2120Tp1 {

    public static void main(String[] args) {
        
        // test methode moyenne
        //System.out.println(evaluationMoyenne());
        
        System.out.println(testRetourNull());
        Produit[] achats = new Produit[Utilisateur.LONG_TAB];
        System.out.println("debug: "+ achats[0]);
    }

    
    
    
    
    public static String[] testRetourNull() {
        String[] test = null;
        //String[] test = new String[5];
        return test;
    }
    
    
    public static double evaluationMoyenne() {
        int[] tabEval = {10, 10, 9};
        double totalScore = 0;
        int nbrEval = 3;

        for (int i = 0; i < tabEval.length; i++) {
            totalScore = totalScore + tabEval[i];
        }
        System.out.println("score = "+ totalScore);
        return (double)Math.round((totalScore / nbrEval) * 100) / 100;
    }
}
