package sort;

public abstract class Sort {

    private final String nom;
    private final int coutMagie;
    private final int degats;

    protected Sort(String nom, int coutMagie, int degats) {
        this.nom = nom;
        this.coutMagie = coutMagie;
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public int getCoutMagie() {
        return coutMagie;
    }

    public int getDegats() {
        return degats;
    }
}
