package OOPKol12024termin2grupa1.voters;

public class PojedinacniIzvodjac extends Izvodjac {
    private Tip tip;

    public PojedinacniIzvodjac(String ime, Tip tip) {
        super(ime);
        this.tip = tip;
    }

    public Tip getTip() {
        return tip;
    }
}
