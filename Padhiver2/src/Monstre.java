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


    public void attaquer(Personnage cible) {
        while (estEnVie() && cible.estEnVie()) {
            // Vérifiez si le monstre est un Nécromant et a assez de magie pour Transfert de vie
            if (this instanceof Necromant && magie >= 5) {
                ((Necromant) this).transfertDeVie((Joueur) cible, cible.getPointsDeVieCourants()); // Appel de la compétence Transfert de vie du Nécromant
            } else if (this instanceof Dragon && magie >= 8) {
                ((Dragon) this).souffleDuDragon((Joueur) cible, cible.getPointsDeVieCourants()); // Appel de la compétence Souffle du dragon du Dragon
            } else {
                // Attaque normale si aucune compétence spéciale n'est utilisée
                int degatsInfliges = degats;
                if (cible.metier instanceof Guerrier) {
                    degatsInfliges -= 2; // Le Guerrier réduit les dégâts de 2
                }
                else {
                    degatsInfliges = degats;
                }
                cible.recevoirDegats(degatsInfliges, getPointsDeVieCourants()); // Infliger des dégâts à la cible
                System.out.println("Le monstre attaque et inflige " + degats + " dégâts au joueur.");
            }

            // Si la cible est toujours en vie, elle attaque le monstre en retour
            if (cible.estEnVie()) {
                cible.attaquer(this, getPointsDeVieCourants());
            }
        }
    }

    protected boolean estEnVie() {
        return getPointsDeVieCourants() > 0;
    }

    @Override
    protected void recevoirDegats(int degatsInfliges, int pointsDeVieCourants) {
        // Implémentation spécifique au Monstre pour recevoir des dégâts
        pointsDeVieCourants -= degatsInfliges;
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

    private void regenererPointsDeVie(int i, int pointsDeVieCourants) {
        // Implémentation spécifique au Monstre pour régénérer des points de vie
        pointsDeVieCourants += i;
    }

    public void souffleDuDragon(Joueur joueur, int pointsDeVieCourants) {
        if (magie >= 8) {
            // Le Dragon a assez de magie pour lancer le sort
            int degatsInfliges = 20;
            if (joueur.metier instanceof Guerrier) {
                joueur.recevoirDegats(degatsInfliges-2, pointsDeVieCourants); // Infliger des dégâts au joueur
            }
            else {
                joueur.recevoirDegats(degatsInfliges, pointsDeVieCourants); // Infliger des dégâts au joueur
            }
            magie -= 8; // Déduire les points de magie utilisés
        } else {
            System.out.println("Le Dragon n'a pas assez de magie pour lancer le sort.");
        }
    }
}
