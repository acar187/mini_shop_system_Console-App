import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Shop Produkte Liste
        List<Produkt> shopProdukteListe = new ArrayList<>();
        shopProdukteListe.add(new Produkt("Apfel", .50));
        shopProdukteListe.add(new Produkt("Brot", 2.00));
        shopProdukteListe.add(new Produkt("Milch", 1.20));

        // Warnkorb laden
        Warenkorb warenkorb = Warenkorb.laden("warenkorb.ser");


        int wahl;
        do{
            System.out.println("\n---Shop Menü---");
            System.out.println("1. Produkte anzeigen");
            System.out.println("2. Produkt in den Warenkorb legen");
            System.out.println("3. Warenkorb anzeigen");
            System.out.println("4. Warenkorb speichern");
            System.out.println("0. Beenden");
            System.out.print("Deine Wahl: ");

            wahl = Integer.parseInt(scanner.nextLine());

            switch (wahl) {
                case 1:
                    System.out.println("\n---Produkte in Shop ---");
                    for (int i = 0; i < shopProdukteListe.size(); i++) {
                        System.out.println(i + ": " + shopProdukteListe.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Produktnummer eingeben: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index >=0 && index < shopProdukteListe.size()) {
                        System.out.println("Menge eingeben ");
                        int menge = Integer.parseInt(scanner.nextLine());
                        System.out.println("Rabat in Prozent(z.B. 10 für 10%): ");
                        double rabatt = Double.parseDouble(scanner.nextLine()) /100.0;
                        System.out.println("Status eingeben()rb. resreviert /gekauft: ");
                        String status = scanner.nextLine();
                        warenkorb.hinzufügen(shopProdukteListe.get(index), menge, rabatt, status);
                    }
                    else{
                        System.out.println("Ungültige Auswahl.");
                    }
                    break;
                case 3:
                    warenkorb.anzeigen();
                    break;
                case 4:
                    warenkorb.speichern("warenkorb.ser");
                    break;
                case 0:
                    System.out.println("Programm beendet. Vielen Dank für den Einkauf!");
                    warenkorb.speichern("warenkorb.ser");
                    break;

                default:
                    System.out.println("Ungültige Eingabe!");
                    break;
            }


        }while (wahl != 0);

        scanner.close();
    }
}
