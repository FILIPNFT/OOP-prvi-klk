package KLKPRVI2024;

import java.util.ArrayList;
import java.util.List;

public class PrivateChat implements Chat {
    private Korisnik k1;
    private Korisnik k2;

    private Korisnik prethodniPosiljalac = null;

    private List<String> poruke = new ArrayList<>();

    public PrivateChat(Korisnik k1, Korisnik k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        if (!korisnik.equals(k1) && !korisnik.equals(k2)) {
            return false;
        }
        if (prethodniPosiljalac == null) {
            return korisnik.equals(k1);
        }
        return !prethodniPosiljalac.equals(korisnik);
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        poruke.add(poruka);
        prethodniPosiljalac = korisnik;
    }

    public Korisnik getK1() {
        return k1;
    }

    public void setK1(Korisnik k1) {
        this.k1 = k1;
    }

    public Korisnik getK2() {
        return k2;
    }

    public void setK2(Korisnik k2) {
        this.k2 = k2;
    }

    public Korisnik getPrethodniPosiljalac() {
        return prethodniPosiljalac;
    }

    public void setPrethodniPosiljalac(Korisnik prethodniPosiljalac) {
        this.prethodniPosiljalac = prethodniPosiljalac;
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }
}
