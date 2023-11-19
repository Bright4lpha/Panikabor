import java.util.ArrayList;
import MG2D.*;
import MG2D.geometrie.*;

/**
 * Cette classe décrit les caractéristiques du joueur Capitaine.
 * @author Mathilde Henrion
 * @version 1.0
 */

public class Capitaine extends Joueur {
    
    // Constructeurs

    /**
     * Permet de créer un Capitaine par défaut
     */
    public Capitaine() {
        this.position = new Position(0,1);
        this.indice = 0;
        this.pv = 4;
    }
    
    /**
     * Permet de créer un Capitaine par copie
     * @param c Capitaine
     */
    public Capitaine(Capitaine c) {
        this.position = c.getPosition();
        this.indice = c.getIndice();
        this.pv = 4;
    }
    
    /**
     * Permet de créer un Capitaine avec la position en paramètre entier
     * @param x position en x sur le plateau
     * @param y position en y sur le plateau
     * @param i indice dans la case
     */
    public Capitaine(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
        this.pv = 4;
    }
    
    /**
     * permet de créer un Capitaine avec la position en paramètre position
     * @param pos position sur le plateau
     * @param i indice dans la case
     */
    public Capitaine(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
        this.pv = 4;
    }

    /**
     * Permet de créer un Capitaine avec la position par chaine de caractères
     * @param str position par chaine de caractères
     * @param i indice dans la case
     */
    public Capitaine(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
        this.pv = 4;
    }

    // Accesseurs //

    // Getter //

    /**
     * Retourne le nom de la piece
     * @return le nom
     */
    public String getNom() {
        return "capitaine";
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
     * Capitaine ne peut annuler aucun combat
     * @param ennemi la piece de l'ennemi à combattre
     * @param f la fenetre du jeu
     * @return true ou false si victoire ou défaite
     */
    public boolean capacite(Piece Ennemi, Fenetre f) {
        return false;
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
        // System.out.println("Combat :");
        // if (ennemi.getNomCourt().equals("TeE")) {
        //     this.passe_tour = false;
        //     return -1;
        // }
        // else {
            int de_joueur = this.lancer_de();
            temp.add(de_joueur);
            // System.out.println("Lancer de dé : " + de_joueur);
            f.ajouter(new Texture("./images/de_" + de_joueur + ".png", new Point(800, 300), 100, 100));
            f.rafraichir();
            if (de_joueur > 3) {
                temp.add(1);
                return temp;
            }   
            else {
                // System.out.println("PV : " + this.getPV());
                this.pv = this.pv -1;
                // System.out.println("PV : " + this.getPV());
                temp.add(0);
                return temp;
            }
        // }
    }
}