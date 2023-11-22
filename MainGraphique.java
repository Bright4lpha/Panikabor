// import java.lang.reflect.Array;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

class MainGraphique {
    
    public MainGraphique(Fenetre f, Plateau plato) {
        f.supprimer(new Texture("./images/space.png", new Point(0, 0)));
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Texture("./images/case1.png", new Point(500, 300), 100, 100));
        f.ajouter(new Texture("./images/case2.png", new Point(400, 300), 100, 100));
        f.ajouter(new Texture("./images/case3.png", new Point(300, 300), 100, 100));
        f.ajouter(new Texture("./images/case4.png", new Point(200, 300), 100, 100));
        f.ajouter(new Texture("./images/case5.png", new Point(600, 300), 100, 100));
        f.ajouter(new Texture("./images/case6.png", new Point(100, 300), 100, 100));

        f.ajouter(new Texture("./images/case7.png", new Point(100, 200), 100, 100));
        f.ajouter(new Texture("./images/case8.png", new Point(200, 200), 100, 100));
        f.ajouter(new Texture("./images/case9.png", new Point(300, 200), 100, 100));
        f.ajouter(new Texture("./images/case10.png", new Point(400, 200), 100, 100));
        f.ajouter(new Texture("./images/case11.png", new Point(500, 200), 100, 100));

        f.ajouter(new Texture("./images/case12.png", new Point(200, 100), 100, 100));
        f.ajouter(new Texture("./images/case13.png", new Point(300, 100), 100, 100));
        f.ajouter(new Texture("./images/case14.png", new Point(400, 100), 100, 100));

        f.ajouter(new Texture("./images/case15.png", new Point(200, 500), 100, 100));
        f.ajouter(new Texture("./images/case16.png", new Point(300, 500), 100, 100));
        f.ajouter(new Texture("./images/case18.png", new Point(400, 500), 100, 100));

        f.ajouter(new Texture("./images/case18.png", new Point(500, 400), 100, 100));
        f.ajouter(new Texture("./images/case19.png", new Point(400, 400), 100, 100));
        f.ajouter(new Texture("./images/case20.png", new Point(300, 400), 100, 100));
        f.ajouter(new Texture("./images/case21.png", new Point(200, 400), 100, 100));
        f.ajouter(new Texture("./images/case22.png", new Point(100, 400), 100, 100));

        // f.ajouter(new Texture("./images/reacteur.png", new Point(100, 100), 100, 100));
        // f.ajouter(new Texture("./images/reacteur.png", new Point(100, 500), 100, 100));

        // ajout des pieces sur le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                // affichage des tâches
                ArrayList<Tache> taches = plato.getPiecesTache();
                for (int t=0; t < taches.size(); t++) {
                    if (taches.get(t).getPosition().equals(new Position(i, j))) {
                        if (taches.get(t).getActive()==true) {
                            f.ajouter(new Texture("./images/tache_A.png", new Point(i*100, j*100), 100, 100));
                        }
                        else {
                            f.ajouter(new Texture("./images/tache_D.png", new Point(i*100, j*100), 100, 100));
                        }
                    }
                }

