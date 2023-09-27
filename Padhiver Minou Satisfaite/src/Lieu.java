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

    // Getters

    public static Lieu[] getLieuxAccessibles(Lieu lieuActuel) {
        return (Lieu[]) lieuActuel.lieuxAccessibles.toArray(new Lieu [0]);
    }

    public Monstre[] getMonstres() {
        return (Monstre[]) monstres.toArray(new Monstre [0]);
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

}