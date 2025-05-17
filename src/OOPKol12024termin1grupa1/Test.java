package OOPKol12024termin1grupa1;

import OOPKol12024termin1grupa1.konkurs.HrIntervju;
import OOPKol12024termin1grupa1.konkurs.Kandidat;
import OOPKol12024termin1grupa1.konkurs.Konkurs;
import OOPKol12024termin1grupa1.konkurs.TehnickiIntervju;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Konkurs konkurs = new Konkurs("Java Developer", List.of("Java", "OOP", "SQL", "Spring"), 2);

        Kandidat k1 = new Kandidat("ana@mail.com", "Ana", "Jovic", List.of("Java", "SQL"));
        Kandidat k2 = new Kandidat("marko@mail.com", "Marko", "Petrovic", List.of("Java", "Spring"));
        Kandidat k3 = new Kandidat("ivana@mail.com", "Ivana", "Nikolic", List.of("Java", "Python"));
        Kandidat k4 = new Kandidat("jovan@mail.com", "Jovan", "Simic", List.of("Java", "OOP", "Spring"));
        Kandidat k5 = new Kandidat("pera@mail.com", "Pera", "Peric", List.of("CSS"));

        k1.prijaviSeNaKonkurs(konkurs);
        k2.prijaviSeNaKonkurs(konkurs);
        k3.prijaviSeNaKonkurs(konkurs);
        k4.prijaviSeNaKonkurs(konkurs);
        k5.prijaviSeNaKonkurs(konkurs);

        TehnickiIntervju ti = new TehnickiIntervju("Milos", 3, LocalDate.now(), LocalDate.now().plusDays(7), 1);
        ti.definisiPoene(List.of(10, 20, 30));
        konkurs.dodajIntervju(ti);

        HrIntervju hi = new HrIntervju("Ivana", 0, LocalDate.now(), LocalDate.now().plusDays(7), 2);
        hi.dodajOsobine(List.of("Uporan", "Timski", "Ambiciozan"));
        konkurs.dodajIntervju(hi);

        konkurs.otpocniSelekcioniProces();

        k1.odradiIntervju(ti, LocalDate.now(), "1-TACNO,2-NETACNO,3-TACNO");
        k2.odradiIntervju(ti, LocalDate.now(), "1-TACNO,2-TACNO,3-NETACNO");
        k3.odradiIntervju(ti, LocalDate.now(), "1-NETACNO,2-TACNO,3-TACNO");
        k4.odradiIntervju(ti, LocalDate.now(), "1-TACNO,2-TACNO,3-TACNO");

        konkurs.posaljiKandidateUNaredniKrug(3);

        for (Kandidat k : konkurs.getKandidati()) {
            for (var ik : k.getIntervjuisanja()) {
                if (ik.getIntervju().equals(hi)) {
                    if (k.getIme().equals("Jovan")) {
                        k.odradiIntervju(hi, LocalDate.now(), "Timski,Uporan,Ambiciozan");
                    }
                }
            }
        }

        konkurs.posaljiKandidateUNaredniKrug(2);

        try (PrintWriter pw = new PrintWriter("izvestaj.txt")) {
            konkurs.ispisiRezultate(pw);
        }
    }
}
