import java.util.ArrayList;

public class Patatiso extends Ennemi{
    public Patatiso() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Patatiso(Patatiso p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Patatiso(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Patatiso(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Patatiso(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "patatiso";
    }
    // Inutile pour les ennemis
    public int getPV() {
        return -1;
    }

    public ArrayList<Position> getDeplacementPossible(Plateau p) {
        ArrayList<Position> pos = new ArrayList<Position>();
        int x = this.position.getX();
        int y = this.position.getY();

        //if (p.getCase(this.position).size() == 1) {  
        // en haut à droite
            if ((0<x+1)&&(x+1<7)&&(0<y+1)&&(y+1<6)) {
                pos.add(new Position(x+1, y+1));
            }
            

            // à droite
            if ((0<x+1)&&(x+1<7)&&(0<y)&&(y<6)) {
                pos.add(new Position(x+1, y));
            }
            

            // en bas à droite
            if ((0<x+1)&&(x+1<7)&&(0<y-1)&&(y-1<6)) {
                pos.add(new Position(x+1, y-1));
            }
            

            // en bas
            if ((0<x)&&(x<7)&&(0<y-1)&&(y-1<6)) {
                pos.add(new Position(x, y-1));
            }
            

            // en bas à gauche
            if ((0<x-1)&&(x-1<7)&&(0<y-1)&&(y-1<6)) {
                pos.add(new Position(x-1, y-1));
            }
            

            // à gauche
            if ((0<x-1)&&(x-1<7)&&(0<y)&&(y<6)) {
                pos.add(new Position(x-1, y));
            }
            

            // en haut à gauche
            if ((0<x-1)&&(x-1<7)&&(0<y+1)&&(y+1<6)) {
                pos.add(new Position(x-1, y+1));
            }
            

            // en haut
            if ((0<x)&&(x<7)&&(0<y+1)&&(y+1<6)) {
                pos.add(new Position(x, y+1));
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
        //}
        

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
