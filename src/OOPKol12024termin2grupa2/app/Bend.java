package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.List;

public class Bend {
    private String naziv;
    private int godinaFormiranja;
    private int godinaRastajanja;
    private String zanrovi;

    public List<Album> albumi = new ArrayList<>();

    public Bend(int godinaRastajanja, String naziv, int godinaFormiranja) {
        this.godinaRastajanja = godinaRastajanja;
        this.naziv = naziv;
        this.godinaFormiranja = godinaFormiranja;
    }

    public void dodajAlbum(Album album) {

    }

    public void diskografijaAbecdno(){

    }

    public void odrediZanrove(){

    }
    public double profit(){
        return 0;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodinaFormiranja() {
        return godinaFormiranja;
    }

    public void setGodinaFormiranja(int godinaFormiranja) {
        this.godinaFormiranja = godinaFormiranja;
    }

    public int getGodinaRastajanja() {
        return godinaRastajanja;
    }

    public void setGodinaRastajanja(int godinaRastajanja) {
        this.godinaRastajanja = godinaRastajanja;
    }

    public String getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(String zanrovi) {
        this.zanrovi = zanrovi;
    }

    public List<Album> getAlbumi() {
        return albumi;
    }

    public void setAlbumi(List<Album> albumi) {
        this.albumi = albumi;
    }
}
