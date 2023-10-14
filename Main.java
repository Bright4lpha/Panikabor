import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;

import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

public class Main {

    public static void main(String[] args) {
        Main main;
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 1000, 700);
        MainGraphique graphique = new MainGraphique(f, plato);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;
        int last_indice = 0;
        int actual_indice = 0;

        // System.out.println("Déplacements");
        // Piece ma_piece = plato.getCase(34).get(1);
        // System.out.println(ma_piece.getDeplacementPossible(plato));


        while(true) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {}

            // si il y a un clic
            if (souris.getClicGauche()) {
                // stockage de la position de la souris
                pos = new Point(souris.getPosition());
                
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
