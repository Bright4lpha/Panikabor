import java.util.ArrayList;
import MG2D.Fenetre;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;

/**
 * Cette classe décrit les caractéristiques du joueur Bibledum.
 * @author Mathilde Henrion
 * @version 1.0
 */

public class Bibledum extends Joueur {
    
    // Constructeurs

    /**
     * Permet de créer un Bibledum par défaut
     */
    public Bibledum() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    /**
     * Permet de créer un Bibledum par copie
     * @param b Bibledum
     */
    public Bibledum(Bibledum b) {
        this.position = b.getPosition();
        this.indice = b.getIndice();
    }
    
    /**
     * Permet de créer un Bibledum avec la position en paramètre entier
     * @param x position en x sur le plateau
     * @param y position en y sur le plateau
     * @param i indice dans la case
     */
    public Bibledum(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    /**
     * permet de créer un Bibledum avec la position en paramètre position
     * @param pos position sur le plateau
     * @param i indice dans la case
     */
    public Bibledum(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    /**
     * Permet de créer un Bibledum avec la position par chaine de caractères
     * @param str position par chaine de caractères
     * @param i indice dans la case
     */
    public Bibledum(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    /**
     * Retourne le nom de la piece
     * @return le nom
     */
    public String getNom() {
        return "bibledum";
    }

    /**
     * Retourne le nombre de point de vie
     * @return le nb de point de vie
     */
    public int getPV() {
        return this.pv;
    }

    /**
     * Retourne la liste des deplacements possibles de la pièce
     * @param p le plateau
     * @return la liste des déplacements
     */
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

    /**
     * Fonction qui active les capacités du joueur.
     * Les capacités sont effectués AVANT les combats.
     * Le but est d'éviter le combat ou l'annuler
     * Bibledum peut annuler les capacités de Crituma, Tentacule et Roswell
     * @param ennemi la piece de l'ennemi à combattre
     * @param f la fenetre du jeu
     * @return true ou false si victoire ou défaite
     */
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

    /**
     * Fonction de combat du joueur
     * Le combat est réussi si le résultat du dé est 5 ou 6
     * @param ennemi la pièce de l'ennemi à combattre
     * @param f la fenetre du jeu
     * @return le premier entier indique le résultat du dé, le deuxième la victoire ou la défaite
     */
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
