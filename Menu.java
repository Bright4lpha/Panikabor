// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class Menu {

    public Menu(Fenetre f) {
        f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 100), 150, 100, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(550, 100), 150, 100, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 300), 400, 100, true));
        f.ajouter(new Rectangle(Couleur.MAGENTA, new Point(300, 500), 400, 100, true));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 100), 150, 100, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(550, 100), 150, 100, true));
        f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 300), 400, 100, true));
        f.ajouter(new Rectangle(Couleur.MAGENTA, new Point(300, 500), 400, 100, true));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Crédits
        if ((to.getX()>=300) && (to.getX()<=450) && (to.getY()>=100) && (to.getY()<=200)) {
            return 2;
        }
        else if ((to.getX()>=550) && (to.getX()<=700) && (to.getY()>=100) && (to.getY()<=200)) {
            return 3;
        }
        else if ((to.getX()>=300) && (to.getX()<=700) && (to.getY()>=300) && (to.getY()<=400)) {
            return 1;
        }
        else {
            return 0;
        }
    }
    }
//}