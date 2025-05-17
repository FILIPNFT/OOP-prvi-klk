package OOPKol12024termin1grupa1.konkurs;

import java.time.LocalDate;

public class IntervjuisanjeKandidata {
    private final Kandidat kandidat;
    private final Intervju intervju;
    private int poeni;
    private Status status = Status.NA_CEKANJU;
    private LocalDate datum;

    public IntervjuisanjeKandidata(Kandidat kandidat, Intervju intervju) {
        this.kandidat = kandidat;
        this.intervju = intervju;
    }

    public Kandidat getKandidat() { return kandidat; }
    public Intervju getIntervju() { return intervju; }
    public int getPoeni() { return poeni; }
    public void setPoeni(int poeni) { this.poeni = poeni; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }
}
