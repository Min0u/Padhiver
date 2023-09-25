public class Metier {

    // Attributs

    private String nom;
    private String arme;
    private int degats;
    private int pvMaxParNiveau;
    private int magieMaxParNiveau;

    // Constructeur

    public Metier(String nom, String arme, int degats, int pvMaxParNiveau, int magieMaxParNiveau) {
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

    public String getArme() {
        return arme;
    }

}
