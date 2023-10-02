package metier;

import base.Joueur;
import base.Metier;
import base.Sort;
import base.Monstre;

public class Magicien extends Metier {

    private final int magieMax;
    private int magieCourante;
    private int magieTotal;

    public Magicien() {
        super("Magicien", "Dague", 2, 7, 4);
        this.magieMax = 4; // Magie max spécifique au Magicien
        this.magieCourante = 4; // Magie courante spécifique au Magicien
        this.magieTotal = 4;
    }

    // Getters

    public int getMagieCourante() {
        return magieCourante;
    }

    // Méthodes spécifiques aux Magiciens

    public void regenererMagie() {
        magieCourante = magieTotal;
    }

    public void gagnerMagie(int niveau) {
        magieTotal = magieMax * niveau;
    }

    @Override
    public void afficherDescription() {
        System.out.println("Métier : " + getNom());
        System.out.println("Arme : " + getArme());
        System.out.println("Dégâts : " + getDegats());
        System.out.println("Points de vie maximum par niveau : " + getPvMaxParNiveau());
        System.out.println("Magie maximum par niveau : " + getMagieMaxParNiveau());
        System.out.println("Magie courante : " + magieCourante);
    }
}
