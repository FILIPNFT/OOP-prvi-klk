package OOPKol12024termin1grupa1.konkurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kandidat {
    private String email, ime, prezime;
    private List<String> sposobnosti;
    private List<IntervjuisanjeKandidata> intervjuisanja = new ArrayList<>();

    public Kandidat(String email, String ime, String prezime, List<String> sposobnosti) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.sposobnosti = sposobnosti;
    }

    public boolean prijaviSeNaKonkurs(Konkurs konkurs) {
        if (!konkurs.isOtvoren()) return false;
        long poklapanja = sposobnosti.stream().filter(konkurs.getZeljeneSposobnosti()::contains).count();
        if (poklapanja >= konkurs.getMinBrojPoklapanja()) {
            konkurs.getKandidati().add(this);
            return true;
        }
        return false;
    }

    public void dodajIntervju(Intervju intervju) {
        intervjuisanja.add(new IntervjuisanjeKandidata(this, intervju));
    }

    public void odradiIntervju(Intervju intervju, LocalDate datum, String odgovori) {
        for (IntervjuisanjeKandidata ik : intervjuisanja) {
            if (ik.getIntervju().equals(intervju)) {
                if (ik.getDatum() != null) {
                    System.out.println("Već ste odradili ovaj intervju."); return;
                }
                if (datum.isAfter(intervju.getKonkurs().getIntervjuDo(intervju))) {
                    System.out.println("Istekao rok za intervju."); return;
                }
                ik.setDatum(datum);
                ik.setPoeni(intervju.izracunajBrojPoena(odgovori));
                return;
            }
        }
        System.out.println("Niste planirani za ovaj intervju.");
    }

    public List<IntervjuisanjeKandidata> getIntervjuisanja() { return intervjuisanja; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public String toString() { return ime + " " + prezime + " (" + email + ")"; }
}
