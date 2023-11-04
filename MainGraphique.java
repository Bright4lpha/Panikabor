// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class MainGraphique {

    // public MainGraphique(Fenetre f) {
    //     f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 100), 150, 100, true));
    //     f.ajouter(new Rectangle(Couleur.CYAN, new Point(550, 100), 150, 100, true));
    //     f.ajouter(new Rectangle(Couleur.CYAN, new Point(300, 300), 400, 100, true));
    //     f.ajouter(new Rectangle(Couleur.MAGENTA, new Point(300, 500), 400, 100, true));
    // }
    
    public MainGraphique(Fenetre f, Plateau plato) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        for (int i=0;i<10;i++) { // lignes
            for (int j=0;j<7;j++) { // colonnes
                if ((i==0) | (i==7) | (j==0) | (j==6)| (i==8) | (i==9)) {
                    //f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==1 && (j==1|j==5))) | ((i==5 && (j==1|j==5)))){
                    //f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==6 && (j==1|j==2|j==4|j==5)))) {
                    //f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if ((i%2==0 && j%2==1) | (i%2==1 && j%2==0)) {
                    f.ajouter(new Carre(Couleur.BLANC, new Point(i*100, j*100), 100, true));
                }
                else {
                    f.ajouter(new Carre(Couleur.GRIS_FONCE, new Point(i*100, j*100), 100, true));
                }
            }
        }
        // f.ajouter(new Texture("./images/case_bureau.jpg", new Point(500, 400), 100, 100));
        // ajout des pieces sur le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                ArrayList<Piece> pieces_case = plato.getCase(i, j);
                // pour chaque piece de la case
                for (int a = 0; a < pieces_case.size(); a++) {
                    // si il n'y a qu'une piece sur la case
                    if (pieces_case.size() == 1) {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                        }
                    }
                    // si il y a plusieurs pièces
                    else {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 1) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 2) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100), (j * 100)+50), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 3) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)+50), 50, 50));
                        }
                    }
                    
                }
        f.ajouter(new Texture("./images/de.png", new Point(800, 300), 100, 100));
        f.ajouter(new Carre(Couleur.ROSE, new Point(0,340), 20, true));
        f.rafraichir(); 
            }
        }   
    }

    public void afficher(Fenetre f, Plateau plato) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        for (int i=0;i<10;i++) { // lignes
            for (int j=0;j<7;j++) { // colonnes
                if ((i==0) | (i==7) | (j==0) | (j==6)| (i==8) | (i==9)) {
                    // f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==1 && (j==1|j==5))) | ((i==5 && (j==1|j==5)))){
                    // f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==6 && (j==1|j==2|j==4|j==5)))) {
                    //f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if ((i%2==0 && j%2==1) | (i%2==1 && j%2==0)) {
                    f.ajouter(new Carre(Couleur.BLANC, new Point(i*100, j*100), 100, true));
                }
                else {
                    f.ajouter(new Carre(Couleur.GRIS_FONCE, new Point(i*100, j*100), 100, true));
                }
            }
        }
        f.ajouter(new Texture("./images/case_bureau.jpg", new Point(500, 400), 100, 100));
        // ajout des pieces sur le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                ArrayList<Piece> pieces_case = plato.getCase(i, j);
                // pour chaque piece de la case
                for (int a = 0; a < pieces_case.size(); a++) {
                    // si il n'y a qu'une piece sur la case
                    if (pieces_case.size() == 1) {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                        }
                    }
                    // si il y a plusieurs pièces
                    else {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 1) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 2) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100), (j * 100)+50), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 3) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)+50), 50, 50));
                        }
                    }
                    
                }
        f.ajouter(new Texture("./images/de.png", new Point(800, 300), 100, 100));
        f.ajouter(new Carre(Couleur.ROSE, new Point(0,340), 20, true));
        f.rafraichir(); 
            }
        }   
    }

    public void afficher(Fenetre f, Plateau plato) {
        // f.ajouter(new Rectangle(Couleur.BLANC, new Point(0,0), 1000, 700, true));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));
        for (int i=0;i<10;i++) { // lignes
            for (int j=0;j<7;j++) { // colonnes
                if ((i==0) | (i==7) | (j==0) | (j==6)| (i==8) | (i==9)) {
                    // f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==1 && (j==1|j==5))) | ((i==5 && (j==1|j==5)))){
                    // f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
                }
                else if (((i==6 && (j==1|j==2|j==4|j==5)))) {
                    // // f.ajouter(new Carre(Couleur.JAUNE, new Point(i*100, j*100), 100, true));
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
                ArrayList<Piece> pieces_case = plato.getCase(i, j);
                // pour chaque piece de la case
                for (int a = 0; a < pieces_case.size(); a++) {
                    // si il n'y a qu'une piece sur la case
                    if (pieces_case.size() == 1) {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                        }
                    }
                    // si il y a plusieurs pièces
                    else {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 1) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 2) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100), (j * 100)+50), 50, 50));
                        }
                        if (pieces_case.get(a).getIndice() == 3) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)+50), 50, 50));
                        }
                    }
                    
                }
        f.ajouter(new Texture("./images/de.png", new Point(800, 300), 100, 100));
        f.ajouter(new Carre(Couleur.ROSE, new Point(0,340), 20, true));
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
        if (pieces != null) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
                this.afficher_cercle(f, pieces_poss);
            }
        }
    }

    public void retirer_deplacements_possibles_pieces(Fenetre f, Position p, Plateau plato) {
        ArrayList<Piece> pieces = plato.getCase(p);
        ArrayList<Position> pieces_poss;
        if (pieces != null) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
            this.supprimer_cercle(f, pieces_poss);
            }
        }
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Crédits
        if ((to.getX()>=0) && (to.getX()<=20) && (to.getY()>=340) && (to.getY()<=360)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean deplacements_souris(Fenetre f, Position from, Position to, Plateau plato, int last_indice, int actual_indice) {
        boolean dep_piece = false;
        ArrayList<Piece> piece_from = plato.getCase(from);
        ArrayList<Piece> piece_to = plato.getCase(to);
        ArrayList<Position> pieces;

        // si il y a une piece sur la case de départ
        if (piece_from != null) {
            // récupère les déplacements possibles de la pièce
            System.out.println("piece_from : " + piece_from);
            System.out.println("bool : " + (piece_from == null));
            if (piece_from.size() == 0) {
                return dep_piece;
            }
            if (piece_from.size() == 1) {
                pieces = piece_from.get(0).getDeplacementPossible(plato);
            }
            else {
                if (last_indice == 0) {
                    pieces = piece_from.get(0).getDeplacementPossible(plato);
                }
                else if (last_indice == 1) {
                    pieces = piece_from.get(1).getDeplacementPossible(plato);
                }
                else if (last_indice == 2) {
                    pieces = piece_from.get(2).getDeplacementPossible(plato);
                }
                else {
                    pieces = piece_from.get(3).getDeplacementPossible(plato);
                }
            }
            System.out.println(pieces);

            // Le clic est-il un déplacement ?
            // est-ce que la position d'arrivée est dans les déplacements possibles
            boolean trouve = pieces.contains(to);
            System.out.println("trouve : " + trouve);
            // si oui
            if (trouve == true) {
                if (piece_from.size() == 1) {
                    plato.deplacer(piece_from.get(0), from, to, last_indice, actual_indice, f); // déplace la pièce sur le plateau
                }
                if (piece_from.size() > 1) {
                    System.out.println("deplace == 2");
                    plato.deplacer(piece_from.get(last_indice), from, to, last_indice, actual_indice, f); // déplace la pièce sur le plateau
                    f.rafraichir();
                }
                this.supprimer_cercle(f, pieces); // supprime les cercles
                dep_piece = true;
                f.rafraichir();
            }
            // si non
            else {
                this.retirer_deplacements_possibles_pieces(f, from, plato);
                // si la pièce d'arriver est de la couleur du joueur
                if (piece_to != null) {
                    this.deplacements_possibles_pieces(f, to, plato);
                }
                
                f.rafraichir();
                
            }
        }
        else {
            if (piece_to != null) {
                //if (piece_to.getCouleur() == joueur) {
                    this.retirer_deplacements_possibles_pieces(f, from, plato);
                    this.deplacements_possibles_pieces(f, to, plato);
                    f.rafraichir();
                //}
                // else {
                //     this.retirer_deplacements_possibles_pieces(f, to, plato);
                //     f.rafraichir();
                // }
            }
        }
        f.rafraichir();
        return dep_piece;
    }
    }
//}