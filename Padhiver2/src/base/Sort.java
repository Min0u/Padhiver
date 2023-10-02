package base;

import base.Monstre;
import metier.Magicien;

public class Sort {

    private String nom;
    private int coutMagie;
    private int degats;

    public Sort(String nom, int coutMagie, int degats) {
        this.nom = nom;
        this.coutMagie = coutMagie;
        this.degats = degats;
    }

    public void lancerSort(Monstre monstre, Joueur joueur) {
        if ("Magicien".equals(joueur.getMetier())) {// Obtenez le métier du joueur et castez en Magicien
            if (nom.equals("Boule de feu") && joueur.getMagieCourante() >= coutMagie) {
                int degatsInfliges = degats; // Pas besoin de multiplier par le niveau ici
                monstre.recevoirDegats(degatsInfliges);
                joueur.setMagieCourante(joueur.getMagieCourante() - coutMagie);
                System.out.println(joueur.getNom() + " lance " + nom + " sur " + monstre.getNom() + " et inflige " + degatsInfliges + " dégâts!");
            } else if (nom.equals("Rayon de givre") && joueur.getMagieCourante() >= coutMagie) {
                int degatsInfliges = degats; // Pas besoin de multiplier par le niveau ici
                monstre.recevoirDegats(degatsInfliges);
                joueur.setMagieCourante(joueur.getMagieCourante() - coutMagie);
                System.out.println(joueur.getNom() + " lance " + nom + " sur " + monstre.getNom() + " et inflige " + degatsInfliges + " dégâts!");
            } else {
                System.out.println(Joueur.getNom() + " n'a pas assez de magie pour lancer " + nom + ".");
            }
        }
    }


    public int getCoutMagie() {
        return coutMagie;
    }

    public String getNom() {
        return nom;
    }
}
