package OOPKol12024termin2grupa1.voters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Evrovizija extends Takmicenje {
    private final List<Zemlja> zemlje = new ArrayList<>();

    public void dodajZemlju(Zemlja z) {
        zemlje.add(z);
    }

    @Override
    public void dodajPesmu(Pesma p) {
        if (p == null || p.getNaziv() == null || p.getZemlja() == null) {
            return;
        }

        boolean vecPostojiIstaPesma = pesme.stream()
            .anyMatch(x -> x != null && x.getNaziv() != null && x.getNaziv().equals(p.getNaziv()));

        boolean vecPostojiIzZemlje = pesme.stream()
            .anyMatch(x -> x != null && x.getZemlja() != null && x.getZemlja().equals(p.getZemlja()));

        if (vecPostojiIstaPesma || vecPostojiIzZemlje) {
            return;
        }

        pesme.add(p);
    }

    @Override
    public void eliminacionaRunda() {
        List<Pesma> kandidati = pesme.stream()
            .filter(p -> !p.getZemlja().isDirektnoUFInale())
            .collect(Collectors.toList());
        List<Pesma> direktne = pesme.stream()
            .filter(p -> p.getZemlja().isDirektnoUFInale())
            .collect(Collectors.toList());

        for (Zemlja z : zemlje) {
            for (Glasanje g : z.glasaj(kandidati)) {
                g.getPesma().dodajGlasove(g.getBrojGlasova());
            }
        }

        kandidati.sort((a, b) -> b.getGlasovi() - a.getGlasovi());
        int broj = kandidati.size() / 2;
        finalnaRunda.addAll(direktne);
        finalnaRunda.addAll(kandidati.subList(0, broj));
    }

    @Override
    public Pesma finalnaRunda() {
        for (Pesma p : finalnaRunda) {
            p.resetuj();
        }

        for (Zemlja z : zemlje) {
            for (Glasanje g : z.glasaj(finalnaRunda)) {
                g.getPesma().dodajGlasove(g.getBrojGlasova());
            }
        }

        Map<Pesma, Integer> poeniPublika = dodeliPoenePoGlasovima(finalnaRunda);
        Map<Pesma, Integer> poeniZiri = new HashMap<>();
        for (Ziri z : ziriji) {
            for (Glasanje g : z.glasaj(finalnaRunda)) {
                poeniZiri.put(g.getPesma(), poeniZiri.getOrDefault(g.getPesma(), 0) + g.getBrojGlasova());
            }
        }
        Map<Pesma, Integer> poeniZiriPretv = dodeliPoenePoMapi(poeniZiri);

        for (Pesma p : finalnaRunda) {
            p.dodajPoene(poeniPublika.getOrDefault(p, 0));
            p.dodajPoene(poeniZiriPretv.getOrDefault(p, 0));
        }

        return finalnaRunda.stream()
            .max(Comparator.comparingInt(Pesma::getPoeni))
            .orElse(null);
    }

    private Map<Pesma, Integer> dodeliPoenePoGlasovima(List<Pesma> lista) {
        return dodeliPoenePoMapi(lista.stream().collect(Collectors.toMap(p -> p, Pesma::getGlasovi)));
    }

    private Map<Pesma, Integer> dodeliPoenePoMapi(Map<Pesma, Integer> mapa) {
        return mapa.entrySet().stream()
            .sorted(Map.Entry.<Pesma, Integer>comparingByValue().reversed())
            .limit(12)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> 12 - mapa.entrySet().stream()
                    .sorted(Map.Entry.<Pesma, Integer>comparingByValue().reversed())
                    .collect(Collectors.toList()).indexOf(e),
                (a, b) -> a,
                LinkedHashMap::new
            ));
    }
}
