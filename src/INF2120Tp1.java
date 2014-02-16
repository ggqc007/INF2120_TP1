
import java.util.ArrayList;

public class INF2120Tp1 {

    public static void testSortArrayDouble() {
        ArrayList source = new ArrayList();
        source.add(1.59);
        source.add(31.6);
        source.add(15.9);
        source.add(16.55);
        source.add(51.333);
        source.add(91.77);
        source.add(8.12);
        source.add(16.0);
        ArrayList sorted = new ArrayList();

        int position;
        for (int i = 0; i < source.size(); i++) {
            // Trouve sa position dans l'ordre
            position = 0;
            while (position < sorted.size() && ((Double) sorted.get(position)).compareTo((Double) source.get(i)) > 0) {
                position = position + 1;
            }
            sorted.add(position, source.get(i));
        }
        System.out.println("Avant: " + source);
        System.out.println("Apres: " + sorted);
    }

    public static void main(String[] args) {

        Utilisateur con = new Consommateur("joe", "password", "email");

        // Test methode sorting dun array liste de double
        testSortArrayDouble();

    }

}
