// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class ChoixJ {

    public ChoixJ(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Rectangle(Couleur.VERT, new Point(300, 500), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.BLEU, new Point(600, 500), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.ROSE, new Point(600, 300), 100, 100, true));

        f.ajouter(new Texture("./images/retour.png", new Point(350, 100)));

        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Rectangle(Couleur.VERT, new Point(300, 500), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.BLEU, new Point(600, 500), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 100, 100, true));
        f.ajouter(new Rectangle(Couleur.ROSE, new Point(600, 300), 100, 100, true));

        f.ajouter(new Texture("./images/retour.png", new Point(350, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Retour vers menu
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            return 0;
        }
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=500) && (to.getY()<=600)) {
            return 11;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=500) && (to.getY()<=600)) {
            return 12;
        }
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=300) && (to.getY()<=400)) {
            return 13;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=300) && (to.getY()<=400)) {
            return 14;
        }
        // Reste sur les choix
        else {
            return 4;
        }
    }
    }
//}