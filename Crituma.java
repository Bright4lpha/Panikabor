import java.util.ArrayList;

public class Crituma extends Ennemi {
    
    public Crituma() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Crituma(Crituma p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Crituma(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Crituma(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Crituma(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "crituma";
    }

    // Inutile pour les ennemis
    public int getPV() {
        return -1;
    }

    public ArrayList<Position> getDeplacementPossible(Plateau p) {
        ArrayList<Position> pos = new ArrayList<Position>();
        int x = this.position.getX();
        int y = this.position.getY();

        // à droite
        if ((0<x+1)&&(x+1<7)&&(0<y)&&(y<6)) {
            pos.add(new Position(x+1, y));
        }
        if ((0<x+2)&&(x+2<7)&&(0<y)&&(y<6)) {
            pos.add(new Position(x+2, y));
        }
        
        // en bas
        if ((0<x)&&(x<7)&&(0<y-1)&&(y-1<6)) {
            pos.add(new Position(x, y-1));
        }
        if ((0<x)&&(x<7)&&(0<y-2)&&(y-2<6)) {
            pos.add(new Position(x, y-2));
        }
        
        // à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y)&&(y<6)) {
            pos.add(new Position(x-1, y));
        }
        if ((0<x-2)&&(x-2<7)&&(0<y)&&(y<6)) {
            pos.add(new Position(x-2, y));
        }

        // en haut
        if ((0<x)&&(x<7)&&(0<y+1)&&(y+1<6)) {
            pos.add(new Position(x, y+1));
        }
        if ((0<x)&&(x<7)&&(0<y+2)&&(y+2<6)) {
            pos.add(new Position(x, y+2));
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

    // Les capacités sont effectués AVANT les combats.
    public boolean capacite() {
        return false;
    }

    public int combat(Piece ennemi) {
        return -2;
    }
}
