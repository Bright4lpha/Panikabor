import java.util.ArrayList;

class Tache {
    // attributs
    private Position position;
    private boolean active;
    
    //methodes
    // constructeur par défaut
    public Tache() {
        this.position = new Position(0,1);
        this.active = false;
    }
    
    // constructeur par copie
    public Tache(Tache p) {
        this.position = p.getPosition();
        this.active = p.getActive();
    }
    
    // constructeur avec paramètres int
    public Tache(int x, int y) {
        this.position = new Position(x, y);
        this.active = false;
    }
    
    // constructeur avec paramètres position
    public Tache(Position pos) {
        this.position = new Position(pos);
        this.active = false;
    }

    // constructeur avec paramètres string
    public Tache(String str) {
        this.position = new Position(str);
        this.active = false;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "tache";
    }
    public char getType() {
        return 'T';
    }
    public Position getPosition() {
        return position;
    }
    public boolean getActive() {
        return active;
    }


    // Setter
    public void setPosition(Position p) {
        this.position = p;
    }
    public void setActive(boolean a) {
        this.active = a;
    }

    /**
     * Fonction de lancer de dé à 6 faces
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+1);
    }


    public ArrayList<Integer> activation() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int de = lancer_de();
        result.add(de);
        if (de>4) {
            this.active = true;
            result.add(1);
            return result;
        }
        else {
            result.add(0);
            return result;
        }
    }

}
