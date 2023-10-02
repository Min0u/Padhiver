package metier;

import base.Metier;

public class Guerrier extends Metier {
    // Attributs et méthodes spécifiques aux guerriers

    public Guerrier() {
        super("Guerrier", "Epée", 4, 8, 0 );
        // Initialisation des attributs spécifiques aux guerriers
    }

    @Override
    public void afficherDescription() {
        System.out.println("Guerrier : Un guerrier est un combattant qui se bat avec une épée.");
    }

    // Autres méthodes spécifiques aux guerriers
}