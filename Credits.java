// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class Credits {

    public Credits(Fenetre f) {
        f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 400, 100, true));
        f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point(400, 100), 200, 100, true));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 400, 100, true));
        f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point(450, 100), 100, 100, true));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Retour vers menu
        // if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            return 0;
        }
        // Reste sur les crédits
        else {
            return 2;
        }
    }
    }
//}