import java.util.Scanner;
public class Joueur extends Personnage {

    // Attributs

    protected Metier metier;
    protected static int niveau;
    protected int degats;

    // Constructeur

    public Joueur(String nom, Metier metier) {
        super(nom, metier.getPvMaxParNiveau());
        this.metier = metier;
        this.niveau = 1;
        this.degats = metier.getDegats();
    }

    // Getters
    //getNiveau
    public int getNiveau() {
        return niveau;
    }

    // Méthodes

    public void attaquer(Personnage cible) {
        while (estEnVie() && cible.estEnVie()) {
            if (metier instanceof Magicien) {
                // Si le joueur est un magicien, utilisez son sort le plus puissant
                Magicien magicien = (Magicien) metier;
                if (magicien.getMagieCourante() >= 9) { // S'il a assez de magie pour "Boule de feu"
                    magicien.lancerBouleDeFeu((Monstre) cible);
                } else if (magicien.getMagieCourante() >= 2) { // Sinon, utilisez "Rayon de givre"
                    magicien.lancerRayonDeGivre((Monstre) cible);
                } else {
                    System.out.println("Le joueur n'a pas assez de magie pour lancer un sort.");
                }
            } else {
                // Si le joueur n'est pas un magicien, utilisez son arme
                int degats = metier.getDegats();
                cible.recevoirDegats(degats, getPointsDeVieCourants());
                System.out.println("Le joueur attaque avec son arme et inflige " + degats + " dégâts au monstre.");
            }
        }
        if (!cible.estEnVie()) {
            System.out.println("Le joueur est mort et ne peut pas attaquer.");
        }
        else {
            System.out.println("Le monstre est mort et ne peut pas attaquer.");
            gagnerNiveau();
            cible.getLieuActuel().retirerMonstre((Monstre) cible);
        }
    }

    public void seReposer(){
        System.out.println("Vous vous reposez et regagnez tous vos points de vie ainsi que votre magie (si vous êtes un magicien).");
        this.setPointsDeVieCourants(this.getPointsDeVieTotal());
    }

    public void gagnerNiveau() {
        // Implémentez le code pour faire gagner un niveau au joueur
        niveau++;
        if (this.niveau >= 3 && this.niveau < 6) {
            this.degats = metier.getDegats() * 2;
        } else if (this.niveau >= 6 && this.niveau < 9) {
            this.degats = metier.getDegats() * 3;
        } else if (this.niveau >= 9) {
            this.degats = metier.getDegats() * 4;
        }
        System.out.println("Vous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");
    }
    // Autres méthodes spécifiques au joueur en fonction de son métier

    protected boolean estEnVie() {
        return getPointsDeVieCourants() > 0;
    }
}
