package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WikiMuzika {
    private List<Album> albumi = new ArrayList<>();

    public WikiMuzika() {
    }

    public void dodajAlbum(Album album) {
        this.albumi.add(album);
    }

    public List<Album> listaj(boolean b, int n) {
        List<Album> kopija = new ArrayList<>(albumi);
        kopija.sort((a1, a2) ->
            b ? a2.getBrojProdatihJedinica() - a1.getBrojProdatihJedinica()
                : a1.getBrojProdatihJedinica() - a2.getBrojProdatihJedinica());

        List<Album> rezultat = new ArrayList<>();
        for (int i = 0; i < n && i < kopija.size(); i++) {
            rezultat.add(kopija.get(i));
        }

        return rezultat;
    }

    public List<Album> listajZanr(String s, boolean b, int n) {
        List<Album> filtrirani = new ArrayList<>();
        for (Album a : albumi) {
            String[] z = a.getZanrovi().split(",");
            for (String jedan : z) {
                if (jedan.trim().equals(s)) {
                    filtrirani.add(a);
                    break;
                }
            }
        }

        Collections.sort(filtrirani, new Comparator<Album>() {
            @Override
            public int compare(Album a1, Album a2) {
                return b ? a2.getBrojProdatihJedinica() - a1.getBrojProdatihJedinica()
                    : a1.getBrojProdatihJedinica() - a2.getBrojProdatihJedinica();
            }
        });

        List<Album> rezultat = new ArrayList<>();
        for (int i = 0; i < n && i < filtrirani.size(); i++) {
            rezultat.add(filtrirani.get(i));
        }

        return rezultat;
    }

    public List<Album> getAlbumi() {
        return albumi;
    }

    public void setAlbumi(List<Album> albumi) {
        this.albumi = albumi;
    }
}
