import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /////////////////////////////////////////////////////////////

        // Choix du nom du joueur
        System.out.println("Bienvenue dans 'Les Nuits de Padhiver' !");
        System.out.print("Veuillez entrer le nom de votre personnage : ");
        String nomJoueur = scanner.nextLine();


        /////////////////////////////////////////////////////////////

        // Choix du métier
        System.out.println("Veuillez choisir un métiers :");
        System.out.println("Barbare");
        System.out.println("Guerrier");
        System.out.println("Magicien");
        String choixMetier = scanner.nextLine();

        /////////////////////////////////////////////////////////////

        // Création du joueur
        Joueur joueur = null;
        Metier metier = null;
        switch (choixMetier) {
            case "Barbare":
                metier = new Barbare();
                joueur = new Joueur(nomJoueur, metier);
                break;
            case "Guerrier":
                metier = new Guerrier();
                joueur = new Joueur(nomJoueur, metier);
                break;
            case "Magicien":
                metier = new Magicien();
                joueur = new Joueur(nomJoueur, metier);
                break;
            default:
                System.out.println("Choix invalide.");
                System.exit(0);
        }
        joueur.setNom(nomJoueur);

        /////////////////////////////////////////////////////////////

        // Creation des Monstres
        Monstre orc1 = new Orc();
        Monstre orc2 = new Orc();
        Monstre gobelin1 = new Gobelin();
        Monstre gobelin2 = new Gobelin();
        Monstre chauveSouris1 = new ChauveSouris();
        Monstre chauveSouris2 = new ChauveSouris();
        Monstre chauveSouris3 = new ChauveSouris();
        Monstre necromant = new Necromant();
        Monstre dragon = new Dragon();

        /////////////////////////////////////////////////////////////

        // Création des PNJ
        PNJ pnj1 = new PNJ("PNJ 1", "Bonjour ! Je suis le PNJ 1. Permettez moi vous raconter l'histoire de Padhiver. Padhiver est un monde fantastique, peuplé de créatures étranges et de monstres en tout genre. Vous êtes un aventurier, et vous avez pour mission de sauver le monde. Pour cela, vous devrez accomplir des quêtes, combattre des monstres, et gagner des niveaux. Vous êtes actuellement niveau 1. Parlez au pnj2 présent dans ce lieu pour avoir des informations complémentaires. Bonne chance !");
        PNJ pnj2 = new PNJ("PNJ 2", "Bonjour ! Je suis le PNJ 2. Vous êtes actuellement à Padhiver. Lorsque vous aurez éliminé tous les monstres d'un lieu, vous aurez la possibilité de vous reposer. En vous reposant, vous regagnerez la totalité de vos points de vie ainsi que vos points de magie (si vous en possédez). D'ici, vous avez accès à la Route Nord et à la Route Sud. Bonne chance !");
        PNJ pnj3 = new PNJ("PNJ 3", "Bonjour ! Je suis le PNJ 3. Vous êtes actuellement sur la Route Nord. Vous pouvez vous rendre à Padhiver ou à la Forêt. En allant dans la Forêt, vous aurez accès au Volcan. Bonne chance !");
        PNJ pnj4 = new PNJ("PNJ 4", "Bonjour ! Je suis le PNJ 4. Vous êtes actuellement sur la Route Sud. Vous pouvez vous rendre à Padhiver ou à la Marais des Morts. En allant dans la Marais des Morts, vous aurez accès au Crypte. Bonne chance !");

        /////////////////////////////////////////////////////////////

        // Création des lieux

        // Padhiver
        Lieu padhiver = new Lieu("Padhiver");
        padhiver.ajouterPersonnage(joueur);
        padhiver.ajouterPNJ(pnj1);
        padhiver.ajouterPNJ(pnj2);

        // Route Nord
        Lieu routeNord = new Lieu("Route Nord");
        routeNord.ajouterPNJ(pnj3);

        // Route Sud
        Lieu routeSud = new Lieu("Route Sud");
        routeSud.ajouterPNJ(pnj4);
        routeSud.ajouterMonstre(orc1);
        routeSud.ajouterMonstre(orc2);


        // Forêt
        Lieu foret = new Lieu("Forêt");
        foret.ajouterMonstre(gobelin1);
        foret.ajouterMonstre(gobelin2);

        // Marais des Morts
        Lieu maraisDesMorts = new Lieu("Marais des Morts");
        maraisDesMorts.ajouterMonstre(chauveSouris1);
        maraisDesMorts.ajouterMonstre(chauveSouris2);
        maraisDesMorts.ajouterMonstre(chauveSouris3);

        // Crypte
        Lieu crypte = new Lieu("Crypte");
        crypte.ajouterMonstre(necromant);

        // Volcan
        Lieu volcan = new Lieu("Volcan");
        volcan.ajouterMonstre(dragon);

        // Accessiblités des lieux
        padhiver.ajouterLieu(routeNord);
        padhiver.ajouterLieu(routeSud);
        routeNord.ajouterLieu(padhiver);
        routeNord.ajouterLieu(foret);
        foret.ajouterLieu(volcan);
        foret.ajouterLieu(routeNord);
        volcan.ajouterLieu(foret);
        routeSud.ajouterLieu(padhiver);
        routeSud.ajouterLieu(maraisDesMorts);
        maraisDesMorts.ajouterLieu(routeSud);
        maraisDesMorts.ajouterLieu(crypte);
        crypte.ajouterLieu(maraisDesMorts);

        /////////////////////////////////////////////////////////////

        // Initialisation du lieu actuel du joueur
        joueur.setLieuActuel(padhiver);
        System.out.println("Vous êtes à " + joueur.getLieuActuel().nom + ".");
        Lieu lieuAv = joueur.getLieuActuel();

        // Le jeu continue jusqu'à ce que le joueur atteigne le niveau 10 ou ses PV atteignent 0
        while (joueur.getNiveau() < 10 && joueur.getPointsDeVieCourants() > 0) {

            // Afficher les actions possibles
            if (joueur.getLieuActuel().nom.equals(lieuAv.nom) == false){
                System.out.println("Vous êtes à " + joueur.getLieuActuel().nom + ".");
            }
            lieuAv = joueur.getLieuActuel();
            System.out.println("Actions possibles :");
            System.out.println("1. Se déplacer");
            //si le lieu a plus de monstre on peut se reposer
            if (joueur.getLieuActuel().nbMonstres == 0) {
                System.out.println("2. Se reposer");
            }
            else {
                System.out.println("2. Attaquer un Monstre");
            }
            if (joueur.getLieuActuel().nbPNJ > 0) {
               System.out.println("3. Parler à un PNJ");
            }

            System.out.print("Entrez le numéro de votre choix : ");

            int choixAction = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            // Exécuter l'action choisie par le joueur
            switch (choixAction) {

                 // Déplacement
                case 1:
                    System.out.println("Lieu(s) accessible(s) :");
                    for (Lieu lieu : Lieu.getLieuxAccessibles(joueur.getLieuActuel())) {
                        System.out.println(lieu);
                    }
                    System.out.print("Entrez le nom du lieu vers lequel vous souhaitez vous déplacer : ");
                    String nomLieu = scanner.nextLine();
                    // Vérifier que le lieu est accessible
                    Lieu lieuDestination = null;
                    for (Lieu lieu : Lieu.getLieuxAccessibles(joueur.getLieuActuel())) {
                        if (lieu.equals(nomLieu)) {
                            lieuDestination = lieu;
                        }
                    }
                    if (lieuDestination != null){
                        joueur.deplacer(lieuDestination);
                    }
                    else {
                        System.out.println("Lieu inaccessible. Veuillez choisir un lieu accessible.");
                    }
                    break;

                // Repos ou Attaque
                case 2:
                    if (joueur.getLieuActuel().nbMonstres == 0){
                        joueur.seReposer();
                    }
                    //attaquer un monstre
                    else {
                        System.out.println("Monstre(s) présent(s) :");
                        for (Monstre monstre : joueur.getLieuActuel().getMonstres()) {
                            System.out.println(monstre);
                        }
                        System.out.print("Entrez le nom du monstre que vous souhaitez attaquer : ");
                        String nomMonstre = scanner.nextLine();
                        // Vérifier que le monstre est présent
                        Monstre monstreCible = null;
                        for (Monstre monstre : joueur.getLieuActuel().getMonstres()) {
                            if (monstre.equals(nomMonstre)) {
                                monstreCible = monstre;
                            }
                        }
                        if (monstreCible != null){
                            joueur.attaquer(monstreCible);
                        }
                        else {
                            System.out.println("Monstre absent. Veuillez choisir un monstre présent.");
                        }
                    }
                    break;
                case 3:
                    // Logique pour parler à un PNJ dans le lieu actuel
                    System.out.println("PNJ(s) présent(s) :");
                    for (PNJ pnj : joueur.getLieuActuel().getPNJ()) {
                        System.out.println(pnj);
                    }
                    System.out.print("Entrez le nom du PNJ que vous souhaitez interroger : ");
                    String nomPNJ = scanner.nextLine();
                    // Vérifier que le PNJ est présent
                    PNJ pnjCible = null;
                    for (PNJ pnj : joueur.getLieuActuel().getPNJ()) {
                        if (pnj.equals(nomPNJ)) {
                            pnjCible = pnj;
                        }
                    }
                    if (pnjCible != null){
                        System.out.println(pnjCible.getReponse());
                    }
                    else {
                        System.out.println("PNJ absent. Veuillez choisir un PNJ présent.");
                    }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une action valide.");
            }
        }

        /////////////////////////////////////////////////////////////

        // Le jeu est terminé (soit le joueur a gagné, soit il a perdu)
        if (joueur.getNiveau() >= 10) {
            System.out.println("Félicitations, vous avez atteint le niveau 10. Vous avez gagné :)");
        } else {
            System.out.println("Dommage, vos points de vie ont atteint 0. Vous avez perdu :(");
        }

    }
}