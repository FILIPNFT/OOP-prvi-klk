package OOPKol12024termin1grupa1.konkurs;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HrIntervju extends Intervju {
    private Set<String> ocekivaneOsobine = new HashSet<>();

    public HrIntervju(String intervjuer, int brojPitanja, LocalDate sprovestiOd, LocalDate aktivanDo, int brojKruga) {
        super(intervjuer, brojPitanja, sprovestiOd, aktivanDo, brojKruga);
    }

    public void dodajOsobine(Collection<String> osobine) {
        ocekivaneOsobine.addAll(osobine);
    }

    @Override
    public int izracunajBrojPoena(String odgovori) {
        String[] osobine = odgovori.split(",");
        int poeni = 0;
        for (String o : osobine) {
            if (ocekivaneOsobine.contains(o)) {
                poeni++;
            }
        }
        return poeni;
    }
}
