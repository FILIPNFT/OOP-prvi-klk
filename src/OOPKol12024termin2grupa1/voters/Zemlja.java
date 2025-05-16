package OOPKol12024termin2grupa1.voters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Zemlja implements Glasac {
    private String naziv;
    private int populacija;
    private boolean direktnoUFInale;

    public Zemlja(String naziv, int populacija, boolean direktnoUFInale) {
        this.naziv = naziv;
        this.populacija = populacija;
        this.direktnoUFInale = direktnoUFInale;
    }

    @Override
    public List<Glasanje> glasaj(List<Pesma> pesme) {
        Map<Pesma, Integer> glasovi = new HashMap<>();
        List<Pesma> validnePesme = pesme.stream()
            .filter(p -> !p.getZemlja().equals(this))
            .collect(Collectors.toList());
        if (validnePesme.isEmpty()) {
            return List.of();
        }

        Random rand = new Random();
        for (int i = 0; i < populacija; i++) {
            Pesma p = validnePesme.get(rand.nextInt(validnePesme.size()));
            glasovi.put(p, glasovi.getOrDefault(p, 0) + 1);
        }
        return glasovi.entrySet().stream()
            .map(e -> new Glasanje(e.getKey(), e.getValue()))
            .collect(Collectors.toList());
    }

    public String getNaziv() {
        return naziv;
    }

    public boolean isDirektnoUFInale() {
        return direktnoUFInale;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPopulacija() {
        return populacija;
    }

    public void setPopulacija(int populacija) {
        this.populacija = populacija;
    }

    public void setDirektnoUFInale(boolean direktnoUFInale) {
        this.direktnoUFInale = direktnoUFInale;
    }
}
