package carte;

public class Aventurier {
	private String nom;
    private int x;
    private int y;
    private char orientation;
    private String sequence;
    private int tresorsCollectes;
    
    

    public Aventurier(String nom, int x, int y, char orientation, String sequence) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.sequence = sequence;
        this.tresorsCollectes = 0;
    }
    
    
 // Getters et Setters pour les attributs de l'aventurier

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public int getTresorsCollectes() {
    	return tresorsCollectes;
    }

	public void setTresorsCollectes(int tresorsCollectes) {
		this.tresorsCollectes = tresorsCollectes;
	}
    
    

    /**
     * Exécute chaque mouvement de la séquence définie pour l'aventurier.
     * @param carte La carte sur laquelle l'aventurier évolue.
     */
    public void executerMouvement(Carte carte) {
        for (char move : sequence.toCharArray()) {
            switch (move) {
                case 'A':
                    avancer(carte);
                    break;
                case 'G':
                    tournerGauche();
                    break;
                case 'D':
                    tournerDroite();
                    break;
            }
        }
    }

    /**
     * Avance l'aventurier dans sa direction actuelle.
     * @param carte La carte sur laquelle l'aventurier évolue.
     */
    public void avancer(Carte carte) {
        int nouveauX = x;
        int nouveauY = y;

        switch (orientation) {
            case 'N':
                nouveauY--;
                break;
            case 'S':
                nouveauY++;
                break;
            case 'E':
                nouveauX++;
                break;
            case 'O':
                nouveauX--;
                break;
        }

        // Vérifie si le déplacement est valide (dans les limites, pas de montagne, pas d'autre aventurier)
        if (estDeplacementValide(carte, nouveauX, nouveauY)) {
            x = nouveauX;
            y = nouveauY;
            collecterTresor(carte);
        }
    }

    /**
     * Vérifie si le déplacement vers une nouvelle position est valide.
     * @param carte La carte sur laquelle l'aventurier évolue.
     * @param x Nouvelle position x.
     * @param y Nouvelle position y.
     * @return true si le déplacement est valide, false sinon.
     */
    private boolean estDeplacementValide(Carte carte, int x, int y) {
        return x >= 0 && x < carte.largeur && y >= 0 && y < carte.hauteur && !carte.estMontagne(x, y) && !carte.aventurierPresent(x, y);
    }

    /**
     * Collecte un trésor si présent sur la case actuelle.
     * @param carte La carte sur laquelle l'aventurier évolue.
     */
    private void collecterTresor(Carte carte) {
        Tresor tresor = carte.getTresor(x, y);
        if (tresor != null && tresor.getQuantite() > 0) {
            tresor.collecter();
            tresorsCollectes++;
        }
    }

    /**
     * Tourne l'aventurier vers la gauche (sens anti-horaire).
     */
    private void tournerGauche() {
        switch (orientation) {
            case 'N':
                orientation = 'O';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'O':
                orientation = 'S';
                break;
        }
    }

    /**
     * Tourne l'aventurier vers la droite (sens horaire).
     */
    private void tournerDroite() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'S':
                orientation = 'O';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'O':
                orientation = 'N';
                break;
        }
    }

    
}
