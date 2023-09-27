public class Joueur extends Personnage {

    // Attributs

    protected Metier metier;
    protected static int niveau;

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

    private String getMagieTotal() {
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    public int getPointsDeMagieCourants() {
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            return magicien.getMagieCourante();
        } else {
            return 0;
        }
    }

    public String getArme() {
        return metier.getArme();
    }

    public int getDegats() {
        return degats;
    }

    public String getPointsDeMagieTotal() {
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    // Méthodes

    public void attaquer(Personnage cible) {
        // Le joueur commence à attaquer
        boolean tourJoueur = true;

        while (estEnVie() && cible.estEnVie()) {

            // Affichez les points de vie et de magie du joueur et du monstre
            System.out.println("Vie du joueur : " + getPointsDeVieCourants() + "/" + getPointsDeVieTotal());
            System.out.println("Vie du monstre : " + cible.getPointsDeVieCourants() + "/" + cible.getPointsDeVieTotal());
            System.out.println("Magie du joueur : " + getPointsDeMagieCourants() + "/" + getMagieTotal());

            // Vérifiez à qui appartient le tour et laissez ce personnage attaquer
            if (tourJoueur) {
                System.out.println("C'est au tour du joueur !");
                if (metier instanceof Magicien) {
                    Magicien magicien = (Magicien) metier;
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
                System.out.println("C'est au tour du monstre !");
                if (cible instanceof Necromant ) {
                    if (cible.getPointsDeMagieCourants() >= 5) {
                        ((Necromant) cible).transfertDeVie(this, getPointsDeVieCourants());
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println("Le monstre attaque et inflige " + degatsInfliges + " dégâts au joueur.");
                        recevoirDegats(degatsInfliges);
                    }
                } else if (cible instanceof Dragon) {
                    if (cible.getPointsDeMagieCourants() >= 8) {
                        ((Dragon) cible).souffleDuDragon(this, getPointsDeVieCourants());
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println("Le monstre attaque et inflige " + degatsInfliges + " dégâts au joueur.");
                        recevoirDegats(degatsInfliges);
                    }
                } else {
                    int degatsInfliges = cible.getDegats();
                    if (metier instanceof Guerrier) {
                        degatsInfliges -= 2; // Le Guerrier réduit les dégâts de 2 (hors sorts)
                    }
                    System.out.println("Le monstre attaque et inflige " + degatsInfliges + " dégâts au joueur.");
                    recevoirDegats(degatsInfliges);
                }
                tourJoueur = true; // Tour au joueur
            }

            // Vérifiez si l'un des personnages est mort
            if (!estEnVie()) {
                System.out.println("Vous êtes mort.");
            } else if (!cible.estEnVie()) {
                System.out.println("Le monstre est mort.");
                gagnerNiveau();
                Lieu lieuActuel = getLieuActuel();
                lieuActuel.retirerMonstre((Monstre) cible);
            }
        }
    }

    public void seReposer(){
        System.out.println("Vous vous reposez et regagnez tous vos points de vie ainsi que votre magie (si vous êtes un magicien).");
        this.setPointsDeVieCourants(this.getPointsDeVieTotal());
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            magicien.regenererMagie();
        }
    }

    public void gagnerNiveau() {
        // Implémentez le code pour faire gagner un niveau au joueur
        niveau++;
        this.setPointsDeVieTotal(metier.getPvMaxParNiveau() * niveau); // Augmentation des points de vie
        // Si c'est un magicien, augmenter la magie max
        if (metier instanceof Magicien) {
            Magicien magicien = (Magicien) metier;
            magicien.gagnerMagie(niveau);
        }
        if (this.niveau >= 3 && this.niveau< 6) {
            this.setDegats(metier.getDegats()*2);
        } else if (this.niveau >= 6 && this.niveau < 9) {
            this.setDegats(metier.getDegats()*3);
        } else if (this.niveau >= 9) {
            this.setDegats(metier.getDegats()*4);
        }
        System.out.println("Vous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");
    }

    protected boolean estEnVie() {
        return getPointsDeVieCourants() > 0;
    }


}
