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

    public void decrementerMagie(int magieRequise) {
        this.magieCourante -= magieRequise;
    }

    // Ajoutez des méthodes spécifiques au Magicien pour gérer la magie
}
