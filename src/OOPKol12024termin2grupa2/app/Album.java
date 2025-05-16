package OOPKol12024termin2grupa2.app;

import java.time.LocalDate;

public class Album {
    private String naziv;
    private double cena;
    private int brojProdatihJedinica;
    private String zanrovi;
    private int trajanje;
    private LocalDate datumIzdavanja;

    private Medij medij;
    private Bend bend;
    private DiskografskaKuca kuca;

    public Album(String naziv, double cena, int brojProdatihJedinica, String zanrovi,
        int trajanjeUMinutima, LocalDate datumIzdavanja,
        DiskografskaKuca diskografskaKuca, Bend bend) {
        this.naziv = naziv;
        this.cena = cena;
        this.brojProdatihJedinica = brojProdatihJedinica;
        this.zanrovi = zanrovi;
        this.trajanje = trajanjeUMinutima;
        this.datumIzdavanja = datumIzdavanja;
        this.kuca = diskografskaKuca;
        this.bend = bend;

        this.medij = trajanje < 45 ? Medij.EP : Medij.LP;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(String zanrovi) {
        this.zanrovi = zanrovi;
    }

    public int getBrojProdatihJedinica() {
        return brojProdatihJedinica;
    }

    public void setBrojProdatihJedinica(int brojProdatihJedinica) {
        this.brojProdatihJedinica = brojProdatihJedinica;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Bend getBend() {
        return bend;
    }

    public void setBend(Bend bend) {
        this.bend = bend;
    }

    public Medij getMedij() {
        return medij;
    }

    public void setMedij(Medij medij) {
        this.medij = medij;
    }

    public DiskografskaKuca getKuca() {
        return kuca;
    }

    public void setKuca(DiskografskaKuca kuca) {
        this.kuca = kuca;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Album) obj).naziv == this.naziv && ((Album) obj).bend == this.bend;
    }

    @Override
    public String toString() {
        return naziv + " (" + this.getMedij() + ") - " + brojProdatihJedinica + " jedinica";
    }
}










