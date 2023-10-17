import base.Lieu;
import base.PNJ;
import metier.Metier;
import base.Joueur;
import monstre.Monstre;

import metier.Barbare;
import metier.Guerrier;
import metier.Magicien;

import monstre.ChauveSouris;
import monstre.Dragon;
import monstre.Gobelin;
import monstre.Necromant;
import monstre.Orc;

import java.util.List;
import java.util.Scanner;
//VIENS JOUEUR chut

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /////////////////////////////////////////////////////////////

        // Choix du nom du joueur
        System.out.println("Bienvenue dans 'Les Nuits de Padhiver' !");
        System.out.print("\nVeuillez entrer le nom de votre personnage : ");
        String nomJoueur = scanner.nextLine();


        /////////////////////////////////////////////////////////////

        // Choix du métier
        System.out.println("\nMétier disponible :");
        System.out.println("1. Barbare");
        System.out.println("2. Guerrier");
        System.out.println("3. Magicien");

        int choixMetierInt;

        // Vérification que l'entrée est un nombre
        while (true) {
            System.out.print("Entrez le numéro correspondant à votre choix : ");
            if (scanner.hasNextInt()) {
                choixMetierInt = scanner.nextInt();
                if (choixMetierInt >= 1 && choixMetierInt <= 3) {
                    break;
                } else {
                    System.out.print("Choix invalide. Veuillez choisir un métier valide :");
                }
            } else {
                System.out.print("Veuillez entrer un numéro valide:");
                scanner.next(); // Consommer l'entrée incorrecte de l'utilisateur
            }
        }

        Joueur joueur = null;
        Metier metier;

        switch (choixMetierInt) {
            case 1:
                metier = new Barbare();
                joueur = new Joueur(nomJoueur, metier);
                break;
            case 2:
                metier = new Guerrier();
                joueur = new Joueur(nomJoueur, metier);
                break;
            case 3:
                metier = new Magicien();
                joueur = new Joueur(nomJoueur, metier);
                break;
            default:
                System.out.print("Choix invalide. Veuillez choisir un métier valide : ");
                scanner.next();
        }
        if (joueur != null) {
            joueur.setNom(nomJoueur);

            //print tout les info du joueur
            System.out.println("\nNom : " + joueur.getNom());
            System.out.println("Metier : " + joueur.getMetier());
            System.out.println("Niveau : " + joueur.getNiveau());
            System.out.println("Points de vie : " + joueur.getPointsDeVieCourants() + "/" + joueur.getPointsDeVieTotal());
            System.out.println("Points de magie : " + joueur.getPointsDeMagieCourants() + "/" + joueur.getPointsDeMagieTotal());
            System.out.println("Arme : " + joueur.getArme());
            System.out.println("Degats : " + joueur.getDegats());

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

            // Création des base.PNJ
            PNJ pnj1 = new PNJ("PNJ 1", "Bonjour " + joueur.getNom() + " ! Je suis le PNJ 1. \nPermettez moi de vous raconter l'histoire de Padhiver. \nPadhiver est un monde fantastique, peuplé de créatures étranges et de monstres en tout genre. \nVous êtes un aventurier, et vous avez pour mission de sauver le monde. \nPour cela, vous devrez accomplir des quêtes, combattre des monstres, et gagner des niveaux. \nVous êtes actuellement niveau 1. \nBonne chance !");
            PNJ pnj2 = new PNJ("PNJ 2", "Bonjour " + joueur.getNom() + " ! Je suis le PNJ 2. \nVous êtes actuellement à Padhiver, la ville principale. \nLorsque vous aurez éliminé tous les monstres d'un lieu, vous aurez la possibilité de vous reposer. \nEn vous reposant, vous regagnerez la totalité de vos points de vie ainsi que vos points de magie (si vous en possédez). \nD'ici, vous avez accès à la Route Nord et à la Route Sud. \nBonne chance !");
            PNJ pnj3 = new PNJ("PNJ 3", "Bonjour " + joueur.getNom() + " ! Je suis le PNJ 3. \nVous êtes actuellement sur la Route Nord. \nVous pouvez vous rendre à Padhiver ou à la Forêt. \nEn allant dans la Forêt, vous aurez accès au Volcan. \nBonne chance !");
            PNJ pnj4 = new PNJ("PNJ 4", "Bonjour " + joueur.getNom() + " ! Je suis le PNJ 4. \nVous êtes actuellement sur la Route Sud. \nVous pouvez vous rendre à Padhiver ou à la Marais des Morts. \nEn allant dans la Marais des Morts, vous aurez accès au Crypte. \nBonne chance !");

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
            System.out.println("\nVous êtes à " + joueur.getLieuActuel().getNom() + ".");
            System.out.println("N'hésitez pas à parler aux PNJ pour avoir des informations sur le jeu.");
            Lieu lieuAv = joueur.getLieuActuel();

            // Le jeu continue jusqu'à ce que le joueur atteigne le niveau 10 ou ses PV atteignent 0
            while (joueur.getNiveau() < 10 && joueur.getPointsDeVieCourants() > 0) {


                if (!joueur.getLieuActuel().getNom().equals(lieuAv.getNom())){
                    System.out.println("\nVous êtes à " + joueur.getLieuActuel().getNom() + ".");
                }
                // Afficher informations du joueur
                System.out.println("\nVie : " + joueur.getPointsDeVieCourants() + "/" + joueur.getPointsDeVieTotal());
                if (joueur.getMetier().equals("Magicien")) {
                    System.out.println("Magie : " + joueur.getPointsDeMagieCourants() + "/" + joueur.getPointsDeMagieTotal());
                }

                // Afficher les actions possibles
                lieuAv = joueur.getLieuActuel();
                System.out.println("\nActions possibles :");
                System.out.println("1. Se déplacer");
                //si le lieu a plus de monstre on peut se reposer
                if (joueur.getLieuActuel().getNbMonstres() == 0) {
                    System.out.println("2. Se reposer");
                }
                else {
                    System.out.println("2. Attaquer un Monstre");
                }
                if (joueur.getLieuActuel().getNbPNJ() > 0) {
                    System.out.println("3. Parler à un PNJ");
                }

                System.out.print("Entrez le numéro de votre choix : ");

                //verifie si cest un nombre
                if (!scanner.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide.");
                    scanner.next();
                }
                int choixAction = scanner.nextInt();
                scanner.nextLine();

                // Exécuter l'action choisie par le joueur
                switch (choixAction) {

                    // Déplacement
                    case 1:
                        List<Lieu> lieuxAccessibles = List.of(Lieu.getLieuxAccessibles(joueur.getLieuActuel()));
                        System.out.println("\nLieu(s) accessible(s) :");
                        for (int i = 0; i < lieuxAccessibles.size(); i++) {
                            Lieu lieu = lieuxAccessibles.get(i);
                            System.out.println((i + 1) + ". " + lieu.getNom()); // Affichez le numéro du lieu et son nom
                        }
                        System.out.print("Entrez le numéro du lieu vers lequel vous souhaitez vous déplacer : ");

                        // Vérifiez que l'entrée de l'utilisateur est un nombre
                        if (scanner.hasNextInt()) {
                            int choixLieu = scanner.nextInt();
                            scanner.nextLine(); // Consommez la nouvelle ligne

                            // Vérifiez que le choix est dans la plage des lieux accessibles
                            if (choixLieu >= 1 && choixLieu <= lieuxAccessibles.size()) {
                                Lieu lieuDestination = lieuxAccessibles.get(choixLieu - 1);
                                joueur.deplacer(lieuDestination);
                            } else {
                                System.out.println("Choix invalide. Veuillez choisir un lieu accessible.");
                            }
                        } else {
                            System.out.println("Veuillez entrer un numéro de lieu valide.");
                            scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
                        }
                        break;

                    // Repos ou Attaque
                    case 2:
                        if (joueur.getLieuActuel().getNbMonstres() == 0) {
                            joueur.seReposer();
                        } else {
                            System.out.println("\nMonstre(s) présent(s) :");
                            List<Monstre> monstres = List.of(joueur.getLieuActuel().getMonstres());
                            for (int i = 0; i < monstres.size(); i++) {
                                Monstre monstre = monstres.get(i);
                                System.out.println((i + 1) + ". " + monstre.getNom());
                            }
                            System.out.print("Entrez le numéro du monstre que vous souhaitez attaquer : ");

                            if (scanner.hasNextInt()) {
                                int choixMonstre = scanner.nextInt();
                                scanner.nextLine(); // Consommez la nouvelle ligne

                                if (choixMonstre >= 1 && choixMonstre <= monstres.size()) {
                                    Monstre monstreCible = monstres.get(choixMonstre - 1);
                                    joueur.attaquer(monstreCible);
                                } else {
                                    System.out.println("Choix invalide. Veuillez choisir un monstre présent.");
                                }
                            } else {
                                System.out.println("Veuillez entrer un numéro de monstre valide.");
                                scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
                            }
                        }
                        break;
                    // Parler à un base.PNJ
                    case 3:
                        System.out.println("\nPNJ(s) présent(s) :");
                        List<PNJ> pnjs = joueur.getLieuActuel().getPNJ();
                        for (int i = 0; i < pnjs.size(); i++) {
                            PNJ pnj = pnjs.get(i);
                            System.out.println((i + 1) + ". " + pnj.getNom());
                        }
                        System.out.print("Entrez le numéro du base.PNJ que vous souhaitez interroger : ");

                        if (scanner.hasNextInt()) {
                            int choixPNJ = scanner.nextInt();
                            scanner.nextLine(); // Consommez la nouvelle ligne

                            if (choixPNJ >= 1 && choixPNJ <= pnjs.size()) {
                                PNJ pnjCible = pnjs.get(choixPNJ - 1);
                                System.out.println("\n" + pnjCible.getReponse());
                            } else {
                                System.out.println("Choix invalide. Veuillez choisir un base.PNJ présent.");
                            }
                        } else {
                            System.out.println("Veuillez entrer un numéro de base.PNJ valide.");
                            scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
                        }
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une action valide.");
                }
            }

            /////////////////////////////////////////////////////////////

            // Le jeu est terminé (soit le joueur a gagné, soit il a perdu)
            if (joueur.getNiveau() >= 10) {
                System.out.println("\nFélicitations, vous avez atteint le niveau 10. Vous avez gagné :)");
            } else {
                System.out.println("\nDommage, vos points de vie ont atteint 0. Vous avez perdu :(");
            }

        }
    }
}