package metier;

import base.Metier;

public class Barbare extends Metier {

    public Barbare() {
        super("Barbare", "Hache", 5, 9, 0);
    }

    @Override
    public void afficherDescription() {
        System.out.println("Métier : " + getNom());
        System.out.println("Arme : " + getArme());
        System.out.println("Dégâts : " + getDegats());
        System.out.println("Points de vie maximum par niveau : " + getPvMaxParNiveau());
    }
}