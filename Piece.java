import java.util.ArrayList;
import MG2D.*;
// import MG2D.geometrie.*;
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

/*    public static void main(String[] args) {
        System.out.println("Test de Piece");
        Piece a = new Piece();
        System.out.println("Constructeur par défaut --> tache en A2");
        System.out.println(a);

        System.out.println();

        Piece copy = new Piece(a);
        System.out.println("Constructeur par copie du précédent --> tache en A2");
        System.out.println(copy);

        System.out.println();

        Piece b = new Piece("tentacule", 'E', 2, 6, 0);
        System.out.println("Constructeur par paramètres ('tentacule', 'E', 2, 6, 0) --> tentacule en C7");
        System.out.println(b);

        System.out.println();

        Piece c = new Piece("mécano", 'J', new Position(3, 7), 0);
        System.out.println("Constructeur par paramètres ('mécano', 'J', pos(3,7), 0) --> mécano en D8");
        System.out.println(c);

        System.out.println();

        Piece d = new Piece("capitaine", 'J', "C4", 0);
        System.out.println("Constructeur par paramètres ('capitaine', 'J', 'C4', 0) --> capitaine en C4");
        System.out.println(d);

        System.out.println();


        Piece e = new Piece();
        System.out.println("getNomCourt TaT");
        System.out.println(e.getNomCourt());

        Piece f = new Piece();
        System.out.println("getNomLong tache_T");
        System.out.println(f.getNomLong());

        System.out.println("equals de A2 et A2");
        Piece g = new Piece();
        Piece h = new Piece();
        boolean bool = g.equals(h);
        System.out.println(bool);

        System.out.println("equals de A2 et A5");
        Piece i = new Piece();
        Piece j = new Piece("patatiso", 'E', 0 , 4, 0);
        bool = i.equals(j);
        System.out.println(bool);
    }*/
}
