package OOPKol12024termin1grupa1.konkurs;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Konkurs {
    private String pozicija;
    private List<String> zeljeneSposobnosti;
    private int minBrojPoklapanja;
    private boolean otvoren = true;
    private int trenutniKrug = 1;
    private List<Intervju> intervjui = new ArrayList<>();
    private List<Kandidat> kandidati = new ArrayList<>();

    public Konkurs(String pozicija, List<String> zeljeneSposobnosti, int minBrojPoklapanja) {
        this.pozicija = pozicija;
        this.zeljeneSposobnosti = zeljeneSposobnosti;
        this.minBrojPoklapanja = minBrojPoklapanja;
    }

    public boolean dodajIntervju(Intervju intervju) {
        if (intervjui.contains(intervju)) return false;
        if (intervjui.isEmpty() || intervju.getKrug() == intervjui.get(intervjui.size()-1).getKrug() + 1) {
            intervju.setKonkurs(this);
            intervjui.add(intervju);
            return true;
        }
        return false;
    }

    public boolean otpocniSelekcioniProces() {
        if (intervjui.isEmpty()) {
            System.out.println("Nema intervjua u konkursu.");
            return false;
        }
        otvoren = false;
        Intervju prvi = intervjui.get(0);
        for (Kandidat k : kandidati) {
            IntervjuisanjeKandidata ik = new IntervjuisanjeKandidata(k, prvi);
            k.getIntervjuisanja().add(ik);
            prvi.getIntervjuisanjeKandidata().add(ik);
        }
        return true;
    }

    public boolean posaljiKandidateUNaredniKrug(int broj) {
        if (trenutniKrug >= intervjui.size()) return false;
        Intervju trenutni = intervjui.get(trenutniKrug - 1);
        List<Kandidat> prosli = trenutni.odaberiKandidataZaProlaz(broj);
        Intervju naredni = intervjui.get(trenutniKrug);
        for (Kandidat k : prosli) {
            IntervjuisanjeKandidata ik = new IntervjuisanjeKandidata(k, naredni);
            k.getIntervjuisanja().add(ik);
            naredni.getIntervjuisanjeKandidata().add(ik);
        }
        trenutniKrug++;
        return true;
    }

    public void ispisiRezultate(PrintWriter pw) {
        for (Intervju i : intervjui) {
            pw.println("Intervju krug " + i.getKrug() + ":");
            List<IntervjuisanjeKandidata> lista = new ArrayList<>();
            for (Kandidat k : kandidati) {
                for (IntervjuisanjeKandidata ik : k.getIntervjuisanja()) {
                    if (ik.getIntervju().equals(i) && ik.getDatum() != null) {
                        lista.add(ik);
                    }
                }
            }
            lista.sort(Comparator.comparingInt(IntervjuisanjeKandidata::getPoeni).reversed()
                    .thenComparing(IntervjuisanjeKandidata::getDatum));
            for (IntervjuisanjeKandidata ik : lista) {
                pw.println(" - " + ik.getKandidat() + " | " + ik.getPoeni() + " | " + ik.getStatus());
            }
        }
    }

    public boolean isOtvoren() { return otvoren; }
    public List<String> getZeljeneSposobnosti() { return zeljeneSposobnosti; }
    public int getMinBrojPoklapanja() { return minBrojPoklapanja; }
    public List<Kandidat> getKandidati() { return kandidati; }
    public int getTrenutniKrug() { return trenutniKrug; }
    public LocalDate getIntervjuDo(Intervju i) { return i.getKonkurs() == this ? i.getAktivanDo() : null; }
}
