import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class MainGraphique {
    
    public MainGraphique(Fenetre f, Plateau plato) {
        for (int i=0;i<8;i++) { // lignes
            for (int j=0;j<7;j++) { // colonnes
                if ((i==0) | (i==7) | (j==0) | (j==6)) {
                    f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==1 && (j==1|j==5))) | ((i==5 && (j==1|j==5)))){
                    f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==6 && (j==1|j==2|j==4|j==5)))) {
                    f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if ((i%2==0 && j%2==1) | (i%2==1 && j%2==0)) {
                    f.ajouter(new Carre(Couleur.BLANC, new Point(i*100, j*100), 100, true));
                }
                else {
                    f.ajouter(new Carre(Couleur.GRIS_FONCE, new Point(i*100, j*100), 100, true));
                }
            }
        }
        // ajout des pieces sur le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                ArrayList<Piece> pieces = new ArrayList<Piece>();
                pieces = plato.getCase(i, j);
                if (pieces.size() != 0) {
                    if (pieces.size() == 1) {
                        f.ajouter(new Texture("./images/" + pieces.get(0).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                    }
                    else if (pieces.size() == 2) {
                        f.ajouter(new Texture("./images/" + pieces.get(0).getNomLong() + ".png", new Point(i * 100, j * 100), 50, 50));
                        f.ajouter(new Texture("./images/" + pieces.get(1).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)+50), 50, 50));
                    }
                }   
        f.rafraichir(); 
            }
        }   
    }

    public void afficher_cercle(Fenetre f, ArrayList<Position> dep) {
        int x, y;
        for (Position p : dep) {
            x = p.getX()*100+50;
            y = p.getY()*100+50;
            for (int i = 0; i <5; i++) {
                f.ajouter(new Cercle(Couleur.ROUGE, new Point(x,y), 45+i));
            }
            f.rafraichir();
        }
    }

    public void supprimer_cercle(Fenetre f, ArrayList<Position> dep) {
        int x, y;
        for (Position p : dep) {
            x = p.getX()*100+50;
            y = p.getY()*100+50;
            for (int i = 0; i <5; i++) {
                f.supprimer(new Cercle(Couleur.ROUGE, new Point(x,y), 45+i));
            }
            f.rafraichir();
        }
    }

    public void deplacements_possibles_pieces(Fenetre f, Position p, Plateau plato) {
        ArrayList<Piece> pieces = plato.getCase(p);
        ArrayList<Position> pieces_poss;
        if (pieces.size() != 0) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
                this.afficher_cercle(f, pieces_poss);
            }
        }
    }

    public void retirer_deplacements_possibles_pieces(Fenetre f, Position p, Plateau plato) {
        ArrayList<Piece> pieces = plato.getCase(p);
        ArrayList<Position> pieces_poss;
        if (pieces.size() != 0) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
            this.supprimer_cercle(f, pieces_poss);
            }
        }
    }

    public boolean deplacements_souris(Fenetre f, Position from, Position to, Plateau plato) {
        boolean dep_piece = false;
        ArrayList<Piece> piece_from = plato.getCase(from);
        ArrayList<Piece> piece_to = plato.getCase(to);
        ArrayList<Position> pieces;

        // si il y a une piece sur la case de départ
        if (piece_from.size() != 0) {            
            // récupère les déplacements possibles de la pièce
            if (piece_from.size() == 1) {
                pieces = piece_from.get(0).getDeplacementPossible(plato);

            // Le clic est-il un déplacement ?
            // est-ce que la position d'arrivée est dans les déplacements possibles
            boolean trouve = pieces.contains(to);
            // si oui
            if (trouve == true) {
                plato.deplacer(from, to); // déplace la pièce sur le plateau
                this.supprimer_cercle(f, pieces); // supprime les cercles
                dep_piece = true;
                f.rafraichir();
            }
            // si non
            else {
                this.retirer_deplacements_possibles_pieces(f, from, plato);
                // si la pièce d'arriver est de la couleur du joueur
                if (piece_to.size() != 0) {
                    this.deplacements_possibles_pieces(f, to, plato);
                }
                
                f.rafraichir();
                
            }
            }
            
        }
        else {
            if (piece_to.size() != 0) {
                    this.retirer_deplacements_possibles_pieces(f, from, plato);
                    this.deplacements_possibles_pieces(f, to, plato);
                    f.rafraichir();
            }
        }
        f.rafraichir();
        return dep_piece;
    }
}