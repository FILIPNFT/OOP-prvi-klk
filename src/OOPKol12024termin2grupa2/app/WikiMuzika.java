package OOPKol12024termin2grupa2.app;

import java.util.ArrayList;
import java.util.List;

public class WikiMuzika {
    private List<Album> albumi = new ArrayList<>();

    public WikiMuzika() {
    }

    public List<Album> listaj(boolean b, int i){
        return albumi;
    }

    public List<Album> listajZanr(String s,boolean b, int i){
        return albumi;
    }

    public List<Album> getAlbumi() {
        return albumi;
    }

    public void setAlbumi(List<Album> albumi) {
        this.albumi = albumi;
    }
}
