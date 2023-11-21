import java.util.ArrayList;
import MG2D.*;

abstract class Piece {
    // attributs
    protected Position position;
    protected int indice;

    // methodes
    // constructeur par défaut
    public Piece() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Piece(Piece p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Piece(String n, char t, int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Piece(String n, char t, Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Piece(String n, char t, String str, int i) {
        this.position = new Position(str);  
        this.indice = i;
    }

    // getter
    public abstract String getNom();

    public abstract char getType();

    public Position getPosition() {
        return this.position;
    }

    public int getIndice() {
        return this.indice;
    }

    public String getNomCourt() {
        String nom = "";
        nom = this.getNom().substring(0,1).toUpperCase();
        nom += this.getNom().substring(1,2);
        return nom + this.getType();
    }

    public String getNomLong() {
        String nom = "";
        nom += this.getNom();
        nom += "_";
        return nom + this.getType();
    }

    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);
    
    // setter

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setIndice(int i) {
        this.indice = i;
    }
    
    // equals
    public boolean equals(Object obj) {
        boolean egaux = false;
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                Piece other = (Piece) obj;
                if ((this.position.equals(other.position))&&(this.indice == other.indice)){
                    egaux = true;
                }
            }
            else {
                egaux = false;
            }
        }
        else {
            egaux = false;
        }
        return egaux;
    }

    public String toString() {
        String chaine = "";
        chaine += this.getNom();
        chaine += " en ";
        chaine += this.position.toString();
        return chaine;
    }

    public abstract ArrayList<Integer> combat(Piece Ennemi, Fenetre f);
    public abstract int getPV();
    public abstract boolean capacite(Piece Ennemi, Fenetre f);
}
