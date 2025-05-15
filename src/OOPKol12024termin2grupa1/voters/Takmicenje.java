package OOPKol12024termin2grupa1.voters;

import java.util.ArrayList;
import java.util.List;

public abstract class Takmicenje {
    protected List<Pesma> pesme = new ArrayList<>();
    protected List<Pesma> finalnaRunda = new ArrayList<>();
    protected List<Ziri> ziriji = new ArrayList<>();

    public abstract void eliminacionaRunda();
    public abstract Pesma finalnaRunda();

    public void dodajZiri(Ziri ziri) {
        ziriji.add(ziri);
    }

    public void dodajPesmu(Pesma p) {
        pesme.add(p);
    }

    public List<Pesma> getFinalnaRunda() { return finalnaRunda; }
}
