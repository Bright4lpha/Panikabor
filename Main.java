import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;
import MG2D.audio.Bruitage;
import MG2D.audio.Musique;
import MG2D.audio.MusiqueATester;

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
        ChoixJ choix = new ChoixJ(f);
        ChoixP choix_p = new ChoixP(f);
        Menu menu = new Menu(f);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;
        int last_indice = 0;
        int actual_indice = 0;
        Joueur j1;
        Joueur j2;
        Joueur j3;
        Joueur j4;


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
                // si on est dans le choix des joueurs 
                if (num_fenetre == 4) {
                    int r = choix.deplacements_souris(f, pos);
                    // Si il y a un joueur
                    if (r == 11) {
                        choix_p.afficher(f);
                        int r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j1 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j1 = new Gamin();
                        }
                        if (r_p == 3) {
                            j1 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j1 = new Mecano();
                        }
                    }
                    // si il y a 2 joueurs
                    if (r == 12) {
                        choix_p.afficher(f);
                        int r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j1 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j1 = new Gamin();
                        }
                        if (r_p == 3) {
                            j1 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j1 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j2 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j2 = new Gamin();
                        }
                        if (r_p == 3) {
                            j2 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j2 = new Mecano();
                        }
                    }
                    // si il y a 3 joueurs
                    if (r == 13) {
                        choix_p.afficher(f);
                        int r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j1 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j1 = new Gamin();
                        }
                        if (r_p == 3) {
                            j1 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j1 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j2 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j2 = new Gamin();
                        }
                        if (r_p == 3) {
                            j2 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j2 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j3 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j3 = new Gamin();
                        }
                        if (r_p == 3) {
                            j3 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j3 = new Mecano();
                        }
                    }
                    // si il y a 4 joueurs
                    if (r == 14) {
                        choix_p.afficher(f);
                        int r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j1 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j1 = new Gamin();
                        }
                        if (r_p == 3) {
                            j1 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j1 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j2 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j2 = new Gamin();
                        }
                        if (r_p == 3) {
                            j2 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j2 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j3 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j3 = new Gamin();
                        }
                        if (r_p == 3) {
                            j3 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j3 = new Mecano();
                        }
                        choix_p.afficher(f);
                        r_p = choix_p.deplacements_souris(f, pos);
                        if (r_p == 1) {
                            j4 = new Capitaine();
                        }
                        if (r_p == 2) {
                            j4 = new Gamin();
                        }
                        if (r_p == 3) {
                            j4 = new Bibledum();
                        }
                        if (r_p == 4) {
                            j4 = new Mecano();
                        }
                    }
                    num_fenetre = 1;
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
                // si on est dans le choix de joueur alors on l'affiche
                if (num_fenetre == 4) {
                    choix.afficher(f);
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
