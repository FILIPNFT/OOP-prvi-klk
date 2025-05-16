package KLKPRVI2024;

public class Korisnik {
    private String prikazIme;
    private String korisnickoIme;
    private String lozinka;

    public Korisnik(String prikazIme, String korisnickoIme, String lozinka) {
        this.prikazIme = prikazIme;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public boolean napisiPoruku(Chat chat, String poruka) {
        if (chat.mozeNapisatiPoruku(this)) {
            chat.dodajPoruku(this, poruka);
            return true;
        }
        return false;
    }

    public String getPrikazIme() {
        return prikazIme;
    }

    public void setPrikazIme(String prikazIme) {
        this.prikazIme = prikazIme;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
