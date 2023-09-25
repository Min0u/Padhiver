public class Monstre extends Personnage {

    // Attributs

    private int degats;
    private int magie;

    // Constructeur

    public Monstre(String nom, int pointsDeVieTotal, int degats, int magie) {
        super(nom, pointsDeVieTotal);
        this.degats = degats;
        this.magie = magie;
    }

    // Méthodes

    @Override
    public void attaquer(Personnage cible, int pointsDeVieCourants) {
        // Implémentation spécifique au Monstre pour attaquer
        cible.recevoirDegats(degats, getPointsDeVieCourants());

    }

    @Override
    public void parler() {

    }

    @Override
    protected void recevoirDegats(int degatsInfliges, int pointsDeVieCourants) {
        // Implémentation spécifique au Monstre pour recevoir des dégâts
        pointsDeVieCourants -= degatsInfliges;
    }

    @Override
    protected void regenererPointsDeVie(int i, int pointsDeVieCourants) {
        // Implémentation spécifique au Monstre pour régénérer des PV
        pointsDeVieCourants += i;
    }

    public void transfertDeVie(Joueur joueur, int pointsDeVieCourants) {
        if (magie >= 5) {
            // Le Nécromant a assez de magie pour lancer le sort
            int degatsInfliges = 12;
            joueur.recevoirDegats(degatsInfliges, pointsDeVieCourants); // Infliger des dégâts au joueur
            this.regenererPointsDeVie(6, pointsDeVieCourants); // Redonner 6 PV au Nécromant
            magie -= 5; // Déduire les points de magie utilisés
        } else {
            System.out.println("Le Nécromant n'a pas assez de magie pour lancer le sort.");
        }
    }

    public void souffleDuDragon(Joueur joueur, int pointsDeVieCourants) {
        if (magie >= 8) {
            // Le Dragon a assez de magie pour lancer le sort
            int degatsInfliges = 20;
            joueur.recevoirDegats(degatsInfliges, pointsDeVieCourants); // Infliger des dégâts au joueur
            magie -= 8; // Déduire les points de magie utilisés
        } else {
            System.out.println("Le Dragon n'a pas assez de magie pour lancer le sort.");
        }
    }
}
