package ohtu.verkkokauppa;

public class Kauppa {

    private Sailytys varasto;
    private Maksupalvelu pankki;
    private ViiteNumerot viitegeneraattori;
    private String kaupanTili;
    private Ostoskori ostoskori;

    public Kauppa(Sailytys sailytys, Maksupalvelu maksupalvelu,
            ViiteNumerot viitetarjoaja) {
        this.varasto = sailytys;
        this.pankki = maksupalvelu;
        this.viitegeneraattori = viitetarjoaja;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id);
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id) > 0) {
            Tuote t = varasto.haeTuote(id);
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();

        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
