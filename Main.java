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
        int nb_joueur = 4;
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 1000, 700);
        Credits credits = new Credits(f);
        Victoire victoire = new Victoire(f); //5
        Defaite defaite = new Defaite(f); //6
        MainGraphique graphique = new MainGraphique(f, plato);
        ChoixJ choix = new ChoixJ(f);
        Menu menu = new Menu(f);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;
        int last_indice = 0;
        int actual_indice = 0;
        String tour = "E";
        int cmpt_tour = 0;

        int num_fenetre = 0;
        while(true) {
            try {
                Thread.sleep(40);
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
                    ArrayList<Integer> rep = choix.deplacements_souris(f, pos, nb_joueur);
                    nb_joueur = rep.get(0);
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
            }

            // jeu principal
            if (num_fenetre == 1) {
                plato.nv_plateau(nb_joueur);
                graphique = new MainGraphique(f, plato);
                
                while(num_fenetre == 1) {
                    try {
                        Thread.sleep(40);
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
                        cmpt_tour += 1;
                        num_fenetre = 1;
                        f.rafraichir();
                    }
                    else {
                        f.rafraichir();
                        // si il y a un clic
                        if (souris.getClicGauche()) {
                            System.out.println(nb_joueur);
                            // stockage de la position de la souris
                            pos = new Point(souris.getPosition());
                            if (num_fenetre == 1) {
                                num_fenetre = graphique.deplacements_souris(f, pos);
                            }
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
                            
                            dep_piece = graphique.deplacements_souris(f, last_pos_souris, actual_pos_souris, plato, last_indice, actual_indice, tour);
                            
                            
                            System.out.println(plato); 

                            // System.out.println(dep_piece);
                            if (dep_piece == true) {
                                actual_pos_souris = new Position(-1, -1);
                                actual_indice = plato.trouve_indice(a, b);
                                last_pos_souris.setX(-1);
                                last_pos_souris.setY(-1);
                                last_indice = 0;
                                graphique = new MainGraphique(f, plato);

                                // changement de joueur
                                if (tour.equals("E")) {
                                    tour = "J";
                                    cmpt_tour += 1; 
                                }
                                else {
                                    if (cmpt_tour < nb_joueur) {
                                        tour = "J";
                                        cmpt_tour += 1;
                                    }
                                    else {
                                        tour = "E";
                                        cmpt_tour = 0;
                                    }
                                }
                            }
                            else {
                                last_pos_souris.setX(actual_pos_souris.getX());
                                last_pos_souris.setY(actual_pos_souris.getY());
                                last_indice = actual_indice;
                            }
                            // System.out.println(actual_pos_souris);
                            // System.out.println(last_pos_souris);
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