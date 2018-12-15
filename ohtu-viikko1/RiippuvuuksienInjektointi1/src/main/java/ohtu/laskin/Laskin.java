package ohtu.laskin;

public class Laskin {
    private IO io;
    private int quit;

    public Laskin(IO io) {
        this.io = io;
        this.quit= -9999;
    }
    
    public void suorita(){
        while( true ) {
            io.print("luku 1: ");
            int luku1 = io.nextInt();
            if ( luku1==-quit  ) return;
            
            io.print("luku 2: ");
            int luku2 = io.nextInt();           
            if ( luku2==-quit ) return;
            
            int vastaus = laskeSumma(luku1, luku2);
            io.print("summa: "+vastaus+"\n");
        }
    }

    private int laskeSumma(int luku1, int luku2) {
        return luku1+luku2;
    }      
   
}
