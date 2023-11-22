import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class ChoixJ {

    public ChoixJ(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        // f.ajouter(new Rectangle(Couleur.VERT, new Point(300, 500), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.BLEU, new Point(600, 500), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.ROSE, new Point(600, 300), 100, 100, true));

        f.ajouter(new Texture("./images/j1.png", new Point(300, 500), 100, 100));
        f.ajouter(new Texture("./images/j2.png", new Point(600, 500), 100, 100));
        f.ajouter(new Texture("./images/j3.png", new Point(300, 300), 100, 100));
        f.ajouter(new Texture("./images/j4.png", new Point(600, 300), 100, 100));

        f.ajouter(new Texture("./images/retour.png", new Point(350, 100)));

        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        // f.ajouter(new Rectangle(Couleur.VERT, new Point(300, 500), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.BLEU, new Point(600, 500), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 100, 100, true));
        // f.ajouter(new Rectangle(Couleur.ROSE, new Point(600, 300), 100, 100, true));

        f.ajouter(new Texture("./images/j1.png", new Point(300, 500), 100, 100));
        f.ajouter(new Texture("./images/j2.png", new Point(600, 500), 100, 100));
        f.ajouter(new Texture("./images/j3.png", new Point(300, 300), 100, 100));
        f.ajouter(new Texture("./images/j4.png", new Point(600, 300), 100, 100));

        f.ajouter(new Texture("./images/retour.png", new Point(350, 0)));
        f.rafraichir();
    }

    public ArrayList<Integer> deplacements_souris(Fenetre f, Point to) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Retour vers menu
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            result.add(0);
            result.add(0);
            return result;
        }
        // Nombre de joueur
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=500) && (to.getY()<=600)) {
            result.add(1);
            result.add(1);
            return result;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=500) && (to.getY()<=600)) {
            result.add(2);
            result.add(1);
            return result;
        }
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=300) && (to.getY()<=400)) {
            result.add(3);
            result.add(1);
            return result;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=300) && (to.getY()<=400)) {
            result.add(4);
            result.add(1);
            return result;
        }
        // Reste sur les choix
        else {
            result.add(0);
            result.add(4);
            return result;
        }
    }
    }
//}