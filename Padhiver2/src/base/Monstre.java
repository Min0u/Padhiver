package base;

import base.Monstre;
import base.Joueur;
import base.Sort;

public abstract class Monstre extends Personnage {

    private int magie;

    public Monstre(String nom, int pointsDeVieTotal, int degats, int magie) {
        super(nom, pointsDeVieTotal, degats, magie);
        this.magie = magie;
    }

    public void utiliserSort(Sort sort, Monstre monstre, Joueur joueur) {
        if (magie >= sort.getCoutMagie()) {
            sort.lancerSort(this, joueur); // Passer le monstre cible
            magie -= sort.getCoutMagie();
        } else {
            System.out.println("Le monstre n'a pas assez de magie pour lancer le sort.");
            attaquer(joueur);
        }
    }

    public void attaquer(Joueur joueur) { // Modifier l'accès à public
        int degatsInfliges = getDegats();
        joueur.recevoirDegats(degatsInfliges);
        System.out.println("Le monstre attaque et inflige " + degatsInfliges + " dégâts au joueur.");
    }
}
