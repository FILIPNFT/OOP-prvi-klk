package KolokvijumskiZadatakOOP;

public class Test {
    public static void main(String[] args) {
        /*
            U njoj kreirati courseru, dva profesora, dva
            projekta, jedan onlajn kurs i pet polaznika. Registrovati po dva polaznika za kurs i projekte i napraviti
            jedan tim i registrovati ga na projekat i ispisati sve obuke u fajl.
         */

        Coursera coursera = Coursera.getCoursera();
        Profesor profesor1 = new Profesor("Jefimija", "Najdic", "ID67", Oblast.PROGRAMIRANJE);
        Profesor profesor2 = new Profesor("Lazar", "Dejanovic", "ID44", Oblast.PODACI);

        Projekat projekat2 = new Projekat("JavaFX Aplikacija", 2, Oblast.PROGRAMIRANJE, 5);
        Projekat projekat1 = new Projekat("SparkStreaming", 1, Oblast.PODACI, 4);

        Kurs kurs = new Kurs("OOP", 2, Oblast.PROGRAMIRANJE, true);

        Polaznik polaznik1 = new Polaznik("Marko", "Markovic", "mmarkovic22@gmail.com");
        Polaznik polaznik2 = new Polaznik("Pera", "Peric", "pera123@gmail.com");
        Polaznik polaznik3 = new Polaznik("Milica", "Mikic", "mm1234@yahoo.com");
        Polaznik polaznik4 = new Polaznik("Ana", "Markovic", "amarkovic@gmail.com");
        Polaznik polaznik5 = new Polaznik("Filip", "Mitic", "fmitic55@raf.rs");

        polaznik1.registruj(kurs);
        polaznik2.registruj(kurs);
        polaznik3.registruj(kurs);

        polaznik1.registruj(projekat1);
        polaznik2.registruj(projekat1);

        profesor1.registruj(projekat2);
        profesor1.registruj(kurs);

        profesor2.registruj(projekat1);
        profesor2.registruj(kurs);

        Tim tim = new Tim();
        tim.getPolaznici().add(polaznik3);
        tim.getPolaznici().add(polaznik4);
        tim.getPolaznici().add(polaznik5);

        tim.registruj(projekat2);

        coursera.dodajRegistraciju(profesor1);
        coursera.dodajRegistraciju(profesor2);
        coursera.dodajRegistraciju(polaznik1);
        coursera.dodajRegistraciju(polaznik2);
        coursera.dodajRegistraciju(polaznik3);
        coursera.dodajRegistraciju(polaznik4);
        coursera.dodajRegistraciju(polaznik5);

        coursera.getObuke().add(kurs);
        coursera.getObuke().add(projekat1);
        coursera.getObuke().add(projekat2);

        coursera.ispisSvihOdrzivihObuka(true);
    }
}
