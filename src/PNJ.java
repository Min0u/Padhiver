public class PNJ extends Personnage {

    // Attributs

    private final String reponse;

    // Constructeur

    public PNJ(String nom, String reponse) {
        super(nom, 1, 0,0); // Vous pouvez ajuster les PV si nécessaire
        this.reponse = reponse;
    }

    // Getters

    public String getReponse() {
        return reponse;
    }

}