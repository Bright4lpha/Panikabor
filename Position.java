class Position {
    // attributs
    private int x;
    private int y;

    // methodes
    // constructeur par défaut
    public Position() {
        x = 0;
        y = 0;
    }
    
    // constructeur par copie
    public Position(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }
    
    // constructeur avec deux paramètres
    public Position(int a, int b) {
        x = a;
        y = b;
    }

    // constructeur avec chaine de caractère
    public Position(String chaine) {
        // test la lettre
        if (chaine.charAt(0) == 'A') {
            this.x = 0;
        }
        else if (chaine.charAt(0) == 'B') {
            this.x = 1;
        }
        else if (chaine.charAt(0) == 'C') {
            this.x = 2;
        }
        else if (chaine.charAt(0) == 'D') {
            this.x = 3;
        }
        else if (chaine.charAt(0) == 'E') {
            this.x = 4;
        }
        else if (chaine.charAt(0) == 'F') {
            this.x = 5;
        }
        else if (chaine.charAt(0) == 'G') {
            this.x = 6;
        }
        else if (chaine.charAt(0) == 'H') {
            this.x = 7;
        }

        // teste le chiffre
        if (chaine.charAt(1) == '1') {
            this.y = 0;
        }
        else if (chaine.charAt(1) == '2') {
            this.y = 1;
        }
        else if (chaine.charAt(1) == '3') {
            this.y = 2;
        }
        else if (chaine.charAt(1) == '4') {
            this.y = 3;
        }
        else if (chaine.charAt(1) == '5') {
            this.y = 4;
        }
        else if (chaine.charAt(1) == '6') {
            this.y = 5;
        }
        else if (chaine.charAt(1) == '7') {
            this.y = 6;
        }
        else if (chaine.charAt(1) == '8') {
            this.y = 7;
        }
    }

    // getter
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    // setter
    public void setX(int a) {
        x = a;
    }
    public void setY(int a) {
        y = a;
    }

    // equals
    public boolean equals(Object obj) {
        boolean egaux = false;
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                Position other = (Position) obj;
                if ((this.x == other.x)&&(this.y == other.y)){
                    egaux = true;
                }
            }
            else {
                egaux = false;
            }
        }
        else {
            egaux = false;
        }
        return egaux;
    }

    public String toString() {
        String chaine = "" ;
        // teste le x
        if (this.x == 0) {
            chaine += 'A';
        }
        else if (this.x == 1) {
            chaine += 'B';
        }
        else if (this.x == 2) {
            chaine += 'C';
        }
        else if (this.x == 3) {
            chaine += 'D';
        }
        else if (this.x == 4) {
            chaine += 'E';
        }
        else if (this.x == 5) {
            chaine += 'F';
        }
        else if (this.x == 6) {
            chaine += 'G';
        }
        else if (this.x == 7) {
            chaine += 'H';
        }

        // teste le y
        if (this.y == 0) {
            chaine += '1';
        }
        else if (this.y == 1) {
            chaine += '2';
        }
        else if (this.y == 2) {
            chaine += '3';
        }
        else if (this.y == 3) {
            chaine += '4';
        }
        else if (this.y == 4) {
            chaine += '5';
        }
        else if (this.y == 5) {
            chaine += '6';
        }
        else if (this.y == 6) {
            chaine += '7';
        }
        else if (this.y == 7) {
            chaine += '8';
        }
        return chaine;
    }

    public static void main(String[] args) {
        System.out.println("Test de Position");
        Position a = new Position();
        System.out.println("Constructeur");
        System.out.println(a);

        Position copy = new Position(5,2);
        System.out.println("Constructeur par paramètre (5,2)");
        System.out.println(copy);

        Position b = new Position(copy);
        System.out.println("Constructeur par copie de (5,2)");
        System.out.println(b);

        Position c = new Position("D5");
        System.out.println("Constructeur par chaine de D5");
        System.out.println(c);

        System.out.println("getX de (5,2)");
        System.out.println(copy.getX());

        System.out.println("getY de (5,2)");
        System.out.println(copy.getY());

        System.out.println("setX de (5,2) en 7");
        copy.setX(7);
        System.out.println(copy);

        System.out.println("setY de (7,2) en 6");
        copy.setY(6);
        System.out.println(copy);

        System.out.println("equals de (7,6) et (5,2)");
        boolean bool = copy.equals(b);
        System.out.println(bool);

        System.out.println("equals de (7,6) et (7,6)");
        Position d = new Position(7, 6);
        bool = copy.equals(d);
        System.out.println(bool);

        System.out.println("to string de (0,4)");
        Position e = new Position(0,4);
        String str = e.toString();
        System.out.println(str);

    }
}