import java.util.ArrayList;

public class Capitaine extends Joueur {
    
    public Capitaine() {
        this.position = new Position(0,1);
        this.indice = 0;
        this.pv = 4;
    }
    
    // constructeur par copie
    public Capitaine(Capitaine p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
        this.pv = 4;
    }
    
    // constructeur avec paramètres int
    public Capitaine(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
        this.pv = 4;
    }
    
    // constructeur avec paramètres position
    public Capitaine(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
        this.pv = 4;
    }

    // constructeur avec paramètres string
    public Capitaine(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
        this.pv = 4;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "capitaine";
    }

    public int getPV() {
        return this.pv;
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

    /**
     * Fonction de lancer de dé à 6 faces
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+1);
    }
    

    public int combat(Piece ennemi) {
        System.out.println("Combat :");
        if (ennemi.getNomCourt() == "Te_E") {
            this.passe_tour = false;
            return -1;
        }
        else {
            int de_joueur = this.lancer_de();
            System.out.println("Lancer de dé : " + de_joueur);
            if (de_joueur > 4) {
                return 1;
            }   
            else {
                System.out.println("PV : " + this.getPV());
                this.pv = this.pv -1;
                System.out.println("PV : " + this.getPV());
                return 0;
            }
        }
    }

}