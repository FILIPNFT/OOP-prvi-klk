package RAFChatMessages.rafchatmessages;

public abstract class Poruka {
    private String posiljalac;

    public Poruka(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    protected abstract String formirajSadrzinu();

    public String formirajIspis(){
        StringBuilder sb = new StringBuilder();
        sb.append(posiljalac).append("\n\n");

        String[] linije = formirajSadrzinu().split("\n");
        for (int i = 0; i < linije.length; i++) {
            sb.append("\t").append(linije[i]).append("\n");
            if (i < linije.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }
}
