package monstre;

import base.Joueur;
import base.Personnage;

public class Monstre extends Personnage {

    // Attributs

    private int magie;
    private static final String S1 = " dégâts au joueur.";

    // Constructeur

    public Monstre(String nom, int pointsDeVieTotal, int degats, int magie) {
        super(nom, pointsDeVieTotal, degats, magie);
        this.magie = magie;
    }

    // Méthodes

    public void transfertDeVie(Joueur joueur) {

        if (this.getPointsDeMagieCourants() >= 5) {
            // Le Nécromant a assez de magie pour lancer le sort
            int degatsInfliges = 12;
            joueur.recevoirDegats(degatsInfliges); // Infliger des dégâts au joueur
            this.regenererPointsDeVie(); // Redonner 6 PV au Nécromant
            this.setMagie(this.getPointsDeMagieCourants()-5); // Déduire les points de magie utilisés

            System.out.println("Le Nécromant effectue un transfert de vie.");
            System.out.println("Le Nécromant a infligé " + degatsInfliges + S1);
            System.out.println("Le Nécromant a récupéré 6 points de vie.");
        } else {
            System.out.println("Le Nécromant n'a pas assez de magie pour lancer le sort.");
            casGuerrier(joueur);
        }
    }

    private void casGuerrier(Joueur joueur) {

        if (joueur.getMetier().equals("metier.Guerrier")) {
            int degatsInfliges = getDegats() - 2;
            System.out.println("Le monstre attaque et inflige " + degatsInfliges + S1);
            joueur.recevoirDegats(degatsInfliges);
        } else {
            int degatsInfliges = getDegats();
            System.out.println("Le monstre attaque et inflige " + degatsInfliges + S1);
            joueur.recevoirDegats(degatsInfliges);
        }
    }

    private void regenererPointsDeVie() {
        // Implémentation spécifique au monstre.Monstre pour régénérer des points de vie
        this.pointsDeVieCourants += 6;
    }

    public void souffleDuDragon(Joueur joueur) {
        if (this.getPointsDeMagieCourants() >= 8) {
            // Le monstre.Dragon a assez de magie pour lancer le sort
            int degatsInfliges = 20;
            joueur.recevoirDegats(degatsInfliges); // Infliger des dégâts au joueur
            this.setMagie(this.getPointsDeMagieCourants()-8); // Déduire les points de magie utilisés
            System.out.println("Le Dragon lance un souffle de feu.");
            System.out.println("Le Dragon a infligé " + degatsInfliges + S1);
        } else {
            System.out.println("Le Dragon n'a pas assez de magie pour lancer le sort.");

            casGuerrier(joueur);
        }
    }
}
