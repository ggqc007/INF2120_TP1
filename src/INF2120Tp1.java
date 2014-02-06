
public class INF2120Tp1 {

    public static void main(String[] args) {
        
        // test methode moyenne
        //System.out.println(evaluationMoyenne());

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
