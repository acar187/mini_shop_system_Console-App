import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warenkorb implements Serializable{

    private List<WarenkorbEintrag> warenKorbEintragListe = new ArrayList<>();

    public void hinzufügen(Produkt p, int menge, double rabatt, String status){
        //prüfen ob Produkt schon im Warenkorb ist
        for (WarenkorbEintrag warenkorbEintrag : warenKorbEintragListe) {
            if (warenkorbEintrag.getProdukt().getName().equals(p.getName())) {
                warenkorbEintrag.erhoeheMenge(menge);
                System.out.println(menge + " x " + p.getName() + " wurde hinzugefügt.");
            }
        }
        // wenn nicht vorhanden on den -> neuen Eintarg anlegen
        warenKorbEintragListe.add(new WarenkorbEintrag(p, menge, rabatt, status));
        System.out.println(menge + " x " + p.getName() + " wurde in den Warenkorb gelegt.");
    }

    public void anzeigen(){
        if (warenKorbEintragListe.isEmpty()) {
            System.out.println("Warenkorb ist leer.");
            return;
        }
        System.out.println("\n---Warenkorb---");
        for (WarenkorbEintrag e : warenKorbEintragListe) {
            System.out.println(e);    
        }
        System.out.println("Gesamt " + berechneGesamt() + " Euro.");
    }

    private double berechneGesamt() {
        double gesamt = 0;
        for (WarenkorbEintrag e : warenKorbEintragListe) {
            gesamt += e.berechneGesamtpreis();
        }
        return gesamt;
    }

    //Warenkorn seichern
    public void speichern(String dateiname){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname));
            oos.writeObject(this);
            System.out.println("Warenkorb gespeichert.");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }

    }

    //Warenkorb laden
    public static Warenkorb laden(String dateiname) throws ClassNotFoundException{
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));
            return (Warenkorb) ois.readObject();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Kein gespeicherter Warenkorn gefudnen. Neuer Warenkorb erstellt.");
            return new Warenkorb();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Fehler beim Laden: " + e.getMessage());
            return new Warenkorb();
        }
        
    }


}
