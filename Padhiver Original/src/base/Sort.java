
    private void regenererPointsDeVie() {
        // Implémentation spécifique au base.Monstre pour régénérer des points de vie
        this.pointsDeVieCourants += 6;
    }

    public void souffleDuDragon(Joueur joueur) {
        if (this.magie >= 8) {
            // Le monstre.Dragon a assez de magie pour lancer le sort
            int degatsInfliges = 20;
            joueur.recevoirDegats(degatsInfliges); // Infliger des dégâts au joueur
            this.magie -= 8; // Déduire les points de magie utilisés
            System.out.println("Le monstre.Dragon lance un souffle de feu.");
            System.out.println("Le monstre.Dragon a infligé " + degatsInfliges + S1);
        } else {
            System.out.println("Le monstre.Dragon n'a pas assez de magie pour lancer le sort.");

            casGuerrier(joueur);
        }
}
    public void lancerBouleDeFeu(Monstre monstre, int niveau) {
        if (magieCourante >= 9) {
            System.out.println(nom + " lance Boule de feu sur " + monstre.getNom() + "!");
            monstre.recevoirDegats(15*niveau);
            magieCourante -= 9;
            System.out.println("La Boule de feu inflige 15 dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Boule de feu.");
        }
    }

    public void lancerRayonDeGivre(Monstre monstre, int niveau) {
        if (magieCourante >= 2) {
            System.out.println(nom + " lance Rayon de givre sur " + monstre.getNom() + "!");
            monstre.recevoirDegats(4*niveau);
            magieCourante -= 2;
            System.out.println("Le Rayon de givre inflige 4 dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Rayon de givre.");
        }
    }
