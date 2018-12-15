package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriNegatiivinenArvo() {
        Varasto testivarasto = new Varasto(-1);
        assertEquals(0, testivarasto.getTilavuus(), vertailuTarkkuus);
    }

    
    
    @Test
    public void alkuSaldoKonstruktoriLuoVaraston() {
        Varasto testivarasto = new Varasto(10, 8);
        assertEquals(10, testivarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(8, testivarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldoKonstruktoriNegatiivinenTilavuus() {
        Varasto testivarasto = new Varasto(-2, 0);
        assertEquals(0, testivarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldoKonstruktoriNegatiivinenSaldo() {
        Varasto testivarasto = new Varasto(10, -2);
        assertEquals(0, testivarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldoKonstruktoriTilavuuttaIsompiSaldo() {
        Varasto testivarasto = new Varasto(10, 12);
        
        assertEquals(10, testivarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaysNegatiivinenMaara() {

        double saldo = varasto.getSaldo();
        varasto.lisaaVarastoon(-2);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysTilavuuttaIsompiMaaara() {
        varasto.lisaaVarastoon(12);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenLiikaaAntaaKaiken() {
        varasto.lisaaVarastoon(8);

        double maara = varasto.otaVarastosta(12);

        assertEquals(8, maara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLiikaaNollaaSaldon() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(12);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenNegatiivinenMaara() {
        varasto.lisaaVarastoon(8);

        double maara = varasto.otaVarastosta(-2);

        assertEquals(0, maara, vertailuTarkkuus);
    }
    
    @Test
    public void toStringPalauttaaOikeanSaldon() {
        String printti = varasto.toString();
        assertEquals("saldo = " + varasto.getSaldo() + ", vielä tilaa " + (varasto.getTilavuus() - varasto.getSaldo()), printti);
    }

}
