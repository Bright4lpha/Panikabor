import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;
import MG2D.audio.Musique;

// import java.util.ArrayList;

//import MG2D.*;
//import MG2D.geometrie.*;

public class Main {

    public static void main(String[] args) {

        // Menu d'accueil



        // Main main;
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 1000, 700);
        Credits credits = new Credits(f);
        MainGraphique graphique = new MainGraphique(f, plato);
        Menu menu = new Menu(f);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;
        int last_indice = 0;
        int actual_indice = 0;
        Musique son = new Musique("D:\\Music\\this_is_what_space_feels_like.mp3");
        son.lecture();

        // System.out.println("Déplacements");
        // Piece ma_piece = plato.getCase(34).get(1);
        // System.out.println(ma_piece.getDeplacementPossible(plato));
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

                System.out.println(pos);
                // si on est dans le jeu alors les deplacements sont ceux du jeu
                if (num_fenetre == 1) {
                    num_fenetre = graphique.deplacements_souris(f, pos);
                }
                // si on est dans les crédits alors on peut revenir au menu
                if (num_fenetre == 2) {
                    num_fenetre = credits.deplacements_souris(f, pos);
                }
                // si on est dans le menu alors on peu aller dans les crédits, le jeu ou quitter
                if (num_fenetre == 0) {
                    num_fenetre = menu.deplacements_souris(f, pos);
                }
                System.out.println("indice " + num_fenetre);

                // si on est dans le jeu alors on l'affiche
                if (num_fenetre == 1) {
                    graphique.afficher(f, plato);
                }
                // si on est dans les crédits alors on l'affiche
                if (num_fenetre == 2) {
                    credits.afficher(f);
                }
                // si on est dans le menu alors on l'affiche
                if (num_fenetre == 0) {
                    menu.afficher(f);
                }
                if (num_fenetre == 3) {
                    f.fermer();
                }
            }

            if (num_fenetre == 1) {
                while(num_fenetre == 1) {
                    try {
                        Thread.sleep(40);
                    } catch (Exception e) {}

                    // si il y a un clic
                    if (souris.getClicGauche()) {
                        // stockage de la position de la souris
                        pos = new Point(souris.getPosition());
                        if (num_fenetre == 1) {
                            num_fenetre = graphique.deplacements_souris(f, pos);
                        }
                        System.out.println("num fenetre " + num_fenetre);
                        actual_pos_souris.setX(pos.getX()/100);
                        actual_pos_souris.setY(pos.getY()/100);

                        // position actuelle de la souris
                        int a = pos.getX();
                        int b = pos.getY();

                        // position ancienne de la souris
                        int c = pos.getX();
                        int d = pos.getY(); 

                        actual_indice = plato.trouve_indice(a, b);
                        
                        
                        // test les actions à effectuer en fonction de la position de la souris
                        System.out.print("last_pos_souris : ");
                        System.out.println(last_pos_souris);
                        System.out.print("actual_pos_souris : ");
                        System.out.println(actual_pos_souris);
                        System.out.print("indice : ");
                        System.out.println(last_indice);
                        
                        dep_piece = graphique.deplacements_souris(f, last_pos_souris, actual_pos_souris, plato, last_indice, actual_indice);
                        
                        
                        System.out.println(plato); 

                        System.out.println(dep_piece);
                        if (dep_piece == true) {
                            actual_pos_souris = new Position(-1, -1);
                            actual_indice = plato.trouve_indice(a, b);
                            last_pos_souris.setX(-1);
                            last_pos_souris.setY(-1);
                            last_indice = 0;
                            graphique = new MainGraphique(f, plato);
                        }
                        else {
                            last_pos_souris.setX(actual_pos_souris.getX());
                            last_pos_souris.setY(actual_pos_souris.getY());
                            last_indice = actual_indice;
                        }
                        // System.out.println(actual_pos_souris);
                        // System.out.println(last_pos_souris);
                    }
                    f.rafraichir();
                }
            }
        }

    
    }
}
