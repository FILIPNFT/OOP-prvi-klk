package OOPKol12024termin2grupa2.app;

public class UMG extends DiskografskaKuca{

    public UMG(String naziv, int godinaOsnivnaja, String drzava) {
        super(naziv, godinaOsnivnaja, drzava);
    }

    @Override
    public double uzmiProcenat(Album album) {
        return 0;
    }
}
