import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Kundenverwaltung {
    private static final String DATEI = "kunden.ser";
    private Map<String, Kunde> kundenMap= new HashMap<>();

    public Kundenverwaltung(){
        laden();
    }


    public Kunde einloggenOderRegistrieren(String name){
        if (kundenMap.containsKey(name)) {
            System.out.println("Willkommen zurück "+ name + "!");
            return kundenMap.get(name);
        }
        else{
            System.out.println("Neuer Benutzer angelegt: " + name);
            Kunde k = new Kunde(name);
            kundenMap.put(name, k);
            return k;
        }
    }


    public void speichern(){
        try {
            // File f = new File(DATEI);
            // f.canWrite();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATEI));
            oos.writeObject(kundenMap);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    private void laden() {
        File f = new File(DATEI);
        if (!f.exists()) return; 
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATEI));
                kundenMap = (Map<String,Kunde>) ois.readObject();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    }
}
