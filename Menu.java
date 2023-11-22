import MG2D.*;
import MG2D.geometrie.*;

class Menu {

    public Menu(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        
        //f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 100), 150, 100, true));
        f.ajouter(new Texture("./images/credits.png", new Point(225, 0)));
        
        //f.ajouter(new Rectangle(Couleur.CYAN, new Point(550, 100), 150, 100, true));
        f.ajouter(new Texture("./images/quitter.png", new Point(475, 0)));
        
        //f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 300), 400, 100, true));
        f.ajouter(new Texture("./images/jouer.png", new Point(300, 200)));
        //f.ajouter(new Rectangle(Couleur.MAGENTA, new Point(300, 500), 400, 100, true));
        f.ajouter(new Texture("./images/panikabor.png", new Point(210, 390)));

        f.ajouter(new Texture("./images/regles_2.png", new Point(-50, -100)));
        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        // f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 100), 150, 100, true));
        f.ajouter(new Texture("./images/credits.png", new Point(225, 0)));

        // f.ajouter(new Rectangle(Couleur.CYAN, new Point(550, 100), 150, 100, true));
        f.ajouter(new Texture("./images/quitter.png", new Point(475, 0)));
        
        // f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 300), 400, 100, true));
        f.ajouter(new Texture("./images/jouer.png", new Point(300, 200)));
        //f.ajouter(new Rectangle(Couleur.MAGENTA, new Point(300, 500), 400, 100, true));
        f.ajouter(new Texture("./images/panikabor.png", new Point(210, 390)));
        f.ajouter(new Texture("./images/regles_2.png", new Point(-50, -100)));
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
        // bouton regles
        else if ((to.getX()>=0) && (to.getX()<=200) && (to.getY()>=0) && (to.getY()<=100)) {
            return 7;
        }
        // reste sur la page menu
        else {
            return 0;
        }
    }
}