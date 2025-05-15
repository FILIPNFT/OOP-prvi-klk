package KolokvijumskiZadatakOOP;

import java.util.ArrayList;
import java.util.List;

public class Tim implements Registracija{

    private Polaznik vodja;
    private List<Polaznik> polaznici = new ArrayList<>();
    private Oblast oblast;

    public Tim(){
        this.oblast = Oblast.PROGRAMIRANJE;
    }

    @Override
    public boolean registruj(Obuka obuka) {
        for(Polaznik polaznik : polaznici) {
            ObukaPolaznika obukaPolaznika = new ObukaPolaznika(polaznik, obuka);
            obukaPolaznika.setRegistracioniBroj(ObukaPolaznika.getPoslednjiBroj());
            polaznik.getObuke().add(obukaPolaznika);
            obuka.getObukePolaznika().add(obukaPolaznika);
        }
        ObukaPolaznika.setPoslednjiBroj(ObukaPolaznika.getPoslednjiBroj() + 1);
        return true;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        return false;
    }

    public Polaznik getVodja() {
        return vodja;
    }

    public void setVodja(Polaznik vodja) {
        this.vodja = vodja;
    }

    public List<Polaznik> getPolaznici() {
        return polaznici;
    }

    public void setPolaznici(List<Polaznik> polaznici) {
        this.polaznici = polaznici;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }
}
