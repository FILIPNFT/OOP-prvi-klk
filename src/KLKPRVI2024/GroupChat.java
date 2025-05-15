package KLKPRVI2024;

import java.util.ArrayList;
import java.util.List;

public class GroupChat implements Chat{
    private List<Korisnik> grupa = new ArrayList<>();
    private List<String> posiljalac = new ArrayList<>();
    private List<String> poruke = new ArrayList<>();

    public GroupChat() {
    }

    public void dodajUGrupu(Korisnik korisnik) {
        if(grupa.contains(korisnik))
            System.out.println("Korisnik vec postoji");
        else{
            grupa.add(korisnik);
        }
    }

    public void ukloniIzGrupu(Korisnik korisnik) {
        grupa.remove(korisnik);
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        return grupa.contains(korisnik);
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        posiljalac.add(poruka);
        poruke.add(poruka);
    }

    public List<Korisnik> getGrupa() {
        return grupa;
    }

    public void setGrupa(List<Korisnik> grupa) {
        this.grupa = grupa;
    }

    public List<String> getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(List<String> posiljalac) {
        this.posiljalac = posiljalac;
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }
}
