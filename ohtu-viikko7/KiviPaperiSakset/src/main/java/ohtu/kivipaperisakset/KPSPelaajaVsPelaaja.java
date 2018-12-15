package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends PeliMoodi {

    @Override
    public void pelaa(IO io) {
        io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        Tuomari tuomari = new Tuomari();

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.nextLine();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println(tuomari.toString());
            io.println("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.nextLine();

            io.print("Toisen pelaajan siirto: ");
            tokanSiirto = io.nextLine();
        }

        io.println("");
        io.println("Kiitos!");
        io.println(tuomari.toString());
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
