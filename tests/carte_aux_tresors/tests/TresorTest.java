package carte_aux_tresors.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import carte.Tresor;

class TresorTest {
	
	private Tresor tresor;
	
	@BeforeEach
    void setUp() {
    	
    	// Given: Un trésor a pour coordonnées (1, 1) et avec une quantité de 2
        tresor = new Tresor(1, 1, 2);
    }

	@Test
    public void testGetX() {
        
        // When: On obtient la coordonnée x
        int x = tresor.getX();

        // Then: La coordonnée x devrait être 1
        assertEquals(1, x, "La coordonnée X du trésor devrait être 1");
    }
	
	@Test
    void testSetX() {
		
        // When : Nous modifions la coordonnée X de l'aventurier
        tresor.setX(1);

        // Then : Nous vérifions que la coordonnée X a bien été modifiée
        assertEquals(1, tresor.getX(), "La coordonnée X du tresor doit être 1");
    }

    @Test
    public void testGetY() {
      
        // When: On obtient la coordonnée y
        int y = tresor.getY();

        // Then: La coordonnée y devrait être 1
        assertEquals(1, y, "La coordonnée Y du trésor devrait être 1");
    }
    
    @Test
    void testSetY() {
    	
        // When : Nous modifions la coordonnée Y de l'aventurier
        tresor.setY(1);

        // Then : Nous vérifions que la coordonnée Y a bien été modifiée
        assertEquals(1, tresor.getY(), "La coordonnée Y du tresor doit être 1");

    }
    
    
    @Test
    public void testGetQuantite() {
        
        // When: On obtient la quantité de trésors
        int quantite = tresor.getQuantite();

        // Then: La quantité devrait être 2
        assertEquals(2, quantite, "La quantité de trésors devrait être 2");
    }
    
    @Test
    void testSetQuantite() {
    	
        // When : Nous modifions la coordonnée Y de l'aventurier
        tresor.setQuantite(2);

        // Then : Nous vérifions que la coordonnée X a bien été modifiée
        assertEquals(1, tresor.getY(), "La coordonnée Y du tresor doit être 1");

    }

    @Test
    public void testCollecter() {
      
        // When: On collecte un trésor
        tresor.collecter();

        // Then: La quantité de trésors après collecte devrait être 1
        assertEquals(1, tresor.getQuantite(), "La quantité de trésors après collecte devrait être 1");
    }

    @Test
    public void testEstEpuise() {
    	
    	// Given : Un trésor a pour coordonnées (1, 1) et avec une quantité de 1
    	tresor = new Tresor(1, 1, 1);
    	
        // When: On collecte un trésor
        tresor.collecter();
        
        // Then: Il n'y a plus de trésor à collecter
        assertTrue(tresor.estEpuise(), "Le stock de trésor devrait être épuisé");
    }

}
