package OOPKol12024termin2grupa2.app;

public class UMG extends DiskografskaKuca {

    public UMG() {
        super("UMG", 1934, "Amerika");
    }

    @Override
    public double uzmiProcenat(Album album) {
        double procenat = 0.3;
        if (album.getZanrovi().contains("pop") || album.getZanrovi().contains("rock") || album.getZanrovi()
            .contains("hip-hop")) {
            procenat += 0.05;
        }
        if (album.getMedij() == Medij.LP) {
            procenat += 0.05;
        }
        return procenat;
    }
}
