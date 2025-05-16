package KLKPRVI2024;

import java.util.HashMap;
import java.util.Map;

public class KorisnickiServis {
    private Map<String, Korisnik> korisnici = new HashMap<>();

    public boolean registruj(String ime, String korisnickoIme, String lozinka1, String lozinka2) {
        if (!lozinka1.equals(lozinka2)) {
            return false;
        }
        if (korisnici.containsKey(korisnickoIme)) {
            return false;
        }
        if (lozinka1.length() < 8 || !lozinka1.matches(".*\\d.*") ||
            !lozinka1.matches(".*[a-z].*") || !lozinka1.matches(".*[A-Z].*")) {
            return false;
        }

        korisnici.put(korisnickoIme, new Korisnik(ime, korisnickoIme, lozinka1));
        return true;
    }

    public Korisnik prijavi(String korisnickoIme, String lozinka) {
        Korisnik k = korisnici.get(korisnickoIme);
        if (k != null && k.getLozinka().equals(lozinka)) {
            return k;
        }
        return null;
    }

    public Map<String, Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Map<String, Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
