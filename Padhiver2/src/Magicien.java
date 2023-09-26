public class Magicien extends Metier {

    // Attributs

    private int magieMax;
    private int magieCourante;

    // Constructeur

    public Magicien() {
        super("Magicien", "Dague", 2, 7, 4);
        this.magieMax = 4; // Magie max spécifique au Magicien
    }

    // Getters

    public int getMagieCourante() {
        return magieCourante;
    }

    // Méthodes

    public void lancerBouleDeFeu(Monstre monstre) {
        if (magieCourante >= 9) { // Vérifiez si le magicien a assez de magie pour lancer "Boule de feu"
            System.out.println(nom + " lance Boule de feu sur " + monstre.getNom() + "!");
            monstre.recevoirDegats(15, monstre.getPointsDeVieCourants()); // Inflige 15 dégâts au monstre
            magieCourante -= 9; // Déduit 9 points de magie
            System.out.println("La Boule de feu inflige 15 dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Boule de feu.");
        }
    }

    public void lancerRayonDeGivre(Monstre monstre) {
        if (magieCourante >= 2) { // Vérifiez si le magicien a assez de magie pour lancer "Rayon de givre"
            System.out.println(nom + " lance Rayon de givre sur " + monstre.getNom() + "!");
            monstre.recevoirDegats(4, monstre.getPointsDeVieCourants()); // Inflige 4 dégâts au monstre
            magieCourante -= 2; // Déduit 2 points de magie
            System.out.println("Le Rayon de givre inflige 4 dégâts.");
        } else {
            System.out.println(nom + " n'a pas assez de magie pour lancer Rayon de givre.");
        }
    }
}