                ArrayList<Piece> pieces_case = plato.getCase(i, j);
                // pour chaque piece de la case
                for (int a = 0; a < pieces_case.size(); a++) {
                    // si il n'y a qu'une piece sur la case
                    if (pieces_case.size() == 1) {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                            this.affichePV(f, pieces_case.get(a));
                        }
                    }
                    // si il y a plusieurs pièces
                    else {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 50, 50));
                            this.affichePV(f, pieces_case.get(a));
                        }
                        if (pieces_case.get(a).getIndice() == 1) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)), 50, 50));
                            this.affichePV(f, pieces_case.get(a));
                        }
                        if (pieces_case.get(a).getIndice() == 2) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100), (j * 100)+50), 50, 50));
                            this.affichePV(f, pieces_case.get(a));
                        }
                        if (pieces_case.get(a).getIndice() == 3) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point((i * 100)+50, (j * 100)+50), 50, 50));
                            this.affichePV(f, pieces_case.get(a));
                        }
                    }
                    
                }
        f.ajouter(new Texture("./images/de.png", new Point(800, 300), 100, 100));
        f.ajouter(new Texture("./images/retour_2.png", new Point(0,300)));
        // f.ajouter(new Carre(Couleur.ROSE, new Point(0,340), 20, true));
        f.rafraichir(); 
            }
        }   
    }

    public void afficher(Fenetre f, Plateau plato) {
        f.ajouter(new Texture("./images/space.png", new Point(0, 0)));

        f.ajouter(new Texture("./images/case1.png", new Point(500, 300), 100, 100));
        f.ajouter(new Texture("./images/case2.png", new Point(400, 300), 100, 100));
        f.ajouter(new Texture("./images/case3.png", new Point(300, 300), 100, 100));
        f.ajouter(new Texture("./images/case4.png", new Point(200, 300), 100, 100));
        f.ajouter(new Texture("./images/case5.png", new Point(600, 300), 100, 100));
        f.ajouter(new Texture("./images/case6.png", new Point(100, 300), 100, 100));

        f.ajouter(new Texture("./images/case7.png", new Point(100, 400), 100, 100));
        f.ajouter(new Texture("./images/case8.png", new Point(200, 400), 100, 100));
        f.ajouter(new Texture("./images/case9.png", new Point(300, 400), 100, 100));
        f.ajouter(new Texture("./images/case10.png", new Point(400, 400), 100, 100));
        f.ajouter(new Texture("./images/case11.png", new Point(500, 400), 100, 100));

        f.ajouter(new Texture("./images/case12.png", new Point(200, 500), 100, 100));
        f.ajouter(new Texture("./images/case13.png", new Point(300, 500), 100, 100));
        f.ajouter(new Texture("./images/case14.png", new Point(400, 500), 100, 100));

        f.ajouter(new Texture("./images/case15.png", new Point(200, 100), 100, 100));
        f.ajouter(new Texture("./images/case16.png", new Point(300, 100), 100, 100));
        f.ajouter(new Texture("./images/case18.png", new Point(400, 100), 100, 100));

        f.ajouter(new Texture("./images/case18.png", new Point(500, 200), 100, 100));
        f.ajouter(new Texture("./images/case19.png", new Point(400, 200), 100, 100));
        f.ajouter(new Texture("./images/case20.png", new Point(300, 200), 100, 100));
        f.ajouter(new Texture("./images/case21.png", new Point(200, 200), 100, 100));
        f.ajouter(new Texture("./images/case22.png", new Point(100, 200), 100, 100));

        // f.ajouter(new Texture("./images/reacteur.png", new Point(100, 100), 100, 100));
        // f.ajouter(new Texture("./images/reacteur.png", new Point(100, 500), 100, 100));

        // f.ajouter(new Texture("./images/case_bureau.jpg", new Point(500, 400), 100, 100));
        // ajout des pieces sur le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                // affichage des tâches
                ArrayList<Tache> taches = plato.getPiecesTache();
                for (int t=0; t < taches.size(); t++) {
                    if (taches.get(t).getPosition().equals(new Position(i, j))) {
                        if (taches.get(t).getActive()==true) {
                            f.ajouter(new Texture("./images/tache_A.png", new Point(i*100, j*100), 100, 100));
                        }
                        else {
                            f.ajouter(new Texture("./images/tache_D.png", new Point(i*100, j*100), 100, 100));
                        }
                    }
                }
                
                ArrayList<Piece> pieces_case = plato.getCase(i, j);
                // pour chaque piece de la case
                for (int a = 0; a < pieces_case.size(); a++) {
                    // si il n'y a qu'une piece sur la case
                    if (pieces_case.size() == 1) {
                        if (pieces_case.get(a).getIndice() == 0) {
                            f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(i * 100, j * 100), 100, 100));
                            if (pieces_case.get(a).getNom().equals("capitaine")) {
                                f.ajouter(new Texture("./images/" + pieces_case.get(a).getNomLong() + ".png", new Point(0, 0), 100, 100));
                            }
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
        f.ajouter(new Texture("./images/retour_2.png", new Point(0,300)));
        f.rafraichir(); 
            }
        }   
    }

    public void affichePV(Fenetre f, Piece p) {
        if (p.getNom().equals("capitaine")) {
            f.ajouter(new Texture("./images/" + p.getNomLong() + ".png", new Point(0, 0), 100, 100));
            f.ajouter(new Texture("./images/pv_" + p.getPV() + ".png", new Point(100, 0), 100, 100));
        }
        if (p.getNom().equals("bibledum")) {
            f.ajouter(new Texture("./images/" + p.getNomLong() + ".png", new Point(900, 0), 100, 100));
            f.ajouter(new Texture("./images/pv_" + p.getPV() + ".png", new Point(800, 0), 100, 100));
        }
        if (p.getNom().equals("mecano")) {
            f.ajouter(new Texture("./images/" + p.getNomLong() + ".png", new Point(0, 600), 100, 100));
            f.ajouter(new Texture("./images/pv_" + p.getPV() + ".png", new Point(100, 600), 100, 100));
        }
        if (p.getNom().equals("gamin")) {
            f.ajouter(new Texture("./images/" + p.getNomLong() + ".png", new Point(900, 600), 100, 100));
            f.ajouter(new Texture("./images/pv_" + p.getPV() + ".png", new Point(800, 600), 100, 100));
        }
        f.rafraichir();
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

    public void afficher_tour(Fenetre f, Piece joueur) {
        String nom = joueur.getNom();
        if (nom.equals("capitaine")) {
            for (int i = 0; i <5; i++) {
                f.ajouter(new Cercle(Couleur.ROUGE, new Point(50, 50), 45+i));
            }
        }
        if (nom.equals("bibledum")) {
            for (int i = 0; i <5; i++) {
                f.ajouter(new Cercle(Couleur.ROUGE, new Point(950, 50), 45+i));
            }
        }
        if (nom.equals("mecano")) {
            for (int i = 0; i <5; i++) {
                f.ajouter(new Cercle(Couleur.ROUGE, new Point(50, 650), 45+i));
            }
        }
        if (nom.equals("gamin")) {
            for (int i = 0; i <5; i++) {
                f.ajouter(new Cercle(Couleur.ROUGE, new Point(950, 650), 45+i));
            }
        }
    }

    public void deplacements_possibles_pieces(Fenetre f, Position p, Plateau plato, int actual_indice) {
        ArrayList<Piece> pieces = plato.getCase(p);
        ArrayList<Position> pieces_poss;
        if (pieces != null) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
                this.afficher_cercle(f, pieces_poss);
            }
            else if ((pieces.size() > 1) && (pieces.size()<5)) {
                pieces_poss = pieces.get(actual_indice).getDeplacementPossible(plato);
                this.afficher_cercle(f, pieces_poss);
            }
        }
    }

    public void retirer_deplacements_possibles_pieces(Fenetre f, Position p, Plateau plato, int last_indice) {
        ArrayList<Piece> pieces = plato.getCase(p);
        ArrayList<Position> pieces_poss;
        if (pieces != null) {
            if (pieces.size() == 1) {
                pieces_poss = pieces.get(0).getDeplacementPossible(plato);
                this.supprimer_cercle(f, pieces_poss);
            }
            else if ((pieces.size() >= 2) && (pieces.size()<5)) {
                // System.out.println("pieces.size() : " + pieces.size());
                // System.out.println("pieces.get(actual_indice) : " + pieces.get(last_indice));
                pieces_poss = pieces.get(last_indice).getDeplacementPossible(plato);
                this.supprimer_cercle(f, pieces_poss);
            }
        }
    }

    public int deplacements_souris(Fenetre f, Point to) {
        // Crédits
        if ((to.getX()>=0) && (to.getX()<=250) && (to.getY()>=340) && (to.getY()<=360)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public int deplacements_souris(Fenetre f, Position from, Position to, Plateau plato, int last_indice, int actual_indice, String t, Piece actual_joueur) {
        int dep_piece = 0;
        ArrayList<Piece> piece_from = plato.getCase(from);
        ArrayList<Piece> piece_to = plato.getCase(to);
        ArrayList<Position> pieces;

        // si il y a une piece sur la case de départ
        if (piece_from != null) {
            // Si il n'y a pas de pièce au départ
            if (piece_from.size() == 0) {
                return dep_piece;
            }
            // Si il y a 1 pièce au départ
            else if (piece_from.size() == 1) {
                Piece p = piece_from.get(0);
                // System.out.println(p.getNomCourt());
                // System.out.println(t);
                // System.out.println(p.getNomCourt().substring(p.getNomCourt().length() - 1));
                if ((p.getNomCourt().substring(p.getNomCourt().length() - 1).equals(t))&&(p.equals(actual_joueur))) {
                    // System.out.println("position : " + p.getPosition());
                    pieces = piece_from.get(0).getDeplacementPossible(plato);
                    // System.out.println("pieces 1 " + pieces);
                }
                else {
                    Fenetre victoire = new Fenetre("Ce n'est pas ton tour !", 500, 200);
                    victoire.ajouter(new Texture("./images/space.png", new Point(0, 0)));
                    victoire.ajouter(new Texture("./images/tour.png", new Point(0, 0)));
                    victoire.rafraichir();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {}
                    victoire.fermer();
                    pieces = new ArrayList<Position>();
                }
            }
            else {
                Piece p;
                if (last_indice == 0) {
                    p = piece_from.get(0);
                    // pieces = piece_from.get(0).getDeplacementPossible(plato);
                }
                else if (last_indice == 1) {
                    p = piece_from.get(1);
                    // pieces = piece_from.get(1).getDeplacementPossible(plato);
                }
                else if (last_indice == 2) {
                    p = piece_from.get(2);
                    // pieces = piece_from.get(2).getDeplacementPossible(plato);
                }
                else {
                    p = piece_from.get(3);
                    // pieces = piece_from.get(3).getDeplacementPossible(plato);
                }
                if ((p.getNomCourt().substring(p.getNomCourt().length() - 1).equals(t))&&(p.equals(actual_joueur))) {
                    pieces = p.getDeplacementPossible(plato);
                    // System.out.println(pieces);
                }
                else {
                    Fenetre victoire = new Fenetre("Ce n'est pas ton tour !", 500, 200);
                    victoire.ajouter(new Texture("./images/tour.png", new Point(0, 000)));
                    victoire.rafraichir();
                    try {  
                        Thread.sleep(1000);
                    } catch (Exception e) {}
                    victoire.fermer();
                    pieces = new ArrayList<Position>();
                }
            }
            // System.out.println(pieces);
            // Le clic est-il un déplacement ?
            // est-ce que la position d'arrivée est dans les déplacements possibles
            boolean trouve = pieces.contains(to);
            // System.out.println("trouve : " + trouve);
            // si oui
            if (trouve == true) {
                if ((piece_from.size() == 1)&&(piece_to.size()<5)) {
                    int mort = 0;
                    mort = plato.deplacer(piece_from.get(0), from, to, last_indice, actual_indice, f); // déplace la pièce sur le plateau
                    this.supprimer_cercle(f, pieces); // supprime les cercles
                    if (mort == 1){
                        dep_piece = 2;
                    }
                    else {
                        dep_piece = 1;
                    }
                    
                    f.rafraichir();
                }
                if ((piece_from.size() > 1)&&(piece_to.size()<5)) {
                    // System.out.println("deplace == 2");
                    int mort = 0;
                    mort = plato.deplacer(piece_from.get(last_indice), from, to, last_indice, actual_indice, f); // déplace la pièce sur le plateau
                    //f.rafraichir();
                    this.supprimer_cercle(f, pieces); // supprime les cercles
                    if (mort == 1){
                        dep_piece = 2;
                    }
                    else {
                        dep_piece = 1;
                    }
                    f.rafraichir();
                }
                // this.supprimer_cercle(f, pieces); // supprime les cercles
                // dep_piece = true;
                // f.rafraichir();
            }
            // si non
            else {
                this.retirer_deplacements_possibles_pieces(f, from, plato, last_indice);
                // si la pièce d'arriver est de la couleur du joueur
                if (piece_to != null) {
                    this.deplacements_possibles_pieces(f, to, plato, actual_indice);
                }
                
                f.rafraichir();
                
            }
        }
        else {
            if (piece_to != null) {
                //if (piece_to.getCouleur() == joueur) {
                    this.retirer_deplacements_possibles_pieces(f, from, plato, last_indice);
                    this.deplacements_possibles_pieces(f, to, plato, actual_indice);
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

    public void deplacementEnnemi(Plateau plato, Piece p, Fenetre f) {
        ArrayList<Position> positions = p.getDeplacementPossible(plato);
        int indice = (int)((Math.random() * (positions.size()))+0);
        System.out.println(positions.get(indice));
        plato.deplacer(p, p.getPosition(), positions.get(indice), p.getIndice(), 0, f);
        f.rafraichir();
    }
}