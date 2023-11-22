import MG2D.*;
import MG2D.geometrie.*;

class Combat {

    public Combat(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.rafraichir();
    }

    public void afficher(Piece ennemi, Piece joueur, Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0), 1100, 700));
        f.ajouter(new Texture("./images/combat_txt.png", new Point(400, 400)));
        f.ajouter(new Texture("./images/de_txt_2.png", new Point(400, 300)));
        f.ajouter(new Texture("./images/" + joueur.getNomLong() + ".png", new Point(0, 200)));
        f.ajouter(new Texture("./images/de.png", new Point(500, 200), 100, 100));
        f.ajouter(new Texture("./images/" + ennemi.getNomLong() + ".png", new Point(600, 200)));
        f.rafraichir();
    }

    public void afficher_de(int de, Fenetre f) {
        f.ajouter(new Texture("./images/de_" + de + ".png", new Point(500, 200), 100, 100));
        f.rafraichir();
    }

    public void afficher_vic(Fenetre f) {
        f.ajouter(new Texture("./images/vic.png", new Point(0, 0)));
        f.rafraichir();
    }

    public void afficher_perdu(Fenetre f) {
        f.ajouter(new Texture("./images/pdv.png", new Point(0, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // bouton retour vers menu
        if ((to.getX()>=500) && (to.getX()<=600) && (to.getY()>=200) && (to.getY()<=300)) {
            return 0;
        }
        // reste sur les crédits
        else {
            return 1;
        }
    }
}