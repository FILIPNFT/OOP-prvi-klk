package KLKPRVI2024;

import java.util.ArrayList;
import java.util.List;

public class JustMeChat implements Chat {
    private Korisnik korisnik;
    private List<String> poruke = new ArrayList<>();

    public JustMeChat(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        return this.korisnik.equals(korisnik);
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        poruke.add(poruka);
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
