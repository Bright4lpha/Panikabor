import MG2D.*;
import MG2D.geometrie.*;

class Menu {

    public Menu(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/credits.png", new Point(225, 0)));
        f.ajouter(new Texture("./images/quitter.png", new Point(475, 0)));
        f.ajouter(new Texture("./images/jouer.png", new Point(300, 200)));
        f.ajouter(new Texture("./images/panikabor.png", new Point(210, 390)));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/credits.png", new Point(225, 0)));
        f.ajouter(new Texture("./images/quitter.png", new Point(475, 0)));
        f.ajouter(new Texture("./images/jouer.png", new Point(300, 200)));
        f.ajouter(new Texture("./images/panikabor.png", new Point(210, 390)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // bouton crédits
        if ((to.getX()>=300) && (to.getX()<=450) && (to.getY()>=100) && (to.getY()<=200)) {
            return 2;
        }
        // bouton quitter
        else if ((to.getX()>=550) && (to.getX()<=700) && (to.getY()>=100) && (to.getY()<=200)) {
            return 3;
        }
        // bouton jouer
        else if ((to.getX()>=300) && (to.getX()<=700) && (to.getY()>=300) && (to.getY()<=400)) {
            return 4;
            // 4 pour les choix
        }
        // reste sur la page menu
        else {
            return 0;
        }
    }
}