import java.io.Serializable;
import java.time.LocalDate;

public class WarenkorbEintrag implements Serializable{

    private static final long serialVersionUID = 1L;
    private Produkt produkt;
    private int menge;
    private double rabatt; // zB. 0.1 = 10%
    private String status;
    private LocalDate hinzugefuegtAm;
    
    public WarenkorbEintrag(Produkt produkt, int menge, double rabatt, String status){
        this.produkt = produkt;
        this.menge  = menge;
        this.rabatt = rabatt;
        this.status = status;
        this.hinzugefuegtAm = LocalDate.now();
    }    

    public Produkt getProdukt() {
        return produkt;
    }

    public int getMenge() {
        return menge;
    }
     
    public double getRabatt() {
        return rabatt;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getHinzugefuegtAm() {
        return hinzugefuegtAm;
    }

    public void erhoeheMenge(int anzahl){
        this.menge += anzahl;
    }

    public double berechneGesamtpreis(){
       return produkt.getPreis() * menge * (1 - rabatt);
    }

    @Override
    public String toString() {
        return produkt.getName() + " x " + menge + " (Rabatt: " + (rabatt *100) + "%, Status: " + status + ", hinzugefügt am: " + hinzugefuegtAm + ")" + " => Gesamt " + berechneGesamtpreis()+ " Euro";
    }
}
