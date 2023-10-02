package base;

public class PNJ extends Personnage {

    private final String reponse;

    public PNJ(String nom, String reponse) {
        super(nom, 1, 0, 0); // Les PNJ ont 1 point de vie, sans dégâts ni magie
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    // Vous pouvez ajouter d'autres méthodes spécifiques au PNJ si nécessaire
}
