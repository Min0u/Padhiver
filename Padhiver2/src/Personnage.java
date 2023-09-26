import java.util.Scanner;

public class Personnage {
    protected Object metier;

    // Attributs

    private String nom;
    private int pointsDeVieTotal;
    private int pointsDeVieCourants;
    private Lieu lieuActuel;

    // Constructeur

    public Personnage(String nom, int pointsDeVieTotal) {
        this.nom = nom;
        this.pointsDeVieTotal = pointsDeVieTotal;
        this.pointsDeVieCourants = pointsDeVieTotal;
    }

    // Setters

    public void setLieuActuel(Lieu lieuActuel) {
        this.lieuActuel = lieuActuel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointsDeVieTotal(int pointsDeVieTotal) {
        this.pointsDeVieTotal = pointsDeVieTotal;
    }

    public void setPointsDeVieCourants(int pointsDeVieCourants) {
        this.pointsDeVieCourants = pointsDeVieCourants;
    }

    // Getters

    public String getNom() {
        return nom;
    }

    public int getPointsDeVieTotal() {
        return pointsDeVieTotal;
    }

    public int getPointsDeVieCourants() {
        return pointsDeVieCourants;
    }

    public Lieu getLieuActuel() {
        return lieuActuel;
    }

    // Méthodes

    public void attaquer(Personnage cible, int pointsDeVieCourants) {
        // Attaquer un autre personnage
        cible.recevoirDegats(1, this.pointsDeVieCourants);
    }

    public void deplacer(Lieu destination) {
        // Déplacer le personnage vers un autre lieu
        if (lieuActuel != null) {
            lieuActuel.retirerPersonnage(this);
        }
        lieuActuel = destination;
        destination.ajouterPersonnage(this);
    }

    protected void recevoirDegats(int degatsInfliges, int pointsDeVieCourants) {
        // Implémentation spécifique au Personnage pour recevoir des dégâts
        pointsDeVieCourants -= degatsInfliges;
    }

    protected boolean estEnVie() {
        // Implémentation spécifique au Personnage pour vérifier s'il est en vie
        return pointsDeVieCourants > 0;
    }
}

