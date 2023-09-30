import java.util.ArrayList;

class Piece {
    // attributs
    private String nom;
    private char type;
    private Position position;
    private int indice;

    // methodes
    // constructeur par défaut
    public Piece() {
        this.nom = "tache";
        this.type = 'T';
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Piece(Piece p) {
        this.nom = p.getNom();
        this.type = p.getType();
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Piece(String n, char t, int x, int y, int i) {
        this.nom = n.toLowerCase();
        if ((t == 'E') || (t == 'T') || (t == 'J')) {
            this.type = t;
        }
        else {
            System.out.println("Le type ne correspond pas");
        }
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Piece(String n, char t, Position pos, int i) {
        this.nom = n.toLowerCase();
        if ((t == 'E') || (t == 'T') || (t == 'J')) {
            this.type = t;
        }
        else {
            System.out.println("Le type ne correspond pas");
        }
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Piece(String n, char t, String str, int i) {
        this.nom = n.toLowerCase();
        if ((t == 'E') || (t == 'T') || (t == 'J')) {
            this.type = t;
        }
        else {
            System.out.println("Le type ne correspond pas");
        }
        this.position = new Position(str);  
        this.indice = i;
    }

    // getter
    public String getNom() {
        return this.nom;
    }

    public char getType() {
        return this.type;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getIndice() {
        return this.indice;
    }

    // setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setIndice(int i) {
        this.indice = i;
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

    public String getNomCourt() {
        String nom = "";
        nom = this.nom.substring(0,1).toUpperCase();
        nom += this.nom.substring(1,2);
        return nom + this.type;
    }

    public String getNomLong() {
        String nom = "";
        nom += this.nom;
        nom += "_";
        return nom + this.type;
    }

    // equals
    public boolean equals(Object obj) {
        boolean egaux = false;
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                Piece other = (Piece) obj;
                if ((this.nom == other.nom)&&(this.type == other.type)&&(this.position.equals(other.position))&&(this.indice == other.indice)){
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
        chaine += this.nom;
        chaine += " en ";
        chaine += this.position.toString();
        return chaine;
    }
    
    public static void main(String[] args) {
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
    }
}
