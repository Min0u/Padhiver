public class PNJ extends Personnage {

    // Attributs

    private String reponse;

    // Constructeur

    public PNJ(String nom, String reponse) {
        super(nom, 1); // Vous pouvez ajuster les PV si nécessaire
        this.reponse = reponse;
    }

    // Méthodes

    @Override
    public void parler() {
        System.out.println(this.reponse); // Afficher la réponse du PNJ
    }

}