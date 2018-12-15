package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final IO io = new KonsoliIO(new Scanner(System.in));

    public static void main(String[] args) {
        KomentoTehdas komennot = new KomentoTehdas(io);

        while (true) {
            io.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();

           PeliMoodi peli = komennot.hae(vastaus);
           
           if (peli == null) {
               break;
           }
           
           else peli.pelaa(io);
        }

    }
}
