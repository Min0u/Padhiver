import java.util.ArrayList;
import java.util.List;

public class Lieu {

    // Attributs

    private String nom;
    private int nbMonstres;
    private List<Personnage> personnages;
    private List<Lieu> lieuxAccessibles;

    // Constructeur

    public Lieu(String nom) {
        this.nom = nom;
        this.nbMonstres = 0;
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
}