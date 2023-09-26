import java.util.ArrayList;

class Plateau {
    // attributs
    private ArrayList<ArrayList<Piece>> plateau = new ArrayList<ArrayList<Piece>>();
    public ArrayList<Position> interdit = new ArrayList<Position>();

    // methodes
    public Plateau() {
        for (int i = 0; i <= 70; i++) {
            this.plateau.add(new ArrayList<Piece>());
        }
        this.plateau.get(34).add(new Piece("mecano", 'J', "E4"));//34
        this.plateau.get(34).add(new Piece("capitaine", 'J', "E4"));
        this.plateau.get(13).add(new Piece("tache", 'T', "D2"));//13
        this.plateau.get(31).add(new Piece("gamin", 'J', "B4"));//31
        this.plateau.get(53).add(new Piece("tentacule", 'E', "D6"));//53
    }

/*
 * Pour les positions des cases et leurs références
 * Les positions de la classe Position utilisent la notation normalisée des échecs abscisses puis ordonnées.
 * Ici, la liste se lit dans l'autre sens.
 * Exemple : 
 * Position(3, 1) --> Pion en D2
 * Plateau(31) --> Pion en B4
 * Le plateau est découpée par 10. Le premier chiffre indique l'ordonnée, le deuxième l'abscisse.
 * Ainsi pour les calculs (ordonnée * 10) + abscisse = indice pour récupérer la case.
 */

    // getCase
    public ArrayList<Piece> getCase(int a) {
        return this.plateau.get(a);
    }

    public ArrayList<Piece> getCase(Position pos) {
        String position = "" + pos.getY() + pos.getX();
        return this.plateau.get(Integer.parseInt(position));
    }

    public ArrayList<Piece> getCase(String chaine) {
        String position = "";
        // teste le chiffre
        if (chaine.charAt(1) == '1') {
            position += 0;
        }
        else if (chaine.charAt(1) == '2') {
            position += 1;
        }
        else if (chaine.charAt(1) == '3') {
            position += 2;
        }
        else if (chaine.charAt(1) == '4') {
            position += 3;
        }
        else if (chaine.charAt(1) == '5') {
            position += 4;
        }
        else if (chaine.charAt(1) == '6') {
            position += 5;
        }
        else if (chaine.charAt(1) == '7') {
            position += 6;
        }
        else if (chaine.charAt(1) == '8') {
            position += 7;
        }
        // test la lettre
        if (chaine.charAt(0) == 'A') {
            position += 0;
        }
        else if (chaine.charAt(0) == 'B') {
            position += 1;
        }
        else if (chaine.charAt(0) == 'C') {
            position += 2;
        }
        else if (chaine.charAt(0) == 'D') {
            position += 3;
        }
        else if (chaine.charAt(0) == 'E') {
            position += 4;
        }
        else if (chaine.charAt(0) == 'F') {
            position += 5;
        }
        else if (chaine.charAt(0) == 'G') {
            position += 6;
        }
        else if (chaine.charAt(0) == 'H') {
            position += 7;
        }
        return this.plateau.get(Integer.parseInt(position));
    }

    // toString
    public String toString() {
        String chaine = "";
        String ligne = " |---|---|---|---|---|---|---|---|---|---|\n";
        for (int i = 7; i >= 0; i--) {
            chaine += ligne;
            if (i == 0) {
                chaine += "   A   B   C   D   E   F   G   H   I   J";
            } else {
                chaine += i + "|";
                for (int a = 0; a < 10; a++) {
                    ArrayList<Piece> pieces = this.getCase(((i-1)*10)+a);
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

    public ArrayList<Piece> getPiecesTache() {
        ArrayList<Piece> tache = new ArrayList<Piece>();
        for (ArrayList<Piece> p : this.plateau) {
            if (p.size() != 0) {
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).getType() == 'T') {
                        tache.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition()));
                    } 
                }
            }
        }
        return tache;
    }

    public ArrayList<Piece> getPiecesEnnemi() {
        ArrayList<Piece> ennemi = new ArrayList<Piece>();
        for (ArrayList<Piece> p : this.plateau) {
            if (p.size() != 0) {
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).getType() == 'E') {
                        ennemi.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition()));
                    } 
                }
            }
        }
        return ennemi;
    }

    public ArrayList<Piece> getPiecesJoueur() {
        ArrayList<Piece> joueur = new ArrayList<Piece>();
        for (ArrayList<Piece> p : this.plateau) {
            if (p.size() != 0) {
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).getType() == 'J') {
                        joueur.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition()));
                    } 
                }
            }
        }
        return joueur;
    }

    public void remove(Piece p) {
        for (ArrayList<Piece> pl : this.plateau) {
            if (pl.size() != 0) {
                for (int i = 0; i < pl.size(); i++) {
                    if (pl.get(i).equals(p)) {
                        pl.remove(p);
                    } 
                }
            }
        }
    }

    public void deplacer(Piece p, Position from, Position to) {
        ArrayList<Piece> piece_from = this.getCase(from);
        ArrayList<Piece> piece_to = this.getCase(to);
        this.remove(p);
        if (piece_from.size() == 1) {
            piece_from.get(0).setPosition(to);
        }
        this.getCase(to).add(p);
    }

    // main pour tests

    public static void main(String[] args) {
        System.out.println("Test de Plateau");
        System.out.println("création d'un plateau plato");
        Plateau plato = new Plateau();
        System.out.println(plato);

        System.out.println("Test de getCase(31) --> GaJ en B4");
        ArrayList<Piece> p1 = plato.getCase(31);
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
        System.out.println(plato.getPiecesTache());

        System.out.println();

        System.out.println("Test de getPiecesNoires");
        System.out.println(plato.getPiecesEnnemi());

        System.out.println();

        System.out.println("Test de getPiecesJoueurs");
        System.out.println(plato.getPiecesJoueur());

        Piece p = new Piece("gamin", 'J', "B4");
        // plato.remove(p);
        // System.out.println(plato);

        System.out.println("Déplacer");
        plato.deplacer(p, new Position(1, 3), new Position(2, 3));
        System.out.println(plato);
    }
}
