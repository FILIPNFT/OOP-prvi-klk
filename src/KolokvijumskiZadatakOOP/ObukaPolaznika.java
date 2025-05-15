package KolokvijumskiZadatakOOP;

public class ObukaPolaznika {
    private static int poslednjiBroj;
    private int registracioniBroj;
    private Polaznik polaznik;
    private Obuka obuka;

    // Nadogradili konstruktor sa obukom
    public ObukaPolaznika(Polaznik polaznik, Obuka obuka) {
        this.polaznik = polaznik;
        this.obuka = obuka;
    }

    public static int getPoslednjiBroj() {
        return poslednjiBroj;
    }

    public static void setPoslednjiBroj(int poslednjiBroj) {
        ObukaPolaznika.poslednjiBroj = poslednjiBroj;
    }

    public int getRegistracioniBroj() {
        return registracioniBroj;
    }

    public void setRegistracioniBroj(int registracioniBroj) {
        this.registracioniBroj = registracioniBroj;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public Obuka getObuka() {
        return obuka;
    }

    public void setObuka(Obuka obuka) {
        this.obuka = obuka;
    }
}
