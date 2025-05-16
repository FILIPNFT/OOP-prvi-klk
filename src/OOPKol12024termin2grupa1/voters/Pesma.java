package OOPKol12024termin2grupa1.voters;

import java.util.ArrayList;
import java.util.List;

public class Pesma {
    private final String naziv;
    private final Zemlja zemlja;
    private int glasovi;
    private int poeni;
    private final List<Izvodjac> izvodjaci = new ArrayList<>();

    public Pesma(String naziv, Zemlja zemlja) {
        this.naziv = naziv;
        this.zemlja = zemlja;
    }

    public String getNaziv() {
        return naziv;
    }

    public Zemlja getZemlja() {
        return zemlja;
    }

    public int getGlasovi() {
        return glasovi;
    }

    public int getPoeni() {
        return poeni;
    }

    public void dodajGlasove(int g) {
        glasovi += g;
    }

    public void dodajPoene(int p) {
        poeni += p;
    }

    public void resetuj() {
        glasovi = 0;
        poeni = 0;
    }

    public boolean dodajIzvodjaca(Izvodjac i) {
        if (izvodjaci.size() >= 6) {
            return false;
        }
        if (i instanceof Bend && izvodjaci.stream().anyMatch(x -> x instanceof Bend)) {
            return false;
        }
        if (i instanceof PojedinacniIzvodjac &&
            izvodjaci.stream().anyMatch(x -> x instanceof Bend)) {
            return false;
        }
        izvodjaci.add(i);
        return true;
    }

    @Override
    public String toString() {
        return zemlja.getNaziv() + " - " + naziv + ", " + poeni;
    }
}
