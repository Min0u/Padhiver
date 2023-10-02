package base;

import java.util.ArrayList;
import java.util.List;

public class Lieu {
    public int nbMonstres;
    public int nbPNJ;

    // Attributs

    private String nom;
    private final List<Personnage> personnages;
    private final List<Monstre> monstres;
    private static List<Lieu> lieuxAccessibles = null;

    // Constructeur

    public Lieu(String nom) {
        this.nom = nom;
        this.monstres = new ArrayList<>();
        this.personnages = new ArrayList<>();
        this.lieuxAccessibles = new ArrayList<>();
    }

    // Getters

    public static Lieu[] getLieuxAccessibles(Lieu lieuActuel) {
        return lieuxAccessibles.toArray(new Lieu[0]);
    }

    public Monstre[] getMonstres() {
        return monstres.toArray(new Monstre[0]);
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    public String getNom() {
        return nom;
    }

    // Méthodes

    public void ajouterPersonnage(Personnage personnage) {
        personnages.add(personnage);
    }

    public void retirerPersonnage(Personnage personnage) {
        personnages.remove(personnage);
    }

    public void ajouterLieu(Lieu lieu) {
        lieuxAccessibles.add(lieu);
    }

    public void ajouterMonstre(Monstre monstre) {
        monstres.add(monstre);
    }

    public void retirerMonstre(Monstre monstre) {
        monstres.remove(monstre);
    }

    public List<PNJ> getPNJ() {
        List<PNJ> pnjs = new ArrayList<>();
        for (Personnage personnage : personnages) {
            if (personnage instanceof PNJ) {
                pnjs.add((PNJ) personnage);
            }
        }
        return pnjs;
    }

    public int getNbPNJ() {
        return personnages.size();
    }

    public int getNbMonstres() {
        return monstres.size();
    }
}
