package metier;

import monstre.Monstre;

import sort.Sort;
import sort.BouleDeFeu;
import sort.RayonDeGivre;

public class Magicien extends Metier {

    // Attributs

    private final int magieMax;
    private int magieCourante;
    private int magieTotal;

    // Constructeur

    public Magicien() {
        super("Magicien", "Dague", 2, 7, 4);
        this.magieMax = 4; // Magie max spécifique au metier.Magicien
        this.magieCourante = 4; // Magie courante spécifique au metier.Magicien
        this.magieTotal = 4;
    }

    // Getters

    public int getMagieCourante() {
        return magieCourante;
    }

    @Override
    public int getMagieMaxParNiveau() {
        return magieMax;
    }
    // Méthodes

    public void lancerBouleDeFeu(Monstre monstre, int niveau) {
        Sort bouleDeFeu = new BouleDeFeu();
        int degat;
        if (magieCourante >= bouleDeFeu.getCoutMagie()) {
            System.out.println(nom + " lance " + bouleDeFeu.getNom() + " sur " + monstre.getNom() + "!");
            if (niveau >= 6) {
                degat = bouleDeFeu.getDegats() * 2;
            }
            else {
                degat = 15;
            }
            monstre.recevoirDegats(degat);
            magieCourante -= bouleDeFeu.getCoutMagie();
            System.out.println("La Boule de feu inflige " + degat + " dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Boule de feu.");
        }
    }

    public void lancerRayonDeGivre(Monstre monstre, int niveau) {
        Sort rayonDeGivre = new RayonDeGivre();
        int degat;
        if (magieCourante >= rayonDeGivre.getCoutMagie()) {
            System.out.println(nom + " lance " + rayonDeGivre.getNom() + " sur " + monstre.getNom() + "!");
            if (niveau >= 6) {
                degat = rayonDeGivre.getDegats() * 2;
            }
            else {
                degat = 4;
            }
            monstre.recevoirDegats(degat);
            magieCourante -= rayonDeGivre.getCoutMagie();
            System.out.println("Le " + rayonDeGivre.getNom() + " inflige " + degat + " dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Rayon de givre.");
        }
    }

    public void regenererMagie() {
        magieCourante = magieTotal;
    }

    public void gagnerMagie(int niveau) {
        magieTotal = magieMax * niveau;
    }
}
