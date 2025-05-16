package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bend {
    private String naziv;
    private int godinaFormiranja;
    private int godinaRastajanja = 0;
    private String zanrovi;

    public List<Album> albumi = new ArrayList<>();

    public Bend(String naziv, int godinaFormiranja, int godinaRastajanja) {
        this.godinaRastajanja = godinaRastajanja;
        this.naziv = naziv;
        this.godinaFormiranja = godinaFormiranja;
    }

    public void dodajAlbum(Album a) {
        if (a.getDatumIzdavanja().getYear() >= godinaFormiranja &&
            (godinaRastajanja == 0 || a.getDatumIzdavanja().getYear() <= godinaRastajanja)) {
            albumi.add(a);
        }
    }

    public List<Album> diskografijaAbecdno() {
        List<Album> sortirano = new ArrayList<>(albumi);
        Collections.sort(sortirano, new Comparator<Album>() {
            @Override
            public int compare(Album a1, Album a2) {
                int rez = a2.getMedij().compareTo(a1.getMedij());
                return rez != 0 ? rez : a1.getNaziv().compareTo(a2.getNaziv());
            }
        });
        return sortirano;
    }

    public void odrediZanrove() {
        List<String> sviZanrovi = new ArrayList<>();
        for (Album a : albumi) {
            String[] zanroviAlbuma = a.getZanrovi().split(",");
            for (String z : zanroviAlbuma) {
                sviZanrovi.add(z.trim());
            }
        }

        List<String> jedinstveni = new ArrayList<>();
        List<Integer> brojevi = new ArrayList<>();
        for (String z : sviZanrovi) {
            if (!jedinstveni.contains(z)) {
                jedinstveni.add(z);
                brojevi.add(1);
            } else {
                int index = jedinstveni.indexOf(z);
                brojevi.set(index, brojevi.get(index) + 1);
            }
        }

        int max = 0;
        for (int b : brojevi) {
            if (b > max) {
                max = b;
            }
        }

        List<String> najzastupljiji = new ArrayList<>();
        for (int i = 0; i < jedinstveni.size(); i++) {
            if (brojevi.get(i) == max) {
                najzastupljiji.add(jedinstveni.get(i));
            }
        }

        Collections.sort(najzastupljiji);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < najzastupljiji.size(); i++) {
            sb.append(najzastupljiji.get(i));
            if (i < najzastupljiji.size() - 1) {
                sb.append(", ");
            }
        }
        this.zanrovi = sb.toString();
    }

    public double profit() {
        double suma = 0;
        for (Album a : albumi) {
            double prihod = a.getCena() * a.getBrojProdatihJedinica();
            double uzeto = prihod * a.getKuca().uzmiProcenat(a);
            suma += (prihod - uzeto);
        }
        return suma;
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

    @Override
    public boolean equals(Object obj) {
        return ((Bend) obj).naziv == this.naziv && ((Bend) obj).godinaFormiranja == this.godinaFormiranja;
    }

    @Override
    public String toString() {
        return naziv + " (" + godinaFormiranja + ") - " + zanrovi;
    }
}
