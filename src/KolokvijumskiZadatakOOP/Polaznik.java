package KolokvijumskiZadatakOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polaznik implements Registracija{

    private String ime;
    private String prezime;
    private String email;
    private List<ObukaPolaznika> obuke = new ArrayList<>();

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    @Override
    public boolean registruj(Obuka obuka) {
        // polaznik ima validan email (da nije null i da sadrži znak '@')
        if(email == null || !email.contains("@")) return false; // bitan redosled provere
        // prvo se proverava null, jer u suprotnom bi mogao da izbaci NullPointerException

        // da nije već prošao (bio registrovan) tu obuku
        if(registrovan(obuka)) return false;

        // Na kurs možemo registrovati polaznike koji su
        // prošli sve kurseve koji su preduslovi tog kursa
        if(obuka instanceof Kurs){
            // da proverimo preduslove
            Kurs kurs = (Kurs) obuka;
            int cnt=0;
            for(Kurs preduslov : kurs.getPreduslovi()){
                for(ObukaPolaznika op : obuke){
                    if(preduslov.equals(op.getObuka())) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt < kurs.getPreduslovi().size()) return false; // polaznik nije prosao sve preduslove za kurs
        } else if(obuka instanceof Projekat){
            // za projekat imamo maksimalan broj polaznika koji mora biti ispoštovan
            Projekat projekat = (Projekat) obuka;
            if(projekat.getMaksimalanBrojPolaznika() == projekat.getObukePolaznika().size()) return false; // ovo znaci da je projekat popunjen
        }

        ObukaPolaznika op = new ObukaPolaznika(this, obuka);
        op.setRegistracioniBroj(ObukaPolaznika.getPoslednjiBroj());
        ObukaPolaznika.setPoslednjiBroj(ObukaPolaznika.getPoslednjiBroj()+1);
        this.obuke.add(op);
        obuka.getObukePolaznika().add(op);

        /*
            Obuka UUP
            brojac 0,1,2,3,4,5

            polaznik Jefimija reg broj 0
            polaznik Mladen reg broj 1
            polaznik Mixa reg broj 2
            polaznik Lazar reg broj 3
            polaznik Redza reg broj 4
            ...

         */

        return false;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        for(ObukaPolaznika op : obuke){
            if(op.getObuka().equals(obuka))
                return true;
        }
        return false;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ObukaPolaznika> getObuke() {
        return obuke;
    }

    public void setObuke(List<ObukaPolaznika> obuke) {
        this.obuke = obuke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik polaznik = (Polaznik) o;
        return Objects.equals(email, polaznik.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return ime + " " + prezime + "[" + email + "]";
    }
}
