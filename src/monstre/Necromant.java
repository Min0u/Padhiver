package monstre;

import base.Joueur;


public class Necromant extends Monstre {

    public Necromant() {
        super("Nécromant", 30, 8, 10);
    }

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

}