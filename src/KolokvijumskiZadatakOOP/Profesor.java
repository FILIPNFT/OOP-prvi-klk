package KolokvijumskiZadatakOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor implements Registracija{
   private String ime;
   private String prezime;
   private String id;
   private Oblast oblast;
   private List<Obuka> obuke = new ArrayList<>();

    public Profesor(String ime, String prezime, String id, Oblast oblast) {
        this.ime = ime;
        this.prezime = prezime;
        this.id = id;
        this.oblast = oblast;
    }

    @Override
    public boolean registruj(Obuka obuka) {
        // profesor mora da bude iz iste oblasti kao i obuka
        if(this.oblast != obuka.getOblast()) return false;
        // nije već registrovan za obuku
        if(registrovan(obuka)) return false;
        // nije registrovan na više od 3 obuke do sada
        if(obuke.size() > 3) return false;

        // Za projekte važi da broj predavača ne
        // sme biti veći od maksimalnog broja polaznika
        if(obuka instanceof Projekat){
            if(obuka.getPredavaci().size() + 1 > ((Projekat) obuka).getMaksimalanBrojPolaznika())
                return false;
        }

        // registracija je moguca
        // profesoru se dodaje nova obuka, a obuci predavac
        this.obuke.add(obuka);
        obuka.getPredavaci().add(this);

        return false;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        /*
        for(Obuka o : obuke){
            if(o.equals(obuka)) return false;
        }
        return true;
         */
        return obuke.contains(obuka);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }

    public List<Obuka> getObuke() {
        return obuke;
    }

    public void setObuke(List<Obuka> obuke) {
        this.obuke = obuke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(id, profesor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
