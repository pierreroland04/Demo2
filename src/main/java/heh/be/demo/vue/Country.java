package heh.be.demo.vue;

public class Country {
    private String name;
    private Number num;

    // Constructeur par défaut
    public Country() {
        this.name = null; // ou une valeur par défaut
        this.num = null; // ou une valeur par défaut
    }

    // Constructeur avec paramètres
    public Country(String name, Number num) {
        this.name = name;
        this.num = num;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Number getNum() {
        return num;
    }
}
