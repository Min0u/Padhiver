package base;

public abstract class Metier {

    // Attributs

    protected String nom;
    protected String arme;
    protected int degats;
    protected int pvMaxParNiveau;
    protected int magieMaxParNiveau;
    protected int magieCourante;

    // Constructeur

    public Metier(String nom, String arme, int degats, int pvMaxParNiveau, int magieMaxParNiveau) {
        this.nom = nom;
        this.arme = arme;
        this.degats = degats;
        this.pvMaxParNiveau = pvMaxParNiveau;
        this.magieMaxParNiveau = magieMaxParNiveau;
        this.magieCourante = magieMaxParNiveau;
    }

    // Méthodes

    public abstract void afficherDescription(); // Affiche une description du métier

    // Getters et Setters

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

    public void setMagieCourante(int magieCourante) {
        this.magieCourante = magieCourante;
    }

    public int getMagieCourante() {
        return magieCourante;
    }
}
