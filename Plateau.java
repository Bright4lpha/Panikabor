import java.util.ArrayList;

class Plateau {
    // attributs
    private ArrayList<Piece> plateau = new ArrayList<Piece>();
    public ArrayList<Position> interdit = new ArrayList<Position>();

    // methodes
    public Plateau() {
        this.plateau.add(new Piece("mecano", 'J', "E4"));
        this.plateau.add(new Piece("capitaine", 'J', "E4"));
        this.plateau.add(new Piece("tache", 'T', "D2"));
        this.plateau.add(new Piece("gamin", 'J', "B4"));
        this.plateau.add(new Piece("tentacule", 'E', "D6"));
    }

    // getCase
    public ArrayList<Piece> getCase(int a, int b) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if ((p.getPosition().getX() == a) && (p.getPosition().getY() == b)) {
                pieces.add(p);
            }
        }
        return pieces;
    }

    public ArrayList<Piece> getCase(Position pos) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if ((p.getPosition().getX() == pos.getX()) && (p.getPosition().getY() == pos.getY())) {
                pieces.add(p);
            }
        }
        return pieces;
    }

    public ArrayList<Piece> getCase(String piece) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        for (Piece p : this.plateau) {
            if (p.getPosition().toString().equals(piece)) {
                pieces.add(p);
            }
        }
        return pieces;
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
                    ArrayList<Piece> pieces = getCase(a, i - 1);
                    if (pieces.size() == 0) {
                        chaine += "   |";
                    } else if (pieces.size() == 1) {
                        chaine += pieces.get(0).getNomCourt() + "|";
                    } else {
                        for (int j = 0; j < pieces.size(); j++) {
                            chaine += pieces.get(j).getNomCourt();
                        }
                        chaine += "|";
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
        ArrayList<Piece> piece_from = this.getCase(from);
        ArrayList<Piece> piece_to = this.getCase(to);
        if (piece_from.size() == 1) {
            piece_from.get(0).setPosition(to);
        }
        
    }

    // main pour tests

    public static void main(String[] args) {
        System.out.println("Test de Plateau");
        System.out.println("création d'un plateau plato");
        Plateau plato = new Plateau();
        System.out.println(plato);

        System.out.println();

        System.out.println("Test de getCase(0, 1) --> MeJ en A2");
        ArrayList<Piece> p1 = plato.getCase(0, 1);
        System.out.println(p1);

        System.out.println("Test de getCase(pos) --> (3, 1) --> TaT en D2");
        Position pos = new Position(3, 1);
        ArrayList<Piece> p2 = plato.getCase(pos);
        System.out.println(p2);

        System.out.println("Test de getCase('B4') --> GaJ en B4");
        ArrayList<Piece> p3 = plato.getCase("B4");
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

        plato.deplacer(pos, new Position(3,2));
        System.out.println(plato);
    }
}