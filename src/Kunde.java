import java.io.Serializable;

public class Kunde implements Serializable{
    private static final long serialVersionUID = 1L;

    private String benutzername;
    private Warenkorb warenkorb;

    public Kunde(String benutzername){
        this.benutzername = benutzername;
        this.warenkorb = new Warenkorb();
    }

    public String getBenutzername() {
        return benutzername;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

}
