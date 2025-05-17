package RAFChatMessages.rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class KombinovanaPoruka extends Poruka{
    private List<Poruka> sadrzina = new ArrayList<>();

    public KombinovanaPoruka(String posiljalac) {
        super(posiljalac);
    }

    public void dodajUSadrzinu(Poruka p) {
        if (!p.getPosiljalac().equals(this.getPosiljalac())) return;

        if (p instanceof KombinovanaPoruka kp) {
            List<Poruka> kopija = new ArrayList<>(kp.sadrzina);
            for (Poruka poruka : kopija) {
                this.sadrzina.add(poruka);
            }
        } else {
            sadrzina.add(p);
        }
    }

    @Override
    protected String formirajSadrzinu() {
        StringBuilder sb = new StringBuilder();
        for(int i  = 0; i < sadrzina.size(); i++) {
            sb.append(sadrzina.get(i).formirajSadrzinu());
            if (i < sadrzina.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public List<Poruka> getSadrzina() {
        return sadrzina;
    }

    public void setSadrzina(List<Poruka> sadrzina) {
        this.sadrzina = sadrzina;
    }
}
