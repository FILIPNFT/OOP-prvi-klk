package OOPKol12024termin2grupa1.voters;

class Glasanje {
    private final Pesma pesma;
    private final int brojGlasova;

    public Glasanje(Pesma pesma, int brojGlasova) {
        this.pesma = pesma;
        this.brojGlasova = brojGlasova;
    }

    public Pesma getPesma() {
        return pesma;
    }

    public int getBrojGlasova() {
        return brojGlasova;
    }
}
