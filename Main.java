import java.util.ArrayList;

import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;
// import java.util.ArrayList;
import MG2D.geometrie.Texture;

//import MG2D.*;
//import MG2D.geometrie.*;

public class Main {

     public static void main(String[] args) {

        // Initialisation des variables
        ArrayList<Piece> nb_joueur = new ArrayList<Piece>();
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 1000, 700);
        Credits credits = new Credits(f);
        Victoire victoire = new Victoire(f); //5
        Defaite defaite = new Defaite(f); //6
        Regles regles = new Regles(f); // 7
        MainGraphique graphique = new MainGraphique(f, plato);
        ChoixJ choix = new ChoixJ(f);
        Menu menu = new Menu(f);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        int dep_piece = 0;
        int last_indice = 0;
        int actual_indice = 0;
        String tour = "J";
        int cmpt_tour = 0;

        int num_fenetre = 0;
        while(true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {}

            // menu et changement de fenetre
            if (souris.getClicGauche()) {
                
                // stockage de la position de la souris
                pos = new Point(souris.getPosition());
                
                actual_pos_souris.setX(pos.getX());
                actual_pos_souris.setY(pos.getY());

                // System.out.println(pos);
                // MODIFICATION DE LA FENETRE SUR LES BOUTONS
                // si on est dans le menu alors on peu aller dans les crédits, le jeu ou quitter
                if (num_fenetre == 0) {
                    num_fenetre = menu.deplacements_souris(f, pos);
                    System.out.println(num_fenetre);
                }
                // si on est dans le jeu alors les deplacements sont ceux du jeu
                if (num_fenetre == 1) {
                    num_fenetre = graphique.deplacements_souris(f, pos);
                }
                // si on est dans les crédits alors on peut revenir au menu
                if (num_fenetre == 2) {
                    num_fenetre = credits.deplacements_souris(f, pos);
                }
                // si on est dans le choix des joueurs // à continuer ne fonctionne pas
                if (num_fenetre == 4) {
                    ArrayList<Integer> rep = choix.deplacements_souris(f, pos);
                    int nb = rep.get(0);
                    if (nb == 1) {
                        Capitaine capitaine = new Capitaine();
                        nb_joueur.add(capitaine);
                    }
                    if (nb == 2) {
                        Capitaine capitaine = new Capitaine("D4", 0);
                        Bibledum bibledum = new Bibledum("D4", 1);
                        nb_joueur.add(capitaine);
                        nb_joueur.add(bibledum);
                    }
                    if (nb == 3) {
                        Capitaine capitaine = new Capitaine("D4", 0);
                        Bibledum bibledum = new Bibledum("D4", 1);
                        Mecano mecano = new Mecano("D4", 2);
                        nb_joueur.add(capitaine);
                        nb_joueur.add(bibledum);
                        nb_joueur.add(mecano);
                    }
                    if (nb == 4) {
                        Capitaine capitaine = new Capitaine("D4", 0);
                        Bibledum bibledum = new Bibledum("D4", 1);
                        Mecano mecano = new Mecano("D4", 2);
                        Gamin gamin = new Gamin("D4", 3);
                        nb_joueur.add(capitaine);
                        nb_joueur.add(bibledum);
                        nb_joueur.add(mecano);
                        nb_joueur.add(gamin);
                    }
                    num_fenetre = rep.get(1);
                }
                // si on est dans la victoire on peut quitter
                if (num_fenetre == 5) {
                    num_fenetre = victoire.deplacements_souris(f, pos);
                }
                // si on est dans la defaite on peut quitter
                if (num_fenetre == 6) {
                    num_fenetre = defaite.deplacements_souris(f, pos);
                }
                // si on est dans les regles on retourne au menu
                if (num_fenetre == 7) {
                    num_fenetre = regles.deplacements_souris(f, pos);
                }
                
                // System.out.println("indice " + num_fenetre);

                // si on est dans le menu alors on l'affiche
                if (num_fenetre == 0) {
                    menu.afficher(f);
                }
                // si on est dans le jeu alors on l'affiche
                if (num_fenetre == 1) {
                    graphique.afficher(f, plato);
                }
                // si on est dans les crédits alors on l'affiche
                if (num_fenetre == 2) {
                    credits.afficher(f);
                }
                // si on a cliquer sur fermer la fenetre
                if (num_fenetre == 3) {
                    f.fermer();
                }
                // si on est dans le choix de joueur alors on l'affiche
                if (num_fenetre == 4) {
                    choix.afficher(f);
                }
                // si on est dans la victoire alors on l'affiche
                if (num_fenetre == 5) {
                    victoire.afficher(f);
                }
                // si on est dans la defaite alors on l'affiche
                if (num_fenetre == 6) {
                    defaite.afficher(f);
                }
                // si on est dans les regles alors on l'affiche
                if (num_fenetre == 7) {
                    regles.afficher(f);
                }
            }

            // jeu principal
            if (num_fenetre == 1) {
                // plato.nv_plateau(nb_joueur);
                plato.ajouter_joueur(nb_joueur);
                graphique = new MainGraphique(f, plato);
                
                while(num_fenetre == 1) {
                    try {
                        Thread.sleep(30);
                    } catch (Exception e) {}

                    // Si c'est le tour des ennemis
                    if (tour.equals("E")) {
                        System.out.println("tour des ennemis");
                        ArrayList<Piece> p = plato.getPiecesEnnemi();
                        for (int i = 0; i < p.size(); i++) {
                            Fenetre depEnnemi = new Fenetre("Deplacement", 500, 500);
                            depEnnemi.ajouter(new Texture("./images/case3.png", new Point(0, 0), 500, 500));
                            depEnnemi.ajouter(new Texture("./images/"+p.get(i).getNomLong()+".png", new Point(0, 0)));
                            depEnnemi.rafraichir();
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {}
                            depEnnemi.fermer();
                            graphique.deplacementEnnemi(plato, p.get(i), f);
                            graphique = new MainGraphique(f, plato);
                            f.rafraichir();
                        }
                        tour = "J";
                        cmpt_tour = 0;
                        num_fenetre = 1;
                        f.rafraichir();
                    }
                    else {
                        Piece actual_joueur = nb_joueur.get(cmpt_tour);
                        graphique.afficher_tour(f, actual_joueur);
                        f.rafraichir();
                        // si il y a un clic
                        if (souris.getClicGauche()) {
                            System.out.println(actual_joueur);
                            System.out.println(nb_joueur);
                            // stockage de la position de la souris
                            pos = new Point(souris.getPosition());
                            num_fenetre = graphique.deplacements_souris(f, pos);
                            // System.out.println("num fenetre " + num_fenetre);
                            actual_pos_souris.setX(pos.getX()/100);
                            actual_pos_souris.setY(pos.getY()/100);

                            // position actuelle de la souris
                            int a = pos.getX();
                            int b = pos.getY();

                            // position ancienne de la souris
                            // int c = pos.getX();
                            // int d = pos.getY(); 

                            actual_indice = plato.trouve_indice(a, b);
                            
                            
                            // test les actions à effectuer en fonction de la position de la souris
                            // System.out.println("last_pos_souris : " + last_pos_souris);
                            // System.out.println("actual_pos_souris : "+ actual_pos_souris);
                            // System.out.println("indice : "+ last_indice);
                            
                            dep_piece = graphique.deplacements_souris(f, last_pos_souris, actual_pos_souris, plato, last_indice, actual_indice, tour, actual_joueur);
                            
                            
                            System.out.println(plato); 

                            // System.out.println(dep_piece);
                            if ((dep_piece == 1) || (dep_piece == 2)) {
                                actual_pos_souris = new Position(-1, -1);
                                actual_indice = plato.trouve_indice(a, b);
                                last_pos_souris.setX(-1);
                                last_pos_souris.setY(-1);
                                last_indice = 0;
                                graphique = new MainGraphique(f, plato);
                                if (dep_piece == 2) {
                                    nb_joueur.remove(actual_joueur);
                                }
                                if (cmpt_tour < nb_joueur.size()-1) {
                                    tour = "J";
                                    cmpt_tour += 1;
                                }
                                else {
                                    tour = "E";
                                    cmpt_tour = 0;
                                }
                            }
                            else {
                                last_pos_souris.setX(actual_pos_souris.getX());
                                last_pos_souris.setY(actual_pos_souris.getY());
                                last_indice = actual_indice;
                            }
                        }
                    }
                    f.rafraichir();

                    // Conditions de victoire :
                    // 3 tâches réalisées
                    // 1 joueur sur la case 63 (G4)

                    if ((plato.getCase(6,3).size() == 1)&&(plato.allActive()==true)) {
                        if ((plato.getCase(6,3).get(0).getType() == 'J')) {
                            num_fenetre = 5;
                        }
                    }
                    if ((plato.getPiecesJoueur().size() == 0)) {
                        num_fenetre = 6;
                    }
                }
                f.rafraichir();
            }
        }
    }
}