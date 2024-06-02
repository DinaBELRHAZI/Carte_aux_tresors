package carte;

import java.util.*;

public class Carte {
    public int largeur;
    public int hauteur;
    List<Montagne> montagnes;
    List<Tresor> tresors;
    List<Aventurier> aventuriers;

    /**
     * Constructeur de la classe Carte.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     */
    public Carte(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.montagnes = new ArrayList<>();
        this.tresors = new ArrayList<>();
        this.aventuriers = new ArrayList<>();
    }
    
 // Getters et Setters pour les attributs de la carte
    public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	/**
     * Retourne le trésor à une position donnée.
     * @param x Position x sur la carte.
     * @param y Position y sur la carte.
     * @return Le trésor si présent, sinon null.
     */
    public Tresor getTresor(int x, int y) {
        return tresors.stream().filter(t -> t.getX() == x && t.getY() == y).findFirst().orElse(null);
    }
    
    /**
     * Retourne la liste des aventuriers.
     * @return La liste des aventuriers.
     */
    public List<Aventurier> getAventuriers() {
        return aventuriers;
    }
    
    

    /**
     * Ajoute une montagne à la carte.
     * @param montagne La montagne à ajouter.
     */
    public void ajouterMontagne(Montagne montagne) {
        montagnes.add(montagne);
    }

    /**
     * Ajoute un trésor à la carte.
     * @param tresor Le trésor à ajouter.
     */
    public void ajouterTresor(Tresor tresor) {
        tresors.add(tresor);
    }

    /**
     * Ajoute un aventurier à la carte.
     * @param aventurier L'aventurier à ajouter.
     */
    public void ajouterAventurier(Aventurier aventurier) {
        aventuriers.add(aventurier);
    }

    /**
     * Vérifie si une case est une montagne.
     * @param x Position x sur la carte.
     * @param y Position y sur la carte.
     * @return true si la case est une montagne, sinon false.
     */
    public boolean estMontagne(int x, int y) {
        return montagnes.stream().anyMatch(m -> m.getX() == x && m.getY() == y);
    }

    

    /**
     * Vérifie si un aventurier est présent sur une case donnée.
     * @param x Position x sur la carte.
     * @param y Position y sur la carte.
     * @return true si un aventurier est présent, false sinon.
     */
    public boolean aventurierPresent(int x, int y) {
        return aventuriers.stream().anyMatch(a -> a.getX() == x && a.getY() == y);
    }

    
    
    /**
     * Affiche la carte dans la console.
     */
    public void afficherCarte() {
        char[][] grille = new char[hauteur][largeur];

        // Initialiser la grille avec des points
        for (int i = 0; i < hauteur; i++) {
            Arrays.fill(grille[i], '.');
        }

        // Placer les montagnes
        for (Montagne montagne : montagnes) {
            grille[montagne.getY()][montagne.getX()] = 'M';
        }

        // Placer les trésors
        for (Tresor tresor : tresors) {
            if (tresor.getQuantite() > 0) {
                grille[tresor.getY()][tresor.getX()] = 'T';
            }
        }

        // Placer les aventuriers
        for (Aventurier aventurier : aventuriers) {
            grille[aventurier.getY()][aventurier.getX()] = 'A';
        }

        // Afficher la grille
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(grille[i][j] + "   ");
            }
            System.out.println();
        }

        // Afficher les aventuriers
        for (Aventurier aventurier : aventuriers) {
            System.out.println("Aventurier: " + aventurier.getNom() + " - Position: (" + aventurier.getX() + ", " + aventurier.getY() + ") - Orientation: " + aventurier.getOrientation() + " - Trésors collectés: " + aventurier.getTresorsCollectes());
        }
    }
}
