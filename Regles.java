import MG2D.*;
import MG2D.geometrie.*;

class Regles {

    public Regles(Fenetre f) {
        f.ajouter(new Texture("./images/regles.png", new Point(0, 0)));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Texture("./images/regles.png", new Point(0, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // bouton retour vers menu
        if ((to.getX()>=0) && (to.getX()<=100) && (to.getY()>=600) && (to.getY()<=700)) {
            return 0;
        }
        // reste sur les crédits
        else {
            return 7;
        }
    }
}