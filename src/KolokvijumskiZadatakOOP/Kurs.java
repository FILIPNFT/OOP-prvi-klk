package KolokvijumskiZadatakOOP;

import java.util.ArrayList;
import java.util.List;

public class Kurs extends Obuka {
    private boolean onlajn;
    private List<Kurs> preduslovi = new ArrayList<>();
    public Kurs(String naziv, int minimalanBrojPolaznika, Oblast oblast, boolean onlajn) {
        super(naziv, minimalanBrojPolaznika, oblast);
        this.onlajn = onlajn;
    }

    public boolean isOnlajn() {
        return onlajn;
    }

    public void setOnlajn(boolean onlajn) {
        this.onlajn = onlajn;
    }

    public List<Kurs> getPreduslovi() {
        return preduslovi;
    }

    @Override
    public String info() {
        if(onlajn)
            return super.info() + " tip: KURS (onlajn)";
        else
            return super.info() + " tip: KURS";
    }
}
