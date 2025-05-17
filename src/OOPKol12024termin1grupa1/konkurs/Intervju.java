package OOPKol12024termin1grupa1.konkurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Intervju {
    private String intervjuer;
    private int brojPitanja;
    private LocalDate sprovestiOd;
    private LocalDate aktivanDo;
    private int brojKruga;

    private List<IntervjuisanjeKandidata> intervjuisanjeKandidata = new ArrayList<>();
    private Konkurs konkurs;

    public Intervju(String intervjuer, int brojPitanja, LocalDate sprovestiOd, LocalDate aktivanDo, int brojKruga) {
        this.intervjuer = intervjuer;
        this.brojPitanja = brojPitanja;
        this.sprovestiOd = sprovestiOd;
        this.aktivanDo = aktivanDo;
        this.brojKruga = brojKruga;
    }

    public abstract int izracunajBrojPoena(String s);

    public List<Kandidat> odaberiKandidataZaProlaz(int ogranicenje) {
        List<IntervjuisanjeKandidata> odradjeni = new ArrayList<>();
        for (IntervjuisanjeKandidata ik : intervjuisanjeKandidata) {
            if (ik.getDatum() != null && ik.getPoeni() >= 50) {
                odradjeni.add(ik);
            }
        }

        odradjeni.sort(java.util.Comparator.comparingInt(IntervjuisanjeKandidata::getPoeni).reversed()
            .thenComparing(IntervjuisanjeKandidata::getDatum));

        List<Kandidat> prosli = new ArrayList<>();
        for (int i = 0; i < odradjeni.size(); i++) {
            IntervjuisanjeKandidata ik = odradjeni.get(i);
            if (i < ogranicenje) {
                ik.setStatus(Status.PROSAO);
                prosli.add(ik.getKandidat());
            } else {
                ik.setStatus(Status.NIJE_PROSAO);
            }
        }

        return prosli;
    }

    public String getIntervjuer() {
        return intervjuer;
    }

    public void setIntervjuer(String intervjuer) {
        this.intervjuer = intervjuer;
    }

    public int getBrojPitanja() {
        return brojPitanja;
    }

    public void setBrojPitanja(int brojPitanja) {
        this.brojPitanja = brojPitanja;
    }

    public LocalDate getSprovestiOd() {
        return sprovestiOd;
    }

    public void setSprovestiOd(LocalDate sprovestiOd) {
        this.sprovestiOd = sprovestiOd;
    }

    public LocalDate getAktivanDo() {
        return aktivanDo;
    }


    public void setAktivanDo(LocalDate aktivanDo) {
        this.aktivanDo = aktivanDo;
    }

    public int getKrug() {
        return brojKruga;
    }

    public void setBrojKruga(int brojKruga) {
        this.brojKruga = brojKruga;
    }

    public List<IntervjuisanjeKandidata> getIntervjuisanjeKandidata() {
        return intervjuisanjeKandidata;
    }

    public void setIntervjuisanjeKandidata(List<IntervjuisanjeKandidata> intervjuisanjeKandidata) {
        this.intervjuisanjeKandidata = intervjuisanjeKandidata;
    }

    public Konkurs getKonkurs() {
        return konkurs;
    }

    public void setKonkurs(Konkurs konkurs) {
        this.konkurs = konkurs;
    }

    @Override
    public boolean equals(Object obj) {
        obj = ((Intervju) obj);
        return ((Intervju) obj).getKrug() == this.brojKruga && ((Intervju) obj).getKonkurs() == this.konkurs;
    }
}
