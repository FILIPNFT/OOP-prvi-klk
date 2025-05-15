package OOPKol12024termin2grupa1.voters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Beovizija extends Takmicenje {
    private Zemlja zemljaDomacin;

    public Beovizija(Zemlja zemljaDomacin) {
        this.zemljaDomacin = zemljaDomacin;
    }

    @Override
    public void dodajPesmu(Pesma p) {
        if (p.getZemlja().equals(zemljaDomacin)) {
            pesme.add(p);
        }
    }

    @Override
    public void eliminacionaRunda() {
        for (Pesma p : pesme) p.resetuj();

        if (pesme.isEmpty()) return;
        Random rand = new Random();
        // Publika glasa
        for (int i = 0; i < zemljaDomacin.getPopulacija(); i++) {
            Pesma izabrana = pesme.get(rand.nextInt(pesme.size()));
            izabrana.dodajGlasove(1);
        }

        // Žiri glasa
        for (Ziri z : ziriji) {
            for (Glasanje g : z.glasaj(pesme)) {
                g.getPesma().dodajGlasove(g.getBrojGlasova() * 10000);
            }
        }

        pesme.sort((a, b) -> b.getGlasovi() - a.getGlasovi());
        int broj = pesme.size() / 2;
        finalnaRunda = new ArrayList<>(pesme.subList(0, broj));
    }

    @Override
    public Pesma finalnaRunda() {
        if (finalnaRunda == null || finalnaRunda.isEmpty()) return null;

        for (Pesma p : finalnaRunda) p.resetuj();

        Random rand = new Random();
        // Publika glasa
        for (int i = 0; i < zemljaDomacin.getPopulacija(); i++) {
            Pesma izabrana = finalnaRunda.get(rand.nextInt(finalnaRunda.size()));
            izabrana.dodajGlasove(1);
        }

        // Žiri glasa
        for (Ziri z : ziriji) {
            for (Glasanje g : z.glasaj(finalnaRunda)) {
                g.getPesma().dodajGlasove(g.getBrojGlasova() * 10000);
            }
        }

        return finalnaRunda.stream()
                .max(Comparator.comparingInt(Pesma::getGlasovi))
                .orElse(null);
    }
}
