import java.util.ArrayList;
import MG2D.*;
import MG2D.geometrie.*;

public class Capitaine extends Joueur {
    
    public Capitaine() {
        this.position = new Position(0,1);
        this.indice = 0;
        this.pv = 4;
    }
    
    // constructeur par copie
    public Capitaine(Capitaine p) {
        this.position = p.getPosition();
        this.indice = p.getIndice();
        this.pv = 4;
    }
    
    // constructeur avec paramètres int
    public Capitaine(int x, int y, int i) {
        this.position = new Position(x, y);
        this.indice = i;
        this.pv = 4;
    }
    
    // constructeur avec paramètres position
    public Capitaine(Position pos, int i) {
        this.position = new Position(pos);
        this.indice = i;
        this.pv = 4;
    }

    // constructeur avec paramètres string
    public Capitaine(String str, int i) {
        this.position = new Position(str);
        this.indice = i;
        this.pv = 4;
    }

    // Accesseurs //

    // Getter //

    public String getNom() {
        return "capitaine";
    }

    public int getPV() {
        return this.pv;
    }

    public ArrayList<Position> getDeplacementPossible(Plateau p) {
        ArrayList<Position> pos = new ArrayList<Position>();
        int x = this.position.getX();
        int y = this.position.getY(); 
        // en haut à droite
        if ((0<x+1)&&(x+1<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x+1, y+1).size() < 4) {
                pos.add(new Position(x+1, y+1));
            }
        }
        // à droite
        if ((0<x+1)&&(x+1<7)&&(0<y)&&(y<6)) {
            if (p.getCase(x+1, y).size() < 4) {
                pos.add(new Position(x+1, y));
            }
        }
        // en bas à droite
        if ((0<x+1)&&(x+1<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x+1, y-1).size() < 4) {
                pos.add(new Position(x+1, y-1));
            }
        }
        // en bas
        if ((0<x)&&(x<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x, y-1).size() < 4) {
                pos.add(new Position(x, y-1));
            }
        }
        // en bas à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y-1)&&(y-1<6)) {
            if (p.getCase(x-1, y-1).size() < 4) {
                pos.add(new Position(x-1, y-1));
            }
        }
        // à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y)&&(y<6)) {
            if (p.getCase(x+1, y+1).size() < 4) {
                pos.add(new Position(x-1, y));
            }
        }
        // en haut à gauche
        if ((0<x-1)&&(x-1<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x-1, y+1).size() < 4) {
                pos.add(new Position(x-1, y+1));
            }
        }
        // en haut
        if ((0<x)&&(x<7)&&(0<y+1)&&(y+1<6)) {
            if (p.getCase(x, y+1).size() < 4) {
                pos.add(new Position(x, y+1));
            }
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
        return pos;
    }

    /**
     * Fonction de lancer de dé à 6 faces
     * @return int
     */
    public int lancer_de() {
        return (int)((Math.random() * (5 + 1))+1);
    }
    

    // Les capacités sont effectués AVANT les combats.
    // Le but est d'éviter le combat ou l'annuler
    // Capitaine ne peut annuler aucun combat
    public boolean capacite(Piece Ennemi, Fenetre f) {
        return false;
    }

    public ArrayList<Integer> combat(Piece ennemi, Fenetre f) {
        // combat avec clic ?
        ArrayList<Integer> temp = new ArrayList<Integer>();

        // Combat fcombat = new Combat(f);
        // fcombat.afficher(ennemi, this, f);
        boolean en_cours = true;
        Fenetre fcombat = new Fenetre("Combat", 1100, 700);
        Combat affiche_combat = new Combat(fcombat);
        affiche_combat.afficher(ennemi, this, fcombat);
        Souris souris = fcombat.getSouris();
        Point pos;
        Position actual_pos_souris = new Position(-1, -1);
        int de_joueur=0;

        while (en_cours==true) {
            try {
                Thread.sleep(30);
            } catch (Exception e) {}
            if (souris.getClicGauche()) {
                pos = new Point(souris.getPosition());
                actual_pos_souris.setX(pos.getX()/100);
                actual_pos_souris.setY(pos.getY()/100);

                int res = affiche_combat.deplacements_souris(fcombat, pos);
                if (res == 0) {
                    // lancer le dé
                    res = 1;
                    de_joueur = this.lancer_de();
                    temp.add(de_joueur);
                    affiche_combat.afficher_de(de_joueur, fcombat);
                    if (de_joueur > 3) {
                        affiche_combat.afficher_vic(fcombat);
                        temp.add(1);
                        try {
                            Thread.sleep(1500);
                        } catch (Exception e) {}
                        fcombat.fermer();
                        en_cours = false;
                    }   
                    else {
                        // System.out.println("PV : " + this.getPV());
                        this.pv = this.pv -1;
                        // System.out.println("PV : " + this.getPV());
                        affiche_combat.afficher_perdu(fcombat);
                        temp.add(0);
                        try {
                            Thread.sleep(1500);
                        } catch (Exception e) {}
                        fcombat.fermer();
                        en_cours = false;
                    }
                }
            }
        }
        return temp;
    }


public static void main(String[] args) {
    Piece ennemi = new Crituma(1,2,0);
    Piece capi = new Capitaine(1, 2, 1);
    Fenetre fenetre = new Fenetre("Mon jeu", 1000, 700);
    ArrayList<Integer> temp = new ArrayList<Integer>();
    temp = capi.combat(ennemi, fenetre);
    System.out.println(temp.size());
}

}