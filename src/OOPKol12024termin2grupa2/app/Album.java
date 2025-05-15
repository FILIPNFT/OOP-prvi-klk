package OOPKol12024termin2grupa2.app;

public class Album {
    private String naziv;
    private double cena;
    private int brojProdatihJedinica;
    private String zanrovi;
    private int trajanje;

    private Medij medij;
    private Bend bend;
    private DiskografskaKuca kuca;

    public Album(String naziv, double cena, String zanrovi, int trajanje, Bend bend, DiskografskaKuca kuca) {
        this.naziv = naziv;
        this.cena = cena;
        this.zanrovi = zanrovi;
        this.trajanje = trajanje;
        this.bend = bend;
        this.kuca = kuca;

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

    @Override
    public boolean equals(Object obj) {
        return ((Album) obj).naziv == this.naziv && ((Album) obj).bend == this.bend;
    }
}










