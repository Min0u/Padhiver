package base;

import metier.Guerrier;
import metier.Metier;
import metier.Magicien;

import monstre.Dragon;
import monstre.Monstre;
import monstre.Necromant;


public class Joueur extends Personnage {

    // Attributs

    protected Metier metier;
    protected int niveau;

    // Constructeur

    public Joueur(String nom, Metier metier) {
        super(nom, metier.getPvMaxParNiveau(), metier.getDegats(), metier.getMagieMaxParNiveau());
        this.metier = metier;
        niveau = 1;
    }

    // Getters

    public int getNiveau() {
        return niveau;
    }

    public String getMetier() {
        return metier.getNom();
    }

    private String getMagieTotal() {
        if (metier instanceof Magicien magicien) {
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    @Override
    public int getPointsDeMagieCourants() {
        if (metier instanceof Magicien magicien) {
            return magicien.getMagieCourante();
        } else {
            return 0;
        }
    }

    public String getArme() {
        return metier.getArme();
    }

    public String getPointsDeMagieTotal() {
        if (metier instanceof Magicien magicien) {
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    // Méthodes

    public void attaquer(Personnage cible) {
        // Le joueur commence à attaquer
        boolean tourJoueur = true;
        String s1 = "Le monstre attaque et inflige ";
        String s2 = " dégâts au joueur.";

        while (estEnVie() && cible.estEnVie()) {

            // Affichez les points de vie et de magie du joueur et du monstre
            System.out.println("\nVie du joueur : " + getPointsDeVieCourants() + "/" + getPointsDeVieTotal());
            System.out.println("Vie du monstre : " + cible.getPointsDeVieCourants() + "/" + cible.getPointsDeVieTotal());
            if (metier instanceof Magicien) {
                System.out.println("Magie du joueur : " + getPointsDeMagieCourants() + "/" + getMagieTotal());
            }
            if (cible instanceof Necromant || cible instanceof Dragon) {
                System.out.println("Magie du monstre : " + cible.getPointsDeMagieCourants() + "/" + cible.getMagie());
            }

            // Vérifiez à qui appartient le tour et laissez ce personnage attaquer
            if (tourJoueur) {
                System.out.println("\nC'est au tour du joueur !");
                if (metier instanceof Magicien magicien) {
                    if (magicien.getMagieCourante() >= 9) {
                        magicien.lancerBouleDeFeu((Monstre) cible, niveau);
                    } else if (magicien.getMagieCourante() >= 2) {
                        magicien.lancerRayonDeGivre((Monstre) cible, niveau);
                    } else {
                        System.out.println("Le joueur n'a pas assez de magie pour lancer un sort.");
                        int degats = getDegats();
                        System.out.println("Le joueur attaque avec son arme et inflige " + degats + " dégâts au monstre.");
                        cible.recevoirDegats(degats);
                    }
                } else {
                    int degats = getDegats();
                    System.out.println("Le joueur attaque avec son arme et inflige " + degats + " dégâts au monstre.");
                    cible.recevoirDegats(degats);
                }
                tourJoueur = false; // Tour au monstre
            } else {
                System.out.println("\nC'est au tour du monstre !");
                if (cible instanceof Necromant) {
                    if (cible.getPointsDeMagieCourants() >= 5) {
                        ((Necromant) cible).transfertDeVie(this);
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println(s1 + degatsInfliges + s2);
                        recevoirDegats(degatsInfliges);
                    }
                } else if (cible instanceof Dragon) {
                    if (cible.getPointsDeMagieCourants() >= 8) {
                        ((Dragon) cible).souffleDuDragon(this);
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println(s1 + degatsInfliges + s2);
                        recevoirDegats(degatsInfliges);
                    }
                } else {
                    int degatsInfliges = cible.getDegats();
                    if (metier instanceof Guerrier) {
                        degatsInfliges -= 2; // Le metier.Guerrier réduit les dégâts de 2 (hors sorts)
                    }
                    System.out.println(s1 + degatsInfliges + s2);
                    recevoirDegats(degatsInfliges);
                }
                tourJoueur = true; // Tour au joueur
            }

            // Vérifiez si l'un des personnages est mort
            if (!estEnVie()) {
                System.out.println("\nVous êtes mort.");
            } else if (!cible.estEnVie()) {
                System.out.println("\nLe monstre est mort.");
                gagnerNiveau();
                Lieu lieuActuel = getLieuActuel();
                lieuActuel.retirerMonstre((Monstre) cible);
            }
        }
    }

    public void seReposer(){
        if (metier instanceof Magicien) {
            System.out.print("\nVous vous reposez et regagnez tous vos points de vie et de magie.");
        }
        else {
            System.out.print("\nVous vous reposez et regagnez tous vos points de vie.");
        }
        this.setPointsDeVieCourants(this.getPointsDeVieTotal());
        if (metier instanceof Magicien magicien) {
            magicien.regenererMagie();
        }
    }

    public void gagnerNiveau() {
        // Implémentez le code pour faire gagner un niveau au joueur
        niveau++;
        this.setPointsDeVieTotal(metier.getPvMaxParNiveau() * niveau); // Augmentation des points de vie
        // Si c'est un magicien, augmenter la magie max
        if (metier instanceof Magicien magicien) {
            magicien.gagnerMagie(niveau);
        }
        if (niveau >= 3 && niveau< 6) {
            this.setDegats(metier.getDegats()*2);
        } else if (niveau >= 6 && niveau < 9) {
            this.setMagie(getMagie()*2);
            this.setDegats(metier.getDegats()*3);
        } else if (niveau >= 9) {
            this.setDegats(metier.getDegats()*4);
        }
        System.out.println("\nVous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");
    }

}
