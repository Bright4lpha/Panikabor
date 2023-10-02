import java.util.ArrayList;
import MG2D.*;
import MG2D.geometrie.*;
class Plateau {
    // attributs
    private ArrayList<ArrayList<Piece>> plateau = new ArrayList<ArrayList<Piece>>();
    public ArrayList<Position> interdit = new ArrayList<Position>();

    // methodes
    public Plateau() {
        for (int i = 0; i <= 70; i++) {
            this.plateau.add(new ArrayList<Piece>());
        }
        this.plateau.get(34).add(new Piece("mecano", 'J', "E4", 0));//34
        this.plateau.get(34).add(new Piece("capitaine", 'J', "E4", 1));//34
        this.plateau.get(13).add(new Piece("tache", 'T', "D2", 0));//13
        this.plateau.get(31).add(new Piece("gamin", 'J', "B4", 0));//31
        this.plateau.get(53).add(new Piece("tentacule", 'E', "D6", 0));//53
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

    public ArrayList<Piece> getCase(int a, int b) {
        if (a<0 || b<0) {
            return null;
        }
        String chaine = "" + b + a;
        return this.plateau.get(Integer.parseInt(chaine));
    }

    public ArrayList<Piece> getCase(Position pos) {
        if (pos.getX()<0 || pos.getY()<0) {
            return null;
        }
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
                        tache.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition(), p.get(i).getIndice()));
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
                        ennemi.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition(), p.get(i).getIndice()));
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
                        joueur.add(new Piece(p.get(i).getNom(), p.get(i).getType(), p.get(i).getPosition(), p.get(i).getIndice()));
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

    public void remove(int c, int indice) {
        Piece p = this.getCase(c).get(indice);
        this.remove(p);
    }

    public void deplacer(Piece p, Position from, Position to, int last_indice, int actual_indice) {
        ArrayList<Piece> piece_from = this.getCase(from);
        ArrayList<Piece> piece_to = this.getCase(to);

        // // retirer la piece et décaler les pièces existantes
        // this.remove(p);
        // if (piece_from.size() > 1) {
        //     System.out.println("la liste est bien supérieure à 1");
        //     for (int i = 0; i <= piece_from.size(); i++) {
        //         Piece piece = piece_from.get(i);
        //         int ind = piece.getIndice();
        //         piece.setIndice(ind-1);
        //     }
        // }
        
        // // if (piece_to.size() > 0) {
        // //     p.setIndice(piece_to.size());
        // // }
        // else {
        //     p.setIndice(0);
        // }
        // // si la case de départ ne contient qu'une pièce
        // //piece_from.get(indice).setPosition(to);
        // p.setPosition(to);
        // this.getCase(to).add(p);

        if (piece_from.size() > 1) {
            if (piece_from.size() == last_indice+1) {
                this.remove(p);
            }
            else {
                if (piece_from.size() == 2) {
                    if (last_indice == 0) {
                        Piece piece = piece_from.get(1);
                        this.remove(p);
                        this.remove(piece);
                        piece.setIndice(0);
                        this.getCase(from).add(piece);
                    }
                }
                if (piece_from.size() == 3) {
                    if (last_indice == 0) {
                        Piece piece = piece_from.get(1);
                        Piece piece_2 = piece_from.get(2);
                        this.remove(p);
                        this.remove(piece);
                        this.remove(piece_2);
                        piece.setIndice(0);
                        piece_2.setIndice(1);
                        this.getCase(from).add(piece);
                        this.getCase(from).add(piece_2);
                    }
                    if (last_indice == 1) {
                        Piece piece_2 = piece_from.get(2);
                        this.remove(p);
                        this.remove(piece_2);
                        piece_2.setIndice(1);
                        this.getCase(from).add(piece_2);
                    }
                }
                if (piece_from.size() == 4) {
                    if (last_indice == 0) {
                        Piece piece_1 = piece_from.get(1);
                        Piece piece_2 = piece_from.get(2);
                        Piece piece_3 = piece_from.get(3);
                        this.remove(p);
                        this.remove(piece_1);
                        this.remove(piece_2);
                        this.remove(piece_3);
                        piece_1.setIndice(0);
                        piece_2.setIndice(1);
                        piece_3.setIndice(2);
                        this.getCase(from).add(piece_1);
                        this.getCase(from).add(piece_2);
                        this.getCase(from).add(piece_3);
                    }
                    if (last_indice == 1) {
                        Piece piece_2 = piece_from.get(2);
                        Piece piece_3 = piece_from.get(3);
                        this.remove(p);
                        this.remove(piece_2);
                        this.remove(piece_3);
                        piece_2.setIndice(1);
                        piece_3.setIndice(2);
                        this.getCase(from).add(piece_2);
                        this.getCase(from).add(piece_3);
                    }
                    if (last_indice == 2) {
                        Piece piece_3 = piece_from.get(3);
                        this.remove(p);
                        this.remove(piece_3);
                        piece_3.setIndice(2);
                        this.getCase(from).add(piece_3);
                    }
                }
            }
            
        }
        else {
            this.remove(p);
        }


        // Bien placer la pièce sur la case d'arrivée
        // Y a t il un ennemi sur la case d'arrivée
        boolean ennemi = false;
        for (int i = 0; i < piece_to.size(); i++) {
            if (piece_to.get(i).getType() == 'E') {
                ennemi = true;
            }
        }
        if (p.getType() == 'J' && ennemi==true) {
            int de = this.lancer_de();
            System.out.println("Lancer de dé : " + de);
        }
        p.setPosition(to);
        p.setIndice(piece_to.size());
        this.getCase(to).add(p);
    }

    /**
     * Fonction qui renvoie l'indice de la piece sur la case
     * à partir de la position du clic de la souris
     * @param a 
     * @param b
     * @return int
     */
    public int trouve_indice(int a, int b) {
        int indice = 0;
        // connaitre l'indice de la pièce sur la case
        if (((a%100)>=50)&&((b%100)>=50)) {
            indice = 3;
        }
        if (((a%100)>=50)&&((b%100)<50)) {
            indice = 1;
        }
        if (((a%100)<50)&&((b%100)>=50)) {
            indice = 2;
        }
        if (((a%100)<50)&&((b%100)<50)) {
            indice = 0;
        }
        return indice;
    }

    /**
     * Fonction de lancer de dé à 6 faces
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+1);
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

        // Piece p = new Piece("gamin", 'J', "B4", 0);
        // plato.remove(p);
        // plato.remove(31,0);
        // System.out.println(plato);

        System.out.println("Déplacer");
        // plato.deplacer(p, new Position(1, 3), new Position(2, 3));
        // System.out.println(plato);

        System.out.println("Lancer de dé : " + plato.lancer_de());
        for (int i = 0; i < 10; i++) {
            System.out.println(plato.lancer_de());
        }
    }
}
