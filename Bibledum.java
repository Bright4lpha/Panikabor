import java.util.ArrayList;

import MG2D.Fenetre;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;

public class Bibledum extends Joueur {
    
    public Bibledum() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Bibledum(Bibledum p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Bibledum(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Bibledum(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Bibledum(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "bibledum";
    }

    public int getPV() {
        return this.pv;
    }

    public ArrayList<Position> getDeplacementPossible(Plateau p) {
        ArrayList<Position> pos = new ArrayList<Position>();
        int x = this.position.getX();
        int y = this.position.getY();
        // en haut à droite
        if ((0<x+1)&&(x+1<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x+1, y+1).size() < 4) {
                pos.add(new Position(x+1, y+1));
            }
        }
        // à droite
        if ((0<x+1)&&(x+1<7)&&(0<y)&&(y<6)) {
            if (p.getCase(x+1, y).size() < 4) {
                pos.add(new Position(x+1, y));
            }
        }
        // en bas à droite
        if ((0<x+1)&&(x+1<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x+1, y-1).size() < 4) {
                pos.add(new Position(x+1, y-1));
            }
        }
        // en bas
        if ((0<x)&&(x<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x, y-1).size() < 4) {
                pos.add(new Position(x, y-1));
            }
        }
        // en bas à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x-1, y-1).size() < 4) {
                pos.add(new Position(x-1, y-1));
            }
        }
        // à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y)&&(y<6)) {
            if (p.getCase(x+1, y+1).size() < 4) {
                pos.add(new Position(x-1, y));
            }
        }
        // en haut à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x-1, y+1).size() < 4) {
                pos.add(new Position(x-1, y+1));
            }
        }
        // en haut
        if ((0<x)&&(x<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x, y+1).size() < 4) {
                pos.add(new Position(x, y+1));
            }
        }
        Position temp;
        if (pos.contains(temp = new Position(1,1))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(1,5))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(5,1))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(5,5))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(6,1))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(6,2))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(6,4))) {
            pos.remove(temp);
        }
        if (pos.contains(temp = new Position(6,5))) {
            pos.remove(temp);
        }
        return pos;
    }

    /**
     * Fonction de lancer de dé à 6 faces
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+1);
    }

    // Les capacités sont effectués AVANT les combats.
    // Le but est d'éviter le combat ou l'annuler
    // Bibledum peut annuler les capacités de Crituma, Tentacule et Roswell
    public boolean capacite(Piece ennemi, Fenetre f) {
        if (ennemi.getNomCourt().equals("Pa_E")) {
            return false;
        }
        else {
            int de_joueur = this.lancer_de();
            f.ajouter(new Texture("./images/de_" + de_joueur + ".png", new Point(800, 300), 100, 100));
            f.rafraichir();
            if (de_joueur > 4) {
                Fenetre victoire = new Fenetre("Capacite", 1100, 700);
                victoire.ajouter(new Texture("./images/space.png", new Point(0, 0), 1100, 700));
                victoire.ajouter(new Texture("./images/" + this.getNomLong() + ".png", new Point(0, 200)));
                victoire.ajouter(new Texture("./images/de_" + de_joueur + ".png", new Point(500, 200), 100, 100));
                victoire.ajouter(new Texture("./images/" + ennemi.getNomLong() + ".png", new Point(600, 200)));
                victoire.ajouter(new Texture("./images/vic.png", new Point(0, 0)));
                victoire.rafraichir();
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {}
                victoire.fermer();
                return true;
            }   
            else {
                Fenetre perdu = new Fenetre("Capacite", 1100, 700);
                perdu.ajouter(new Texture("./images/space.png", new Point(0, 0), 1100, 700));
                perdu.ajouter(new Texture("./images/" + this.getNomLong() + ".png", new Point(0, 200)));
                perdu.ajouter(new Texture("./images/de_" + de_joueur + ".png", new Point(500, 200), 100, 100));
                perdu.ajouter(new Texture("./images/" + ennemi.getNomLong() + ".png", new Point(600, 200)));
                perdu.ajouter(new Texture("./images/perdu.png", new Point(0, 0)));
                perdu.rafraichir();
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {}
                perdu.fermer();
                return false;
            }
        }
    }

    public ArrayList<Integer> combat(Piece ennemi, Fenetre f) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // if (ennemi.getNomCourt().equals("TeE")) {
        //     this.passe_tour = false;
        //     return -1;
        // }
        // else {
            int de_joueur = this.lancer_de();
            temp.add(de_joueur);
            f.ajouter(new Texture("./images/de_" + de_joueur + ".png", new Point(800, 300), 100, 100));
            f.rafraichir();
            if (de_joueur > 4) {
                temp.add(1);
                return temp;
            }   
            else {
                this.pv = this.pv -1;
                temp.add(0);
                return temp;
            }
        //}
    }
}
