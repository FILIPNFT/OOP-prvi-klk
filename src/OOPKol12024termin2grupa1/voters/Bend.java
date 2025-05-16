package OOPKol12024termin2grupa1.voters;

import java.util.HashSet;
import java.util.Set;

public class Bend extends Izvodjac {
    private final Set<PojedinacniIzvodjac> clanovi = new HashSet<>();

    public Bend(String ime) {
        super(ime);
    }

    public boolean dodajClana(PojedinacniIzvodjac p) {
        if (p.getTip() == Tip.PLESAC) {
            return false;
        }
        return clanovi.add(p);
    }

    public Set<PojedinacniIzvodjac> getClanovi() {
        return clanovi;
    }
}
