package KLKPRVI2024;

import java.util.ArrayList;
import java.util.List;

public class PublicChat implements Chat {
    public List<String> poruke = new ArrayList<>();

    public PublicChat() {
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        return true;
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        poruke.add(korisnik.getPrikazIme() + "==>" + poruka);
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }
}
