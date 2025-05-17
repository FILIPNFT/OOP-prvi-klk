package RAFChatMessages.rafchatmessages;

public class Emoji {
    private String naziv;
    private String skracenica;

     Emoji(String naziv, String skracenica) {
        this.naziv = naziv;
        this.skracenica = skracenica;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emoji)) return false;
        Emoji other = (Emoji) o;
        return this.naziv.equals(other.naziv) || this.skracenica.equals(other.skracenica);
    }
}
