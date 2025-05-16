package KolokvijumskiZadatakOOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Coursera {
    private final List<Obuka> obuke = new ArrayList<>();
    private final List<Registracija> registracije = new ArrayList<>();
    private static Coursera coursera = null;

    private Coursera() {

    }

    public static Coursera getCoursera() {
        if (coursera == null) {
            coursera = new Coursera();
        }
        return coursera;
    }

    public void sveObukePolaznika(Polaznik polaznik) {
        for (ObukaPolaznika op : polaznik.getObuke()) {
            System.out.println(op.getObuka());
        }
    }

    public void ispisSvihOdrzivihObuka(boolean fajl) {
        List<Obuka> odrziveObuke = new ArrayList<>();
        // obuke se drze ako imaju minimalan broj polaznika
        for (Obuka obuka : obuke) {
            if (obuka.getMinimalanBrojPolaznika() > obuka.getObukePolaznika().size()) {
                continue;
            }

            odrziveObuke.add(obuka);
        }

        // odrziveObuke je lista koju treba sortirati prema broju polaznika, i prema nazivu
        odrziveObuke.sort(null);

        /*
            Ispisuje se naziv obuke, broj polaznika, vrsta obuke (projekat ili kurs), ako je
            kurs ispusuje se da li je onlajn. Za svaku obuku ispisati i sve polaznike i to email i registracioni broj.
        */
        StringBuilder sb = new StringBuilder();
        for (Obuka obuka : odrziveObuke) {
            sb.append(obuka.info()).append("\nPOLAZNICI\n");
            for (ObukaPolaznika op : obuka.getObukePolaznika()) {
                sb.append(op.getPolaznik().getEmail())
                    .append(" reg. br. ")
                    .append(op.getRegistracioniBroj())
                    .append("\n");
            }
        }

        if (fajl) {
            try {
                FileWriter fw = new FileWriter("obuke.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString()); // mora eksplicitno toString()
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(sb);
        }
    }

    public boolean dodajRegistraciju(Registracija registracija) {
        if (registracije.contains(registracija)) {
            return false;
        }
        registracije.add(registracija);
        return true;
    }

    public List<Obuka> getObuke() {
        return obuke;
    }

    public List<Registracija> getRegistracije() {
        return registracije;
    }
}
