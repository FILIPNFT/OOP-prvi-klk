package OOPKol12024termin2grupa2;

import OOPKol12024termin2grupa2.app.Album;
import OOPKol12024termin2grupa2.app.Bend;
import OOPKol12024termin2grupa2.app.DiskografskaKuca;
import OOPKol12024termin2grupa2.app.UMG;
import OOPKol12024termin2grupa2.app.WMG;
import OOPKol12024termin2grupa2.app.WikiMuzika;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Bend b1 = new Bend("RokBend", 1990, 2000);
        Bend b2 = new Bend("PopStar", 2005, 0);

        DiskografskaKuca umg = new UMG();
        DiskografskaKuca wmg = new WMG();

        Album a1 = new Album("Prvi", 10, 1000000, "rok", 50,
            LocalDate.of(1995, 5, 1), umg, b1);
        Album a2 = new Album("Drugi", 8, 200000, "rok,bluz", 40,
            LocalDate.of(1999, 7, 10), wmg, b1);
        Album a3 = new Album("Treći", 12, 1500000, "pop", 55,
            LocalDate.of(2010, 3, 20), umg, b2);
        Album a4 = new Album("Četvrti", 9, 50000, "hip-hop", 35,
            LocalDate.of(2015, 11, 11), wmg, b2);

        b1.dodajAlbum(a1);
        b1.dodajAlbum(a2);
        b2.dodajAlbum(a3);
        b2.dodajAlbum(a4);

        b1.odrediZanrove();
        b2.odrediZanrove();

        System.out.println(b1);
        System.out.println("Profit: " + b1.profit());
        System.out.println(b2);
        System.out.println("Profit: " + b2.profit());

        WikiMuzika wiki = new WikiMuzika();
        wiki.dodajAlbum(a1);
        wiki.dodajAlbum(a2);
        wiki.dodajAlbum(a3);
        wiki.dodajAlbum(a4);

        System.out.println("Top albumi:");
        for (Album a : wiki.listaj(true, 2)) {
            System.out.println(a);
        }

        System.out.println("Najmanje popularni hip-hop:");
        for (Album a : wiki.listajZanr("hip-hop", false, 1)) {
            System.out.println(a);
        }
    }
}
