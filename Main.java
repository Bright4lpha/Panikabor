import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;
import MG2D.*;
import MG2D.geometrie.*;

public class Main {

    public static void main(String[] args) {
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 800, 700);
        MainGraphique graphique = new MainGraphique(f, plato);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;

        while(true) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {}
            
            // si il y a un clic
            if (souris.getClicGauche()) {
                // stockage de la position de la souris
                pos = new Point(souris.getPosition());
                // position actuelle de la souris
                actual_pos_souris.setX(pos.getX()/100);
                actual_pos_souris.setY(pos.getY()/100);

                // test les actions à effectuer en fonction de la position de la souris
                dep_piece = graphique.deplacements_souris(f, last_pos_souris, actual_pos_souris, plato);
                System.out.println(plato);

                if (dep_piece == true) {
                    actual_pos_souris = new Position(-1, -1);
                    last_pos_souris.setX(-1);
                    last_pos_souris.setY(-1);
                    graphique = new MainGraphique(f, plato);
                }
                else {
                    last_pos_souris.setX(actual_pos_souris.getX());
                    last_pos_souris.setY(actual_pos_souris.getY());
                }
            }
            f.rafraichir();
        }
    }
}
