package KolokvijumskiZadatakOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Obuka implements Comparable<Obuka> {
    private String naziv;
    private int minimalanBrojPolaznika;
    private Oblast oblast;
    private final List<ObukaPolaznika> obukePolaznika = new ArrayList<>();
    private final List<Profesor> predavaci = new ArrayList<>();

    public Obuka(String naziv, int minimalanBrojPolaznika, Oblast oblast) {
        this.naziv = naziv;
        this.minimalanBrojPolaznika = minimalanBrojPolaznika;
        this.oblast = oblast;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMinimalanBrojPolaznika() {
        return minimalanBrojPolaznika;
    }

    public void setMinimalanBrojPolaznika(int minimalanBrojPolaznika) {
        this.minimalanBrojPolaznika = minimalanBrojPolaznika;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }

    public List<ObukaPolaznika> getObukePolaznika() {
        return obukePolaznika;
    }

    public List<Profesor> getPredavaci() {
        return predavaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Obuka obuka = (Obuka) o;
        return Objects.equals(naziv, obuka.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }

    @Override
    public String toString() {
        return naziv;
    }

    public String info() {
        return naziv + " broj polaznika: " + obukePolaznika.size();
    }

    /*
        vraca 0 ukoliko su isti
        vraca > 0 ako je prvi veci od drugog
        vraca < 0 ako je prvi manji od drugog

        Obuka o1 = new ...
        Obuka o2 = new ...

        o1.compareTo(o2);
        zelimo da ih poredimo na osnovu broja polaznika (velicina liste obukePolaznika)
        ako obe obuke imaju isti broj, onda po nazivu

        o1 OOP 20
        o2 UUP 21

     */
    @Override
    public int compareTo(Obuka o) {
        int rez = this.obukePolaznika.size() - o.getObukePolaznika().size();
        if (rez == 0) {
            // isti broj polaznika, onda poredi po nazivu
            return this.naziv.compareTo(o.naziv);
        }
        return (-1) * rez;
    }
}
