
package ohtu.kivipaperisakset;

import java.util.HashMap;

/**
 *
 * @author JoonaHa
 */
public class KomentoTehdas {

    private HashMap<String, PeliMoodi> komennot;

    public KomentoTehdas(IO io) {
        komennot = new HashMap<>();
        komennot.put("a", PeliMoodiTehdas.PelaajaVSPelaaja());
        komennot.put("b", PeliMoodiTehdas.HelppoYksinpeli());
        komennot.put("c", PeliMoodiTehdas.VaikeYksinpeli());
        
        
    }
    
    public PeliMoodi hae(String syote) {
        PeliMoodi pel =komennot.get(syote);
        if (pel == null) {
            return null;
        }
        return pel;
    }
    
    

}
