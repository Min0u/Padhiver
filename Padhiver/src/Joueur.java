import java.util.Scanner;
public class Joueur extends Personnage {

    // Attributs

    private Metier metier;
    private int niveau;

    // Constructeur

    public Joueur(String nom, Metier metier) {
        super(nom, metier.getPvMaxParNiveau());
        this.metier = metier;
        this.niveau = 1;
    }

    // Méthodes

    @Override
    public void parler() {
        // Implémentation spécifique au Joueur pour parler
        System.out.println("Que voulez-vous dire ?");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("Vous avez dit : " + message);
    }

    @Override
    protected void recevoirDegats(int degatsInfliges, int pointsDeVieCourants) {
        // Implémentation spécifique au Joueur pour recevoir des dégâts
        pointsDeVieCourants -= degatsInfliges;
    }

    @Override
    protected void regenererPointsDeVie(int i, int pointsDeVieCourants) {
        // Implémentation spécifique au Joueur pour régénérer des PV
        pointsDeVieCourants += i;
    }

    public void regenererMagie(int i, int magieCourante) {
        // Implémentation spécifique au Joueur pour régénérer de la magie
        magieCourante += i;
    }

    public void gagnerNiveau() {
        // Implémentez le code pour faire gagner un niveau au joueur
        niveau++;
        System.out.println("Vous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");
    }
    // Autres méthodes spécifiques au joueur en fonction de son métier

    public void utiliserArme(Personnage cible) {
        // Implémentez le code pour utiliser l'arme du joueur (dégâts, etc.)
        int degats = metier.getDegats();
        System.out.println("Vous attaquez " + cible.getNom() + " avec votre " + metier.getArme() + " et infligez " + degats + " dégâts.");
        cible.recevoirDegats(degats, cible.getPointsDeVieCourants());
    }

    public void utiliserSort(Personnage cible) {
        // Implémentez le code pour utiliser un sort spécifique au métier du joueur
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            int magieRequise = 2; // Exemple de coût en magie pour le sort
            if (magicien.getMagieCourante() >= magieRequise) {
                int degatsSort = 4; // Exemple de dégâts infligés par le sort
                System.out.println("Vous lancez le sort 'Rayon de givre' sur " + cible.getNom() + " et infligez " + degatsSort + " dégâts.");
                cible.recevoirDegats(degatsSort, cible.getPointsDeVieCourants());
                magicien.decrementerMagie(magieRequise);
            } else {
                System.out.println("Vous n'avez pas assez de magie pour lancer le sort.");
            }
        }
    }
}
