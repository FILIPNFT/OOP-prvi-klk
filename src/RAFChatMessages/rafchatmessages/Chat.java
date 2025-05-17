package RAFChatMessages.rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Poruka> poruke = new ArrayList<>();
    private List<String> posiljaoci = new ArrayList<>();

    public void dodajPoruku(Poruka p){
        poruke.add(p);

        if (!posiljaoci.contains(p.getPosiljalac())){
            posiljaoci.add(p.getPosiljalac());
        }
    }

    public void prikaziSve() {
        for (Poruka p : poruke) {
            System.out.println(p.formirajIspis());
            System.out.println();
        }
    }

    public void prikaziPosiljaoce(){
        System.out.println("Posiljaoci:");
        for(String s : posiljaoci){
            System.out.println("- " + s);
        }
    }
}
