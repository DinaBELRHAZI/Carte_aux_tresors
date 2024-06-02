package carte;

public class Tresor {

	private int x;
    private int y;
    private int quantite;

    public Tresor(int x, int y, int quantite) {
        this.x = x;
        this.y = y;
        this.quantite = quantite;
    }

 // Getters et Setters pour les attributs d'un trésor
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

    public int getQuantite() {
        return quantite;
    }

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
    public void collecter() {
        if (quantite > 0) {
            quantite--;
        }
    }
    
   
    public boolean estEpuise() {
        return quantite == 0;
    }
}
