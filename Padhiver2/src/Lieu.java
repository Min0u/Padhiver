import java.util.ArrayList;
import java.util.List;

public class Lieu {

    // Attributs

    protected String nom;
    public int nbMonstres;
    public int nbPNJ;
    private List<Personnage> personnages;
    private List<Monstre> monstres;
    private List<Lieu> lieuxAccessibles;

    // Constructeur

    public Lieu(String nom) {
        this.nom = nom;
        this.nbMonstres = 0;
        this.nbPNJ = 0;
        this.monstres = new ArrayList<>();
        this.personnages = new ArrayList<>();
        this.lieuxAccessibles = new ArrayList<>();
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
        nbMonstres++;
    }

    public void retirerMonstre(Monstre monstre) {
        monstres.remove(monstre);
        nbMonstres--;
    }

    public void ajouterPNJ(PNJ pnj) {
        personnages.add(pnj);
        nbPNJ++;
    }

    // Getters

    public static Lieu[] getLieuxAccessibles(Lieu lieuActuel) {
        return (Lieu[]) lieuActuel.lieuxAccessibles.toArray();
    }

    public Monstre[] getMonstres() {
        return (Monstre[]) monstres.toArray();
    }

    public PNJ[] getPNJ() {
        return (PNJ[]) personnages.toArray();
    }
}