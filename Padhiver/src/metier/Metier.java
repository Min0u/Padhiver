package metier;

public abstract class Metier {

    // Attributs

    protected String nom;
    private final String arme;
    private final int degats;
    private final int pvMaxParNiveau;
    private final int magieMaxParNiveau;

    // Constructeur

    protected Metier(String nom, String arme, int degats, int pvMaxParNiveau, int magieMaxParNiveau) {
        this.nom = nom;
        this.arme = arme;
        this.degats = degats;
        this.pvMaxParNiveau = pvMaxParNiveau;
        this.magieMaxParNiveau = magieMaxParNiveau;
    }

    // Getters

    public int getPvMaxParNiveau() {
        return pvMaxParNiveau;
    }

    public int getDegats() {
        return degats;
    }

    public String getNom() {
        return nom;
    }

    public String getArme() {
        return arme;
    }

    public int getMagieMaxParNiveau() {
        return magieMaxParNiveau;
    }

}

