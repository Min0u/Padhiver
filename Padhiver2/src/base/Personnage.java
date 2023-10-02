package base;

public class Personnage {
    private static String nom;
    int pointsDeVieTotal;
    int pointsDeVieCourants;
    private Lieu lieuActuel;
    int degats;
    private int magie;

    public Personnage(String nom, int pointsDeVieTotal, int degats, int magie) {
        this.nom = nom;
        this.pointsDeVieTotal = pointsDeVieTotal;
        this.pointsDeVieCourants = pointsDeVieTotal;
        this.degats = degats;
        this.magie = magie;
    }

    public void deplacer(Lieu destination) {
        // Déplacer le personnage vers un autre lieu
        if (lieuActuel != null) {
            lieuActuel.retirerPersonnage(this);
        }
        lieuActuel = destination;
        destination.ajouterPersonnage(this);
    }

    protected void recevoirDegats(int degatsInfliges) {
        this.pointsDeVieCourants -= degatsInfliges;
    }

    protected boolean estEnVie() {
        return pointsDeVieCourants > 0;
    }

    public int getPointsDeMagieCourants() {
        return magie;
    }

    public static String getNom() {
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

    public int getDegats() {
        return degats;
    }

    public void setNom(String nomJoueur) {
        this.nom = nomJoueur;
    }

    public int getPointsDeMagieTotal() {
        return magie;
    }

    public void setLieuActuel(Lieu lieu) {
        this.lieuActuel = lieu;
    }

    public int getMagieCourante() {
        return magie;
    }

    public void setMagieCourante(int i) {
        this.magie = i;
    }

    // Autres méthodes spécifiques au personnage
}
