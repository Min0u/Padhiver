public class Personnage {

    // Attributs

    private String nom;
    private int pointsDeVieTotal;
    protected int pointsDeVieCourants;
    private Lieu lieuActuel;
    protected int degats;
    private final int magie;

    // Constructeur

    public Personnage(String nom, int pointsDeVieTotal, int degats, int magie) {
        this.nom = nom;
        this.pointsDeVieTotal = pointsDeVieTotal;
        this.pointsDeVieCourants = pointsDeVieTotal;
        this.degats = degats;
        this.magie = magie;
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

    protected void setDegats(int degat) {
        degats = degat;
    }

    // Getters

    protected int getPointsDeMagieCourants() {
        return magie;
    }

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

    public int getDegats() {
        return degats;
    }

    // Méthodes

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

}

