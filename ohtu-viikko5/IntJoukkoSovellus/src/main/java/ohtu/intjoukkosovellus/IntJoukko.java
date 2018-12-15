package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luoJoukko(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luoJoukko(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        luoJoukko(kapasiteetti, kasvatuskoko);

    }

    public boolean lisaa(int luku) {

        int ensimmainen = 0;
        if (alkioidenLkm == 0) {
            lisaaAlkio(luku, ensimmainen);
            return true;
        } else {
        }
        if (!kuuluu(luku)) {
            lisaaAlkio(luku, alkioidenLkm);
            if (alkioidenLkm % alkiot.length == 0) {
                kasvataJonoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        int on = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                on++;
            }
        }
        if (on > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int luku) {
        int kohta = -1;
        kohta = etsiKohta(luku, kohta);
        if (kohta != -1) {
            siirraKohta(kohta);
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    public int koko() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + alkiot[0] + "}";
        } else {
            return SummaToString();
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = alkiot[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

    private void luoJoukko(int kapasiteetti, int kasvatuskoko) {
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    private void lisaaAlkio(int luku, int kohta) {
        alkiot[kohta] = luku;
        alkioidenLkm++;
    }

    private void kasvataJonoa() {
        int[] taulukkoOld = new int[alkiot.length];
        taulukkoOld = alkiot;
        kopioiTaulukko(alkiot, taulukkoOld);
        alkiot = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, alkiot);
    }

    private void siirraKohta(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = alkiot[j];
            alkiot[j] = alkiot[j + 1];
            alkiot[j + 1] = apu;
        }
    }

    private int etsiKohta(int luku, int kohta) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                alkiot[kohta] = 0;
                break;
            }
        }
        return kohta;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    private String SummaToString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += alkiot[i];
            tuotos += ", ";
        }
        tuotos += alkiot[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

}
