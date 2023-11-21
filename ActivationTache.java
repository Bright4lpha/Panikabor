import MG2D.*;
import MG2D.geometrie.*;

class ActivationTache {
    Texture TD = new Texture("./images/tache_D.png", new Point(600, 200));
    Texture TA = new Texture("./images/tache_A.png", new Point(600, 200));

    public ActivationTache(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        f.rafraichir();
    }

    public void afficher(Piece joueur, Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0), 1100, 700));
        f.ajouter(new Texture("./images/" + joueur.getNomLong() + ".png", new Point(0, 200)));
        f.ajouter(new Texture("./images/de.png", new Point(500, 200), 100, 100));
        f.ajouter(this.TD);
        f.rafraichir();
    }

    public void afficher_de(int de, Fenetre f) {
        f.ajouter(new Texture("./images/de_" + de + ".png", new Point(500, 200), 100, 100));
        f.rafraichir();
    }

    public void afficher_vic(Piece joueur, int de, Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0), 1100, 700));
        f.ajouter(new Texture("./images/" + joueur.getNomLong() + ".png", new Point(0, 200)));
        f.ajouter(new Texture("./images/de_" + de + ".png", new Point(500, 200), 100, 100));
        f.ajouter(new Texture("./images/vic.png", new Point(0, 0)));
        f.ajouter(this.TA);
        f.rafraichir();
    }

    public void afficher_perdu(Fenetre f) {
        f.ajouter(new Texture("./images/perdu.png", new Point(0, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // lancé de dé
        if ((to.getX()>=500) && (to.getX()<=600) && (to.getY()>=200) && (to.getY()<=300)) {
            return 0;
        }
        else {
            return 1;
        }
    }
}