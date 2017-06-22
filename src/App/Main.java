package App;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class Main {

    static sonido s3= new sonido();
    
    public static void main(String[] args) throws InterruptedException {
        
        Principal p = new Principal();
        p.setVisible(true);
        sonido s= new sonido();
        s3.sound3();
        Thread.sleep(2500);
        s.sound();   
        }   
}
