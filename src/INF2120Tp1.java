
public class INF2120Tp1 {

    public static void main(String[] args) {
        
        Utilisateur con = new Consommateur("joe", "password", "email");
        
        String test = "chat";
        String test1 = "un chat noir";
        String test2 = "un chaton noir";
              
        System.out.println("->"+ test +"<-");
        test = " "+ test +" ";
        System.out.println("->"+ test +"<-");
        
        System.out.println(test1.contains(test));
        System.out.println(test2.contains(test));

    }
}
