import java.util.ArrayList;

class Plateau {
    // attributs
    private ArrayList<Piece> plateau = new ArrayList<Piece>();
    public ArrayList<Position> interdit = new ArrayList<Position>();

    // methodes
    public Plateau() {
        this.plateau.add(new Piece("mecano", 'J', "E4"));
        this.plateau.add(new Piece("tache", 'T', "D2"));
        this.plateau.add(new Piece("gamin", 'J', "B4"));
        this.plateau.add(new Piece("tentacule", 'E', "D6"));
    }

    // getCase
    public Piece getCase(int a, int b) {
        for (Piece p : this.plateau) {
            if ((p.getPosition().getX() == a) && (p.getPosition().getY() == b)) {
                return p;
            }
        }
        return null;
    }

    public Piece getCase(Position pos) {
        for (Piece p : this.plateau) {
            if ((p.getPosition().getX() == pos.getX()) && (p.getPosition().getY() == pos.getY())) {
                return p;
            }
        }
        return null;
    }

    public Piece getCase(String piece) {
        for (Piece p : this.plateau) {
            if (p.getPosition().toString().equals(piece)) {
                return p;
            }
        }
        return null;
    }

    // toString
    public String toString() {
        String chaine = "";
        String ligne = " |---|---|---|---|---|---|---|---| \n";
        for (int i = 7; i >= 0; i--) {
            chaine += ligne;
            if (i == 0) {
                chaine += "   A   B   C   D   E   F   G   H   ";
            } else {
                chaine += i + "|";
                for (int a = 0; a < 8; a++) {
                    Piece piece = getCase(a, i - 1);
                    if (piece == null) {
                        chaine += "   |";
                    } else {
                        chaine += piece.getNomCourt() + "|";
                    }
                }
                chaine += i + "\n";
            }
        }
        return chaine;
    }

    // getPieces

    public ArrayList<Piece> getPiecesTaches() {
        ArrayList<Piece> taches = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if (p.getType() == 'T') {
                taches.add(new Piece(p.getNom(), p.getType(), p.getPosition()));
            }
        }
        return taches;
    }

    public ArrayList<Piece> getPiecesEnnemi() {
        ArrayList<Piece> ennemi = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if (p.getType() == 'E') {
                ennemi.add(new Piece(p.getNom(), p.getType(), p.getPosition()));
            }
        }
        return ennemi;
    }

    public ArrayList<Piece> getPiecesJoueur() {
        ArrayList<Piece> joueur = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if (p.getType() == 'J') {
                joueur.add(new Piece(p.getNom(), p.getType(), p.getPosition()));
            }
        }
        return joueur;
    }

    public void remove(Piece p) {
        this.plateau.remove(p);
    }

    public void deplacer(Position from, Position to) {
        Piece piece_from = this.getCase(from);
        Piece piece_to = this.getCase(to);
        if (piece_to != null) {
            this.remove(piece_to); // on supprime la pièce d'arrivée du plateau
        }
        piece_from.setPosition(to);
    }

    // main pour tests

    public static void main(String[] args) {
        System.out.println("Test de Plateau");
        System.out.println("création d'un plateau plato");
        Plateau plato = new Plateau();
        System.out.println(plato);

        System.out.println();

        System.out.println("Test de getCase(0, 1) --> MeJ en A2");
        Piece p1 = plato.getCase(0, 1);
        System.out.println(p1);

        System.out.println("Test de getCase(pos) --> (3, 1) --> TaT en D2");
        Position pos = new Position(3, 1);
        Piece p2 = plato.getCase(pos);
        System.out.println(p2);

        System.out.println("Test de getCase('B4') --> GaJ en B4");
        Piece p3 = plato.getCase("B4");
        System.out.println(p3);

        System.out.println();

        System.out.println("Test de getPiecesTaches");
        System.out.println(plato.getPiecesTaches());

        System.out.println();

        System.out.println("Test de getPiecesNoires");
        System.out.println(plato.getPiecesEnnemi());

        System.out.println();

        System.out.println("Test de getPiecesJoueurs");
        System.out.println(plato.getPiecesJoueur());
    }
}
