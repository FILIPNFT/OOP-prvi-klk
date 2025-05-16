package OOPKol12024termin2grupa2.app;

public class WMG extends DiskografskaKuca {

    public WMG() {
        super("WMG", 1958, "Amerika");
    }

    @Override
    public double uzmiProcenat(Album album) {
        double procenat = 0;
        if (album.getZanrovi().contains("pop") || album.getZanrovi().contains("rock") || album.getZanrovi()
            .contains("hip-hop")) {
            if (album.getBrojProdatihJedinica() <= 100000) {
                procenat += 0.25;
            } else if (album.getBrojProdatihJedinica() >= 50000) {
                procenat += 0.5;
            } else {
                procenat += 0.25;
                for (int i = 10000; i < album.getBrojProdatihJedinica(); i += 10000) {
                    procenat += 0.00005;
                }
            }
        } else {
            if (album.getBrojProdatihJedinica() <= 100000) {
                procenat += 0.2;
            } else if (album.getBrojProdatihJedinica() >= 50000000) {
                procenat += 0.4;
            } else {
                procenat += 0.20;
                for (int i = 100000; i < album.getBrojProdatihJedinica(); i += 10000) {
                    procenat += 0.00004;
                }
            }
        }
        return procenat;
    }
}
