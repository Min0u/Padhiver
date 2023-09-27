public class Magicien extends Metier {

    // Attributs

    private int magieMax;
    private int magieCourante;
    private int magieTotal;

    // Constructeur

    public Magicien() {
        super("Magicien", "Dague", 2, 7, 4);
        this.magieMax = 4; // Magie max spécifique au Magicien
        this.magieCourante = 4; // Magie courante spécifique au Magicien
        this.magieTotal = 4;
    }

    // Getters

    public int getMagieCourante() {
        return magieCourante;
    }

    public int getMagieMaxParNiveau() {
        return magieMax;
    }
    // Méthodes

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

    public void regenererMagie() {
        magieCourante = magieTotal;
    }

    public void gagnerMagie(int niveau) {
        magieTotal = magieMax * niveau;
    }
}
