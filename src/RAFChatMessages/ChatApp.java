package RAFChatMessages;

import RAFChatMessages.rafchatmessages.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ChatApp {
    public static void main(String[] args) throws IOException {
        Emojis e = Emojis.getEmojis();
        e.dodajEmoji("happy", ":)");
        e.dodajEmoji("sad", ":(");
        e.dodajEmoji("angry", ">:(");
        e.dodajEmoji("cool", "B)");
        e.dodajEmoji("happy", ":D"); //nece biti dodat(isti naziv)

        Emoji happy = e.sviEmojiji().get(0);
        Emoji sad = e.sviEmojiji().get(1);

        TekstualnaPoruka tp1 = new TekstualnaPoruka("Pera", "Hello");
        TekstualnaPoruka tp2 = new TekstualnaPoruka("Pera", "Sr?");

        EmojiPoruka ep1 = new EmojiPoruka("Bojan", happy);
        EmojiPoruka ep2 = new EmojiPoruka("Pera", sad);

        EmojiListaPoruka elp = new EmojiListaPoruka("Pera");
        elp.dodajViseEmoji(List.of(happy,sad));

        KombinovanaPoruka kp = new KombinovanaPoruka("Pera");
        kp.dodajUSadrzinu(tp1);
        kp.dodajUSadrzinu(tp2);
        kp.dodajUSadrzinu(ep1);
        kp.dodajUSadrzinu(kp);

        Chat chat = new Chat();
        chat.dodajPoruku(tp1);
        chat.dodajPoruku(tp2);
        chat.dodajPoruku(ep1);
        chat.dodajPoruku(kp);

        chat.prikaziSve();

        List<Emoji> svi = new ArrayList<>(e.sviEmojiji());

        Collections.sort(svi, new Comparator<Emoji>() {
            @Override
            public int compare(Emoji o1, Emoji o2) {
                return o1.getNaziv().compareTo(o2.getNaziv());
            }
        });

        FileWriter fw = new FileWriter("emojis.txt");
        for (Emoji emoji : svi) {
            fw.write(emoji.getNaziv() + "," + emoji.getSkracenica() + "\n");
        }
        fw.close();
    }
}
