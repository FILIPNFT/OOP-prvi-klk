package RAFChatMessages.rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class EmojiListaPoruka extends Poruka {
    private List<Emoji> emojiji = new ArrayList<>();

    public EmojiListaPoruka(String posiljalac) {
        super(posiljalac);
    }

    public void dodajEmoji(Emoji emoji) {
        if (emoji != null) {
            emojiji.add(emoji);
        }
    }

    public void dodajViseEmoji(List<Emoji> lista) {
        if (lista != null) {
            for (Emoji e : lista) {
                dodajEmoji(e); // koristi već validiranu metodu
            }
        }
    }

    @Override
    protected String formirajSadrzinu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < emojiji.size(); ++i) {
            sb.append(emojiji.get(i).getSkracenica());
            if (i < emojiji.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}
