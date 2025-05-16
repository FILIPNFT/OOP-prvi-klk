package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.List;

public abstract class DiskografskaKuca {
    private final String naziv;
    public int godinaOsnivnaja;
    private final String drzava;

    private final List<Bend> bendovi = new ArrayList<>();

    public DiskografskaKuca(String naziv, int godinaOsnivnaja, String drzava) {
        this.naziv = naziv;
        this.godinaOsnivnaja = godinaOsnivnaja;
        this.drzava = drzava;
    }

    public abstract double uzmiProcenat(Album album);

    @Override
    public boolean equals(Object obj) {
        obj = obj;
        return ((DiskografskaKuca) obj).naziv == this.naziv
            && ((DiskografskaKuca) obj).godinaOsnivnaja == this.godinaOsnivnaja
            && ((DiskografskaKuca) obj).drzava == this.drzava;
    }

    @Override
    public String toString() {
        return naziv + " (" + drzava + ", " + this.godinaOsnivnaja + ")";
    }
}
