
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
