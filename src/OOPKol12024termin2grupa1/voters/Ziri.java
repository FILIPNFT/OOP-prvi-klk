package OOPKol12024termin2grupa1.voters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ziri implements Glasac {
    private final int brojClanova;

    public Ziri(int brojClanova) {
        this.brojClanova = brojClanova;
    }

    @Override
    public List<Glasanje> glasaj(List<Pesma> pesme) {
        Random rand = new Random();
        List<Glasanje> rezultati = new ArrayList<>();
        for (Pesma p : pesme) {
            int glasovi = 0;
            for (int i = 0; i < brojClanova; i++) {
                if (rand.nextBoolean()) {
                    glasovi++;
                }
            }
            rezultati.add(new Glasanje(p, glasovi));
        }
        return rezultati;
    }
}
