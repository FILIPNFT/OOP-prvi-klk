package OOPKol12024termin1grupa1.konkurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TehnickiIntervju extends Intervju {
    private List<Integer> poeniZaPitanja = new ArrayList<>();

    public TehnickiIntervju(String intervjuer, int brojPitanja, LocalDate sprovestiOd, LocalDate aktivanDo, int brojKruga) {
        super(intervjuer, brojPitanja, sprovestiOd, aktivanDo, brojKruga);
    }

    public void definisiPoene(List<Integer> poeni) {
        if (poeni == null || poeni.stream().anyMatch(Objects::isNull)) {
            System.out.println("Nisu zadati poeni za sva pitanja.");
        } else {
            this.poeniZaPitanja = poeni;
        }
    }

    @Override
    public int izracunajBrojPoena(String odgovori) {
        String[] split = odgovori.split(",");
        int poeni = 0;
        for (String s : split) {
            String[] par = s.split("-");
            int indeks = Integer.parseInt(par[0]) - 1;
            if (par[1].equals("TACNO")) {
                poeni += poeniZaPitanja.get(indeks);
            }
        }
        return poeni;
    }
}

