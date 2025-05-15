package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.List;

public abstract class DiskografskaKuca {
    private String naziv;
    public int godinaOsnivnaja;
    private String drzava;

    private List<Bend> bendovi = new ArrayList<>();

    public DiskografskaKuca(String naziv, int godinaOsnivnaja, String drzava) {
        this.naziv = naziv;
        this.godinaOsnivnaja = godinaOsnivnaja;
        this.drzava = drzava;
    }

    public abstract double uzmiProcenat(Album album);

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodinaOsnivnaja() {
        return godinaOsnivnaja;
    }

    public void setGodinaOsnivnaja(int godinaOsnivnaja) {
        this.godinaOsnivnaja = godinaOsnivnaja;
    }

    public List<Bend> getBendovi() {
        return bendovi;
    }

    public void setBendovi(List<Bend> bendovi) {
        this.bendovi = bendovi;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}
