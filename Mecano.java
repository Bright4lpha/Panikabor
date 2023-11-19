import java.util.ArrayList;

import MG2D.Fenetre;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;

public class Mecano extends Joueur {
    
    public Mecano() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Mecano(Mecano p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Mecano(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Mecano(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Mecano(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "mecano";
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
     * Elle a la capacité d'ajouter 1 à son lancé
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+2);
    }

    // Les capacités sont effectués AVANT les combats.
    // Le but est d'éviter le combat ou l'annuler
    // Mecano ne peut annuler aucun combat
    public boolean capacite(Piece ennemi, Fenetre f) {
        return false;
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
                this.pv = this.pv-1;
                temp.add(0);
                return temp;
            }
        // }
    }
}
