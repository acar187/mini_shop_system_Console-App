import java.io.Serializable;

public class Produkt implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private double preis;

    public Produkt(String name, double preis){
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return name + " - " + preis +" Euro"; 
    }
}