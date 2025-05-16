package OOPKol12024termin2grupa1;

import OOPKol12024termin2grupa1.voters.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        // Zemlje
        Zemlja srbija = new Zemlja("Srbija", 1000, false);
        Zemlja hrvatska = new Zemlja("Hrvatska", 800, false);
        Zemlja italija = new Zemlja("Italija", 1500, true);
        Zemlja spanija = new Zemlja("Španija", 1200, true);
        Zemlja nemacka = new Zemlja("Nemačka", 1300, false);

        // Izvođači
        PojedinacniIzvodjac a1 = new PojedinacniIzvodjac("Ana", Tip.PEVAC);
        PojedinacniIzvodjac a2 = new PojedinacniIzvodjac("Luka", Tip.INSTRUMENTALISTA);
        PojedinacniIzvodjac a3 = new PojedinacniIzvodjac("Maja", Tip.PLESAC);

        Bend bend1 = new Bend("Rockers");
        bend1.dodajClana(new PojedinacniIzvodjac("Marko", Tip.PEVAC));
        bend1.dodajClana(new PojedinacniIzvodjac("Ivan", Tip.INSTRUMENTALISTA));

        // Pesme
        Pesma p1 = new Pesma("Balada", srbija);
        p1.dodajIzvodjaca(a1);

        Pesma p2 = new Pesma("Ljubav", hrvatska);
        p2.dodajIzvodjaca(a1);
        p2.dodajIzvodjaca(a2);

        Pesma p3 = new Pesma("Fiesta", spanija);
        p3.dodajIzvodjaca(a3);

        Pesma p4 = new Pesma("Rock Himna", italija);
        p4.dodajIzvodjaca(bend1);

        Pesma p5 = new Pesma("Nebo", nemacka);
        p5.dodajIzvodjaca(a1);

        // Žiriji
        Ziri z1 = new Ziri(5);
        Ziri z2 = new Ziri(4);

        // Beovizije
        Beovizija b1 = new Beovizija(srbija);
        b1.dodajZiri(z1);
        b1.dodajPesmu(p1);
        b1.dodajPesmu(p5);

        Beovizija b2 = new Beovizija(hrvatska);
        b2.dodajZiri(z2);
        b2.dodajPesmu(p2);
        b2.dodajPesmu(p3);

        b1.eliminacionaRunda();
        Pesma pobednik1 = b1.finalnaRunda();

        b2.eliminacionaRunda();
        Pesma pobednik2 = b2.finalnaRunda();

        // Evrovizija
        Evrovizija evrovizija = new Evrovizija();
        evrovizija.dodajZemlju(srbija);
        evrovizija.dodajZemlju(hrvatska);
        evrovizija.dodajZemlju(italija);
        evrovizija.dodajZemlju(spanija);
        evrovizija.dodajZemlju(nemacka);

        evrovizija.dodajZiri(z1);
        evrovizija.dodajZiri(z2);

        evrovizija.dodajPesmu(pobednik1);
        evrovizija.dodajPesmu(pobednik2);
        evrovizija.dodajPesmu(p4); // Italija direktno
        evrovizija.dodajPesmu(p3); // Španija direktno

        evrovizija.eliminacionaRunda();
        evrovizija.finalnaRunda();

        // Ispis u fajl
        List<String> rezultati = evrovizija.getFinalnaRunda().stream()
            .sorted((a, b) -> Integer.compare(b.getPoeni(), a.getPoeni()))
            .map(p -> p.getZemlja().getNaziv() + " - " + p.getNaziv() + ", " + p.getPoeni())
            .collect(Collectors.toList());

        Files.write(Paths.get("rezultati_evrovizije.txt"), rezultati);
    }
}

