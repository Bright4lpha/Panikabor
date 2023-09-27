import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;
import MG2D.*;
import MG2D.geometrie.*;

public class Main {

    public static void main(String[] args) {
        Plateau plato = new Plateau();        
        Fenetre f = new Fenetre("Mon jeu", 1000, 700);
        MainGraphique graphique = new MainGraphique(f, plato);
        Souris souris = f.getSouris();
        Position last_pos_souris = new Position(-1, -1);
        Position actual_pos_souris = new Position(-1, -1);
        Point pos;
        boolean dep_piece = false;
        int indice = 0;

        while(true) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {}
            
            // si il y a un clic
            if (souris.getClicGauche()) {
                // stockage de la position de la souris
                pos = new Point(souris.getPosition());
                // position actuelle de la souris
                int a = actual_pos_souris.getX();
                int b = actual_pos_souris.getY();
                // connaitre l'indice de la pièce sur la case
                if (((a%100)>=50)&&((b%100)>=50)) {
                    indice = 3;
                }
                if (((a%100)>=50)&&((b%100)<50)) {
                    indice = 1;
                }
                if (((a%100)<50)&&((b%100)>=50)) {
                    indice = 2;
                }
                if (((a%100)<50)&&((b%100)<50)) {
                    indice = 0;
                }

                actual_pos_souris.setX(pos.getX()/100);
                actual_pos_souris.setY(pos.getY()/100);

                // test les actions à effectuer en fonction de la position de la souris
                System.out.print("last_pos_souris : ");
                System.out.println(last_pos_souris);
                System.out.print("actual_pos_souris : ");
                System.out.println(actual_pos_souris);
                System.out.print("indice : ");
                System.out.println(indice);

                dep_piece = graphique.deplacements_souris(f, last_pos_souris, actual_pos_souris, plato, indice);
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
