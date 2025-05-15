package KLKPRVI2024;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ChatApp {

    public static void main(String[] args) {
        KorisnickiServis servis = new KorisnickiServis();

        // Registracija korisnika
        servis.registruj("Ana", "ana123", "Lozinka1", "Lozinka1");
        servis.registruj("Bojan", "bojan456", "Lozinka2", "Lozinka2");
        servis.registruj("Ceca", "ceca789", "Lozinka3", "Lozinka3");
        servis.registruj("Dusan", "dusan321", "Lozinka4", "Lozinka4");
        servis.registruj("Eva", "eva654", "Lozinka5", "Lozinka5");

        // Prijava korisnika
        Korisnik ana = servis.prijavi("ana123", "Lozinka1");
        Korisnik bojan = servis.prijavi("bojan456", "Lozinka2");
        Korisnik ceca = servis.prijavi("ceca789", "Lozinka3");
        Korisnik dusan = servis.prijavi("dusan321", "Lozinka4");
        Korisnik eva = servis.prijavi("eva654", "Lozinka5");

        // Kreiranje četova
        PublicChat pub1 = new PublicChat();
        PublicChat pub2 = new PublicChat();

        GroupChat grp1 = new GroupChat();
        GroupChat grp2 = new GroupChat();
        grp1.dodajUGrupu(ana);
        grp1.dodajUGrupu(bojan);
        grp2.dodajUGrupu(ceca);
        grp2.dodajUGrupu(dusan);

        PrivateChat priv1 = new PrivateChat(ana, bojan);
        PrivateChat priv2 = new PrivateChat(ceca, dusan);

        JustMeChat me1 = new JustMeChat(eva);
        JustMeChat me2 = new JustMeChat(bojan);

        // Dodavanje poruka
        ana.napisiPoruku(pub1, "Zdravo svima!");
        bojan.napisiPoruku(pub2, "Ćao ljudi!");

        ana.napisiPoruku(grp1, "Poruka u grupi 1");
        bojan.napisiPoruku(grp1, "Ćao Ana!");

        ceca.napisiPoruku(grp2, "Poruka u grupi 2");
        dusan.napisiPoruku(grp2, "Ćao Ceco!");

        ana.napisiPoruku(priv1, "Ćao Bojane");
        bojan.napisiPoruku(priv1, "Zdravo Ana");

        ceca.napisiPoruku(priv2, "Ćao Dušane");
        dusan.napisiPoruku(priv2, "Zdravo Ceco");

        eva.napisiPoruku(me1, "Zapisujem misli");
        bojan.napisiPoruku(me2, "Podsetnik: sastanak u 3");

        // Neuspešna poruka – Eva pokušava da piše u grupu gde nije član
        boolean uspesno = eva.napisiPoruku(grp1, "Mogu li i ja?");
        if (!uspesno) {
            upisiNeuspesnuPoruku("eva654", "Mogu li i ja?", grp1);
        }

        // Ispis svih poruka
        System.out.println("=== PUBLIC CHAT ===");
        ispisi(pub1.getPoruke());
        ispisi(pub2.getPoruke());

        System.out.println("\n=== GROUP CHAT ===");
        ispisi(grp1.getPoruke());
        ispisi(grp2.getPoruke());

        System.out.println("\n=== PRIVATE CHAT ===");
        ispisi(priv1.getPoruke());
        ispisi(priv2.getPoruke());

        System.out.println("\n=== JUST ME CHAT ===");
        ispisi(me1.getPoruke());
        ispisi(me2.getPoruke());
    }

    private static void ispisi(List<String> poruke) {
        for (String p : poruke) {
            System.out.println(p);
        }
    }

    private static void upisiNeuspesnuPoruku(String korisnickoIme, String poruka, GroupChat chat) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("neuspesne_poruke.txt", true))) {
            writer.write("NEUSPEŠNA PORUKA:");
            writer.newLine();
            writer.write("Korisnik: " + korisnickoIme);
            writer.newLine();
            writer.write("Pokušao da pošalje: " + poruka);
            writer.newLine();
            writer.write("Članovi četa:");
            for (Korisnik k : chat.getGrupa()) {
                writer.write("- " + k.getKorisnickoIme());
                writer.newLine();
            }
            writer.write("========================================");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Greška pri upisu u fajl: " + e.getMessage());
        }
    }
}

