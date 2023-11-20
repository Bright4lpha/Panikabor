import java.util.ArrayList;

import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Point;

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

    public void activation(Piece joueur) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean en_cours = true;
        Fenetre ftache = new Fenetre("Tâche", 1100, 700);
        ActivationTache affiche_tache = new ActivationTache(ftache);
        affiche_tache.afficher(joueur, ftache);
        Souris souris = ftache.getSouris();
        Point pos;
        Position actual_pos_souris = new Position(-1, -1);
        int de_joueur=0;

        while (en_cours==true) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {}
            if (souris.getClicGauche()) {
                pos = new Point(souris.getPosition());
                actual_pos_souris.setX(pos.getX()/100);
                actual_pos_souris.setY(pos.getY()/100);

                int res = affiche_tache.deplacements_souris(ftache, pos);
                if (res == 0) {
                    // lancer le dé
                    res = 1;
                    de_joueur = this.lancer_de();
                    temp.add(de_joueur);
                    affiche_tache.afficher_de(de_joueur, ftache);
                    if (de_joueur > 4) {
                        affiche_tache.afficher_vic(joueur, de_joueur, ftache);
                        temp.add(1);
                        try {
                            Thread.sleep(1500);
                        } catch (Exception e) {}
                        ftache.fermer();
                        en_cours = false;
                        this.active = true;
                    }   
                    else {
                        affiche_tache.afficher_perdu(ftache);
                        temp.add(0);
                        try {
                            Thread.sleep(1500);
                        } catch (Exception e) {}
                        ftache.fermer();
                        en_cours = false;
                    }
                }
            }
        }
    }
}
