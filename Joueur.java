import java.util.ArrayList;

import MG2D.*;
// import MG2D.geometrie.*;

abstract class Joueur extends Piece {
    
    // Attributs //
    protected int pv;
    protected boolean tour;
    protected boolean passe_tour;

    public Joueur() {
        this.position = new Position(0,1);
        this.indice = 0;
        this.pv = 3;
        this.tour = false;
        this.passe_tour = false;
    }
    
    // constructeur par copie
    public Joueur(Joueur p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
        this.pv = 3;
        this.tour = false;
        this.passe_tour = false;
    }
    
    // constructeur avec paramètres int
    public Joueur(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
        this.pv = 3;
        this.tour = false;
        this.passe_tour = false;
    }
    
    // constructeur avec paramètres position
    public Joueur(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
        this.pv = 3;
        this.tour = false;
        this.passe_tour = false;
    }

    // constructeur avec paramètres string
    public Joueur(String str, int i) {
        this.position = new Position(str);  
        this.indice = i;
        this.pv = 3;
        this.tour = false;
        this.passe_tour = false;
    }

    // Accesseurs //

    // Getter //

    public abstract String getNom();
    public char getType() {
        return 'J';
    }

    public abstract int getPV();

    // Méthodes //
    // Combat //
    // -1 --> passe son tour
    // 0 --> perdu
    // 1 --> gagné
    public abstract ArrayList<Integer> combat(Piece ennemi, Fenetre f);

}
