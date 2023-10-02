package base;

import metier.Magicien;

public class Joueur extends Personnage {

    private Metier metier;
    private int niveau;

    // Constructeur
    public Joueur(String nom, Metier metier) {
        super(nom, metier.getPvMaxParNiveau(), metier.getDegats(), metier.getMagieMaxParNiveau());
        this.metier = metier;
        this.niveau = 1;
    }

    // Getters

    public int getNiveau() {
        return niveau;
    }

    public String getMetier() {
        return metier.getNom();
    }

    // Setters

    private void setPointsDeVieCourant(int pointsDeVieTotal) {
        this.pointsDeVieCourants = pointsDeVieTotal;
    }

    private void setDegats(int i) {
        this.degats = i;
    }

    private void setPointsDeVieTotal(int i) {
        this.pointsDeVieTotal = i;
    }

    // Méthodes

    public void attaquer(Personnage cible) {
        // Le joueur commence à attaquer
        boolean tourJoueur = true;

        while (estEnVie() && cible.estEnVie()) {
            // Affichez les points de vie du joueur et de la cible
            System.out.println("\nVie du joueur : " + getPointsDeVieCourants() + "/" + getPointsDeVieTotal());
            System.out.println("Vie de la cible : " + cible.getPointsDeVieCourants() + "/" + cible.getPointsDeVieTotal());

            // Vérifiez à qui appartient le tour et laissez ce personnage attaquer
            if (tourJoueur) {
                System.out.println("\nC'est au tour du joueur !");
                int degats = getDegats();
                System.out.println("Le joueur attaque avec son arme et inflige " + degats + " dégâts à la cible.");
                cible.recevoirDegats(degats);
                tourJoueur = false; // Tour à la cible
            } else {
                System.out.println("\nC'est au tour de la cible !");
                int degatsInfliges = cible.getDegats();
                System.out.println("La cible attaque et inflige " + degatsInfliges + " dégâts au joueur.");
                recevoirDegats(degatsInfliges);
                tourJoueur = true; // Tour au joueur
            }
        }

        // Vérifiez si l'un des personnages est mort
        if (!estEnVie()) {
            System.out.println("\nVous êtes mort.");
        } else if (!cible.estEnVie()) {
            System.out.println("\nLa cible est morte.");
            gagnerNiveau();
        }
    }

    public void recevoirDegats(int degatsInfliges) {
        super.recevoirDegats(degatsInfliges);
        System.out.println("Le joueur a subi " + degatsInfliges + " dégâts !");
    }

    public void seReposer() {
        System.out.print("\nVous vous reposez et récupérez tous vos points de vie.");
        setPointsDeVieCourant(getPointsDeVieTotal());
    }

    public void gagnerNiveau() {
        niveau++;
        setPointsDeVieTotal(metier.getPvMaxParNiveau() * niveau);

        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            magicien.gagnerMagie(niveau);
            magicien.regenererMagie(); // Réinitialiser les points de magie après avoir gagné un niveau
        }

        if (niveau >= 3 && niveau < 6) {
            setDegats(metier.getDegats() * 2);
        } else if (niveau >= 6 && niveau < 9) {
            setDegats(metier.getDegats() * 3);
        } else if (niveau >= 9) {
            setDegats(metier.getDegats() * 4);
        }

        System.out.println("\nVous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");
    }

    public String getArme() {
        return metier.getArme();
    }
}
