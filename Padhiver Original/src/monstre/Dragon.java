package monstre;

import base.Joueur;

public class Dragon extends Monstre {

    public Dragon() {
        super("Dragon", 70, 12, 24);
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