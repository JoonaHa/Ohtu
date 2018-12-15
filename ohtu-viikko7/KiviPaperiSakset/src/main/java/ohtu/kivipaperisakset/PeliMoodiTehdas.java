package ohtu.kivipaperisakset;

/**
 *
 * @author JoonaHa
 */
public class PeliMoodiTehdas {
    
    public static PeliMoodi PelaajaVSPelaaja() {
       PeliMoodi pvp = new KPSPelaajaVsPelaaja();
        
       return pvp;
    }
    
    public static PeliMoodi HelppoYksinpeli() {
        PeliMoodi helppoYksinplei = KPSTekoaly.luoHelppoTekoAly();
        return helppoYksinplei;
    } 
    
    public static PeliMoodi VaikeYksinpeli() {
        PeliMoodi vaikeaYksinpeli = KPSTekoaly.luoVaikeaTekoAly();
        return vaikeaYksinpeli;
    }
    
}
