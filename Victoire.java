import MG2D.*;
import MG2D.geometrie.*;

class Victoire {

    public Victoire(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.VERT, new Point(0, 0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/victoire.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/quitter.png", new Point(350, 0)));
        // f.ajouter(new Texture("./images/retour.png", new Point(350, 0)));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.VERT, new Point(0, 0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/victoire.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/quitter.png", new Point(350, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // bouton quitter
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            return 3;
        }
        // reste sur la page victoire
        else {
            return 5;
        }
    }
}