import MG2D.*;
import MG2D.geometrie.*;

class Credits {

    public Credits(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 400, 100, true));
        
        // f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point(400, 100), 200, 100, true));
        f.ajouter(new Texture("./images/retour.png", new Point(350, 100)));

        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Rectangle(Couleur.ORANGE, new Point(300, 300), 400, 100, true));
        // f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point(450, 100), 100, 100, true));
        f.ajouter(new Texture("./images/retour.png", new Point(350, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // bouton retour vers menu
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            return 0;
        }
        // reste sur les crédits
        else {
            return 2;
        }
    }
}

/*
 * Auteur du jeu et développement : Mathilde Henrion
 * Création graphique : Priscille Lagouardille et Charlotte Henrion
 * Testeurs : Mathilde Henrion
 * Musique : 
 * Remerciements spéciaux : ma famille et mes amis qui m'ont partagé leurs idées et leur soutien
 * Et merci à vous qui jouer à ce jeu !
 */