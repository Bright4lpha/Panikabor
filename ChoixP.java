// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class ChoixP {

    public ChoixP(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        // f.ajouter(new Texture("./images/capitaine_J.png", new Point(300, 400), 200, 200));
        // f.ajouter(new Texture("./images/gamin_J.png", new Point(200, 200), 200, 200));
        // f.ajouter(new Texture("./images/bibledum_J.png", new Point(500, 200), 200, 200));
        // f.ajouter(new Texture("./images/mecano_J.png", new Point(500, 400), 200, 200));

        f.ajouter(new Texture("./images/capitaine_J.png", new Point(100, 300), 200, 200));
        f.ajouter(new Texture("./images/gamin_J.png", new Point(300, 300), 200, 200));
        f.ajouter(new Texture("./images/bibledum_J.png", new Point(500, 300), 200, 200));
        f.ajouter(new Texture("./images/mecano_J.png", new Point(700, 300), 200, 200));
        
        f.ajouter(new Texture("./images/retour.png", new Point(350, 100)));

        f.rafraichir();
    }

    public void afficher(Fenetre f) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        // f.ajouter(new Texture("./images/capitaine_J.png", new Point(300, 400), 200, 200));
        // f.ajouter(new Texture("./images/gamin_J.png", new Point(300, 200), 200, 200));
        // f.ajouter(new Texture("./images/bibledum_J.png", new Point(500, 200), 200, 200));
        // f.ajouter(new Texture("./images/mecano_J.png", new Point(500, 400), 200, 200));

        f.ajouter(new Texture("./images/capitaine_J.png", new Point(100, 300), 200, 200));
        f.ajouter(new Texture("./images/gamin_J.png", new Point(300, 300), 200, 200));
        f.ajouter(new Texture("./images/bibledum_J.png", new Point(500, 300), 200, 200));
        f.ajouter(new Texture("./images/mecano_J.png", new Point(700, 300), 200, 200));

        f.ajouter(new Texture("./images/retour.png", new Point(350, 0)));
        f.rafraichir();
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Retour vers menu
        if ((to.getX()>=400) && (to.getX()<=600) && (to.getY()>=100) && (to.getY()<=200)) {
            return 0;
        }
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=500) && (to.getY()<=600)) {
            return 1;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=500) && (to.getY()<=600)) {
            return 2;
        }
        if ((to.getX()>=300) && (to.getX()<=400) && (to.getY()>=300) && (to.getY()<=400)) {
            return 3;
        }
        if ((to.getX()>=600) && (to.getX()<=700) && (to.getY()>=300) && (to.getY()<=400)) {
            return 4;
        }
        // Reste sur les choix
        else {
            return 4;
        }
    }
    }
//}