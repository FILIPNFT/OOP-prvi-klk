package RAFChatMessages.rafchatmessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Emojis {
    private List<Emoji> emojis = new ArrayList<>();
    private static Emojis instance;

    private Emojis() {
    }

    public static Emojis getEmojis() {
        if (instance == null) {
            instance = new Emojis();
        }
        return instance;
    }

    public boolean dodajEmoji(String naziv, String skracenica) {
        Emoji novi = new Emoji(naziv, skracenica);
        for (Emoji e : emojis) {
            if (e.equals(novi)) return false;
        }
        emojis.add(novi);
        return true;
    }

    public List<Emoji> sviEmojiji() {
        return new ArrayList<>(emojis);
    }

    public List<Emoji> sviSortirani() {
        List<Emoji> kopija = new ArrayList<>(emojis);
        kopija.sort((a, b) -> a.getNaziv().compareTo(b.getNaziv()));
        return Collections.unmodifiableList(kopija);
    }
}
