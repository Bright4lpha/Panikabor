abstract class Ennemi extends Piece {
        
    public Ennemi() {
        this.position = new Position(0,1);
        this.indice = 0;
    }
    
    // constructeur par copie
    public Ennemi(Ennemi p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
    }
    
    // constructeur avec paramètres int
    public Ennemi(String n, int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
    }
    
    // constructeur avec paramètres position
    public Ennemi(String n, Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
    }

    // constructeur avec paramètres string
    public Ennemi(String n, String str, int i) {
        this.position = new Position(str);  
        this.indice = i;
    }

    // Accesseurs //

    // Getter //

    public abstract String getNom();
    public char getType() {
        return 'E';
    }
}
