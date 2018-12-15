package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSTekoaly extends PeliMoodi {

    private Tuomari tuomari;
    private TK tekoaly;

    public static KPSTekoaly luoHelppoTekoAly() {
        
        return new KPSTekoaly(new Tekoaly(), new Tuomari());
    }

    public static KPSTekoaly luoVaikeaTekoAly() {

        return new KPSTekoaly(new TekoalyParannettu(20), new Tuomari());
    }

    private KPSTekoaly(TK tekoaly, Tuomari tuomari) {
        this.tekoaly = tekoaly;
        this.tuomari = tuomari;
    }

    @Override
    public void pelaa(IO io) {
        io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.println("Tietokone valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println(tuomari.toString());
            io.println("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            io.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        io.println("");
        io.println("Kiitos!");
        io.println(tuomari.toString());
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
